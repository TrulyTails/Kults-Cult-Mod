package com.githubtrulytails.kultscultmod.entity.custom;

import com.githubtrulytails.kultscultmod.entity.ai.WringAttackGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MinithulusEntity extends HostileEntity {
    public MinithulusEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }


/*
 Next make a model and renderer class under the client package.
Bring the animation under animation package.
AI should be okay ass is but right now the MINI uses the same attacking logic as the wring.
*/

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        // uses the attack logic that the Wring has. The logic is specific to the WringEntity there for will not work
        // All we have to do is remake the logic tied to the MinithulusEntity
        // this.goalSelector.add(1, new WringAttackGoal(this,1d,true));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 3D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.jumpControl = new JumpControl(this);
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createWringAttributes(){
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH,15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,5)
                .add(EntityAttributes.GENERIC_ARMOR,3)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED,4)
                ;
    }



    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_GUARDIAN_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WITHER_HURT;
    }

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
