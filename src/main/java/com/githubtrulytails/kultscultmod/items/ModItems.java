package com.githubtrulytails.kultscultmod.items;

import com.githubtrulytails.kultscultmod.KultsCultMod;
import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.items.item_classes.FollowerShard;
import com.githubtrulytails.kultscultmod.items.item_classes.PlagueItem;
import com.githubtrulytails.kultscultmod.items.item_classes.RitualBladeItem;
import com.githubtrulytails.kultscultmod.items.item_classes.RitualShard;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


//register basic item
public static final Item BASIC_ITEM = registerItem("basic_item", new Item(new FabricItemSettings()));

//add a spawn egg
 public static final Item RAT_SPAWN_EGG = registerItem("rat_spawn_egg", new SpawnEggItem
        (ModEntities.RAT, 0xa86518, 0x3b260f, new FabricItemSettings()));

public static final Item CAPY_SPAWN_EGG = registerItem("capy_spawn_egg", new SpawnEggItem
        (ModEntities.CAPY, 0xa84518, 0x2b257f, new FabricItemSettings()));

public static final Item WRING_SPAWN_EGG = registerItem("wring_spawn_egg", new SpawnEggItem
        (ModEntities.WRING, 0xa99918, 0x3b293f, new FabricItemSettings()));

//register class item (please just use this for all items inside KCM.
    public static final Item FOLLOWER_SHARD = registerItem("follower_shard", new FollowerShard
            (new FabricItemSettings()));

    public static final Item RITUAL_SHARD = registerItem("ritual_shard", new RitualShard
            (new FabricItemSettings()));

 public static final Item PLAGUE_ITEM = registerItem("plague_item", new PlagueItem
            (new FabricItemSettings()));


// when registering a weapon/tool just set the damage and attack speed here rather than the tool material.
    public static final Item RITUAL_DAGGER = registerItem("ritual_dagger", new RitualBladeItem(
            ModToolMaterials.RITUAL_MATERIAL, 10, 16F, new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(KultsCultMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        KultsCultMod.LOGGER.info("Registering Mod Items for " + KultsCultMod.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);

    }

}
