package com.githubtrulytails.kultscultmod.datagen;

import com.githubtrulytails.kultscultmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_CORE, 1)
                .input(ModItems.RITUAL_SHARD).input(Items.COPPER_INGOT).group("copper core")
                .criterion(RecipeProvider.hasItem(ModItems.RITUAL_SHARD),
                        (AdvancementCriterion) RecipeProvider.conditionsFromItem(ModItems.COPPER_CORE)).offerTo(exporter,
                        RecipeProvider.convertBetween(Items.COPPER_INGOT, ModItems.RITUAL_SHARD));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_CORE, 1)
                .input(ModItems.RITUAL_SHARD).input(Items.IRON_INGOT).group("iron core")
                .criterion(RecipeProvider.hasItem(ModItems.RITUAL_SHARD),
                        (AdvancementCriterion) RecipeProvider.conditionsFromItem(ModItems.RITUAL_SHARD)).offerTo(exporter,
                        RecipeProvider.convertBetween(ModItems.IRON_CORE, ModItems.RITUAL_SHARD));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLD_CORE, 1)
                .input(ModItems.RITUAL_SHARD).input(Items.GOLD_INGOT).group("gold core")
                .criterion(RecipeProvider.hasItem(ModItems.RITUAL_SHARD),
                        (AdvancementCriterion) RecipeProvider.conditionsFromItem(ModItems.RITUAL_SHARD)).offerTo(exporter,
                        RecipeProvider.convertBetween(ModItems.GOLD_CORE, ModItems.RITUAL_SHARD));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.DIAMOND_CORE, 1)
                .input(ModItems.RITUAL_SHARD).input(Items.DIAMOND).group("diamond core")
                .criterion(RecipeProvider.hasItem(ModItems.RITUAL_SHARD),
                        (AdvancementCriterion) RecipeProvider.conditionsFromItem(ModItems.RITUAL_SHARD)).offerTo(exporter,
                        RecipeProvider.convertBetween(ModItems.DIAMOND_CORE, ModItems.RITUAL_SHARD));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.EMERALD_CORE, 1)
                .input(ModItems.RITUAL_SHARD).input(Items.EMERALD).group("emerald core")
                .criterion(RecipeProvider.hasItem(ModItems.RITUAL_SHARD),
                        (AdvancementCriterion) RecipeProvider.conditionsFromItem(ModItems.RITUAL_SHARD)).offerTo(exporter,
                        RecipeProvider.convertBetween(ModItems.EMERALD_CORE, ModItems.RITUAL_SHARD));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.AMETHYST_CORE, 1)
                .input(ModItems.RITUAL_SHARD).input(Items.AMETHYST_SHARD).group("amethyst core")
                .criterion(RecipeProvider.hasItem(ModItems.RITUAL_SHARD),
                        (AdvancementCriterion) RecipeProvider.conditionsFromItem(ModItems.RITUAL_SHARD)).offerTo(exporter,
                        RecipeProvider.convertBetween(ModItems.AMETHYST_CORE, ModItems.RITUAL_SHARD));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.QUARTZ_CORE, 1)
                .input(ModItems.RITUAL_SHARD).input(Items.QUARTZ).group("quartz core")
                .criterion(RecipeProvider.hasItem(ModItems.RITUAL_SHARD),
                        (AdvancementCriterion) RecipeProvider.conditionsFromItem(ModItems.RITUAL_SHARD)).offerTo(exporter,
                        RecipeProvider.convertBetween(ModItems.QUARTZ_CORE, ModItems.RITUAL_SHARD));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.NETHERITE_CORE, 1)
                .input(ModItems.RITUAL_SHARD).input(Items.NETHERITE_INGOT).group("netherite core")
                .criterion(RecipeProvider.hasItem(ModItems.RITUAL_SHARD),
                        (AdvancementCriterion) RecipeProvider.conditionsFromItem(ModItems.RITUAL_SHARD)).offerTo(exporter,
                        RecipeProvider.convertBetween(ModItems.NETHERITE_CORE, ModItems.RITUAL_SHARD));



    }
}
