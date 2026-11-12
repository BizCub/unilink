package io.github.bizcub.unilink.platform;

import io.github.bizcub.unilink.Main;
import io.github.bizcub.unilink.config.ConfigHelper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Main.MOD_ID, dist = Dist.CLIENT)
public class NeoForge {

    public NeoForge(ModContainer modContainer) {
        Main.init();

        modContainer.registerExtensionPoint(IConfigScreenFactory.class,
                (container, parent) -> ConfigHelper.getScreen(parent));
    }
}
