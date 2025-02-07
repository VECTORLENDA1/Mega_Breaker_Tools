package net.vector.megabreakertools.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.vector.megabreakertools.crafting.ModAnvilRecipe;



import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class JEIMegaBreakerToolsPlugin implements IModPlugin {

    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath("megabreakertools", "jei_plugin");


    @Override
    public ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AnvilRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }


    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        IModPlugin.super.registerRecipes(registration);
        List<ModAnvilRecipe> recipes = new ArrayList<>();
        recipes.add(new ModAnvilRecipe());
        registration.addRecipes(AnvilRecipeCategory.ANVIL_TYPE, recipes);
    }
}



