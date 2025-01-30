package com.githubtrulytails.kultscultmod.entity.custom;

import com.githubtrulytails.kultscultmod.entity.ai.MiniAttackGoal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import org.jetbrains.annotations.Nullable;

public class MinithulusEntity extends HostileEntity {
    public MinithulusEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 1;

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(100) + 100;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new MiniAttackGoal(this,3d,false));
        this.goalSelector.add(1, new WanderAroundFarGoal(this, 3D));
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 10f));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.add(4, new SwimGoal(this));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.jumpControl = new JumpControl(this);

    }

    public static DefaultAttributeContainer.Builder createMiniAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 10)
                .add(EntityAttributes.GENERIC_ARMOR, 4)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 4)
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
        return SoundEvents.ENTITY_GLOW_SQUID_HURT;
    }

    @Override
    public int getXpToDrop() {
        this.experiencePoints = (int) ((double) this.experiencePoints * 10);
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
        this.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_DEATH, 1f, 1f);
    }

    public boolean isAngryAt(PlayerEntity player) {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            setupAnimationStates();
        }
    }


    //spawning

    // is the light level bright enough from the sky?
    protected static boolean isLightLevelValidForNaturalSpawn(BlockRenderView world, BlockPos pos, Random random) {
        return world.getLightLevel(LightType.SKY, pos) >= 0;
    }

    // is there a solid block here?
    public static boolean validMiniSpawn(EntityType<? extends LivingEntity> type, ServerWorldAccess world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolidBlock(world, pos);
    }

    public static boolean isValidSpawnBiome(WorldAccess world, BlockPos pos) {
        RegistryEntry<Biome> biome = world.getBiome(pos);

        // Return false if the biome is Mushroom Fields
        return !biome.matchesKey(BiomeKeys.MUSHROOM_FIELDS);
    }

    public static boolean miniSpawnMechanics(EntityType<? extends HostileEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        boolean lightLevel = isLightLevelValidForNaturalSpawn(world, pos, random);
        boolean validMiniSpawn = validMiniSpawn(type, world, pos);
        boolean isValidSpawnBiome = isValidSpawnBiome(world, pos);

        return validMiniSpawn && lightLevel && isValidSpawnBiome;
    }

/*
    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);

        // Retrieve the position from the packet
        int x = (int) packet.getX();
        int y = (int) packet.getY();
        int z = (int) packet.getZ();
        BlockPos pos = new BlockPos(x, y, z);

        // Get the world instance (assuming this is on the client side)
        World world = this.getWorld();

        // Get the light levels at the spawn position
        int skyLightLevel = world.getLightLevel(LightType.SKY, BlockPos.ofFloored(getPos()));
        int blockLightLevel = world.getLightLevel(LightType.BLOCK, BlockPos.ofFloored(getPos()));
        int totalLightLevel = world.getLightLevel(BlockPos.ofFloored(getPos()));

        int ambientdarkness = world.getBaseLightLevel(pos, 0);

        // Get the block the rat spawned on

        BlockPos blockPosBelow = pos.down();
        BlockState blockStateBelow = world.getBlockState(blockPosBelow);
        Block blockBelow = blockStateBelow.getBlock();

        System.out.println("---------------------------------------------------");
        System.out.println("Mini spawned at position: " + pos);
        System.out.println("Sky Light Level: " + skyLightLevel);
        System.out.println("Block Light Level: " + blockLightLevel);
        System.out.println("Total Light Level: " + totalLightLevel);
        System.out.println("Ambient Darkness: " + ambientdarkness);
        System.out.println("On Block: " + blockBelow);
        System.out.println("/tp " + x + " " + y + " " + z);
        System.out.println("---------------------------------------------------");
*/
    }

