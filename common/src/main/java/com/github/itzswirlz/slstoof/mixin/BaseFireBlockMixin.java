package com.github.itzswirlz.slstoof.mixin;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.block.CopperFireBlock;
import com.github.itzswirlz.slstoof.block.IronFireBlock;
import com.github.itzswirlz.slstoof.block.RedstoneFireBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseFireBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BaseFireBlock.class)
public class BaseFireBlockMixin {
	@Inject(method = "getState", at = @At("RETURN"), cancellable = true)
	private static void injected(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<BlockState> cir) {
		if (CopperFireBlock.canSurviveOnBlock(blockGetter.getBlockState(blockPos.below()))) {
			cir.setReturnValue(SLSTOOFBlocks.COPPER_FIRE.get().defaultBlockState());
		} else if (IronFireBlock.canSurviveOnBlock(blockGetter.getBlockState(blockPos.below()))) {
			cir.setReturnValue(SLSTOOFBlocks.IRON_FIRE.get().defaultBlockState());
		} else if (RedstoneFireBlock.canSurviveOnBlock(blockGetter.getBlockState(blockPos.below()))) {
			cir.setReturnValue(SLSTOOFBlocks.REDSTONE_FIRE.get().defaultBlockState());
		}
	}
}
