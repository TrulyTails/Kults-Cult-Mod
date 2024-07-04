package com.githubtrulytails.kultscultmod.world.gen;

import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.entity.custom.RatEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;

import static net.fabricmc.fabric.api.biome.v1.BiomeModifications.addSpawn;

public class ModEntitySpawn {

    public static void addEntitySpawn  (){

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK).and(BiomeSelectors.excludeByKey(BiomeKeys.DEEP_DARK)
        ), SpawnGroup.CREATURE, ModEntities.RAT, 100, 5, 10);

          BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES), SpawnGroup.CREATURE,
                ModEntities.RAT, 100, 2, 4);

          BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), SpawnGroup.CREATURE,
                ModEntities.RAT, 100, 1, 2);

            BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), SpawnGroup.CREATURE,
                ModEntities.RAT, 100, 4, 8);

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), SpawnGroup.CREATURE,
                ModEntities.RAT, 100, 4, 8);


         BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK).and(BiomeSelectors.excludeByKey(BiomeKeys.DEEP_DARK)
        ), SpawnGroup.MONSTER, ModEntities.WRING, 500, 1, 1);
         BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES).and(BiomeSelectors.excludeByKey(BiomeKeys.DEEP_DARK)
         ), SpawnGroup.MONSTER, ModEntities.WRING, 500, 1, 1);
         BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH).and(BiomeSelectors.excludeByKey(BiomeKeys.DEEP_DARK)
         ), SpawnGroup.MONSTER, ModEntities.WRING, 500, 1, 1);
         BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST).and(BiomeSelectors.excludeByKey(BiomeKeys.DEEP_DARK)
         ), SpawnGroup.MONSTER, ModEntities.WRING, 500, 1, 1);



        SpawnRestriction.register(ModEntities.RAT, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
        SpawnRestriction.register(ModEntities.WRING, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
    }


}
