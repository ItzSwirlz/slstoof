package com.github.itzswirlz.slstoof.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class RedstoneFireBlock extends AbstractFireBlock {
    public static final MapCodec<RedstoneFireBlock> CODEC = createCodec(RedstoneFireBlock::new);

    public RedstoneFireBlock(Settings settings) {
        super(settings, 1.0F);
    }

    public MapCodec<RedstoneFireBlock> getCodec() {
        return CODEC;
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView,
            BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return isRedstoneBase(world.getBlockState(pos.down()));
    }

    public static boolean isRedstoneBase(BlockState state) {
        return state.getBlock().equals(Blocks.REDSTONE_BLOCK);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }

    protected boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    // RedstoneBlock and RedstoneTorchBlock emits 15
    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 15;
    }
}
