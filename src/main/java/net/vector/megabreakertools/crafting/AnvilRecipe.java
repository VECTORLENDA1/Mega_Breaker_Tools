package net.vector.megabreakertools.crafting;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AnvilRecipe {
    private final Item leftItem;
    private final Item rightItem;
    private final ItemStack result;
    private final int cost;
    private final int materialCost;

    public AnvilRecipe(Item leftItem, Item rightItem, ItemStack result, int cost, int materialCost) {
        this.leftItem = leftItem;
        this.rightItem = rightItem;
        this.result = result;
        this.cost = cost;
        this.materialCost = materialCost;
    }

    public Item getLeftItem() {
        return leftItem;
    }

    public Item getRightItem() {
        return rightItem;
    }

    public ItemStack getResult() {
        return result;
    }

    public int getCost() {
        return cost;
    }

    public int getMaterialCost() {
        return materialCost;
    }
}