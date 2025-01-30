package com.githubtrulytails.kultscultmod.entity.ai;

import com.githubtrulytails.kultscultmod.entity.custom.MinithulusEntity;
import com.githubtrulytails.kultscultmod.entity.custom.WringEntity;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class MiniAttackGoal extends MeleeAttackGoal {

    private final MinithulusEntity entity;
    private int attackDelay = 2;
    private int ticksUntilNextAttack = 5;
    private boolean shouldCountTillNextAttack = false;


    public MiniAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((MinithulusEntity) mob);
    }

    @Override
    public void start() {
        super.start();
        attackDelay = 2;
        ticksUntilNextAttack = 5;
    }


    @Override
    protected void attack(LivingEntity pEnemy) {
        if (isEnemyWithinAttackDistance(pEnemy)) {
            shouldCountTillNextAttack = true;

            if(isTimeToAttack()) {
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getEyeY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
        }
    }



    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy) {
        return this.entity.distanceTo(pEnemy) <= 2f;
    }

    protected void resetAttackCooldown() {
        this.ticksUntilNextAttack = this.getTickCount(attackDelay * 4);
    }


    protected boolean isTimeToAttack() {
        return this.ticksUntilNextAttack <= 0;
    }

    protected void performAttack(LivingEntity pEnemy) {
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    @Override
    public void tick() {
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }


    @Override
    public void stop() {
        entity.setAttacking(false);
        super.stop();
    }
}
