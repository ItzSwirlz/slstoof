package com.github.itzswirlz.slstoof.particle;

import com.github.itzswirlz.slstoof.SLSTOOFMod;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SLSTOOFParticles {
    public static final SimpleParticleType COPPER_FIRE_FLAME = FabricParticleTypes.simple();
    public static final SimpleParticleType IRON_FIRE_FLAME = FabricParticleTypes.simple();

    public static void registerFireParticles() {
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(SLSTOOFMod.MOD_ID, "copper_fire_flame"),
                COPPER_FIRE_FLAME);
        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(SLSTOOFMod.MOD_ID, "iron_fire_flame"),
                IRON_FIRE_FLAME);
    }
}
