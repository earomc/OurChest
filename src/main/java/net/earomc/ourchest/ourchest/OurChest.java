package net.earomc.ourchest.ourchest;

import net.earomc.ourchest.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

public class OurChest implements ModInitializer {

    public static final String MOD_ID = "ourchest";
    public static ResourceLocation resourceLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
    }
}
