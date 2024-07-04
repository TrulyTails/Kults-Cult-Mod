package com.githubtrulytails.kultscultmod.entity.animation;

import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

public class ModAnimations {

    public static final Animation RATIDLEANIMATION = Animation.Builder.create(0.875f).looping()
.addBoneAnimation("body",
                          new Transformation(Transformation.Targets.TRANSLATE,
		new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.4583433f, AnimationHelper.createTranslationalVector(0f, -0.35f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("body",
                                      new Transformation(Transformation.Targets.ROTATE,
		new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.375f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.7083434f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                                      new Transformation(Transformation.Targets.TRANSLATE,
		new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.4583433f, AnimationHelper.createTranslationalVector(0f, -0.35f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                                      new Transformation(Transformation.Targets.ROTATE,
		new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.4583433f, AnimationHelper.createRotationalVector(0f, 0f, 2.5f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("tail",
                                      new Transformation(Transformation.Targets.ROTATE,
		new Keyframe(0f, AnimationHelper.createRotationalVector(-4f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.375f, AnimationHelper.createRotationalVector(9.69f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createRotationalVector(-5f, 0f, 0f),
    Transformation.Interpolations.LINEAR))).build();
    public static final Animation RATWALKANIMATION = Animation.Builder.create(1.4167667f).looping()
.addBoneAnimation("body",
                          new Transformation(Transformation.Targets.ROTATE,
		new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.5f, AnimationHelper.createRotationalVector(0f, 0f, 2.5f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createRotationalVector(0f, 0f, -2.5f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("frontright",
                                      new Transformation(Transformation.Targets.TRANSLATE,
		new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0.35f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createTranslationalVector(0f, 0f, -0.35f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.2083433f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("backright",
                                      new Transformation(Transformation.Targets.TRANSLATE,
		new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, 0.35f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createTranslationalVector(0f, 0f, -0.35f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.2083433f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("backleft",
                                      new Transformation(Transformation.Targets.TRANSLATE,
		new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, -0.35f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createTranslationalVector(0f, 0f, 0.35f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.2083433f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("frontleft",
                                      new Transformation(Transformation.Targets.TRANSLATE,
		new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 0f, -0.35f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createTranslationalVector(0f, 0f, 0.35f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.2083433f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("tail",
                                      new Transformation(Transformation.Targets.ROTATE,
		new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createRotationalVector(5f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.0416767f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.2916767f, AnimationHelper.createRotationalVector(-2.5f, 0f, 0f),
    Transformation.Interpolations.LINEAR))).build();
    public static final Animation RATATTACKANIMATION = Animation.Builder.create(1.7916767f).looping()
.addBoneAnimation("body",
                          new Transformation(Transformation.Targets.ROTATE,
		new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.5f, AnimationHelper.createRotationalVector(-45f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.4167667f, AnimationHelper.createRotationalVector(-20f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.625f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("frontright",
                                      new Transformation(Transformation.Targets.TRANSLATE,
		new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, -1f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.4583433f, AnimationHelper.createTranslationalVector(0f, 1f, -2f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.7916766f, AnimationHelper.createTranslationalVector(0f, 1f, -3f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.625f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("frontright",
                                      new Transformation(Transformation.Targets.ROTATE,
		new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.4583433f, AnimationHelper.createRotationalVector(-45f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(-55.5f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(-77.5f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.5f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("frontright",
                                      new Transformation(Transformation.Targets.SCALE,
		new Keyframe(0.125f, AnimationHelper.createScalingVector(1f, 1.2f, 1f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("frontleft",
                                      new Transformation(Transformation.Targets.TRANSLATE,
		new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.25f, AnimationHelper.createTranslationalVector(0f, 0f, -1f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.4583433f, AnimationHelper.createTranslationalVector(0f, 1f, -2f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.7916766f, AnimationHelper.createTranslationalVector(0f, 1f, -3f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.0416767f, AnimationHelper.createTranslationalVector(0f, 0.87f, -2.97f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.3433333f, AnimationHelper.createTranslationalVector(0f, 0.79f, -1.38f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.625f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("frontleft",
                                      new Transformation(Transformation.Targets.ROTATE,
		new Keyframe(0f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.4583433f, AnimationHelper.createRotationalVector(-45f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.6766666f, AnimationHelper.createRotationalVector(-55.5f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.7916766f, AnimationHelper.createRotationalVector(-77.5f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.875f, AnimationHelper.createRotationalVector(-78.32f, 3.91f, -18.22f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.125f, AnimationHelper.createRotationalVector(-77.69f, 0.24f, -1.09f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.4583433f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.625f, AnimationHelper.createRotationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("frontleft",
                                      new Transformation(Transformation.Targets.SCALE,
		new Keyframe(0f, AnimationHelper.createScalingVector(1f, 1f, 1f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.125f, AnimationHelper.createScalingVector(1f, 1.2f, 1f),
    Transformation.Interpolations.LINEAR)))
            .addBoneAnimation("head",
                                      new Transformation(Transformation.Targets.TRANSLATE,
		new Keyframe(0f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(0.5f, AnimationHelper.createTranslationalVector(0f, 1f, 1f),
    Transformation.Interpolations.LINEAR),
            new Keyframe(1.625f, AnimationHelper.createTranslationalVector(0f, 0f, 0f),
    Transformation.Interpolations.LINEAR))).build();





}
