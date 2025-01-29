package com.githubtrulytails.kultscultmod.entity.custom;

import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.entity.ai.RatAttackGoal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.GuardianEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

public class CapyEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;



    public CapyEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);

        this.setPathfindingPenalty(PathNodeType.WATER_BORDER, +5f);

    }
    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(100) + 100;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }


    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient) {
            setupAnimationStates();
        }
    }



    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2));

        this.goalSelector.add(2, new TemptGoal(this, 2, Ingredient.ofItems(Items.APPLE), false));
        this.goalSelector.add(3, new AnimalMateGoal(this, 2D));
        this.goalSelector.add(3, new FollowParentGoal(this, 2D));

        this.goalSelector.add(4, new WanderAroundFarGoal(this, 2D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(7, new FleeEntityGoal<>(this, GuardianEntity.class, 6.0F, 1.0, 1.2));
        this.goalSelector.add(12, new LookAtEntityGoal(this, CatEntity.class, 5.0F));
        this.goalSelector.add(12, new LookAtEntityGoal(this, WolfEntity.class, 5.0F));
        this.goalSelector.add(12, new LookAtEntityGoal(this, ParrotEntity.class, 5.0F));
        this.goalSelector.add(12, new LookAtEntityGoal(this, AxolotlEntity.class, 5.0F));
        this.goalSelector.add(12, new LookAtEntityGoal(this, SquidEntity.class, 5.0F));
        this.goalSelector.add(12, new LookAtEntityGoal(this, VillagerEntity.class, 5.0F));
        this.goalSelector.add(12, new LookAtEntityGoal(this, RatEntity.class, 5.0F));


        this.jumpControl = new JumpControl(this);
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
    }


    public static DefaultAttributeContainer.Builder createCapyAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 11)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.090F)
                .add(EntityAttributes.GENERIC_ARMOR, 0)
                ;
    }



    // is the light level bright enough from the sky?
    protected static boolean isLightLevelValidForNaturalSpawn(BlockRenderView world, BlockPos pos, Random random) {
        return world.getLightLevel(LightType.SKY, pos) >= random.nextInt(32)+6;
    }
    // is there a solid block here?
    public static boolean validCapySpawn(EntityType<? extends LivingEntity> type, ServerWorldAccess world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolidBlock(world,pos);
    }
    // something to return true sometimes (ambient mobs spawn all over the place)
    public static boolean reduceAmbientSpawnRate(ServerWorldAccess world, BlockPos pos, Random random){
        return 5 > random.nextInt(150);
    }

    public static boolean capySpawnMechanics(EntityType<? extends AnimalEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        boolean lightLevel = isLightLevelValidForNaturalSpawn(world, pos, random);
        boolean validCapySpawn = validCapySpawn(type, world,pos);
        boolean rate = reduceAmbientSpawnRate(world, pos, random);

        return validCapySpawn && lightLevel && rate;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }
    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.APPLE);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_CAMEL_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_DONKEY_DEATH;
    }


    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.CAPY.create(world);
    }


    // This will only spawn on grass blocks!!!!!
    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return 1.0F;
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

        int ambientdarkness = world.getBaseLightLevel(pos,0);




        // Get the block the rat spawned on

        BlockPos blockPosBelow = pos.down();
        BlockState blockStateBelow = world.getBlockState(blockPosBelow);
        Block blockBelow = blockStateBelow.getBlock();

        System.out.println("---------------------------------------------------");
        System.out.println("Capy spawned at position: " + pos);
        System.out.println("Sky Light Level: " + skyLightLevel);
        System.out.println("Block Light Level: " + blockLightLevel);
        System.out.println("Total Light Level: " + totalLightLevel);
        System.out.println("Ambient Darkness: " + ambientdarkness);
        System.out.println("On Block: " + blockBelow);
        System.out.println("---------------------------------------------------");

    }
*/


}
