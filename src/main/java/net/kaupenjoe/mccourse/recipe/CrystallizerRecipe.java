package net.kaupenjoe.mccourse.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record CrystallizerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CrystallizerRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(CrystallizerRecipeInput pInput, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }

        return inputItem.test(pInput.getItem(0));
    }

    @Override
    public ItemStack assemble(CrystallizerRecipeInput pInput, HolderLookup.Provider pRegistries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider pRegistries) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CRYSTALLIZER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CRYSTALLIZER_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<CrystallizerRecipe> {
        public static final MapCodec<CrystallizerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(CrystallizerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CrystallizerRecipe::output)
        ).apply(inst, CrystallizerRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, CrystallizerRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, CrystallizerRecipe::inputItem,
                        ItemStack.STREAM_CODEC, CrystallizerRecipe::output,
                        CrystallizerRecipe::new);

        @Override
        public MapCodec<CrystallizerRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CrystallizerRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
