package com.github.itzswirlz.slstoof.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.TorchBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SLSTOOFTorchBlock extends TorchBlock {
	// This is a hacky workaround needing to set the particle of the block
	public SimpleParticleType replacementParticle;

	public SLSTOOFTorchBlock(Settings settings) {
		// Although we are calling super on the generic flame particle, we override in
		// randomDisplayTick
		super(ParticleTypes.FLAME, settings);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		double d = (double) pos.getX() + (double) 0.5F;
		double e = (double) pos.getY() + 0.7;
		double f = (double) pos.getZ() + (double) 0.5F;
		world.addParticleClient(ParticleTypes.SMOKE, d, e, f, (double) 0.0F, (double) 0.0F, (double) 0.0F);
		world.addParticleClient(this.replacementParticle, d, e, f, (double) 0.0F, (double) 0.0F, (double) 0.0F);
	}

}
