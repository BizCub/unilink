package io.github.bizcub.unilink;

import io.github.bizcub.unilink.config.SimpleConfig;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {
    public static final String MOD_ID = "unilink";

    public static ArrayList<String> oldLinksList = new ArrayList<>();
    public static List<String> recreatedDirectories = Arrays.asList("saves", "resourcepacks");

    public static void init() {
        SimpleConfig.getInstance().onSave(config -> Main.onSave());

        initLinks();
    }

    public static void onSave() {
        Main.initLinks();
        if (SimpleConfig.getInstance().get().recreateDirs) Main.recreateDirs();
    }

    public static void initLinks() {
        ArrayList<String> currentLinks = new ArrayList<>();
        boolean success = true;
        for (SimpleConfig.Pair pair : SimpleConfig.getInstance().get().linksList) {
            try {
                if (pair.from.isBlank() || pair.to.isBlank()) continue;
                Path source = Path.of(pair.from).toAbsolutePath().normalize();
                Path destination = Path.of(pair.to).toAbsolutePath().normalize();
                if (!Files.isDirectory(source) || source.startsWith(destination) || destination.startsWith(source)) {
                    throw new IOException("Invalid link paths: " + pair);
                }
                updateLink(source, destination);
                currentLinks.add(pair.to);
            } catch (IOException | IllegalArgumentException | UnsupportedOperationException | SecurityException e) {
                success = false;
                e.printStackTrace();
            }
        }
        if (!success) return;
        for (String link : oldLinksList) {
            if (!currentLinks.contains(link)) {
                try {
                    Path path = Path.of(link);
                    if (Files.isSymbolicLink(path)) Files.delete(path);
                } catch (IOException | SecurityException e) {
                    e.printStackTrace();
                }
            }
        }
        oldLinksList = currentLinks;
    }

    private static void updateLink(Path source, Path destination) throws IOException {
        if (Files.isSymbolicLink(destination) && Files.exists(destination) && Files.isSameFile(destination, source)) return;
        boolean emptyDirectory = Files.isDirectory(destination, LinkOption.NOFOLLOW_LINKS);
        if (emptyDirectory) {
            try (var children = Files.list(destination)) {
                if (children.findAny().isPresent()) throw new IOException("Directory is not empty: " + destination);
            }
        } else if (Files.exists(destination, LinkOption.NOFOLLOW_LINKS) && !Files.isSymbolicLink(destination)) {
            throw new IOException("Destination is not a symbolic link: " + destination);
        }
        Path temporary = destination.resolveSibling(".unilink-" + UUID.randomUUID());
        Files.createSymbolicLink(temporary, source);
        try {
            if (emptyDirectory) Files.delete(destination);
            Files.move(temporary, destination, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            if (emptyDirectory && !Files.exists(destination, LinkOption.NOFOLLOW_LINKS)) Files.createDirectory(destination);
            throw e;
        } finally {
            Files.deleteIfExists(temporary);
        }
    }

    public static void recreateDirs() {
        recreatedDirectories.forEach(dir -> new File(dir).mkdir());
    }
}
