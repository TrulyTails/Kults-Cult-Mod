package com.githubtrulytails.kultscultmod.entity.client.mini;

import com.githubtrulytails.kultscultmod.entity.custom.MinithulusEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.12.2
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class MiniModel<T extends MinithulusEntity> extends SinglePartEntityModel<T> {
    private final ModelPart mini_entity;
    private final ModelPart head;

    public MiniModel(ModelPart root) {
        this.mini_entity = root.getChild("mini_entity");
        this.head = this.mini_entity.getChild("head");

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData mini_entity = modelPartData.addChild("mini_entity", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData head = mini_entity.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -3.95F, -4.0F, 6.0F, 4.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.5F, -0.05F, 3.7F));

        ModelPartData Head_r1 = head.addChild("Head_r1", ModelPartBuilder.create().uv(0, 17).cuboid(-2.0F, -2.0F, -4.0F, 4.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -0.2F, -3.2F, 0.0436F, 0.0F, 0.0F));

        ModelPartData Head_r2 = head.addChild("Head_r2", ModelPartBuilder.create().uv(0, 9).cuboid(-2.0F, -3.0F, -3.0F, 5.0F, 3.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, -0.2F, -3.7F, 0.0436F, 0.0F, 0.0F));

        ModelPartData eyes = mini_entity.addChild("eyes", ModelPartBuilder.create(), ModelTransform.pivot(2.6F, -2.85F, -2.3F));

        ModelPartData Head_r3 = eyes.addChild("Head_r3", ModelPartBuilder.create().uv(20, 9).cuboid(-1.0F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                .uv(18, 17).cuboid(-5.1F, -0.5F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData tentacleMR = mini_entity.addChild("tentacleMR", ModelPartBuilder.create(), ModelTransform.of(-1.1333F, -0.5F, -4.25F, 0.0F, 0.3054F, 0.0F));

        ModelPartData top3 = tentacleMR.addChild("top3", ModelPartBuilder.create().uv(8, 24).cuboid(-0.4167F, -0.75F, 0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData mid3 = tentacleMR.addChild("mid3", ModelPartBuilder.create().uv(18, 21).cuboid(-0.6667F, -0.65F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bottom3 = tentacleMR.addChild("bottom3", ModelPartBuilder.create().uv(12, 24).cuboid(-0.4167F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tentacleML = mini_entity.addChild("tentacleML", ModelPartBuilder.create(), ModelTransform.of(2.2833F, -0.5F, -4.25F, 0.0F, 2.8362F, 0.0F));

        ModelPartData top2 = tentacleML.addChild("top2", ModelPartBuilder.create().uv(0, 24).cuboid(-0.4167F, -0.75F, -1.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData mid2 = tentacleML.addChild("mid2", ModelPartBuilder.create().uv(20, 13).cuboid(-0.6667F, -0.65F, -1.0F, 1.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bottom2 = tentacleML.addChild("bottom2", ModelPartBuilder.create().uv(20, 24).cuboid(-0.4167F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tentacleR = mini_entity.addChild("tentacleR", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, 0.0F, 2.0F));

        ModelPartData top = tentacleR.addChild("top", ModelPartBuilder.create(), ModelTransform.pivot(-2.9F, -0.25F, -5.4F));

        ModelPartData tentacleR_r1 = top.addChild("tentacleR_r1", ModelPartBuilder.create().uv(4, 24).cuboid(-1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.6981F, 0.0F));

        ModelPartData mid = tentacleR.addChild("mid", ModelPartBuilder.create(), ModelTransform.pivot(-2.9F, -0.25F, -5.4F));

        ModelPartData tentacleR_r2 = mid.addChild("tentacleR_r2", ModelPartBuilder.create().uv(16, 24).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.1F, 0.15F, 0.3F, 0.0F, 0.6981F, 0.0F));

        ModelPartData bottom = tentacleR.addChild("bottom", ModelPartBuilder.create(), ModelTransform.pivot(-2.7F, -0.6167F, -4.0F));

        ModelPartData tentacleR_r3 = bottom.addChild("tentacleR_r3", ModelPartBuilder.create().uv(24, 21).cuboid(-1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.6F, 0.6167F, -1.8F, 0.0F, 0.6981F, 0.0F));

        ModelPartData tentacleL = mini_entity.addChild("tentacleL", ModelPartBuilder.create(), ModelTransform.of(7.0F, 0.0F, 0.0F, 0.0F, 1.6144F, 0.0F));

        ModelPartData top4 = tentacleL.addChild("top4", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, -0.75F, -4.5F));

        ModelPartData tentacleR_r4 = top4.addChild("tentacleR_r4", ModelPartBuilder.create().uv(24, 23).cuboid(-1.0F, -1.25F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.3532F, 0.75F, 0.6601F, 0.0F, 0.6981F, 0.0F));

        ModelPartData mid4 = tentacleL.addChild("mid4", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, -0.65F, -4.5F));

        ModelPartData tentacleR_r5 = mid4.addChild("tentacleR_r5", ModelPartBuilder.create().uv(22, 6).cuboid(-1.0F, -1.25F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.6532F, 0.75F, 1.3601F, 0.0F, 0.6981F, 0.0F));

        ModelPartData bottom4 = tentacleL.addChild("bottom4", ModelPartBuilder.create(), ModelTransform.pivot(2.5F, -0.5F, -4.5F));

        ModelPartData tentacleR_r6 = bottom4.addChild("tentacleR_r6", ModelPartBuilder.create().uv(22, 2).cuboid(-1.0F, -1.2F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.7532F, 0.7F, 1.0601F, 0.0F, 0.6981F, 0.0F));

        ModelPartData tentacleM = mini_entity.addChild("tentacleM", ModelPartBuilder.create(), ModelTransform.of(0.4463F, -0.75F, -5.0295F, 0.0F, -0.6981F, 0.0F));

        ModelPartData top5 = tentacleM.addChild("top5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tentacleR_r7 = top5.addChild("tentacleR_r7", ModelPartBuilder.create().uv(22, 0).cuboid(-1.0F, -1.25F, 0.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.6568F, 0.75F, -0.1604F, 0.0F, 0.6981F, 0.0F));

        ModelPartData mid5 = tentacleM.addChild("mid5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tentacleR_r8 = mid5.addChild("tentacleR_r8", ModelPartBuilder.create().uv(22, 4).cuboid(-1.0F, -1.25F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.8568F, 0.85F, 0.1396F, 0.0F, 0.6981F, 0.0F));

        ModelPartData bottom5 = tentacleM.addChild("bottom5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tentacleR_r9 = bottom5.addChild("tentacleR_r9", ModelPartBuilder.create().uv(24, 25).cuboid(-1.0F, -1.3F, -1.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.3568F, 1.05F, -0.5604F, 0.0F, 0.6981F, 0.0F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        mini_entity.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return mini_entity;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}