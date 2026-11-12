package io.github.bizcub.unilink.config;

import io.github.bizcub.simpleConfigLib.autoconfig.ConfigHolder;
import io.github.bizcub.simpleConfigLib.autoconfig.ConfigSide;
import io.github.bizcub.simpleConfigLib.autoconfig.annotation.AutoConfig;
import io.github.bizcub.simpleConfigLib.autoconfig.annotation.Tooltip;
import io.github.bizcub.unilink.Main;

import java.util.ArrayList;
import java.util.List;

@AutoConfig(name = Main.MOD_ID, side = ConfigSide.CLIENT, translate = true)
public class SimpleConfig {

    public static ConfigHolder<SimpleConfig> getInstance() {
        return ConfigHolder.register(SimpleConfig.class);
    }

    @Tooltip
    public boolean recreateDirs = true;

    public List<Pair> linksList = new ArrayList<>();

    public static class Pair {
        public String from = "";
        public String to = "";

        @Override
        public String toString() {
            return from + " -> " + to;
        }
    }
}
