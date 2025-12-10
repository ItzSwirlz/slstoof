package com.github.itzswirlz.slstoof.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class RedstoneFireBlock extends BaseFireBlock {
	public static final MapCodec<RedstoneFireBlock> CODEC = simpleCodec(RedstoneFireBlock::new);

	public MapCodec<RedstoneFireBlock> codec() {
		return CODEC;
	}

	// TODO: Do we want copper fires to oxidize?
	public RedstoneFireBlock(BlockBehaviour.Properties properties) {
		super(properties, 1.0F);
	}


	protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
		return this.canSurvive(blockState, levelReader, blockPos) ? this.defaultBlockState() : Blocks.AIR.defaultBlockState();
	}

	protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		return canSurviveOnBlock(levelReader.getBlockState(blockPos.below()));
	}

	// TODO: check we got every block
	public static boolean canSurviveOnBlock(BlockState blockState) {
		return blockState.is(BlockTags.REDSTONE_ORES) || blockState.is(Blocks.REDSTONE_BLOCK);
	}

	protected boolean canBurn(BlockState blockState) {
		return true;
	}

	protected boolean isSignalSource(BlockState blockState) {
		return true;
	}

	// RedstoneBlock and RedstoneTorchBlock emits 15
	protected int getSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
		return 15;
	}
}
