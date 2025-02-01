package net.vector.megabreakertools.crafting;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vector.megabreakertools.item.ModItems;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber
public class ModAnvilRecipe {
    private static final Map<String, AnvilRecipe> RECIPES = new HashMap<>();

    public ModAnvilRecipe() {
        MinecraftForge.EVENT_BUS.register(this);
        registerRecipes();
    }

    private void registerRecipes() {
        // Registra as receitas
        registerRecipe(Items.DIRT, ModItems.SIMPLE_BREAKER.get(), new ItemStack(ModItems.BIG_SIMPLE_BREAKER.get()), 15, 5);

        registerRecipe(Items.STONE, ModItems.SIMPLE_BREAKER.get(), new ItemStack(ModItems.ADVANCE_BREAKER.get()), 40, 1);
        registerRecipe(Items.DIRT, ModItems.ADVANCE_BREAKER.get(), new ItemStack(ModItems.BIG_ADVANCE_BREAKER.get()), 40, 1);
        registerRecipe(Items.DIRT, ModItems.BIG_SIMPLE_BREAKER.get(), new ItemStack(ModItems.BIG_ADVANCE_BREAKER.get()), 40, 1);

        registerRecipe(Items.STONE, ModItems.ADVANCE_BREAKER.get(), new ItemStack(ModItems.ULTRA_BREAKER.get()), 50, 1);
        registerRecipe(Items.DIRT, ModItems.ULTRA_BREAKER.get(), new ItemStack(ModItems.BIG_ULTRA_BREAKER.get()), 50, 1);
        registerRecipe(Items.DIRT, ModItems.BIG_ADVANCE_BREAKER.get(), new ItemStack(ModItems.BIG_ULTRA_BREAKER.get()), 50, 1);

        registerRecipe(Items.STONE, ModItems.ULTRA_BREAKER.get(), new ItemStack(ModItems.ULTIMATE_BREAKER.get()), 60, 1);
        registerRecipe(Items.DIRT, ModItems.ULTIMATE_BREAKER.get(), new ItemStack(ModItems.BIG_ULTIMATE_BREAKER.get()), 60, 1);
        registerRecipe(Items.DIRT, ModItems.BIG_ULTRA_BREAKER.get(), new ItemStack(ModItems.BIG_ULTIMATE_BREAKER.get()), 60, 1);

        registerRecipe(Items.STONE, ModItems.ULTIMATE_BREAKER.get(), new ItemStack(ModItems.LEGENDARY_BREAKER.get()), 70, 1);
        registerRecipe(Items.DIRT, ModItems.LEGENDARY_BREAKER.get(), new ItemStack(ModItems.BIG_LEGENDARY_BREAKER.get()), 70, 1);
        registerRecipe(Items.DIRT, ModItems.BIG_ULTIMATE_BREAKER.get(), new ItemStack(ModItems.BIG_LEGENDARY_BREAKER.get()), 70, 1);

        registerRecipe(Items.STONE, ModItems.LEGENDARY_BREAKER.get(), new ItemStack(ModItems.ATOMIC_BREAKER.get()), 80, 1);
        registerRecipe(Items.DIRT, ModItems.ATOMIC_BREAKER.get(), new ItemStack(ModItems.BIG_ATOMIC_BREAKER.get()), 80, 1);
        registerRecipe(Items.DIRT, ModItems.BIG_LEGENDARY_BREAKER.get(), new ItemStack(ModItems.BIG_ATOMIC_BREAKER.get()), 80, 1);
        // Adicione mais receitas aqui...
    }

    private void registerRecipe(Item leftItem, Item rightItem, ItemStack result, int cost, int materialCost) {
        String key = getItemKey(leftItem) + "_" + getItemKey(rightItem);
        RECIPES.put(key, new AnvilRecipe(leftItem, rightItem, result, cost, materialCost));
    }

    private String getItemKey(Item item) {
        return BuiltInRegistries.ITEM.getKey(item).toString(); // Obtém o nome de registro do item
    }

    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();

        if (left.isEmpty() || right.isEmpty()) {
            return;
        }

        // Verifica se há uma receita para os itens na bigorna
        AnvilRecipe recipe = findRecipe(left.getItem(), right.getItem());
        if (recipe != null) {
            int craftableAmount = Math.min(left.getCount(), right.getCount());
            ItemStack result = recipe.getResult().copy();
            result.setCount(craftableAmount);

            event.setOutput(result);
            event.setCost(recipe.getCost() * craftableAmount);
            event.setMaterialCost(recipe.getMaterialCost() * craftableAmount);
        } else {
            event.setOutput(ItemStack.EMPTY);
        }
    }

    private AnvilRecipe findRecipe(Item leftItem, Item rightItem) {
        String key1 = getItemKey(leftItem) + "_" + getItemKey(rightItem);
        String key2 = getItemKey(rightItem) + "_" + getItemKey(leftItem);

        return RECIPES.getOrDefault(key1, RECIPES.get(key2));
    }

    @SubscribeEvent
    public void onAnvilRepair(AnvilRepairEvent event) {
        ItemStack output = event.getOutput();
        Player player = event.getEntity();
        Container anvilContainer = player.containerMenu.getSlot(0).container;

        ItemStack leftStack = anvilContainer.getItem(0);
        ItemStack rightStack = anvilContainer.getItem(1);

        if (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            int craftedAmount = output.getCount();
            leftStack.shrink(craftedAmount);
            rightStack.shrink(craftedAmount);

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }
    }
}