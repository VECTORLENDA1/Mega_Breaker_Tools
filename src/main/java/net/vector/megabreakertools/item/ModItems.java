package net.vector.megabreakertools.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vector.megabreakertools.MegaBreakerTools;
import net.vector.megabreakertools.item.custom.*;
import net.vector.megabreakertools.item.custom.pickaxe.*;
import net.vector.megabreakertools.item.custom.pickaxe.SimpleBreakerItem;
import net.vector.megabreakertools.item.custom.pickaxe.UltraBreakerItem;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MegaBreakerTools.MODID);



    //Items//
    public static final RegistryObject<Item> CELESTINE = ITEMS.register("celestine",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ZENITHRA = ITEMS.register("zenithra",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASTRALITE = ITEMS.register("astralite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ASTRALITE = ITEMS.register("raw_astralite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NEXALITE = ITEMS.register("raw_nexalite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NEXALITE = ITEMS.register("nexalite",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> IGNITHRA = ITEMS.register("ignithra",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_IGNITHRA = ITEMS.register("raw_ignithra",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ANTRACITE = ITEMS.register("antracite",
            () -> new FuelItem(new Item.Properties(), 3200));
    public static final RegistryObject<Item> RAW_OBSCURIDIUM = ITEMS.register("raw_obscuridium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBSCURIDIUM = ITEMS.register("obscuridium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OBSCURITE = ITEMS.register("obscurite",
            () -> new Item(new Item.Properties()));


    //Mega Tools
    public static final RegistryObject<Item> SIMPLE_BREAKER = ITEMS.register("simple_breaker",
            () -> new SimpleBreakerItem(ModMegaToolTiers.ASTRALITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.ASTRALITE, 2, -0.5F))));
    public static final RegistryObject<Item> BIG_SIMPLE_BREAKER = ITEMS.register("big_simple_breaker",
            () -> new MegaSimpleBreakerItem(ModMegaToolTiers.ASTRALITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.ASTRALITE, 2, -0.5F))));
    public static final RegistryObject<Item> ADVANCE_BREAKER = ITEMS.register("advance_breaker",
            () -> new AdvanceBreakerItem(ModMegaToolTiers.CELESTINE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.CELESTINE, 2, -0.5F))));
    public static final RegistryObject<Item> BIG_ADVANCE_BREAKER = ITEMS.register("big_advance_breaker",
            () -> new MegaAdvanceBreakerItem(ModMegaToolTiers.CELESTINE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.CELESTINE, 2, -0.5F))));
    public static final RegistryObject<Item> ULTRA_BREAKER = ITEMS.register("ultra_breaker",
            () -> new UltraBreakerItem(ModMegaToolTiers.CELESTINE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.CELESTINE, 2, -0.5F))));
    public static final RegistryObject<Item> BIG_ULTRA_BREAKER = ITEMS.register("big_ultra_breaker",
            () -> new MegaUltraBreakerItem(ModMegaToolTiers.CELESTINE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.CELESTINE, 2, -0.5F))));
    public static final RegistryObject<Item> ULTIMATE_BREAKER = ITEMS.register("ultimate_breaker",
            () -> new UltimateBreakerItem(ModMegaToolTiers.ASTRALITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.ASTRALITE, 2, -0.5F))));
    public static final RegistryObject<Item> BIG_ULTIMATE_BREAKER = ITEMS.register("big_ultimate_breaker",
            () -> new MegaUltimateBreakerItem(ModMegaToolTiers.ASTRALITE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.ASTRALITE, 2, -0.5F))));
    public static final RegistryObject<Item> LEGENDARY_BREAKER = ITEMS.register("legendary_breaker",
            () -> new LegendaryBreakerItem(ModMegaToolTiers.CELESTINE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.CELESTINE, 2, -0.5F))));
    public static final RegistryObject<Item> BIG_LEGENDARY_BREAKER = ITEMS.register("big_legendary_breaker",
            () -> new MegaLegendaryBreakerItem(ModMegaToolTiers.CELESTINE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.CELESTINE, 2, -0.5F))));
    public static final RegistryObject<Item> ATOMIC_BREAKER = ITEMS.register("atomic_breaker",
            () -> new AtomicBreakerItem(ModMegaToolTiers.CELESTINE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.CELESTINE, 2, -0.5F))));
    public static final RegistryObject<Item> BIG_ATOMIC_BREAKER = ITEMS.register("big_atomic_breaker",
            () -> new MegaAtomicBreakerItem(ModMegaToolTiers.CELESTINE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModMegaToolTiers.CELESTINE, 2, -0.5F))));



    public static void Register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
