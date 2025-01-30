package com.githubtrulytails.kultscultmod.entity.custom;

import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.entity.ai.RatAttackGoal;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
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
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
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
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new RatAttackGoal(this, 1d, true));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 1.0));

        this.goalSelector.add(2, new TemptGoal(this, 1.5, Ingredient.ofItems(Items.ROTTEN_FLESH), false));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.5D));
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
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.45F)
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
/*@Override     this lets us decide favor of blocks should we want to do so. might use it one day.
public float getPathfindingFavor(BlockPos pos, WorldView world) {
    BlockState blockStateBelow = world.getBlockState(pos.down());
    if (blockStateBelow.isOf(Blocks.GRASS_BLOCK)) {
        return 10.0F; // High favor for grass block
    } else if (blockStateBelow.isOf(Blocks.STONE) || blockStateBelow.isOf(Blocks.DIRT) ||
               blockStateBelow.isOf(Blocks.COBBLESTONE) || blockStateBelow.isOf(Blocks.ANDESITE) ||
               blockStateBelow.isOf(Blocks.DIORITE) || blockStateBelow.isOf(Blocks.GRANITE) ||
               blockStateBelow.isOf(Blocks.GRAVEL) || blockStateBelow.isOf(Blocks.SAND) ||
               blockStateBelow.isOf(Blocks.DEEPSLATE) || blockStateBelow.isOf(Blocks.TUFF) ||
               blockStateBelow.isOf(Blocks.CLAY) || blockStateBelow.isOf(Blocks.PODZOL) ||
               blockStateBelow.isOf(Blocks.MYCELIUM) || blockStateBelow.isOf(Blocks.RED_SAND) ||
               blockStateBelow.isOf(Blocks.NETHERRACK) || blockStateBelow.isOf(Blocks.BASALT) ||
               blockStateBelow.isOf(Blocks.BLACKSTONE) || blockStateBelow.isOf(Blocks.CRIMSON_NYLIUM) ||
               blockStateBelow.isOf(Blocks.WARPED_NYLIUM) || blockStateBelow.isOf(Blocks.MOSS_BLOCK) ||
               blockStateBelow.isOf(Blocks.MOSSY_COBBLESTONE) || blockStateBelow.isOf(Blocks.MOSSY_STONE_BRICKS)) {
        return 5.0F; // Neutral favor for other valid blocks
    } else {
        return 0.0F; // Low favor for all other blocks
    }
}
 */

    //for some reason the pathfinding also means spawning. by default, it is only grassblock
    @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        int blockLightLevel = world.getLightLevel(LightType.BLOCK, pos);
        //int skyLightLevel = world.getLightLevel(LightType.SKY, pos);
       // float skyLightFavor = 15.0F - skyLightLevel + 2;
      //  float lightFavor = 15.0F - blockLightLevel; // Normally this would add 15 to our return block favored. but it subtracts the current light level.
        // if the light level is 7. 15-7 =8 + return F = 9. Higher return means higher favor.
        return 1.0F ;//+ lightFavor; //+ skyLightFavor; // Neutral favor for all blocks
    }

    /* default isspawndark method hostilemob
      public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
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
    public static boolean isNightTime() {
        var client = MinecraftClient.getInstance();

        long timeOfDay = client.world.getTime() % 24000;
        boolean isNightTime = timeOfDay > 13187; // Roughly between 13187 and 22812 is night time

        return isNightTime;
    }

    public static boolean reduceSpawnRate(ServerWorldAccess world, BlockPos pos, Random random){
        return 90 > random.nextInt(100);
    }

    public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
        // Check sky light level. Sky light will always be 15. Change random int, lower means higher chance of spawning.
        int blockLightLevel = world.getLightLevel(LightType.BLOCK, pos);
        int skyLightLevel = world.getLightLevel(LightType.SKY, pos);
        int lightLevelToSpawnUnder = 7;
        int skyLightLevelToSpawnUnder= 10;

        if (skyLightLevel > random.nextInt(20)) {
            return false;
        } else {
            if (blockLightLevel >= lightLevelToSpawnUnder) {
                return false;
            } else {
                // Check thundering condition for light level
                int lightLevel = world.toServerWorld().isThundering() ? world.getLightLevel(pos, 10) : world.getLightLevel(pos);
                return lightLevel <= lightLevelToSpawnUnder; // Ensure light level is 8 or below
            }
        }
    }
    /*  public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
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
  /*  public static boolean validRatSpawn( WorldAccess world, BlockPos pos) {
        BlockPos[] positionsToCheck = {
                pos.down(), pos.down().north(), pos.down().south(), pos.down().east(), pos.down().west()
        };

        for (BlockPos checkPos : positionsToCheck) {
            BlockState blockStateBelow = world.getBlockState(checkPos);
            boolean isValid = blockStateBelow.isOf(Blocks.STONE) || blockStateBelow.isOf(Blocks.DIRT) ||
                    blockStateBelow.isOf(Blocks.GRASS_BLOCK) || blockStateBelow.isOf(Blocks.COBBLESTONE) ||
                    blockStateBelow.isOf(Blocks.ANDESITE) || blockStateBelow.isOf(Blocks.DIORITE) ||
                    blockStateBelow.isOf(Blocks.GRANITE) || blockStateBelow.isOf(Blocks.GRAVEL) ||
                    blockStateBelow.isOf(Blocks.SAND) || blockStateBelow.isOf(Blocks.DEEPSLATE) ||
                    blockStateBelow.isOf(Blocks.TUFF) || blockStateBelow.isOf(Blocks.CLAY) ||
                    blockStateBelow.isOf(Blocks.PODZOL) || blockStateBelow.isOf(Blocks.MYCELIUM) ||
                    blockStateBelow.isOf(Blocks.RED_SAND) || blockStateBelow.isOf(Blocks.NETHERRACK) ||
                    blockStateBelow.isOf(Blocks.BASALT) || blockStateBelow.isOf(Blocks.BLACKSTONE) ||
                    blockStateBelow.isOf(Blocks.CRIMSON_NYLIUM) || blockStateBelow.isOf(Blocks.WARPED_NYLIUM) ||
                    blockStateBelow.isOf(Blocks.MOSS_BLOCK) || blockStateBelow.isOf(Blocks.MOSSY_COBBLESTONE) ||
                    blockStateBelow.isOf(Blocks.MOSSY_STONE_BRICKS);

            if (isValid) {
                return true;
            }
        }
        return false;
    }
*/
    public static boolean validRatSpawn(WorldAccess world, BlockPos pos) {
        BlockPos[] positionsToCheck = {
                pos.down(), pos.down().north(), pos.down().south(), pos.down().east(), pos.down().west()
        };

        for (BlockPos checkPos : positionsToCheck) {
            BlockState blockStateBelow = world.getBlockState(checkPos);
            boolean isValid = blockStateBelow.isSolidBlock(world, checkPos);
            if (isValid) {
                return true;
            }
        }
        return false;
    }

    public static boolean ratCanMobSpawn(EntityType<? extends AnimalEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, net.minecraft.util.math.random.Random random) {
        BlockPos blockPos = pos.down();
        return spawnReason == SpawnReason.SPAWNER || world.getBlockState(blockPos).allowsSpawning(world, blockPos, type);
    }


    // what gets called in ModEntitySpawn
    public static boolean ratSpawnMechanics(EntityType<? extends RatEntity> type, ServerWorldAccess world, SpawnReason spawnReason,
                                            BlockPos pos, net.minecraft.util.math.random.Random random) {

        boolean rate = reduceSpawnRate(world, pos, random);
        boolean darkenough = isSpawnDark(world, pos, random);
        boolean vrs = validRatSpawn( world, pos);
        boolean reason = ratCanMobSpawn(type,world,spawnReason,pos,random);

       /* BlockPos blockPos = pos.down();
        BlockPos blockPosBelow = pos.down();
        BlockState blockStateBelow = world.getBlockState(blockPosBelow);
        Block blockBelow = blockStateBelow.getBlock();
        System.out.println
         ("Checking rat spawn on " + blockBelow + " at: "+pos+ " isDark=" + darkenough + ", canSpawnOnBlock=" + validRatSpawn + " Has reason: " + spawnReason);
        */
        return rate && darkenough && vrs && reason;

    }

    private static int getInternalSkyLightLevel(ServerWorld world, BlockPos pos) {
        // Access the world's light engine directly to fetch internal sky light levels
        // This method may require more detailed handling depending on the internal light propagation
        return world.getChunkManager().getLightingProvider().getLight(pos, 0);
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);

        /*
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
        System.out.println("Rat spawned at position: " + pos);
        System.out.println("Sky Light Level: " + skyLightLevel);
        System.out.println("Block Light Level: " + blockLightLevel);
        System.out.println("Total Light Level: " + totalLightLevel);
        System.out.println("Ambient Darkness: " + ambientdarkness);
        System.out.println("On Block: " + blockBelow);
        System.out.println("---------------------------------------------------");
*/
    }




}//end class



