package com.githubtrulytails.kultscultmod.util;

import com.mojang.serialization.Codec;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.StringIdentifiable;

public enum ModSpawnGroup implements StringIdentifiable {

    RATGROUP("rats",25,true,false,150)


    ;
    public static final Codec<SpawnGroup> CODEC = StringIdentifiable.createCodec(SpawnGroup::values);
    private final int capacity;
    private final boolean peaceful;
    private final boolean rare;
    private final String name;
    private final int despawnStartRange = 32;
    private final int immediateDespawnRange;

    private ModSpawnGroup(String name, int spawnCap, boolean peaceful, boolean rare, int immediateDespawnRange) {
        this.name = name;
        this.capacity = spawnCap;
        this.peaceful = peaceful;
        this.rare = rare;
        this.immediateDespawnRange = immediateDespawnRange;
    }


    public String getName() {
        return this.name;
    }

    @Override
    public String asString() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }


    public boolean isPeaceful() {
        return this.peaceful;
    }


    public boolean isRare() {
        return this.rare;
    }


    public int getImmediateDespawnRange() {
        return this.immediateDespawnRange;
    }


    public int getDespawnStartRange() {
        return 32;
    }
}


