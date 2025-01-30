package com.githubtrulytails.kultscultmod.world.gen;

import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.entity.custom.CapyEntity;
import com.githubtrulytails.kultscultmod.entity.custom.MinithulusEntity;
import com.githubtrulytails.kultscultmod.entity.custom.RatAnimal;
import com.githubtrulytails.kultscultmod.entity.custom.RatEntity;
import com.githubtrulytails.kultscultmod.util.ModSpawnGroup;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class ModEntitySpawn {

    public static void addEntitySpawn  (){

      //  BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER,
      //         ModEntities.WRING, 5, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER,
                ModEntities.MINI, 30, 1, 1);


        //Using monster will impact hostile mob spawn rates. Look into making a custom spawn group later.
        // Apparently it also dictates spawn conditions. Creature cannot spawn below a light level of 9. Rats need 7 or lower atm.
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 15, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BIRCH_FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 15, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DRIPSTONE_CAVES), SpawnGroup.MONSTER,
                ModEntities.RAT, 15, 2, 9);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.LUSH_CAVES), SpawnGroup.MONSTER,
                ModEntities.RAT, 15, 2, 9);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), SpawnGroup.MONSTER,
                ModEntities.RAT, 10, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.DARK_FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 15, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), SpawnGroup.MONSTER,
                ModEntities.RAT, 15, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.OLD_GROWTH_BIRCH_FOREST), SpawnGroup.MONSTER,
                ModEntities.RAT, 15, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.JUNGLE), SpawnGroup.MONSTER,
                ModEntities.RAT, 15, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BAMBOO_JUNGLE), SpawnGroup.MONSTER,
                ModEntities.RAT, 10, 2, 5);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SPARSE_JUNGLE), SpawnGroup.MONSTER,
                ModEntities.RAT, 10, 2, 5);



        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.BEACH), SpawnGroup.AMBIENT,
                ModEntities.CAPY, 7, 1, 2);
         BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.RIVER), SpawnGroup.AMBIENT,
                ModEntities.CAPY, 7, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SWAMP), SpawnGroup.AMBIENT,
                ModEntities.CAPY, 7, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.SUNFLOWER_PLAINS), SpawnGroup.AMBIENT,
                ModEntities.CAPY, 7, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST), SpawnGroup.AMBIENT,
                ModEntities.CAPY, 7, 1, 3);
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.STONY_SHORE), SpawnGroup.AMBIENT,
                ModEntities.CAPY, 7, 1, 3);


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

        //good set of rules to hard test spawning. This creates around 900 rats in a normal world
     /*  BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.AMBIENT,
                ModEntities.RAT, 500, 1, 5);
*/



        SpawnRestriction.register(ModEntities.RAT, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, RatEntity::ratSpawnMechanics);

        SpawnRestriction.register(ModEntities.WRING, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, HostileEntity::canSpawnInDark);

        SpawnRestriction.register(ModEntities.CAPY, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, CapyEntity::capySpawnMechanics);

        SpawnRestriction.register(ModEntities.MINI, SpawnRestriction.Location.NO_RESTRICTIONS,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MinithulusEntity::miniSpawnMechanics);


    }


}
