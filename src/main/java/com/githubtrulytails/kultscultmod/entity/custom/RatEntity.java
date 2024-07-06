package com.githubtrulytails.kultscultmod.entity.custom;

import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.entity.ai.RatAttackGoal;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import net.minecraft.world.dimension.DimensionType;
import org.jetbrains.annotations.Nullable;


public class RatEntity extends AnimalEntity {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(RatEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    public RatEntity(EntityType<? extends AnimalEntity> entityType, World world) {
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
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            attackAnimationState.stop();
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

            new StatusEffectInstance(StatusEffects.GLOWING, 500, 1);

        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new RatAttackGoal(this, 1d, true));
        this.goalSelector.add(1, new AnimalMateGoal(this, 1.5D));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.0));
        this.goalSelector.add(2, new TemptGoal(this, 1.5, Ingredient.ofItems(Items.ROTTEN_FLESH), false));
        this.goalSelector.add(3, new FollowParentGoal(this, 1.15D));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(7, new FleeEntityGoal<>(this, OcelotEntity.class, 6.0F, 1.0, 1.2));
        this.goalSelector.add(7, new FleeEntityGoal<>(this, CatEntity.class, 8.0F, 0.5, 1.0));
        this.goalSelector.add(12, new LookAtEntityGoal(this, CatEntity.class, 10.0F));


        this.jumpControl = new JumpControl(this);
        this.targetSelector.add(1, new RevengeGoal(this).setGroupRevenge());
    }

    public static DefaultAttributeContainer.Builder createRatAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 6)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.7F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 3)
                .add(EntityAttributes.GENERIC_ARMOR, 0)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 6)
                ;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.DEFAULT;
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.ROTTEN_FLESH);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.RAT.create(world);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_FOX_AMBIENT;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_BAT_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_BAT_DEATH;
    }


//spawn stuff


 /*   public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.BLOCK, pos) <= 8) {
            return true;
        }
        if (world.getLightLevel(LightType.SKY, pos) <= 8) {
           return true;
            } else {
                DimensionType dimensionType = world.getDimension();
                int j = world.toServerWorld().isThundering() ? world.getLightLevel(pos, 10) : world.getLightLevel(pos);
                return j <= dimensionType.monsterSpawnLightTest().get(random);
            }
        }
*/


public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
    // Check sky light level. Sky light will always be 15. Change random int, lower means higher chance of spawning.
    int skyLightLevel = world.getLightLevel(LightType.SKY, pos);
    if (skyLightLevel < random.nextInt(65)) {
        return false;
    } else {
        // Check block light level.
        int blockLightLevel = world.getLightLevel(LightType.BLOCK, pos);
        if (blockLightLevel > 8) {
            return false;
        } else {
            // Check thundering condition for light level
            int lightLevel = world.toServerWorld().isThundering() ? world.getLightLevel(pos, 10) : world.getLightLevel(pos);
            return lightLevel <= 8; // Ensure light level is 8 or below
        }
    }
}


 /*   public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
        if (world.getLightLevel(LightType.SKY, pos) > random.nextInt(32)) {
            return false;
        } else {
            DimensionType dimensionType = world.getDimension();
            int i = dimensionType.monsterSpawnBlockLightLimit();
            if (i < 15 && world.getLightLevel(LightType.BLOCK, pos) > i) {
                return false;
            } else {
                int j = world.toServerWorld().isThundering() ? world.getLightLevel(pos, 10) : world.getLightLevel(pos);
                return j <= dimensionType.monsterSpawnLightTest().get(random);
            }
        }
    }*/

    public static boolean canMobSpawn(EntityType<? extends MobEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        BlockPos blockPos = pos.down();
        return spawnReason == SpawnReason.SPAWNER || world.getBlockState(blockPos).allowsSpawning(world, blockPos, type);
    }

    // what gets called in ModEntitySpawn
    public static boolean ratSpawnMechanics(EntityType<? extends RatEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        return isSpawnDark(world, pos, random) && canMobSpawn(type, world, spawnReason, pos, random);
    }

    public static void ratGlow(LivingEntity entity) {
        if (entity.getType().equals(ModEntities.RAT)) { // Replace MyModEntities.RAT with your entity type
            // Apply a status effect, for example, Speed for 200 ticks (10 seconds) at amplifier level 1
            StatusEffectInstance GlowEffect = new StatusEffectInstance(StatusEffects.GLOWING, 500, 1);
            entity.addStatusEffect(GlowEffect);
        }
    }


    int skyLightLevel = getWorld().getLightLevel(LightType.SKY, BlockPos.ofFloored(getPos()));
    int blockLightLevel = getWorld().getLightLevel(LightType.BLOCK, BlockPos.ofFloored(getPos()));
    int totalLightLevel = getWorld().getLightLevel(BlockPos.ofFloored(getPos()));

    int ratBlockPosX = getWorld().getSpawnPos().getX();
    int ratBlockPosY = getWorld().getSpawnPos().getY();
    int ratBlockPosZ = getWorld().getSpawnPos().getZ();

    private static int getInternalSkyLightLevel(ServerWorld world, BlockPos pos) {
        // Access the world's light engine directly to fetch internal sky light levels
        // This method may require more detailed handling depending on the internal light propagation
        return world.getChunkManager().getLightingProvider().getLight(pos, 0);
    }

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

        // Print the position and light levels
        System.out.println("---------------------------------------------------");
        System.out.println("Rat spawned at position: " + pos);
        System.out.println("Sky Light Level: " + skyLightLevel);
        System.out.println("Block Light Level: " + blockLightLevel);
        System.out.println("Total Light Level: " + totalLightLevel);
        System.out.println("Ambient Darkness: " + ambientdarkness);
        System.out.println("---------------------------------------------------");

    }




}//end class



