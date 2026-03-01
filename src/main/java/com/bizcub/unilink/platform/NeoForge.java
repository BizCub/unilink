//? neoforge {
/*package com.bizcub.unilink.platform;

import com.bizcub.unilink.Main;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(Main.MOD_ID)
public class NeoForge {

    public NeoForge() {
        Main.init();

        ModLoadingContext.get().registerExtensionPoint(
                IConfigScreenFactory.class, () -> (container, screen) ->
                        PlatformInit.getScreen(screen)
        );
    }
}*///?}
