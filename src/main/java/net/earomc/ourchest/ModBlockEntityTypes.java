package net.earomc.ourchest;

import net.earomc.ourchest.ourchest.OurChest;
import net.earomc.ourchest.ourchest.OurChestBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntityTypes {

    public static final BlockEntityType<OurChestBlockEntity> OUR_CHEST = register("our_chest", OurChestBlockEntity::new, ModBlocks.OUR_CHEST);

    private static <T extends BlockEntity> BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(OurChest.MOD_ID, name);
        var type = FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build();
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, type);
    }
}