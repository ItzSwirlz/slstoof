package com.github.itzswirlz.slstoof;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.item.SLSTOOFCreativeModeTab;
import com.github.itzswirlz.slstoof.item.SLSTOOFItems;
import com.github.itzswirlz.slstoof.particle.SLSTOOFParticles;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public final class SLSTOOFMod {
	public static final String MOD_ID = "soletssettheoreonfire";

	public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
	public static final Registrar<Block> BLOCKS = MANAGER.get().get(Registries.BLOCK);
	public static final Registrar<Item> ITEMS = MANAGER.get().get(Registries.ITEM);
	public static final Registrar<CreativeModeTab> CREATIVE_MODE_TABS = MANAGER.get().get(Registries.CREATIVE_MODE_TAB);
	public static final Registrar<ParticleType<?>> PARTICLES = MANAGER.get().get(Registries.PARTICLE_TYPE);

	public static void init() {
		// GO GO GO
		SLSTOOFParticles.registerFireParticles();  // Must be done first because items/blocks rely on this
		SLSTOOFBlocks.registerBlocks();
		SLSTOOFItems.registerItems();
		SLSTOOFCreativeModeTab.registerItemGroup();
	}

	public static void initClient() {
		// Each platform handles adding blocks that have a BlockEntityType differently, so specifically for the campfires, check the individual handling.
		// Also: Until Architectury's ParticleProviderRegistry is working, particle providers are provided per client

		// Now that we are registered we can set our particles
		SLSTOOFBlocks.IRON_TORCH.get().flameParticle = SLSTOOFParticles.IRON_FIRE_FLAME.get();
		SLSTOOFBlocks.IRON_WALL_TORCH.get().flameParticle = SLSTOOFParticles.IRON_FIRE_FLAME.get();
	}
}
