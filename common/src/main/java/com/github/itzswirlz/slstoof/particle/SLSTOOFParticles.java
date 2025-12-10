package com.github.itzswirlz.slstoof.particle;

import com.github.itzswirlz.slstoof.SLSTOOFMod;
import com.google.common.base.Supplier;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;

public class SLSTOOFParticles {
	public static RegistrySupplier<SimpleParticleType> COPPER_FIRE_FLAME;
	public static RegistrySupplier<SimpleParticleType> IRON_FIRE_FLAME;

	public static void registerFireParticles() {
		COPPER_FIRE_FLAME = registerParticle("copper_fire_flame", () -> new SimpleParticleType(false));
		IRON_FIRE_FLAME = registerParticle("iron_fire_flame", () -> new SimpleParticleType(false));
	}

	private static <P extends ParticleType<SimpleParticleType>> RegistrySupplier<P> registerParticle(String id, Supplier<P> supplier) {
		return SLSTOOFMod.PARTICLES.register(ResourceLocation.fromNamespaceAndPath(SLSTOOFMod.MOD_ID, id), supplier);
	}
}
