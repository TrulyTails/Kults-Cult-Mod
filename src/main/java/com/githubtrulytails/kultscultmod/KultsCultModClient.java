package com.githubtrulytails.kultscultmod;

import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.entity.client.ModModelLayers;
import com.githubtrulytails.kultscultmod.entity.client.capy.CapyModel;
import com.githubtrulytails.kultscultmod.entity.client.capy.CapyRenderer;
import com.githubtrulytails.kultscultmod.entity.client.mini.MiniModel;
import com.githubtrulytails.kultscultmod.entity.client.mini.MiniRenderer;
import com.githubtrulytails.kultscultmod.entity.client.rat.RatModel;
import com.githubtrulytails.kultscultmod.entity.client.rat.RatRenderer;
import com.githubtrulytails.kultscultmod.entity.client.wring.WringModel;
import com.githubtrulytails.kultscultmod.entity.client.wring.WringRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class KultsCultModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {


        EntityRendererRegistry.register(ModEntities.RAT, RatRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.RAT, RatModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.WRING, WringRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.WRING, WringModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.CAPY, CapyRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CAPY, CapyModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.MINI, MiniRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.MINI, MiniModel::getTexturedModelData);



    }
}
