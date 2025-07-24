package net.earomc.ourchest.client;

import net.earomc.ourchest.ModBlockEntityTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class OurChestClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //SpecialBlockRendererRegistry.register(ModBlocks.OUR_CHEST, new ChestSpecialRenderer.Unbaked(resourceLocation("chest")));
        BlockEntityRenderers.register(ModBlockEntityTypes.OUR_CHEST, OurChestBlockEntityRenderer::new);
    }
}
