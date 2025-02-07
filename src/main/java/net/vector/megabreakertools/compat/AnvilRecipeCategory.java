package net.vector.megabreakertools.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.vector.megabreakertools.client.ScaledDrawable;
import net.vector.megabreakertools.crafting.AnvilRecipe;
import org.jetbrains.annotations.NotNull;

public class AnvilRecipeCategory implements IRecipeCategory<AnvilRecipe> {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath("megabreakertools", "anvil");
    public static final RecipeType<AnvilRecipe> ANVIL_TYPE = new RecipeType<>(UID, AnvilRecipe.class);
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("megabreakertools", "textures/gui/anvil_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public AnvilRecipeCategory(IGuiHelper helper) {
        IDrawable baseBackground = helper.createDrawable(TEXTURE, 0, 0, 125, 38);
        this.background = new ScaledDrawable(baseBackground, 1f);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.ANVIL));
    }

    @Override
    public @NotNull RecipeType<AnvilRecipe> getRecipeType() {
        return ANVIL_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return Component.literal("Anvil");
    }

    @Override
    public @NotNull IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, @NotNull AnvilRecipe recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 5, 5).addItemStack(new ItemStack(recipe.getLeftItem()));
        builder.addSlot(RecipeIngredientRole.INPUT, 51, 5).addItemStack(new ItemStack(recipe.getRightItem()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 5).addItemStack(recipe.getResult());
    }
}