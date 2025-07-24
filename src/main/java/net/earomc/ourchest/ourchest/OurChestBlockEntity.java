package net.earomc.ourchest.ourchest;

import net.earomc.ourchest.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OurChestBlockEntity extends ChestBlockEntity implements LidBlockEntity {

    public OurChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.OUR_CHEST, blockPos, blockState);
    }
}
