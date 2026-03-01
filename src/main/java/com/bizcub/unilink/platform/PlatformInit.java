package com.bizcub.unilink.platform;

//~ auto_config
import com.bizcub.unilink.config.Configs;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.client.gui.screens.Screen;

public class PlatformInit {

    public static Screen getScreen(Screen parent) {
        return AutoConfig.getConfigScreen(Configs.class, parent).get();
    }
}
