package com.githubtrulytails.kultscultmod.util;

import com.githubtrulytails.kultscultmod.entity.ModEntities;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;

public class ModEntityHandler {

    public static void logSpawnLightLevel(ServerWorld world, LivingEntity entity, BlockPos pos) {
        // Check if the entity is of the type you want to log the light level for
        if (entity.getType().equals(ModEntities.RAT)) { // Replace MyModEntities.RAT with your entity type
            // Get the light levels at the spawn position
            int skyLightLevel = world.getLightLevel(LightType.SKY, pos);
            int blockLightLevel = world.getLightLevel(LightType.BLOCK, pos);
            int totalLightLevel = world.getLightLevel(pos);

            // Print the light levels
            System.out.println("Rat spawned at position: " + pos);
            System.out.println("Sky Light Level: " + skyLightLevel);
            System.out.println("Block Light Level: " + blockLightLevel);
            System.out.println("Total Light Level: " + totalLightLevel);
        }
    }

    // Example method to trigger the light level logging, e.g., when the entity spawns
    public static void onEntitySpawn(LivingEntity entity, ServerWorld world, BlockPos pos) {
        logSpawnLightLevel(world, entity, pos);
    }
}
