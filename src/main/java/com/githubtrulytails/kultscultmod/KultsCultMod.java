package com.githubtrulytails.kultscultmod;

import com.githubtrulytails.kultscultmod.Blocks.ModBlocks;
import com.githubtrulytails.kultscultmod.entity.ModEntities;
import com.githubtrulytails.kultscultmod.entity.custom.RatEntity;
import com.githubtrulytails.kultscultmod.entity.custom.WringEntity;
import com.githubtrulytails.kultscultmod.items.ModItemGroups;
import com.githubtrulytails.kultscultmod.items.ModItems;
import com.githubtrulytails.kultscultmod.util.ModEntityHandler;
import com.githubtrulytails.kultscultmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
// rename class with shift+f6 use caps because class name
public class KultsCultMod implements ModInitializer {

	//the internal name of the mod. Must be different from other mods. Lowercase, no spaces _ 1-9
	// see resources > fabric.mod.json next
	public static final String MOD_ID = "kultscultmod";


    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		LOGGER.info("Hello Fabric world!");
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FabricDefaultAttributeRegistry.register(ModEntities.RAT, RatEntity.createRatAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.WRING, WringEntity.createWringAttributes());

		ModEntities.registerModEntities();

		ModWorldGeneration.generateModWorldGen();


	}
	}


