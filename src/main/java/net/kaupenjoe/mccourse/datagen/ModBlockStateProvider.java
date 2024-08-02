package net.kaupenjoe.mccourse.datagen;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.awt.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MCCourseMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLACK_OPAL_BLOCK);
        blockWithItem(ModBlocks.RAW_BLACK_OPAL_BLOCK);

        blockWithItem(ModBlocks.BLACK_OPAL_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_DEEPSLATE_ORE );
        blockWithItem(ModBlocks.BLACK_OPAL_END_ORE);
        blockWithItem(ModBlocks.BLACK_OPAL_NETHER_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(((StairBlock) ModBlocks.BLACK_OPAL_STAIRS.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.BLACK_OPAL_SLAB.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

        pressurePlateBlock(((PressurePlateBlock) ModBlocks.BLACK_OPAL_PRESSURE_PLATE.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.BLACK_OPAL_BUTTON.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.BLACK_OPAL_FENCE.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.BLACK_OPAL_FENCE_GATE.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.BLACK_OPAL_WALL.get()), blockTexture(ModBlocks.BLACK_OPAL_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.BLACK_OPAL_DOOR.get()), modLoc("block/black_opal_door_bottom"), modLoc("block/black_opal_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.BLACK_OPAL_TRAPDOOR.get()), modLoc("block/black_opal_trapdoor"), true, "cutout");

        blockItem(ModBlocks.BLACK_OPAL_STAIRS);
        blockItem(ModBlocks.BLACK_OPAL_SLAB);
        blockItem(ModBlocks.BLACK_OPAL_PRESSURE_PLATE);
        blockItem(ModBlocks.BLACK_OPAL_FENCE_GATE);

        blockItem(ModBlocks.BLACK_OPAL_TRAPDOOR, "_bottom");
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<Block> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
