package com.github.itzswirlz.slstoof.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.LanternBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

// Sole purpose of this class is to give the redstone lantern block the redstone emitting capabilities
public class RedstoneLanternBlock extends LanternBlock {
    public RedstoneLanternBlock(Settings settings) {
        super(settings);
    }

    // LanternBlock extends Block which contain the redstone methods
    protected boolean emitsRedstonePower(BlockState state) {
      return true;
   }

   protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
      return 15;
   }
}
