package io.github.bizcub.unilink.config;

import io.github.bizcub.simpleConfigLib.autoconfig.ConfigHolder;
import io.github.bizcub.simpleConfigLib.autoconfig.annotation.*;
import io.github.bizcub.unilink.Main;

import java.util.List;

@AutoConfig(name = Main.MOD_ID, translate = true)
public class SimpleConfig implements Config {

    public static ConfigHolder<SimpleConfig> getInstance() {
        return ConfigHolder.register(SimpleConfig.class).onSave(config -> Main.onSave());
    }

    @Tooltip
    public boolean recreateDirs = Config.super.recreateDirs();

    public List<Pair> linksList = Config.super.linksList();

    @Override
    public boolean recreateDirs() {
        return this.recreateDirs;
    }

    @Override
    public List<Pair> linksList() {
        return this.linksList;
    }
}
