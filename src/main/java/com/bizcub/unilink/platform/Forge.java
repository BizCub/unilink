//? forge {
/*package com.bizcub.unilink.platform;

import com.bizcub.unilink.Main;
import me.shedaniel.autoconfig.AutoConfig;
/^? >=1.19^/ import net.minecraftforge.client.ConfigScreenHandler;
/^? >=1.18 && <=1.18.2^/ //import net.minecraftforge.client.ConfigGuiHandler;
/^? >=1.17 && <=1.17.1^/ //import net.minecraftforge.fmlclient.ConfigGuiHandler;
/^? <=1.16.5^/ //import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(Main.MOD_ID)
public class Forge {

    public Forge() {
        Main.init();

        //? >=1.19 {
        ModLoadingContext.get().registerExtensionPoint(ConfigScreenHandler.ConfigScreenFactory.class, () ->
                new ConfigScreenHandler.ConfigScreenFactory((minecraft, screen) ->
                        PlatformInit.getScreen(screen)
        ));

        //?} >=1.17 && <=1.18.2 {
        /^ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () ->
                new ConfigGuiHandler.ConfigGuiFactory((minecraft, screen) ->
                        PlatformInit.getScreen(screen)
        ));

        ^///?} <=1.16.5 {
        /^ModLoadingContext.get().registerExtensionPoint(
                ExtensionPoint.CONFIGGUIFACTORY, () -> (minecraft, screen) ->
                        PlatformInit.getScreen(screen)
        );^///?}
    }
}*///?}
