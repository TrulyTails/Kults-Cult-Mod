package com.githubtrulytails.kultscultmod;

import net.fabricmc.api.ModInitializer;

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
	}
}