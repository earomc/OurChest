package net.earomc.ourchest.ourchest;

import net.earomc.ourchest.ModBlockEntityTypes;
import net.earomc.ourchest.ModBlocks;
import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OurChestMod implements ModInitializer {

    public static final String MOD_ID = "ourchest";
    public static final Logger LOGGER = LoggerFactory.getLogger("OurChest");

    public static ResourceLocation resourceLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    @Override
    public void onInitialize() {
        ModBlocks.initialize();
        ModBlockEntityTypes.initialize();
    }
}
