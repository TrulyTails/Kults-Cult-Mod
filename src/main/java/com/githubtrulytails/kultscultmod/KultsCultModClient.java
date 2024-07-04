package com.githubtrulytails.kultscultmod;

import com.githubtrulytails.kultscultmod.Blocks.ModBlocks;
import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.entity.client.ModModelLayers;
import com.githubtrulytails.kultscultmod.entity.client.RatModel;
import com.githubtrulytails.kultscultmod.entity.client.RatRenderer;
import com.githubtrulytails.kultscultmod.items.ModItemGroups;
import com.githubtrulytails.kultscultmod.items.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;

public class KultsCultModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        EntityRendererRegistry.register(ModEntities.RAT, RatRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAT, RatModel::getTexturedModelData);
    }
}
