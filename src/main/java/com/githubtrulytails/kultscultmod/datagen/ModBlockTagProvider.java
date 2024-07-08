package com.githubtrulytails.kultscultmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final TagKey<Block> RAT_SPAWNABLE = TagKey.of(RegistryKeys.BLOCK, Identifier.of("kultscultmod", "rat_spawnable"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {


        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
        // add for tool to be pickaxe


        ;// end pickaxe

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)


        ;//end axe

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
        // add for stone level

        ;//end stone tool


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
        // add for iron level

        ;//end iron tool
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        // add for diamond level


        ;// end diamond tool


        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric","needs_tool_level_4")))
        //.add(ModBlocks.[BLOCK])


        ; //end netherite tool

    }


}

