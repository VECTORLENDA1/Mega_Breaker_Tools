package net.vector.megabreakertools.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;


import java.util.ArrayList;

@JeiPlugin
public class JEIMegaBreakerToolsPlugin implements IModPlugin {

    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath("megabreakertools", "jei_plugin");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return UID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {

    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
     }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
    }
}



