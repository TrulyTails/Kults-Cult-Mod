package com.githubtrulytails.kultscultmod.datagen;

import com.githubtrulytails.kultscultmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        // for basic all sided blocks


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //for basic held items (not the tools model)
        itemModelGenerator.register(ModItems.FOLLOWER_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RITUAL_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLAGUE_ITEM, Models.GENERATED);

        //for tools
        itemModelGenerator.register(ModItems.RITUAL_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.RAT_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.WRING_SPAWN_EGG,

                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

   itemModelGenerator.register(ModItems.CAPY_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

    }
}
