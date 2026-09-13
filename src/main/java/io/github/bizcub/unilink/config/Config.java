package io.github.bizcub.unilink.config;

import io.github.bizcub.simpleConfigLib.autoconfig.ConfigProvider;

import java.util.Collections;
import java.util.List;

public interface Config {
    static Config get() {
        return ConfigProvider.get(Config.class);
    }
    static void set(Config instance) {
        ConfigProvider.set(Config.class, instance);
    }

    default boolean recreateDirs() {
        return true;
    }

    default List<Pair> linksList() {
        return Collections.emptyList();
    }
}
