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
        itemModelGenerator.register(ModItems.COPPER_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.IRON_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AMETHYST_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIAMOND_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.QUARTZ_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MINITHULUS_TENTACLE, Models.GENERATED);


        //for tools
        itemModelGenerator.register(ModItems.RITUAL_DAGGER, Models.HANDHELD);

        itemModelGenerator.register(ModItems.RAT_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

        itemModelGenerator.register(ModItems.WRING_SPAWN_EGG,

                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

   itemModelGenerator.register(ModItems.CAPY_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

 itemModelGenerator.register(ModItems.MINITHULUS_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));

    }
}
