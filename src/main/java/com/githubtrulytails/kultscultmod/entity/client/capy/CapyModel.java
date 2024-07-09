package com.githubtrulytails.kultscultmod.entity.client.capy;

import com.githubtrulytails.kultscultmod.entity.animation.CapyAnimations;
import com.githubtrulytails.kultscultmod.entity.animation.RatAnimations;
import com.githubtrulytails.kultscultmod.entity.custom.CapyEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

// Made with Blockbench 4.10.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class CapyModel<T extends CapyEntity>  extends SinglePartEntityModel<T> {

	private final ModelPart capy_entity;
	private final ModelPart head;


	public CapyModel(ModelPart root) {
		this.capy_entity = root.getChild("capy_entity");
		this.head = capy_entity.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData capy_entity = modelPartData.addChild("capy_entity", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = capy_entity.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-9.0F, -5.0F, -9.0F, 13.0F, 12.0F, 19.0F, new Dilation(0.0F)), ModelTransform.pivot(0.3F, -12.0F, 0.0F));

		ModelPartData front_legL = body.addChild("front_legL", ModelPartBuilder.create().uv(12, 47).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.4F, 7.0F, -6.7F));

		ModelPartData front_legR = body.addChild("front_legR", ModelPartBuilder.create().uv(45, 0).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.7F, 7.0F, -6.7F));

		ModelPartData back_legR = body.addChild("back_legR", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.7F, 7.0F, 7.3F));

		ModelPartData back_legL = body.addChild("back_legL", ModelPartBuilder.create().uv(0, 39).cuboid(-2.0F, -1.0F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(1.4F, 7.0F, 7.3F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(-2.3F, -4.544F, 10.5433F));

		ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(26, 33).cuboid(-1.0F, -0.5F, -1.5F, 2.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 1.0F, 0.0F, -1.0297F, 0.0F, 0.0F));

		ModelPartData hang_hair = body.addChild("hang_hair", ModelPartBuilder.create(), ModelTransform.pivot(-10.0F, 10.5F, -0.7F));

		ModelPartData right_hang = hang_hair.addChild("right_hang", ModelPartBuilder.create().uv(28, 36).cuboid(0.0F, 1.74F, -7.82F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 20).cuboid(0.0F, -0.16F, -3.62F, 0.0F, 2.0F, 13.0F, new Dilation(0.0F))
		.uv(0, 11).cuboid(0.0F, -0.16F, -9.62F, 0.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 7).cuboid(0.0F, 1.84F, 0.88F, 0.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(33, 31).cuboid(0.0F, 1.74F, 6.68F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -3.34F, 1.32F));

		ModelPartData front_hang = hang_hair.addChild("front_hang", ModelPartBuilder.create(), ModelTransform.pivot(7.8F, -3.1667F, -8.3F));

		ModelPartData cube_r1 = front_hang.addChild("cube_r1", ModelPartBuilder.create().uv(0, 22).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(-3.8F, 1.6667F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r2 = front_hang.addChild("cube_r2", ModelPartBuilder.create().uv(0, 0).cuboid(1.0F, -2.0F, 6.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.9F, 3.6667F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r3 = front_hang.addChild("cube_r3", ModelPartBuilder.create().uv(10, 6).cuboid(1.0F, -2.0F, 6.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-10.8F, 3.6667F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData left_hang = hang_hair.addChild("left_hang", ModelPartBuilder.create().uv(0, 12).cuboid(0.0F, 0.0F, -8.9667F, 0.0F, 2.0F, 19.0F, new Dilation(0.0F))
		.uv(0, 5).cuboid(0.0F, 2.0F, 1.5333F, 0.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 9).cuboid(0.0F, 1.9F, -7.0667F, 0.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(14.0F, -3.5F, 0.6667F));

		ModelPartData back_hang = hang_hair.addChild("back_hang", ModelPartBuilder.create(), ModelTransform.pivot(7.75F, -3.5F, 10.7F));

		ModelPartData cube_r4 = back_hang.addChild("cube_r4", ModelPartBuilder.create().uv(0, 24).cuboid(1.0F, -2.0F, -3.0F, 0.0F, 2.0F, 13.0F, new Dilation(0.0F))
		.uv(15, 12).cuboid(1.0F, 0.0F, 8.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-3.75F, 2.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r5 = back_hang.addChild("cube_r5", ModelPartBuilder.create().uv(10, 8).cuboid(1.0F, -2.0F, 6.0F, 0.0F, 2.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-8.65F, 4.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r6 = back_hang.addChild("cube_r6", ModelPartBuilder.create().uv(12, 0).cuboid(1.0F, -2.0F, 8.0F, 0.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-13.35F, 4.0F, 1.0F, 0.0F, 1.5708F, 0.0F));

		ModelPartData head = capy_entity.addChild("head", ModelPartBuilder.create().uv(26, 31).cuboid(-3.5F, -3.5F, -12.0F, 7.0F, 7.0F, 12.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.1F, -19.1F, -5.6F));

		ModelPartData ears = head.addChild("ears", ModelPartBuilder.create(), ModelTransform.pivot(3.5F, -2.6F, -1.1F));

		ModelPartData ear_right = ears.addChild("ear_right", ModelPartBuilder.create(), ModelTransform.pivot(-6.8F, 0.0F, 0.0F));

		ModelPartData ear_right_r1 = ear_right.addChild("ear_right_r1", ModelPartBuilder.create().uv(10, 14).cuboid(0.0F, -2.0F, -1.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5075F, 0.0048F, -0.4656F));

		ModelPartData ear_left = ears.addChild("ear_left", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData ear_left_r1 = ear_left.addChild("ear_left_r1", ModelPartBuilder.create().uv(23, 38).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 2.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.5075F, -0.0048F, 0.4656F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(CapyEntity entity,float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw,headPitch);

		this.animateMovement(CapyAnimations.CAPY_WALK,limbSwing,limbSwingAmount,2f,2.5f);
		this.updateAnimation(entity.idleAnimationState, CapyAnimations.CAPY_IDLE, ageInTicks, 1f);

	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		capy_entity.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return capy_entity;
	}


}