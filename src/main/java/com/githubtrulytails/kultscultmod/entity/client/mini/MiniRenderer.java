package com.githubtrulytails.kultscultmod.entity.client.mini;

import com.githubtrulytails.kultscultmod.KultsCultMod;
import com.githubtrulytails.kultscultmod.entity.client.ModModelLayers;
import com.githubtrulytails.kultscultmod.entity.custom.CapyEntity;
import com.githubtrulytails.kultscultmod.entity.custom.MinithulusEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MiniRenderer extends MobEntityRenderer<MinithulusEntity, MiniModel<MinithulusEntity>> {

    private static final Identifier TEXTURE = new Identifier(KultsCultMod.MOD_ID, "textures/entity/minithulus_texture.png");
    public MiniRenderer(EntityRendererFactory.Context context){

        super(context, new MiniModel(context.getPart(ModModelLayers.MINI)), 0.1F);
    }

    @Override
    public Identifier getTexture(MinithulusEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(MinithulusEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(!mobEntity.isBaby()){
            matrixStack.scale(2f,2f,2f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

}
