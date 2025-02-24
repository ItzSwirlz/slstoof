package com.github.itzswirlz.slstoof.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;

public class IronFireBlock extends AbstractFireBlock {
    public static final MapCodec<IronFireBlock> CODEC = createCodec(IronFireBlock::new);

    public IronFireBlock(Settings settings) {
        super(settings, 1.0F);
    }

    public MapCodec<IronFireBlock> getCodec() {
        return CODEC;
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView,
            BlockPos pos, Direction direction, BlockPos neighborPos, BlockState neighborState, Random random) {
        return this.canPlaceAt(state, world, pos) ? this.getDefaultState() : Blocks.AIR.getDefaultState();
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return isIronBase(world.getBlockState(pos.down()));
    }

    public static boolean isIronBase(BlockState state) {
        return state.getBlock().equals(Blocks.IRON_BLOCK);
    }

    @Override
    protected boolean isFlammable(BlockState state) {
        return true;
    }
}
