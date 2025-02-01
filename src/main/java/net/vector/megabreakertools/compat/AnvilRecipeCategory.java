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
import net.vector.megabreakertools.block.ModBlocks;
import net.vector.megabreakertools.crafting.ModAnvilRecipe;
import net.vector.megabreakertools.item.ModItems;

public class AnvilRecipeCategory implements IRecipeCategory<ModAnvilRecipe> {

    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath("megabreakertools", "anvil");
    public static final RecipeType<ModAnvilRecipe> ANVIL_TYPE = RecipeType.create("megabreakertools", "anvil", ModAnvilRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public AnvilRecipeCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(
                 ResourceLocation.fromNamespaceAndPath("megabreakertools", "assets/megabreakertools/textures/megabreakertools/gui/gui_vanilla.png"),
                0, 0, 166, 15 // Use a textura padrão da anvil
        );
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Items.ANVIL));
    }

    @Override
    public RecipeType<ModAnvilRecipe> getRecipeType() {
        return ANVIL_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Anvil");
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, ModAnvilRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 27, 20).addItemStack(new ItemStack(ModBlocks.CELESTINE_BLOCK.get()));
        builder.addSlot(RecipeIngredientRole.INPUT, 76, 20).addItemStack(new ItemStack(ModItems.SIMPLE_BREAKER.get()));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 134, 20).addItemStack(new ItemStack(ModItems.ADVANCE_BREAKER.get()));
    }
}
