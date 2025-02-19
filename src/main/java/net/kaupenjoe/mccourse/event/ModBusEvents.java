package net.kaupenjoe.mccourse.event;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.entity.ModBlockEntities;
import net.kaupenjoe.mccourse.block.entity.custom.CoalGeneratorBlockEntity;
import net.kaupenjoe.mccourse.block.entity.custom.CrystallizerBlockEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = MCCourseMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModBusEvents {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ModBlockEntities.CRYSTALLIZER_BE.get(), CrystallizerBlockEntity::getItemHandler);

        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntities.COAL_GENERATOR_BE.get(), CoalGeneratorBlockEntity::getEnergyStorage);
        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK, ModBlockEntities.CRYSTALLIZER_BE.get(), CrystallizerBlockEntity::getEnergyStorage);
    }
}
