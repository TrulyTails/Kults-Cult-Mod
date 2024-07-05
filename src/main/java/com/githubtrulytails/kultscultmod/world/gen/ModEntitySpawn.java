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

        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 5000, 5, 10);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES), SpawnGroup.MONSTER,
                ModEntities.RAT, 5000, 3, 9);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), SpawnGroup.MONSTER,
                ModEntities.RAT, 5000, 3, 6);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), SpawnGroup.MONSTER,
                ModEntities.RAT, 5000, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 5000, 4, 8);


         BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DEEP_DARK), SpawnGroup.MONSTER,
                 ModEntities.WRING, 250, 1, 1);
         BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES), SpawnGroup.MONSTER,
                 ModEntities.WRING, 250, 1, 1);
         BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH), SpawnGroup.MONSTER,
                 ModEntities.WRING, 250, 1, 1);
         BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST), SpawnGroup.MONSTER,
                 ModEntities.WRING, 250, 1, 1);



        SpawnRestriction.register(ModEntities.RAT, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RatEntity::ratCanSpawnInDark);

        SpawnRestriction.register(ModEntities.WRING, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);
    }


}
