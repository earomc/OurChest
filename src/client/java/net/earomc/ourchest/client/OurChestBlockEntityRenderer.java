package net.earomc.ourchest.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.earomc.ourchest.ourchest.OurChestBlockEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.phys.Vec3;

public class OurChestBlockEntityRenderer extends ChestRenderer<OurChestBlockEntity> {

    public OurChestBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(OurChestBlockEntity blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, Vec3 vec3) {
        super.render(blockEntity, f, poseStack, multiBufferSource, i, j, vec3);
    }
}
