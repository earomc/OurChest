package net.earomc.ourchest.ourchest;

import net.earomc.ourchest.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class OurChestBlockEntity extends BlockEntity implements LidBlockEntity, MenuProvider {

    public OurChestBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntityTypes.OUR_CHEST, blockPos, blockState);
    }

    private final ChestLidController chestLidController = new ChestLidController();

    @Override
    public float getOpenNess(float f) {
        return chestLidController.getOpenness(f);
    }

    public static void lidAnimateTick(Level level, BlockPos blockPos, BlockState blockState, OurChestBlockEntity chestBlockEntity) {
        chestBlockEntity.chestLidController.tickLid();
    }

    @Override
    public boolean triggerEvent(int eventType, int viewers) {
        if (eventType == 1) {
            this.chestLidController.shouldBeOpen(viewers > 0);
            return true;
        } else {
            return super.triggerEvent(eventType, viewers);
        }
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Our Chest"); // TODO: Change to translatable.
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null; // TODO: Implement menu
    }
}
