package com.github.itzswirlz.slstoof.test;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import net.minecraft.test.TestContext;
import net.minecraft.util.math.BlockPos;

public class SLSTOOFFireIgnitionTests {
	// Commented the .complete() as it may be unnecessary - in fact, it could be
	// causing testcases that should fail to pass
	// see https://report.bugs.mojang.com/servicedesk/customer/portal/2/MC-295787
	public static void testCopperFireIgnition(TestContext context) {
		context.pushButton(0, 1, 0);
		context.expectBlockAtEnd(SLSTOOFBlocks.COPPER_FIRE.get(), new BlockPos(1, 2, 1));
//		context.complete();
	}

	public static void testIronFireIgnition(TestContext context) {
		context.pushButton(0, 1, 0);
		context.expectBlockAtEnd(SLSTOOFBlocks.IRON_FIRE.get(), new BlockPos(1, 2, 1));
//		context.complete();
	}

	public static void testRedstoneFireIgnition(TestContext context) {
		context.pushButton(0, 1, 0);
		context.expectBlockAtEnd(SLSTOOFBlocks.REDSTONE_FIRE.get(), new BlockPos(1, 2, 1));
//		context.complete();
	}
}
