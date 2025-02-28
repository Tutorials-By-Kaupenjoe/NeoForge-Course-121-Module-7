package net.kaupenjoe.mccourse.block.entity;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.block.entity.custom.CoalGeneratorBlockEntity;
import net.kaupenjoe.mccourse.block.entity.custom.CrystallizerBlockEntity;
import net.kaupenjoe.mccourse.block.entity.custom.PedestalBlockEntity;
import net.kaupenjoe.mccourse.block.entity.custom.TankBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, MCCourseMod.MOD_ID);

    public static final Supplier<BlockEntityType<PedestalBlockEntity>> PEDESTAL_BE =
            BLOCK_ENTITIES.register("pedestal_be", () -> BlockEntityType.Builder.of(
                    PedestalBlockEntity::new, ModBlocks.PEDESTAL.get()).build(null));

    public static final Supplier<BlockEntityType<CrystallizerBlockEntity>> CRYSTALLIZER_BE =
            BLOCK_ENTITIES.register("crystallizer_be", () -> BlockEntityType.Builder.of(
                    CrystallizerBlockEntity::new, ModBlocks.CRYSTALLIZER.get()).build(null));

    public static final Supplier<BlockEntityType<CoalGeneratorBlockEntity>> COAL_GENERATOR_BE =
            BLOCK_ENTITIES.register("coal_generator_be", () -> BlockEntityType.Builder.of(
                    CoalGeneratorBlockEntity::new, ModBlocks.COAL_GENERATOR.get()).build(null));

    public static final Supplier<BlockEntityType<TankBlockEntity>> TANK_BE =
            BLOCK_ENTITIES.register("tank_be", () -> BlockEntityType.Builder.of(
                    TankBlockEntity::new, ModBlocks.TANK.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
