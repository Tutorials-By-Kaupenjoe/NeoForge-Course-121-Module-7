package net.kaupenjoe.mccourse.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.recipe.CrystallizerRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class CrystallizerRecipeCategory implements IRecipeCategory<CrystallizerRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "crystallizing");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,
            "textures/gui/crystallizer/crystallizer_gui.png");

    public static final RecipeType<CrystallizerRecipe> CRYSTALLIZER_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, CrystallizerRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public CrystallizerRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.CRYSTALLIZER.get()));
    }

    @Override
    public RecipeType<CrystallizerRecipe> getRecipeType() {
        return CRYSTALLIZER_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Crystallizer");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, CrystallizerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 34).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 34).addItemStack(recipe.getResultItem(null));
    }
}
