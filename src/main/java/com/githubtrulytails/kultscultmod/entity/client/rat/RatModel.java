package com.githubtrulytails.kultscultmod.entity.client.rat;

import com.githubtrulytails.kultscultmod.entity.animation.RatAnimations;
import com.githubtrulytails.kultscultmod.entity.custom.RatEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;


public class RatModel<T extends RatEntity> extends SinglePartEntityModel<T> {
	private final ModelPart rat;
	private final ModelPart head;

	public RatModel(ModelPart root) {
		this.rat = root.getChild("rat");
		this.head = rat.getChild("body").getChild("tail");

	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData rat = modelPartData.addChild("rat", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData head = rat.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(0.0F, -5.0F, -4.0F, 1.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData body = rat.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.0F, -3.0F, 3.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -2.0F, 0.0F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(6, 0).cuboid(-1.0F, -2.0F, -1.0F, 1.0F, 0.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, 1.0F, 3.0F));

		ModelPartData frontright = rat.addChild("frontright", ModelPartBuilder.create().uv(0, 11).cuboid(-1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData frontleft = rat.addChild("frontleft", ModelPartBuilder.create().uv(0, 8).cuboid(1.0F, -2.0F, -2.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData backright = rat.addChild("backright", ModelPartBuilder.create().uv(8, 8).cuboid(-1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData backleft = rat.addChild("backleft", ModelPartBuilder.create().uv(4, 8).cuboid(1.0F, -2.0F, 1.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 32, 32);
	}
	@Override
	public void setAngles(RatEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw,headPitch);

		this.animateMovement(RatAnimations.RATWALKANIMATION,limbSwing,limbSwingAmount,2f,2.5f);
		this.updateAnimation(entity.idleAnimationState, RatAnimations.RATIDLEANIMATION, ageInTicks, 1f);

		this.updateAnimation(entity.attackAnimationState, RatAnimations.RATATTACKANIMATION, ageInTicks, 1f);

	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}


	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		rat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return rat;
	}
}