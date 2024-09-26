package net.kaupenjoe.mccourse.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record CrystallizerRecipeInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getItem(int pIndex) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }
}
