package com.github.itzswirlz.slstoof.neoforge;

import com.github.itzswirlz.slstoof.SLSTOOFMod;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.particle.SLSTOOFParticles;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.event.BlockEntityTypeAddBlocksEvent;

@Mod(SLSTOOFMod.MOD_ID)
public final class SLSTOOFModNeoForge {
	public SLSTOOFModNeoForge(IEventBus bus) {
		SLSTOOFMod.init();

		bus.addListener(this::onClientSetupEvent);
		bus.addListener(this::onBlockEntityTypeAddBlocksEvent);
		bus.addListener(this::onRegisterParticleProvidersEvent);
	}

	private void onBlockEntityTypeAddBlocksEvent(final BlockEntityTypeAddBlocksEvent event) {
		event.modify(BlockEntityType.CAMPFIRE, SLSTOOFBlocks.COPPER_CAMPFIRE.get(), SLSTOOFBlocks.IRON_CAMPFIRE.get(), SLSTOOFBlocks.REDSTONE_CAMPFIRE.get());
	}

	private void onClientSetupEvent(final FMLClientSetupEvent event) {
		SLSTOOFMod.initClient();

		BuiltInRegistries.BLOCK.addAlias(Identifier.parse("soletssettheoreonfire:copper_lantern"), Identifier.parse("minecraft:copper_lantern"));
		BuiltInRegistries.BLOCK.addAlias(Identifier.parse("soletssettheoreonfire:copper_torch"), Identifier.parse("minecraft:copper_torch"));
		BuiltInRegistries.BLOCK.addAlias(Identifier.parse("soletssettheoreonfire:copper_wall_torch"), Identifier.parse("minecraft:copper_wall_torch"));

		BuiltInRegistries.ITEM.addAlias(Identifier.parse("soletssettheoreonfire:copper_lantern"), Identifier.parse("minecraft:copper_lantern"));
		BuiltInRegistries.ITEM.addAlias(Identifier.parse("soletssettheoreonfire:copper_torch"), Identifier.parse("minecraft:copper_torch"));
	}

	private void onRegisterParticleProvidersEvent(final RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(SLSTOOFParticles.COPPER_FIRE_FLAME.get(), FlameParticle.Provider::new);
		event.registerSpriteSet(SLSTOOFParticles.IRON_FIRE_FLAME.get(), FlameParticle.Provider::new);
	}
}
