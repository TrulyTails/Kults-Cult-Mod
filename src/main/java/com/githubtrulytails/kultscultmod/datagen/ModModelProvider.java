package com.githubtrulytails.kultscultmod.datagen;

import com.githubtrulytails.kultscultmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

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

    }
}
