package com.githubtrulytails.kultscultmod.items;

import com.githubtrulytails.kultscultmod.KultsCultMod;
import com.githubtrulytails.kultscultmod.items.item_classes.FollowerShard;
import com.githubtrulytails.kultscultmod.items.item_classes.RitualBladeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {


//register basic item
public static final Item BASIC_ITEM = registerItem("basic_item", new Item(new FabricItemSettings()));

//register class item (please just use this for all items inside of KCM.
    public static final Item FOLLOWER_SHARD = registerItem("follower_shard", new FollowerShard
            (new FabricItemSettings()));


    public static final Item RITUAL_DAGGER = registerItem("ritual_dagger", new RitualBladeItem(
            ModToolMaterials.RITUAL_MATERIAL, 0, 16F, new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(KultsCultMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        KultsCultMod.LOGGER.info("Registering Mod Items for " + KultsCultMod.MOD_ID);

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);

    }

}
