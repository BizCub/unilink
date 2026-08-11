package io.github.bizcub.unilink.config;

import io.github.bizcub.unilink.Main;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.minecraft.world.InteractionResult;

import java.util.List;

@me.shedaniel.autoconfig.annotation.Config(name = Main.MOD_ID)
public class ClothConfig implements Config, ConfigData {

    public static ClothConfig getInstance() {
        return AutoConfig.getConfigHolder(ClothConfig.class).getConfig();
    }

    public static void init() {
        AutoConfig.register(ClothConfig.class, GsonConfigSerializer::new).registerSaveListener((manager, data) -> {
            Main.onSave();
            return InteractionResult.SUCCESS;
        });
    }

    @ConfigEntry.Gui.Tooltip
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
