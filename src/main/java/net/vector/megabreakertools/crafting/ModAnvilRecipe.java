package net.vector.megabreakertools.crafting;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.entity.player.AnvilRepairEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.vector.megabreakertools.item.ModItems;


public class ModAnvilRecipe {
    public ModAnvilRecipe() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        Player player = event.getPlayer();

        //SIMPLE BREAKER//
        if ((left.getItem() == ModItems.OBSCURITE.get() && left.getCount() == 4 && right.getItem() == ModItems.SIMPLE_BREAKER.get() && right.getCount() == 1) ||
                (right.getItem() == ModItems.OBSCURITE.get() && right.getCount() == 4 && left.getItem() == ModItems.SIMPLE_BREAKER.get() && left.getCount() == 1)) {

            ItemStack result = new ItemStack(ModItems.BIG_SIMPLE_BREAKER.get(), 1);
            event.setOutput(result);

            event.setCost(15);

            event.setMaterialCost(5);

        } else {
            event.setOutput(ItemStack.EMPTY);
        }


        //ADVANCE BREAKER//
        if ((left.getItem() == Items.STONE && right.getItem() == ModItems.SIMPLE_BREAKER.get()) ||
                (right.getItem() == Items.STONE && left.getItem() == ModItems.SIMPLE_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.STONE ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.SIMPLE_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.ADVANCE_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(20 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.ADVANCE_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.ADVANCE_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.ADVANCE_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_ADVANCE_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(20 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.BIG_SIMPLE_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.BIG_SIMPLE_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.BIG_SIMPLE_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_ADVANCE_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(20 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        //ULTRA BREAKER//
        if ((left.getItem() == Items.STONE && right.getItem() == ModItems.ADVANCE_BREAKER.get()) ||
                (right.getItem() == Items.STONE && left.getItem() == ModItems.ADVANCE_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.STONE ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.ADVANCE_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.ULTRA_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(30 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.ULTRA_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.ULTRA_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.ULTRA_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_ULTRA_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(30 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.BIG_ADVANCE_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.BIG_ADVANCE_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.BIG_ADVANCE_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_ULTRA_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(30 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        //ULTIMATE BREAKER//
        if ((left.getItem() == Items.STONE && right.getItem() == ModItems.ULTRA_BREAKER.get()) ||
                (right.getItem() == Items.STONE && left.getItem() == ModItems.ULTRA_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.STONE ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.ULTRA_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.ULTIMATE_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(40 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.ULTIMATE_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.ULTIMATE_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.ULTIMATE_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_ULTIMATE_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(40 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.BIG_ULTRA_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.BIG_ULTRA_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.BIG_ULTRA_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_ULTIMATE_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(40 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        //LEGENDARY BREAKER//
        if ((left.getItem() == Items.STONE && right.getItem() == ModItems.ULTIMATE_BREAKER.get()) ||
                (right.getItem() == Items.STONE && left.getItem() == ModItems.ULTIMATE_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.STONE ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.ULTIMATE_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.LEGENDARY_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(50 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.LEGENDARY_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.LEGENDARY_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.LEGENDARY_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_LEGENDARY_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(50 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.BIG_ULTIMATE_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.BIG_ULTIMATE_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.BIG_ULTIMATE_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_LEGENDARY_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(50 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        //ATOMIC BREAKER//
        if ((left.getItem() == Items.STONE && right.getItem() == ModItems.LEGENDARY_BREAKER.get()) ||
                (right.getItem() == Items.STONE && left.getItem() == ModItems.LEGENDARY_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.STONE ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.LEGENDARY_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.ATOMIC_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(60 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.BIG_LEGENDARY_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.BIG_LEGENDARY_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.BIG_LEGENDARY_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_ATOMIC_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(60 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }

        if ((left.getItem() == Items.DIRT && right.getItem() == ModItems.ATOMIC_BREAKER.get()) ||
                (right.getItem() == Items.DIRT && left.getItem() == ModItems.ATOMIC_BREAKER.get())) {

            ItemStack celestineStack = left.getItem() == Items.DIRT ? left : right;
            ItemStack simpleBreakerStack = left.getItem() == ModItems.ATOMIC_BREAKER.get() ? left : right;

            int craftableAmount = Math.min(celestineStack.getCount(), simpleBreakerStack.getCount());

            ItemStack result = new ItemStack(ModItems.BIG_ATOMIC_BREAKER.get(), craftableAmount);
            event.setOutput(result);

            event.setCost(60 * craftableAmount);

            event.setMaterialCost(craftableAmount);
        }
    }

    @SubscribeEvent
    public void onAnvilRepair(AnvilRepairEvent event) {
        ItemStack output = event.getOutput();

        //SIMPLE BREAKER//
        if (output.getItem() == ModItems.SIMPLE_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == ModItems.OBSCURITE.get()) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        //ADVANCE BREAKER//
        if (output.getItem() == ModItems.ADVANCE_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.STONE) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        if (output.getItem() == ModItems.BIG_ADVANCE_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.DIRT) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        //ULTRA BREAKER//
        if (output.getItem() == ModItems.ULTRA_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.STONE) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        if (output.getItem() == ModItems.BIG_ULTRA_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.DIRT) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        //ULTIMATE BREAKER//
        if (output.getItem() == ModItems.ULTIMATE_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.STONE) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        if (output.getItem() == ModItems.BIG_ULTIMATE_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.DIRT) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        //LEGENDARY BREAKER//
        if (output.getItem() == ModItems.LEGENDARY_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.STONE) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        if (output.getItem() == ModItems.BIG_LEGENDARY_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.DIRT) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        //ATOMIC BREAKER//
        if (output.getItem() == ModItems.ATOMIC_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.STONE) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }

        if (output.getItem() == ModItems.BIG_ATOMIC_BREAKER.get()) {
            int craftedAmount = output.getCount();

            Player player = event.getEntity();
            Container anvilContainer = player.containerMenu.getSlot(0).container;
            ItemStack leftStack = anvilContainer.getItem(0);
            ItemStack rightStack = anvilContainer.getItem(1);

            if (leftStack.getItem() == Items.DIRT) {
                leftStack.shrink(craftedAmount);
                rightStack.shrink(craftedAmount);
            } else {
                rightStack.shrink(craftedAmount);
                leftStack.shrink(craftedAmount);
            }

            anvilContainer.setItem(0, leftStack);
            anvilContainer.setItem(1, rightStack);
        }
    }
}