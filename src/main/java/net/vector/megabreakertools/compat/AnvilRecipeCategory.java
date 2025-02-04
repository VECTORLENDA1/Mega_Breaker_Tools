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
    public static final RecipeType<ModAnvilRecipe> ANVIL_TYPE = new RecipeType<>(UID, ModAnvilRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public AnvilRecipeCategory(IGuiHelper guiHelper) {
        // Usa a textura da bigorna original do Minecraft
        this.background = guiHelper.createDrawable(
                ResourceLocation.fromNamespaceAndPath("megabreakertools", "textures/gui/slot.png"),
                0, 0, 125, 38 // Tamanho da interface da bigorna
        );
        // Ícone da bigorna
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
        //ADVANCE BREAKER
        builder.addSlot(RecipeIngredientRole.INPUT, 2, 0).addItemStack(new ItemStack(ModBlocks.CELESTINE_BLOCK.get())); // Slot esquerdo
        builder.addSlot(RecipeIngredientRole.INPUT, 50, 0).addItemStack(new ItemStack(ModItems.SIMPLE_BREAKER.get())); // Slot direito
        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 0).addItemStack(new ItemStack(ModItems.ADVANCE_BREAKER.get())); // Slot de saída
        //ULTRA BREAKER
        builder.addSlot(RecipeIngredientRole.INPUT, 2, 50).addItemStack(new ItemStack(ModBlocks.CELESTINE_BLOCK.get())); // Slot esquerdo
        builder.addSlot(RecipeIngredientRole.INPUT, 50, 50).addItemStack(new ItemStack(ModItems.ADVANCE_BREAKER.get())); // Slot direito
        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 50).addItemStack(new ItemStack(ModItems.ULTRA_BREAKER.get())); // Slot de saída
        //ULTIMATE BREAKER
        builder.addSlot(RecipeIngredientRole.INPUT, 2, 0).addItemStack(new ItemStack(ModBlocks.CELESTINE_BLOCK.get())); // Slot esquerdo
        builder.addSlot(RecipeIngredientRole.INPUT, 50, 0).addItemStack(new ItemStack(ModItems.ULTRA_BREAKER.get())); // Slot direito
        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 0).addItemStack(new ItemStack(ModItems.ULTIMATE_BREAKER.get())); // Slot de saída
        //LEGENDARY BREAKER
        builder.addSlot(RecipeIngredientRole.INPUT, 2, 0).addItemStack(new ItemStack(ModBlocks.CELESTINE_BLOCK.get())); // Slot esquerdo
        builder.addSlot(RecipeIngredientRole.INPUT, 50, 0).addItemStack(new ItemStack(ModItems.ULTIMATE_BREAKER.get())); // Slot direito
        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 0).addItemStack(new ItemStack(ModItems.LEGENDARY_BREAKER.get())); // Slot de saída
        //ATOMIC BREAKER
        builder.addSlot(RecipeIngredientRole.INPUT, 2, 0).addItemStack(new ItemStack(ModBlocks.CELESTINE_BLOCK.get())); // Slot esquerdo
        builder.addSlot(RecipeIngredientRole.INPUT, 50, 0).addItemStack(new ItemStack(ModItems.LEGENDARY_BREAKER.get())); // Slot direito
        builder.addSlot(RecipeIngredientRole.OUTPUT, 108, 0).addItemStack(new ItemStack(ModItems.ATOMIC_BREAKER.get())); // Slot de saída
    }
}