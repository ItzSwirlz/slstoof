package com.github.itzswirlz.slstoof.client;

import com.github.itzswirlz.slstoof.SLSTOOFMod;
import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.particle.SLSTOOFParticles;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.world.level.block.Block;

public class SLSTOOFModFabricClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		SLSTOOFMod.initClient();
		ParticleFactoryRegistry.getInstance().register(SLSTOOFParticles.COPPER_FIRE_FLAME.get(), FlameParticle.Provider::new);
		ParticleFactoryRegistry.getInstance().register(SLSTOOFParticles.IRON_FIRE_FLAME.get(), FlameParticle.Provider::new);

		Block[] campfireBlocks = new Block[]{SLSTOOFBlocks.COPPER_CAMPFIRE.get(), SLSTOOFBlocks.IRON_CAMPFIRE.get(), SLSTOOFBlocks.REDSTONE_CAMPFIRE.get()};
		for (Block block : campfireBlocks) {
			net.minecraft.world.level.block.entity.BlockEntityType.CAMPFIRE.addSupportedBlock(block);
		}
	}
}
