package net.vector.megabreakertools.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_IRON_TOOL = tag("needs_iron_tool");
        public static final TagKey<Block> INCORRECT_FOR_IRON_TOOL = tag("incorrect_for_iron_tool");
        public static final TagKey<Block> NEEDS_DIAMOND_TOOL = tag("needs_diamond_tool");
        public static final TagKey<Block> INCORRECT_FOR_DIAMOND_TOOL = tag("incorrect_for_diamond_tool");


        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("megabreakertools", name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("megabreakertools", name));
        }
    }
}
