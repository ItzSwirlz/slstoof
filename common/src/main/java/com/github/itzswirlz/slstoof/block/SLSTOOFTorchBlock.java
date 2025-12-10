package com.github.itzswirlz.slstoof.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SLSTOOFTorchBlock extends TorchBlock {
	// This is a hacky workaround needing to set the particle of the block
	public SimpleParticleType flameParticle;

	public SLSTOOFTorchBlock(BlockBehaviour.Properties properties) {
		// Although we are calling super on the generic flame particle, we override in
		// randomDisplayTick
		super(ParticleTypes.FLAME, properties);
	}

	@Override
	public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
		double d = (double)blockPos.getX() + (double)0.5F;
		double e = (double)blockPos.getY() + 0.7;
		double f = (double)blockPos.getZ() + (double)0.5F;
		level.addParticle(ParticleTypes.SMOKE, d, e, f, (double)0.0F, (double)0.0F, (double)0.0F);
		level.addParticle(this.flameParticle, d, e, f, (double)0.0F, (double)0.0F, (double)0.0F);
	}

}
