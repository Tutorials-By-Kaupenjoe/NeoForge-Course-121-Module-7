package net.kaupenjoe.mccourse.recipe;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, MCCourseMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, MCCourseMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CrystallizerRecipe>> CRYSTALLIZER_SERIALIZER =
            SERIALIZERS.register("crystallizing", CrystallizerRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<CrystallizerRecipe>> CRYSTALLIZER_TYPE =
            TYPES.register("crystallizing", () -> new RecipeType<CrystallizerRecipe>() {
                @Override
                public String toString() {
                    return "crystallizing";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
