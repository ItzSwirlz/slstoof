package com.github.itzswirlz.slstoof.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

// Sole purpose of this class is to give the redstone lantern block the redstone emitting capabilities
public class RedstoneLanternBlock extends LanternBlock {
   public RedstoneLanternBlock(BlockBehaviour.Properties properties) {
      super(properties);
   }

   // LanternBlock extends Block which contain the redstone methods
   protected boolean isSignalSource(BlockState blockState) {
	   return true;
   }

   protected int getSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
	   return 15;
   }
}
