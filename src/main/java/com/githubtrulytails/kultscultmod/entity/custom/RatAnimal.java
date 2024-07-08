package com.githubtrulytails.kultscultmod.entity.custom;

import com.githubtrulytails.kultscultmod.entity.ai.PassiveRatEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

public class RatAnimal extends PassiveRatEntity {
    protected static final int BREEDING_COOLDOWN = 6000;
    private int loveTicks;
    @Nullable
    private UUID lovingPlayer;

    protected RatAnimal(EntityType<? extends RatAnimal> entityType, World world) {
        super(entityType, world);
        this.setPathfindingPenalty(PathNodeType.DANGER_FIRE, 16.0F);
        this.setPathfindingPenalty(PathNodeType.DAMAGE_FIRE, -1.0F);
    }


    @Override
    protected void mobTick() {
        if (this.getBreedingAge() != 0) {
            this.loveTicks = 0;
        }

        super.mobTick();
    }

    @Override
    public void tickMovement() {
        super.tickMovement();
        if (this.getBreedingAge() != 0) {
            this.loveTicks = 0;
        }

        if (this.loveTicks > 0) {
            this.loveTicks--;
            if (this.loveTicks % 10 == 0) {
                double d = this.random.nextGaussian() * 0.02;
                double e = this.random.nextGaussian() * 0.02;
                double f = this.random.nextGaussian() * 0.02;
                this.getWorld().addParticle(ParticleTypes.HEART, this.getParticleX(1.0), this.getRandomBodyY() + 0.5, this.getParticleZ(1.0), d, e, f);
            }
        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            this.loveTicks = 0;
            return super.damage(source, amount);
        }
    }

   /* @Override
    public float getPathfindingFavor(BlockPos pos, WorldView world) {
        return world.getBlockState(pos.down()).isOf(Blocks.GRASS_BLOCK) ? 10.0F : world.getPhototaxisFavor(pos);
    }*/

    @Nullable
    public PassiveRatEntity createChild(ServerWorld world, PassiveRatEntity entity) {
        return null;
    }


    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("InLove", this.loveTicks);
        if (this.lovingPlayer != null) {
            nbt.putUuid("LoveCause", this.lovingPlayer);
        }
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.loveTicks = nbt.getInt("InLove");
        this.lovingPlayer = nbt.containsUuid("LoveCause") ? nbt.getUuid("LoveCause") : null;
    }


    public static boolean isSpawnDark(ServerWorldAccess world, BlockPos pos, Random random) {
        // Check sky light level. Sky light will always be 15. Change random int, lower means higher chance of spawning.
        int blockLightLevel = world.getLightLevel(LightType.BLOCK, pos);
        int skyLightLevel = world.getLightLevel(LightType.SKY, pos);
        int lightLevelToSpawnUnder = 7;


        if (skyLightLevel > lightLevelToSpawnUnder) {
            return false;
        } else {
            if (blockLightLevel > lightLevelToSpawnUnder) {

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
    public static boolean validRatSpawn( WorldAccess world, BlockPos pos) {
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

    public static boolean ratCanMobSpawn(EntityType<? extends RatEntity> type, WorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        BlockPos blockPos = pos.down();
        return spawnReason == SpawnReason.SPAWNER || world.getBlockState(blockPos).allowsSpawning(world, blockPos, type);
    }


    // what gets called in ModEntitySpawn
    public static boolean ratSpawnMechanics(EntityType<? extends RatEntity> type,
                                            ServerWorldAccess world,
                                            SpawnReason spawnReason,
                                            BlockPos pos, net.minecraft.util.math.random.Random random) {

        boolean darkenough = isSpawnDark(world, pos, random);
        boolean validRatSpawn = validRatSpawn( world, pos);
        BlockPos blockPos = pos.down();


        BlockPos blockPosBelow = pos.down();
        BlockState blockStateBelow = world.getBlockState(blockPosBelow);
        Block blockBelow = blockStateBelow.getBlock();

        System.out.println("Checking rat spawn on " + blockBelow + " at: "+pos+ " isDark=" + darkenough + ", canSpawnOnBlock=" + validRatSpawn + " Has reason: " + spawnReason);

        return isSpawnDark(world, pos, random) &&  ratCanMobSpawn(type, world, spawnReason, pos, random) &&  validRatSpawn(world,pos);

    }




    @Override
    public int getMinAmbientSoundDelay() {
        return 120;
    }

    @Override
    public boolean canImmediatelyDespawn(double distanceSquared) {
        return false;
    }

    @Override
    public int getXpToDrop() {
        return 1 + this.getWorld().random.nextInt(3);
    }

    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.WHEAT);
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (this.isBreedingItem(itemStack)) {
            int i = this.getBreedingAge();
            if (!this.getWorld().isClient && i == 0 && this.canEat()) {
                this.eat(player, hand, itemStack);
                this.lovePlayer(player);
                return ActionResult.SUCCESS;
            }

            if (this.isBaby()) {
                this.eat(player, hand, itemStack);
                this.growUp(toGrowUpAge(-i), true);
                return ActionResult.success(this.getWorld().isClient);
            }

            if (this.getWorld().isClient) {
                return ActionResult.CONSUME;
            }
        }

        return super.interactMob(player, hand);
    }

    protected void eat(PlayerEntity player, Hand hand, ItemStack stack) {
        if (!player.getAbilities().creativeMode) {
            stack.decrement(1);
        }
    }

    public boolean canEat() {
        return this.loveTicks <= 0;
    }

    public void lovePlayer(@Nullable PlayerEntity player) {
        this.loveTicks = 600;
        if (player != null) {
            this.lovingPlayer = player.getUuid();
        }

        this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_BREEDING_PARTICLES);
    }

    public void setLoveTicks(int loveTicks) {
        this.loveTicks = loveTicks;
    }

    public int getLoveTicks() {
        return this.loveTicks;
    }

    @Nullable
    public ServerPlayerEntity getLovingPlayer() {
        if (this.lovingPlayer == null) {
            return null;
        } else {
            PlayerEntity playerEntity = this.getWorld().getPlayerByUuid(this.lovingPlayer);
            return playerEntity instanceof ServerPlayerEntity ? (ServerPlayerEntity)playerEntity : null;
        }
    }

    public boolean isInLove() {
        return this.loveTicks > 0;
    }

    public void resetLoveTicks() {
        this.loveTicks = 0;
    }



    public void ratBreed(ServerWorld world, RatAnimal other) {
        PassiveRatEntity passiveRatEntity = this.createChild(world, other);
        if (passiveRatEntity != null) {
            passiveRatEntity.setBaby(true);
            passiveRatEntity.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), 0.0F, 0.0F);
            this.ratBreed(world, other);
            world.spawnEntityAndPassengers(passiveRatEntity);
        }
    }

  public void ratBreed(ServerWorld world, RatEntity other) {
        Optional.ofNullable(this.getLovingPlayer()).or(() -> Optional.ofNullable(other.getLovingPlayer())).ifPresent(player -> {
            player.incrementStat(Stats.ANIMALS_BRED);
        });
        this.setBreedingAge(6000);
        other.setBreedingAge(6000);
        this.resetLoveTicks();
        other.resetLoveTicks();
        world.sendEntityStatus(this, EntityStatuses.ADD_BREEDING_PARTICLES);
        if (world.getGameRules().getBoolean(GameRules.DO_MOB_LOOT)) {
            world.spawnEntity(new ExperienceOrbEntity(world, this.getX(), this.getY(), this.getZ(), this.getRandom().nextInt(7) + 1));
        }
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.ADD_BREEDING_PARTICLES) {
            for (int i = 0; i < 7; i++) {
                double d = this.random.nextGaussian() * 0.02;
                double e = this.random.nextGaussian() * 0.02;
                double f = this.random.nextGaussian() * 0.02;
                this.getWorld().addParticle(ParticleTypes.HEART, this.getParticleX(1.0), this.getRandomBodyY() + 0.5, this.getParticleZ(1.0), d, e, f);
            }
        } else {
            super.handleStatus(status);
        }
    }
}
