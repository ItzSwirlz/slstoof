package com.github.itzswirlz.swstoof.block;

import com.mojang.serialization.MapCodec;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public class RedstoneFireBlock extends AbstractFireBlock {
    public static final MapCodec<RedstoneFireBlock> CODEC = createCodec(RedstoneFireBlock::new);

    public RedstoneFireBlock(Settings settings) {
        super(settings, 1.0F);
    }

    public MapCodec<RedstoneFireBlock> getCodec() {
        return CODEC;
    }

    // This is deprecated (in AbstractBlock) but its needed to ensure if the block below the fire breaks, we remove it.
    // SoulFireBlock uses it though?
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
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
