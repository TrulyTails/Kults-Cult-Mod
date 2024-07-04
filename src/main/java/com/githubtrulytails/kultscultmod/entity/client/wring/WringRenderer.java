package com.githubtrulytails.kultscultmod.entity.client.wring;

import com.githubtrulytails.kultscultmod.KultsCultMod;
import com.githubtrulytails.kultscultmod.entity.client.ModModelLayers;
import com.githubtrulytails.kultscultmod.entity.client.rat.RatModel;
import com.githubtrulytails.kultscultmod.entity.custom.RatEntity;
import com.githubtrulytails.kultscultmod.entity.custom.WringEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class WringRenderer extends MobEntityRenderer<WringEntity, WringModel<WringEntity>> {

    private static final Identifier TEXTURE = new Identifier(KultsCultMod.MOD_ID,"textures/entity/wring.png");
    public WringRenderer(EntityRendererFactory.Context context) {
        //shadow size
        super(context, new WringModel<>(context.getPart(ModModelLayers.WRING)),0.1F);
    }

    @Override
    public Identifier getTexture(WringEntity entity) {
        return TEXTURE;
    }


    @Override
    public void render(WringEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(mobEntity.isBaby()){
            matrixStack.scale(0.5f,0.5f,0.5f);
        }else{
            matrixStack.scale(1f,1f,1f);

        }


        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
