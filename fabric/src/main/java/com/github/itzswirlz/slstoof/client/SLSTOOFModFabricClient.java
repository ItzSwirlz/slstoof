package com.github.itzswirlz.slstoof.client;

import com.github.itzswirlz.slstoof.SLSTOOFMod;
import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.particle.SLSTOOFParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleProviderRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityTypes;

public class SLSTOOFModFabricClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		SLSTOOFMod.initClient();
		ParticleProviderRegistry.getInstance().register(SLSTOOFParticles.COPPER_FIRE_FLAME.get(), FlameParticle.Provider::new);
		ParticleProviderRegistry.getInstance().register(SLSTOOFParticles.IRON_FIRE_FLAME.get(), FlameParticle.Provider::new);

		Block[] campfireBlocks = new Block[]{SLSTOOFBlocks.COPPER_CAMPFIRE.get(), SLSTOOFBlocks.IRON_CAMPFIRE.get(), SLSTOOFBlocks.REDSTONE_CAMPFIRE.get()};
		for (Block block : campfireBlocks) {
			BlockEntityTypes.CAMPFIRE.addValidBlock(block);
		}

		BuiltInRegistries.BLOCK.addAlias(Identifier.parse("soletssettheoreonfire:copper_lantern"), Identifier.parse("minecraft:copper_lantern"));
		BuiltInRegistries.BLOCK.addAlias(Identifier.parse("soletssettheoreonfire:copper_torch"), Identifier.parse("minecraft:copper_torch"));
		BuiltInRegistries.BLOCK.addAlias(Identifier.parse("soletssettheoreonfire:copper_wall_torch"), Identifier.parse("minecraft:copper_wall_torch"));

		BuiltInRegistries.ITEM.addAlias(Identifier.parse("soletssettheoreonfire:copper_lantern"), Identifier.parse("minecraft:copper_lantern"));
		BuiltInRegistries.ITEM.addAlias(Identifier.parse("soletssettheoreonfire:copper_torch"), Identifier.parse("minecraft:copper_torch"));

	}
}
