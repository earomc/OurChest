package net.earomc.ourchest.client;

import net.earomc.ourchest.ModBlockEntityTypes;
import net.earomc.ourchest.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.SpecialBlockRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.renderer.special.ChestSpecialRenderer;

import static net.earomc.ourchest.ourchest.OurChest.resourceLocation;

public class OurChestClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        SpecialBlockRendererRegistry.register(ModBlocks.OUR_CHEST, new ChestSpecialRenderer.Unbaked(resourceLocation("chest")));
        BlockEntityRenderers.register(ModBlockEntityTypes.OUR_CHEST, ChestRenderer::new);
    }
}
