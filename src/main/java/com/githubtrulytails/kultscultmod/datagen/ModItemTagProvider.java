package com.githubtrulytails.kultscultmod.datagen;

import com.githubtrulytails.kultscultmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider{


    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {



/*
this was used to make a random tag for items i made

        // needed       tag name      blah blah needed      .ITEM, new Identifier "modname:tagname"
        TagKey<Item> AURITE_ITEMS = TagKey.of(RegistryKeys.ITEM, new Identifier("trulyunknown:aurite_items"));

        //call tag and add things to it
        getOrCreateTagBuilder(AURITE_ITEMS)
                .add(ModItems.AURITE)
                .add(ModItems.RAW_AURITE)
                .add(ModItems.AURITE_BERRIES);

    }*/
    }
}
