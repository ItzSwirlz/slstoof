package com.github.itzswirlz.slstoof.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.CampfireBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

// Sole purpose of this class is to give the redstone campfire block the redstone emitting capabilities
public class RedstoneCampfireBlock extends CampfireBlock {
    public RedstoneCampfireBlock(boolean emitsParticles, int fireDamage, Settings settings) {
        super(emitsParticles, fireDamage, settings);
    }

    // CampfireBlock extends Block which contain the redstone methods
    protected boolean emitsRedstonePower(BlockState state) {
      return true;
    }

    // For now, set to 15
    // TODO: Have a configuration (gamerule?) such that since up to four items can be on a campfire. The more items, the more power
    protected int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 15;
    }
}
