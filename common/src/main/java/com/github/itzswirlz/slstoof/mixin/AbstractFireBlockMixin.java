package com.github.itzswirlz.slstoof.mixin;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.block.CopperFireBlock;
import com.github.itzswirlz.slstoof.block.IronFireBlock;
import com.github.itzswirlz.slstoof.block.RedstoneFireBlock;

import net.minecraft.block.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(AbstractFireBlock.class)
public class AbstractFireBlockMixin {
	@Inject(method = "getState", at = @At("RETURN"), cancellable = true)
	private static void injected(BlockView world, BlockPos pos, CallbackInfoReturnable<BlockState> cir) {
		if (CopperFireBlock.isCopperBase(world.getBlockState(pos.down()))) {
			cir.setReturnValue(SLSTOOFBlocks.COPPER_FIRE.get().getDefaultState());
		} else if (IronFireBlock.isIronBase(world.getBlockState(pos.down()))) {
			cir.setReturnValue(SLSTOOFBlocks.IRON_FIRE.get().getDefaultState());
		} else if (RedstoneFireBlock.isRedstoneBase(world.getBlockState(pos.down()))) {
			cir.setReturnValue(SLSTOOFBlocks.REDSTONE_FIRE.get().getDefaultState());
		}
	}
}
