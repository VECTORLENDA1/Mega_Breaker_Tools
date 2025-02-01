package net.vector.megabreakertools.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.vector.megabreakertools.util.ModTags;

public class ModMegaToolTiers {
    public static final Tier ASTRALITE = new ForgeTier(1500, 5, 3f, 20,
            ModTags.Blocks.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.ASTRALITE.get()),
            ModTags.Blocks.INCORRECT_FOR_IRON_TOOL);
    public static final Tier CELESTINE = new ForgeTier(3000, 6, 3f, 20,
            ModTags.Blocks.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.CELESTINE.get()),
            ModTags.Blocks.INCORRECT_FOR_DIAMOND_TOOL);
}