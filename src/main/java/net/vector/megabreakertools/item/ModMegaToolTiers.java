package net.vector.megabreakertools.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.vector.megabreakertools.util.ModTags;

public class ModMegaToolTiers {
    public static final Tier IGNITHRA = new ForgeTier(800, 0f, 0f, 15,
            ModTags.Blocks.NEEDS_STONE_TOOL, () -> Ingredient.of(ModItems.IGNITHRA.get()),
            ModTags.Blocks.INCORRECT_FOR_STONE_TOOL);
    public static final Tier ASTRALITE = new ForgeTier(1300, 0f, 0f, 20,
            ModTags.Blocks.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.ASTRALITE.get()),
            ModTags.Blocks.INCORRECT_FOR_IRON_TOOL);
    public static final Tier CELESTINE = new ForgeTier(2300, 0f, 0f, 25,
            ModTags.Blocks.NEEDS_DIAMOND_TOOL, () -> Ingredient.of(ModItems.CELESTINE.get()),
            ModTags.Blocks.INCORRECT_FOR_DIAMOND_TOOL);
    public static final Tier OBSCURITE = new ForgeTier(4600, 0f, 0f, 30,
            ModTags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.of(ModItems.OBSCURITE.get()),
            ModTags.Blocks.INCORRECT_FOR_NETHERITE_TOOL);
}