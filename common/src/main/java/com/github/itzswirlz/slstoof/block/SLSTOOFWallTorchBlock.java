package com.github.itzswirlz.slstoof.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SLSTOOFWallTorchBlock extends WallTorchBlock {
	// This is a hacky workaround needing to set the particle of the block
	public SimpleParticleType replacementParticle;

	public SLSTOOFWallTorchBlock(Settings settings) {
		// Although we are calling super on the generic flame particle, we override in
		// randomDisplayTick
		super(ParticleTypes.FLAME, settings);
	}

	@Override
	public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
		Direction direction = (Direction) state.get(FACING);
		double d = (double) pos.getX() + (double) 0.5F;
		double e = (double) pos.getY() + 0.7;
		double f = (double) pos.getZ() + (double) 0.5F;
		double g = 0.22;
		double h = 0.27;
		Direction direction2 = direction.getOpposite();
		world.addParticleClient(ParticleTypes.SMOKE, d + 0.27 * (double) direction2.getOffsetX(), e + 0.22, f + 0.27 * (double) direction2.getOffsetZ(), (double) 0.0F, (double) 0.0F, (double) 0.0F);
		world.addParticleClient(this.replacementParticle, d + 0.27 * (double) direction2.getOffsetX(), e + 0.22, f + 0.27 * (double) direction2.getOffsetZ(), (double) 0.0F, (double) 0.0F, (double) 0.0F);
	}

}
