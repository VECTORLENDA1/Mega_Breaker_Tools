package net.vector.megabreakertools.event;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.vector.megabreakertools.MegaBreakerTools;
import net.vector.megabreakertools.item.custom.pickaxe.*;

import java.util.HashSet;
import java.util.Set;

@Mod.EventBusSubscriber(modid = MegaBreakerTools.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        //SIMPLE BREAKER//
        if(mainHandItem.getItem() instanceof SimpleBreakerItem SimpleBreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : SimpleBreakerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !SimpleBreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                destroyedAnyBlock = true;
                HARVESTED_BLOCKS.remove(pos);
            }



            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 1);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }


        if(mainHandItem.getItem() instanceof MegaSimpleBreakerItem MegaSimplebreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : MegaSimpleBreakerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !MegaSimplebreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }



            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 27);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }


        //ADVANCE BREAKER//
        if(mainHandItem.getItem() instanceof AdvanceBreakerItem Advancebreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : AdvanceBreakerItem.getBlocksToBeDestroyed(2, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !Advancebreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 25);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }

        if(mainHandItem.getItem() instanceof MegaAdvanceBreakerItem MegaAdvancebreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : MegaAdvanceBreakerItem.getBlocksToBeDestroyed(2, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !MegaAdvancebreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 125);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }

        //ULTRA BREAKER//
        if(mainHandItem.getItem() instanceof UltraBreakerItem Ultrabreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : UltraBreakerItem.getBlocksToBeDestroyed(3, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !Ultrabreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 49);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }

        if(mainHandItem.getItem() instanceof MegaUltraBreakerItem MegaUltrabreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : MegaUltraBreakerItem.getBlocksToBeDestroyed(3, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !MegaUltrabreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 343);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }

        //ULTIMATE BREAKER//
        if(mainHandItem.getItem() instanceof UltimateBreakerItem Ultimatebreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : UltimateBreakerItem.getBlocksToBeDestroyed(4, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !Ultimatebreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 81);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }

        if(mainHandItem.getItem() instanceof MegaUltimateBreakerItem MegaUltimatebreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : MegaUltimateBreakerItem.getBlocksToBeDestroyed(4, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !MegaUltimatebreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 729);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }

        //LEGENDARY BREAKER//
        if(mainHandItem.getItem() instanceof LegendaryBreakerItem Legendarybreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : LegendaryBreakerItem.getBlocksToBeDestroyed(5, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !Legendarybreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 121);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }

        if(mainHandItem.getItem() instanceof MegaLegendaryBreakerItem MegaLegendarybreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : MegaLegendaryBreakerItem.getBlocksToBeDestroyed(5, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !MegaLegendarybreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 1331);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }

        //ATOMIC BREAKER//
        if(mainHandItem.getItem() instanceof AtomicBreakerItem Atomicbreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : AtomicBreakerItem.getBlocksToBeDestroyed(6, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !Atomicbreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 169);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }

        if(mainHandItem.getItem() instanceof MegaAtomicBreakerItem MegaAtomicbreaker && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            boolean destroyedAnyBlock = false;

            for(BlockPos pos : MegaAtomicBreakerItem.getBlocksToBeDestroyed(6, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !MegaAtomicbreaker.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
                destroyedAnyBlock = true;
            }

            if (destroyedAnyBlock) {
                int currentDamage = mainHandItem.getDamageValue();
                mainHandItem.setDamageValue(currentDamage - 2197);

                if (mainHandItem.getDamageValue() >= mainHandItem.getMaxDamage()) {
                    mainHandItem.shrink(1);
                }
            }
        }
    }
}
