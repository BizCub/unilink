package io.github.bizcub.unilink.config;

import java.util.Collections;
import java.util.List;

public interface Config {
    static Config get() {
        return Holder.INSTANCE;
    }

    static void set(final Config config) {
        if (config != null) {
            Holder.INSTANCE = config;
        }
    }

    class Holder {
        private static Config INSTANCE = new Config() { };
    }

    default boolean recreateDirs() {
        return true;
    }

    default List<Pair> linksList() {
        return Collections.emptyList();
    }
}
