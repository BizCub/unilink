//? fabric {
package com.bizcub.unilink.platform;

import com.bizcub.unilink.Main;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.api.ClientModInitializer;

public class Fabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Main.init();
    }

    public static class ModMenu implements ModMenuApi {

        @Override
        public ConfigScreenFactory<?> getModConfigScreenFactory() {
            return PlatformInit::getScreen;
        }
    }
}//?}
