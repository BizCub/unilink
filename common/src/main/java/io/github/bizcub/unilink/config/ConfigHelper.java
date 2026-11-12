package io.github.bizcub.unilink.config;

import io.github.bizcub.simpleConfigLib.autoconfig.gui.ConfigScreens;
import io.github.bizcub.unilink.Main;
import net.minecraft.client.gui.screens.Screen;

public class ConfigHelper {
    public static Screen getScreen(Screen parent) {
        return ConfigScreens.open(Main.MOD_ID, parent);
    }
}
