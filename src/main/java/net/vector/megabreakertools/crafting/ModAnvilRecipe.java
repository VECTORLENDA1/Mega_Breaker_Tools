package net.vector.megabreakertools.crafting;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vector.megabreakertools.block.ModBlocks;
import net.vector.megabreakertools.item.ModItems;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber
public class ModAnvilRecipe {
    private static final Map<String, AnvilRecipe> RECIPES = new HashMap<>();

    public ModAnvilRecipe() {
        MinecraftForge.EVENT_BUS.register(this);
        registerRecipes();
    }

    public static Collection<AnvilRecipe> getRecipes() {
        return RECIPES.values();
    }

    private void registerRecipes() {
        registerRecipe(Item.byBlock(ModBlocks.IGNITHRA_BLOCK.get()), ModItems.SIMPLE_BREAKER.get(), new ItemStack(ModItems.MEGA_SIMPLE_BREAKER.get()), 10, 32);

        registerRecipe(Item.byBlock(ModBlocks.IGNITHRA_BLOCK.get()), ModItems.SIMPLE_BREAKER.get(), new ItemStack(ModItems.ADVANCE_BREAKER.get()), 50, 15);
        registerRecipe(Item.byBlock(ModBlocks.IGNITHRA_BLOCK.get()),ModItems.ADVANCE_BREAKER.get(), new ItemStack(ModItems.MEGA_ADVANCE_BREAKER.get()), 50, 32);
        registerRecipe(Item.byBlock(ModBlocks.IGNITHRA_BLOCK.get()), ModItems.MEGA_SIMPLE_BREAKER.get(), new ItemStack(ModItems.MEGA_ADVANCE_BREAKER.get()), 50, 64);

        registerRecipe(Item.byBlock(ModBlocks.ASTRALITE_BLOCK.get()), ModItems.ADVANCE_BREAKER.get(), new ItemStack(ModItems.ULTRA_BREAKER.get()), 60, 15);
        registerRecipe(Item.byBlock(ModBlocks.ASTRALITE_BLOCK.get()), ModItems.ULTRA_BREAKER.get(), new ItemStack(ModItems.MEGA_ULTRA_BREAKER.get()), 60, 32);
        registerRecipe(Item.byBlock(ModBlocks.ASTRALITE_BLOCK.get()), ModItems.MEGA_ADVANCE_BREAKER.get(), new ItemStack(ModItems.MEGA_ULTRA_BREAKER.get()), 60, 64);

        registerRecipe(Item.byBlock(ModBlocks.NEXALITE_BLOCK.get()), ModItems.ULTRA_BREAKER.get(), new ItemStack(ModItems.ULTIMATE_BREAKER.get()), 70, 15);
        registerRecipe(Item.byBlock(ModBlocks.NEXALITE_BLOCK.get()), ModItems.ULTIMATE_BREAKER.get(), new ItemStack(ModItems.MEGA_ULTIMATE_BREAKER.get()), 70, 32);
        registerRecipe(Item.byBlock(ModBlocks.NEXALITE_BLOCK.get()), ModItems.MEGA_ULTRA_BREAKER.get(), new ItemStack(ModItems.MEGA_ULTIMATE_BREAKER.get()), 70, 64);

        registerRecipe(Item.byBlock(ModBlocks.CELESTINE_BLOCK.get()), ModItems.ULTIMATE_BREAKER.get(), new ItemStack(ModItems.LEGENDARY_BREAKER.get()), 80, 15);
        registerRecipe(Item.byBlock(ModBlocks.CELESTINE_BLOCK.get()), ModItems.LEGENDARY_BREAKER.get(), new ItemStack(ModItems.MEGA_LEGENDARY_BREAKER.get()), 80, 32);
        registerRecipe(Item.byBlock(ModBlocks.CELESTINE_BLOCK.get()), ModItems.MEGA_ULTRA_BREAKER.get(), new ItemStack(ModItems.MEGA_LEGENDARY_BREAKER.get()), 80, 64);

        registerRecipe(Item.byBlock(ModBlocks.ZENITHRA_BLOCK.get()), ModItems.LEGENDARY_BREAKER.get(), new ItemStack(ModItems.ATOMIC_BREAKER.get()), 90, 15);
        registerRecipe(Item.byBlock(ModBlocks.ZENITHRA_BLOCK.get()), ModItems.ATOMIC_BREAKER.get(), new ItemStack(ModItems.MEGA_ATOMIC_BREAKER.get()), 90, 32);
        registerRecipe(Item.byBlock(ModBlocks.ZENITHRA_BLOCK.get()), ModItems.MEGA_LEGENDARY_BREAKER.get(), new ItemStack(ModItems.MEGA_ATOMIC_BREAKER.get()), 90, 64);
    }

    private void registerRecipe(Item leftItem, Item rightItem, ItemStack result, int cost, int materialCost) {
        String key = getItemKey(leftItem) + "_" + getItemKey(rightItem);
        RECIPES.put(key, new AnvilRecipe(leftItem, rightItem, result, cost, materialCost));
    }

    private String getItemKey(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString();
    }

    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (left.isEmpty() || right.isEmpty()) {
            return;
        }

        AnvilRecipe recipe = findRecipe(left.getItem(), right.getItem());
        if (recipe != null) {
            ItemStack result = recipe.getResult().copy();
            event.setOutput(result);
            event.setCost(recipe.getCost());
            event.setMaterialCost(recipe.getMaterialCost());
        } else {
            event.setOutput(ItemStack.EMPTY);
        }
    }

    @SubscribeEvent
    public void onAnvilRepair(AnvilRepairEvent event) {
        ItemStack output = event.getOutput();
        Player player = event.getEntity();
        Container anvilContainer = player.containerMenu.getSlot(0).container;

        ItemStack leftStack = anvilContainer.getItem(0);
        ItemStack rightStack = anvilContainer.getItem(1);

        AnvilRecipe recipe = findRecipe(leftStack.getItem(), rightStack.getItem());
        if (recipe != null && !leftStack.isEmpty() && !rightStack.isEmpty()) {

            boolean isLeftMaterial = leftStack.getItem() == recipe.getLeftItem();
            boolean isRightMaterial = rightStack.getItem() == recipe.getRightItem();

            ItemStack materialStack = isLeftMaterial ? leftStack : rightStack;
            ItemStack toolStack = isLeftMaterial ? rightStack : leftStack;

            if (materialStack.getCount() != recipe.getMaterialCost()) {
                event.setCanceled(true);
                return;
            }

            toolStack.shrink(1);
            materialStack.shrink(recipe.getMaterialCost());

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }
    }

    private AnvilRecipe findRecipe(Item leftItem, Item rightItem) {
        String key1 = getItemKey(leftItem) + "_" + getItemKey(rightItem);
        String key2 = getItemKey(rightItem) + "_" + getItemKey(leftItem);

        return RECIPES.getOrDefault(key1, RECIPES.get(key2));
    }
}