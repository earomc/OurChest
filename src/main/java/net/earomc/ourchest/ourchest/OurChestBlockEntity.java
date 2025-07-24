package net.earomc.ourchest.ourchest;

import net.earomc.ourchest.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OurChestBlockEntity extends BlockEntity implements LidBlockEntity {

    public OurChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.OUR_CHEST, blockPos, blockState);
    }

    @Override
    public float getOpenNess(float f) {
        return 0;
    }
}
