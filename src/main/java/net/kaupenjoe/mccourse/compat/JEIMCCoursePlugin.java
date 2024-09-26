package net.kaupenjoe.mccourse.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.recipe.CrystallizerRecipe;
import net.kaupenjoe.mccourse.recipe.ModRecipes;
import net.kaupenjoe.mccourse.screen.custom.CrystallizerScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIMCCoursePlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CrystallizerRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<CrystallizerRecipe> crystallizerRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.CRYSTALLIZER_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(CrystallizerRecipeCategory.CRYSTALLIZER_RECIPE_RECIPE_TYPE, crystallizerRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(CrystallizerScreen.class, 70, 30, 25, 20,
                CrystallizerRecipeCategory.CRYSTALLIZER_RECIPE_RECIPE_TYPE);
    }
}
