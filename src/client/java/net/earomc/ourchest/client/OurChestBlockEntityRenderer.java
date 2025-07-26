package net.earomc.ourchest.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.earomc.ourchest.ModBlocks;
import net.earomc.ourchest.ourchest.OurChestBlockEntity;
import net.earomc.ourchest.ourchest.OurChestMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ChestModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractChestBlock;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

@Environment(EnvType.CLIENT)
public class OurChestBlockEntityRenderer implements BlockEntityRenderer<OurChestBlockEntity> {

    private final ChestModel singleModel;

    public OurChestBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.singleModel = new ChestModel(context.bakeLayer(ModelLayers.CHEST));
    }

    private Material getMaterial() {
        return new Material(Sheets.CHEST_SHEET, OurChestMod.resourceLocation("entity/chest/our")); // texture location
    }

    @Override
    public void render(OurChestBlockEntity blockEntity, float tickProgress, PoseStack poseStack, MultiBufferSource multiBufferSource, int light, int overlay, Vec3 cameraPos) {
        Level level = blockEntity.getLevel();
        boolean inLevel = level != null;
        BlockState blockState = inLevel ? blockEntity.getBlockState() : ModBlocks.OUR_CHEST.defaultBlockState().setValue(ChestBlock.FACING, Direction.SOUTH);
        poseStack.pushPose();
        float g = blockState.getValue(ChestBlock.FACING).toYRot();
        poseStack.translate(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(Axis.YP.rotationDegrees(-g));
        poseStack.translate(-0.5F, -0.5F, -0.5F);


        float openness = blockEntity.getOpenNess(tickProgress);
        openness = 1.0F - openness;
        openness = 1.0F - openness * openness * openness; // 1 - (1 - openness)³
        Material material = getMaterial();
        VertexConsumer vertexConsumer = material.buffer(multiBufferSource, RenderType::entityCutout);
        this.render(poseStack, vertexConsumer, this.singleModel, openness, light, overlay);

        poseStack.popPose();
    }

    private void render(PoseStack poseStack, VertexConsumer vertexConsumer, ChestModel chestModel, float openness, int light, int overlay) {
        chestModel.setupAnim(openness);
        chestModel.renderToBuffer(poseStack, vertexConsumer, light, overlay);
    }
}
