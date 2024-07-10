package com.githubtrulytails.kultscultmod.items;

import com.githubtrulytails.kultscultmod.KultsCultMod;
import com.githubtrulytails.kultscultmod.Blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroups {
    public static final ItemGroup KULTSCULTMOD = Registry.register(Registries.ITEM_GROUP,
            new Identifier(KultsCultMod.MOD_ID, "kultscultmod"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.kultscultmod"))
                    .icon(()->new ItemStack(Items.DIAMOND)).entries((displayContext, entries) -> {
                        //adds items to creative tab
                        entries.add(ModItems.FOLLOWER_SHARD);
                        entries.add(ModItems.RITUAL_SHARD);
                        entries.add(ModItems.PLAGUE_ITEM);

                        entries.add(ModItems.RITUAL_DAGGER);


                       entries.add(ModItems.RAT_SPAWN_EGG);
                       entries.add(ModItems.WRING_SPAWN_EGG);
                       entries.add(ModItems.CAPY_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups(){
        KultsCultMod.LOGGER.info("Registering Item Groups for "+ KultsCultMod.MOD_ID);
    }


}
