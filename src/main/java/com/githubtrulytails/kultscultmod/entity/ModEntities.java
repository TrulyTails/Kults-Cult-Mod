package com.githubtrulytails.kultscultmod.entity;

import com.githubtrulytails.kultscultmod.KultsCultMod;
import com.githubtrulytails.kultscultmod.entity.custom.RatEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.ServerWorldAccess;

import static net.minecraft.entity.mob.HostileEntity.isSpawnDark;
import static net.minecraft.entity.mob.MobEntity.canMobSpawn;

public class ModEntities {
    public static final EntityType<RatEntity> RAT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(KultsCultMod.MOD_ID, "rat"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE,RatEntity::new)
                    // entity's hit box size
                    .dimensions(EntityDimensions.fixed(0.5f,0.5f)).build());


    public static void registerModEntities() {

        KultsCultMod.LOGGER.info("Registering Entities for " + KultsCultMod.MOD_ID);

    }

}
