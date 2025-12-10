package com.github.itzswirlz.slstoof.test;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.gametest.framework.GameTestHelper;

public class SLSTOOFFireIgnitionTests {
	public static void testCopperFireIgnition(GameTestHelper helper) {
		helper.pressButton(0, 1, 0);
		helper.succeedWhenBlockPresent(SLSTOOFBlocks.COPPER_FIRE.get(), new BlockPos(1, 2, 1));
	}

	public static void testIronFireIgnition(GameTestHelper helper) {
		helper.pressButton(0, 1, 0);
		helper.succeedWhenBlockPresent(SLSTOOFBlocks.IRON_FIRE.get(), new BlockPos(1, 2, 1));
	}

	public static void testRedstoneFireIgnition(GameTestHelper helper) {
		helper.pressButton(0, 1, 0);
		helper.succeedWhenBlockPresent(SLSTOOFBlocks.REDSTONE_FIRE.get(), new BlockPos(1, 2, 1));
	}
}
