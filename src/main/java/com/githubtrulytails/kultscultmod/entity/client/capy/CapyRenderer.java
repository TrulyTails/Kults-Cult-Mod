package com.githubtrulytails.kultscultmod.entity.client.capy;

import com.githubtrulytails.kultscultmod.KultsCultMod;
import com.githubtrulytails.kultscultmod.entity.client.ModModelLayers;
import com.githubtrulytails.kultscultmod.entity.custom.CapyEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CapyRenderer extends MobEntityRenderer<CapyEntity, CapyModel<CapyEntity>>{

    private static final Identifier TEXTURE = new Identifier(KultsCultMod.MOD_ID,"textures/entity/capy_texture.png");
    public CapyRenderer(EntityRendererFactory.Context context) {
        //shadow size
        super(context, new CapyModel(context.getPart(ModModelLayers.CAPY)),0.1F);
    }

    @Override
    public Identifier getTexture(CapyEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CapyEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        }else{
            matrixStack.scale(1f,1f,1f);

        }


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}

