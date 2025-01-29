package com.githubtrulytails.kultscultmod.entity;

import com.githubtrulytails.kultscultmod.KultsCultMod;
import com.githubtrulytails.kultscultmod.entity.custom.CapyEntity;
import com.githubtrulytails.kultscultmod.entity.custom.MinithulusEntity;
import com.githubtrulytails.kultscultmod.entity.custom.RatEntity;
import com.githubtrulytails.kultscultmod.entity.custom.WringEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<RatEntity> RAT = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(KultsCultMod.MOD_ID, "rat"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, RatEntity::new)
                    // rat hit box size
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());


    public static final EntityType<WringEntity> WRING = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(KultsCultMod.MOD_ID, "wring"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WringEntity::new)
                    //wring hit box
                    .dimensions(EntityDimensions.fixed(3, 3)).build());


    public static final EntityType<CapyEntity> CAPY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(KultsCultMod.MOD_ID, "capy"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CapyEntity::new)
                    // rat hit box size
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());


    public static final EntityType<MinithulusEntity> MINI = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(KultsCultMod.MOD_ID, "mini"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MinithulusEntity::new)
            .dimensions(EntityDimensions.fixed(1f,1f)).build());



    public static void registerModEntities() {
        KultsCultMod.LOGGER.info("Registering Mod Entities for " + KultsCultMod.MOD_ID);
    }
}