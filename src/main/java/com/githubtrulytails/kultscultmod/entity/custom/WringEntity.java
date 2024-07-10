package com.githubtrulytails.kultscultmod.entity.custom;

import com.githubtrulytails.kultscultmod.entity.ai.RatAttackGoal;
import com.githubtrulytails.kultscultmod.entity.ai.WringAttackGoal;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class WringEntity extends HostileEntity {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(RatEntity.class, TrackedDataHandlerRegistry.BOOLEAN);


    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public WringEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        }else{
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()){
            attackAnimationState.stop();
        }

    }

    public static DefaultAttributeContainer.Builder createWringAttributes(){
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH,50)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,7)
                .add(EntityAttributes.GENERIC_ARMOR,2)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,3)
                ;
    }


    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new WringAttackGoal(this,1d,true));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 3D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.jumpControl = new JumpControl(this);
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient){
            setupAnimationStates();
        }
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_BLAZE_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WITHER_HURT;
    }

 /*   @Nullable
    @Override
    protected SoundEvent getDeathSound() {
    }*/

    @Override
    public int getXpToDrop() {
            this.experiencePoints = (int)((double)this.experiencePoints * 10);
        return super.getXpToDrop();
    }

    @Override
    public boolean shouldDropXp() {
        return true;
    }

    @Override
    protected boolean shouldDropLoot() {
        return true;
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        super.onDeath(damageSource);
        this.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH,1f,1f);
    }

    public boolean isAngryAt(PlayerEntity player) {
        return true;
    }

}
