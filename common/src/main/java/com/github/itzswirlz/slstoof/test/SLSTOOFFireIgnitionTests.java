package com.github.itzswirlz.slstoof.test;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import net.minecraft.test.TestContext;
import net.minecraft.util.math.BlockPos;

public class SLSTOOFFireIgnitionTests {
	public static void testCopperFireIgnition(TestContext context) {
		context.pushButton(0, 1, 0);
		context.expectBlockAtEnd(SLSTOOFBlocks.COPPER_FIRE.get(), new BlockPos(1, 2, 1));
		context.complete();
	}

	public static void testIronFireIgnition(TestContext context) {
		context.pushButton(0, 1, 0);
		context.expectBlockAtEnd(SLSTOOFBlocks.IRON_FIRE.get(), new BlockPos(1, 2, 1));
		context.complete();
	}

	public static void testRedstoneFireIgnition(TestContext context) {
		context.pushButton(0, 1, 0);
		context.expectBlockAtEnd(SLSTOOFBlocks.REDSTONE_FIRE.get(), new BlockPos(1, 2, 1));
		context.complete();
	}
}
