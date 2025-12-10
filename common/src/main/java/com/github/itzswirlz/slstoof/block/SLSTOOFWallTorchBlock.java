package com.github.itzswirlz.slstoof.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class SLSTOOFWallTorchBlock extends WallTorchBlock {
	// This is a hacky workaround needing to set the particle of the block
	public SimpleParticleType flameParticle;

	public SLSTOOFWallTorchBlock(BlockBehaviour.Properties properties) {
		// Although we are calling super on the generic flame particle, we override in
		// randomDisplayTick
		super(ParticleTypes.FLAME, properties);
	}

	@Override
	public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
		Direction direction = (Direction) blockState.getValue(FACING);
		double d = (double) blockPos.getX() + (double) 0.5F;
		double e = (double) blockPos.getY() + 0.7;
		double f = (double) blockPos.getZ() + (double) 0.5F;
		double g = 0.22;
		double h = 0.27;
		Direction direction2 = direction.getOpposite();
		level.addParticle(ParticleTypes.SMOKE, d + 0.27 * (double) direction2.getStepX(), e + 0.22, f + 0.27 * (double) direction2.getStepZ(), (double) 0.0F, (double) 0.0F, (double) 0.0F);
		level.addParticle(this.flameParticle, d + 0.27 * (double) direction2.getStepX(), e + 0.22, f + 0.27 * (double) direction2.getStepZ(), (double) 0.0F, (double) 0.0F, (double) 0.0F);
	}

}
