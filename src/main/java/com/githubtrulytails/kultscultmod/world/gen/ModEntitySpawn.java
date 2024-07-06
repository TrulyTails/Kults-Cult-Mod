package com.githubtrulytails.kultscultmod.world.gen;

import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.entity.custom.RatEntity;
import com.githubtrulytails.kultscultmod.util.ModSpawnGroup;
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
/*
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 25, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 20, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES), SpawnGroup.MONSTER,
                ModEntities.RAT, 20, 2, 9);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), SpawnGroup.MONSTER,
                ModEntities.RAT, 20, 2, 9);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), SpawnGroup.MONSTER,
                ModEntities.RAT, 20, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 20, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), SpawnGroup.MONSTER,
                ModEntities.RAT, 20, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 20, 2, 5);
*/

    /*
     BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), SpawnGroup.MONSTER,
                ModEntities.WRING, 250, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES), SpawnGroup.MONSTER,
                ModEntities.WRING, 250, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DESERT), SpawnGroup.MONSTER,
                ModEntities.WRING, 250, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST), SpawnGroup.MONSTER,
                ModEntities.WRING, 250, 1, 1);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), SpawnGroup.MONSTER,
                ModEntities.WRING, 250, 1, 1);
*/

        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.AMBIENT,
                ModEntities.RAT, 500, 1, 5);
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER,
                ModEntities.WRING, 100, 1, 1);


        SpawnRestriction.register(ModEntities.RAT, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RatEntity::ratSpawnMechanics);

        SpawnRestriction.register(ModEntities.WRING, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
    }


}
