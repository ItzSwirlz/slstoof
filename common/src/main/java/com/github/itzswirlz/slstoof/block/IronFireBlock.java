package com.github.itzswirlz.slstoof.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class IronFireBlock extends BaseFireBlock {
	public static final MapCodec<IronFireBlock> CODEC = simpleCodec(IronFireBlock::new);

	public MapCodec<IronFireBlock> codec() {
		return CODEC;
	}

	// TODO: Do we want copper fires to oxidize?
	public IronFireBlock(BlockBehaviour.Properties properties) {
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
		return blockState.is(BlockTags.IRON_ORES) || blockState.is(Blocks.IRON_BLOCK);
	}

	protected boolean canBurn(BlockState blockState) {
		return true;
	}
}
