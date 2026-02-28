package com.bizcub.unilink.config;

import com.bizcub.unilink.Main;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.world.InteractionResult;

import java.util.List;

@Config(name = Main.MOD_ID)
public class Configs implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean recreateDirs = true;
    public List<Pair> linksList = List.of();

    public static void init() {
        AutoConfig.register(Configs.class, GsonConfigSerializer::new);

        AutoConfig.getConfigHolder(Configs.class).registerSaveListener((manager, data) -> {
            Main.initLinks();
            if (Configs.getInstance().recreateDirs) Main.recreateDirs();
            return InteractionResult.SUCCESS;
        });
    }

    public static Configs getInstance() {
        return AutoConfig.getConfigHolder(Configs.class).getConfig();
    }

    public static class Pair {
        public String from;
        public String to;

        public Pair() {
            this("", "");
        }

        public Pair(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return from + " -> " + to;
        }
    }
}
