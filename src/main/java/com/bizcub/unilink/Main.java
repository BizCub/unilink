package com.bizcub.unilink;

import com.bizcub.unilink.config.Configs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static final String MOD_ID = /*$ mod_id*/ "unilink";

    public static ArrayList<String> oldLinksList = new ArrayList<>();
    public static List<String> recreatedDirectories = Arrays.asList("saves", "resourcepacks");

    public static void init() {
        Configs.init();
        initLinks();
    }

    public static void initLinks() {
        if (!oldLinksList.isEmpty()) {
            ArrayList<String> linksStringList = new ArrayList<>();
            Configs.getInstance().linksList.forEach(link -> linksStringList.add(link.to));

            for (String link : oldLinksList) {
                if (!linksStringList.contains(link)) {
                    deleteFolder(new File(link));
                }
            }
        }

        Configs.getInstance().linksList.forEach(pair -> {
            try {
                File originalPath = new File(pair.from);
                File symbolicLinkPath = new File(pair.to);

                deleteFolder(symbolicLinkPath);
                if (!symbolicLinkPath.exists()) {
                    Files.createSymbolicLink(symbolicLinkPath.toPath(), originalPath.toPath());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        saveTempFile();
    }

    public static void saveTempFile() {
        if (!oldLinksList.isEmpty()) oldLinksList.clear();
        Configs.getInstance().linksList.forEach(link -> oldLinksList.add(link.to));
    }

    public static void deleteFolder(File folder) {
        if ((folder.isDirectory() && folder.listFiles().length == 0)
                || Files.isSymbolicLink(folder.toPath()) || Files.isRegularFile(folder.toPath())) {
            folder.delete();
        }
    }

    public static void recreateDirs() {
        recreatedDirectories.forEach(dir -> new File(dir).mkdir());
    }
}
