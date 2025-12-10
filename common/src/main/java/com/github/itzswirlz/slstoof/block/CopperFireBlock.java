package com.github.itzswirlz.slstoof.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class CopperFireBlock extends BaseFireBlock {
    public static final MapCodec<CopperFireBlock> CODEC = simpleCodec(CopperFireBlock::new);

	public MapCodec<CopperFireBlock> codec() {
		return CODEC;
	}

    // TODO: Do we want copper fires to oxidize?
    public CopperFireBlock(BlockBehaviour.Properties properties) {
        super(properties, 1.0F);
    }


	protected BlockState updateShape(BlockState blockState, LevelReader levelReader, ScheduledTickAccess scheduledTickAccess, BlockPos blockPos, Direction direction, BlockPos blockPos2, BlockState blockState2, RandomSource randomSource) {
		return this.canSurvive(blockState, levelReader, blockPos) ? this.defaultBlockState() : net.minecraft.world.level.block.Blocks.AIR.defaultBlockState();
	}

	protected boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
		return canSurviveOnBlock(levelReader.getBlockState(blockPos.below()));
    }

    // TODO: check we got every block
	public static boolean canSurviveOnBlock(BlockState blockState) {
		return blockState.is(BlockTags.COPPER) || blockState.is(BlockTags.COPPER_CHESTS) || blockState.is(BlockTags.COPPER_ORES) || blockState.is(BlockTags.COPPER_GOLEM_STATUES);
    }

	protected boolean canBurn(BlockState blockState) {
		return true;
	}
}
