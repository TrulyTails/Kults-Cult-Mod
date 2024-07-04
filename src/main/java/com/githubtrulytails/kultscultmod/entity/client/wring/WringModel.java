package com.githubtrulytails.kultscultmod.entity.client.wring;

import com.githubtrulytails.kultscultmod.entity.animation.RatAnimations;
import com.githubtrulytails.kultscultmod.entity.animation.WringAnimations;
import com.githubtrulytails.kultscultmod.entity.custom.WringEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.MathHelper;


public class WringModel<T extends WringEntity> extends SinglePartEntityModel<T> {

	private final ModelPart wring;
	private final ModelPart head;


	public WringModel(ModelPart root) {
		this.wring = root.getChild("wring");
		this.head = wring.getChild("head");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData wring = modelPartData.addChild("wring", ModelPartBuilder.create(), ModelTransform.pivot(3.6991F, 48.6845F, 2.1F));

		ModelPartData head = wring.addChild("head", ModelPartBuilder.create().uv(0, 26).cuboid(-13.71F, -70.148F, -6.594F, 9.0F, 13.0F, 13.0F, new Dilation(0.0F))
				.uv(39, 13).cuboid(5.13F, -70.148F, -6.594F, 9.0F, 13.0F, 13.0F, new Dilation(0.0F))
				.uv(0, 0).cuboid(-6.72F, -52.878F, -6.28F, 13.0F, 13.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(-6.9053F, 10.4108F, -1.884F));

		ModelPartData ring1 = wring.addChild("ring1", ModelPartBuilder.create(), ModelTransform.pivot(-4.0453F, -58.6692F, -1.884F));

		ModelPartData cube_r1 = ring1.addChild("cube_r1", ModelPartBuilder.create().uv(36, 107).cuboid(1.85F, -25.802F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(17.2068F, 42.7403F, -1.57F, 0.0F, 0.0F, 0.6632F));

		ModelPartData cube_r2 = ring1.addChild("cube_r2", ModelPartBuilder.create().uv(108, 62).cuboid(1.85F, -25.802F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(37.7405F, 0.7556F, -1.57F, 0.0F, 0.0F, -0.4276F));

		ModelPartData cube_r3 = ring1.addChild("cube_r3", ModelPartBuilder.create().uv(0, 86).cuboid(1.85F, -25.802F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(10.3204F, -36.738F, -1.57F, 0.0F, 0.0F, -1.5621F));

		ModelPartData cube_r4 = ring1.addChild("cube_r4", ModelPartBuilder.create().uv(54, 107).cuboid(1.85F, -25.802F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(32.2837F, 23.1286F, -1.57F, 0.0F, 0.0F, 0.2269F));

		ModelPartData cube_r5 = ring1.addChild("cube_r5", ModelPartBuilder.create().uv(98, 31).cuboid(1.85F, -25.802F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(27.3064F, -21.6734F, -1.57F, 0.0F, 0.0F, -0.8639F));

		ModelPartData cube_r6 = ring1.addChild("cube_r6", ModelPartBuilder.create().uv(0, 117).cuboid(1.85F, -25.942F, 0.0F, 6.0F, 25.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-5.1579F, 48.2307F, -1.57F, 0.0F, 0.0F, 1.3177F));

		ModelPartData cube_r7 = ring1.addChild("cube_r7", ModelPartBuilder.create().uv(116, 28).cuboid(-7.57F, -25.942F, 0.0F, 6.0F, 25.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(2.0179F, 48.2307F, -1.57F, 0.0F, 0.0F, -1.3177F));

		ModelPartData cube_r8 = ring1.addChild("cube_r8", ModelPartBuilder.create().uv(72, 107).cuboid(-7.57F, -25.802F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-20.3468F, 42.7403F, -1.57F, 0.0F, 0.0F, -0.6632F));

		ModelPartData cube_r9 = ring1.addChild("cube_r9", ModelPartBuilder.create().uv(108, 93).cuboid(-7.57F, -25.802F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-35.4237F, 23.1286F, -1.57F, 0.0F, 0.0F, -0.2269F));

		ModelPartData cube_r10 = ring1.addChild("cube_r10", ModelPartBuilder.create().uv(18, 86).cuboid(-7.57F, -25.802F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-40.8805F, 0.7556F, -1.57F, 0.0F, 0.0F, 0.4276F));

		ModelPartData cube_r11 = ring1.addChild("cube_r11", ModelPartBuilder.create().uv(90, 70).cuboid(-7.57F, -25.802F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-30.4464F, -21.6734F, -1.57F, 0.0F, 0.0F, 0.8639F));

		ModelPartData ring2 = wring.addChild("ring2", ModelPartBuilder.create(), ModelTransform.of(-6.9053F, 16.3768F, -1.884F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r12 = ring2.addChild("cube_r12", ModelPartBuilder.create().uv(0, 52).cuboid(2.7135F, -28.5602F, 0.0F, 6.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(15.6141F, -29.2371F, -1.7427F, 0.0F, 0.0F, 0.6632F));

		ModelPartData cube_r13 = ring2.addChild("cube_r13", ModelPartBuilder.create().uv(18, 52).cuboid(2.7135F, -28.5602F, 0.0F, 6.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(38.4065F, -75.84F, -1.7427F, 0.0F, 0.0F, -0.4276F));

		ModelPartData cube_r14 = ring2.addChild("cube_r14", ModelPartBuilder.create().uv(83, 0).cuboid(2.7135F, -28.5602F, 0.0F, 6.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(7.9703F, -117.458F, -1.7427F, 0.0F, 0.0F, -1.5621F));

		ModelPartData cube_r15 = ring2.addChild("cube_r15", ModelPartBuilder.create().uv(62, 39).cuboid(2.7135F, -28.5602F, 0.0F, 6.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(32.3495F, -51.0061F, -1.7427F, 0.0F, 0.0F, 0.2269F));

		ModelPartData cube_r16 = ring2.addChild("cube_r16", ModelPartBuilder.create().uv(36, 73).cuboid(2.7135F, -28.5602F, 0.0F, 6.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(26.8247F, -100.7363F, -1.7427F, 0.0F, 0.0F, -0.8639F));

		ModelPartData cube_r17 = ring2.addChild("cube_r17", ModelPartBuilder.create().uv(101, 0).cuboid(2.7135F, -29.0456F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-9.2107F, -23.1427F, -1.7427F, 0.0F, 0.0F, 1.3177F));

		ModelPartData cube_r18 = ring2.addChild("cube_r18", ModelPartBuilder.create().uv(90, 101).cuboid(-7.7427F, -29.0456F, 0.0F, 6.0F, 28.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-1.2455F, -23.1427F, -1.7427F, 0.0F, 0.0F, -1.3177F));

		ModelPartData cube_r19 = ring2.addChild("cube_r19", ModelPartBuilder.create().uv(44, 39).cuboid(-7.7427F, -28.5602F, 0.0F, 6.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-26.0703F, -29.2371F, -1.7427F, 0.0F, 0.0F, -0.6632F));

		ModelPartData cube_r20 = ring2.addChild("cube_r20", ModelPartBuilder.create().uv(54, 73).cuboid(-7.7427F, -28.5602F, 0.0F, 6.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-42.8057F, -51.0061F, -1.7427F, 0.0F, 0.0F, -0.2269F));

		ModelPartData cube_r21 = ring2.addChild("cube_r21", ModelPartBuilder.create().uv(72, 73).cuboid(-7.7427F, -28.5602F, 0.0F, 6.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-48.8627F, -75.84F, -1.7427F, 0.0F, 0.0F, 0.4276F));

		ModelPartData cube_r22 = ring2.addChild("cube_r22", ModelPartBuilder.create().uv(80, 36).cuboid(-7.7427F, -28.5602F, 0.0F, 6.0F, 31.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-37.2809F, -100.7363F, -1.7427F, 0.0F, 0.0F, 0.8639F));
		return TexturedModelData.of(modelData, 256, 256);
	}

	@Override
	public void setAngles(WringEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw,headPitch);

		this.updateAnimation(entity.idleAnimationState, WringAnimations.WRINGIDLANIMATION, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, WringAnimations.WRINGATTACKANIMATION, ageInTicks, 1f);

	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		wring.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}


	public ModelPart getPart() {
		return wring;
	}


}
