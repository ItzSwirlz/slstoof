package com.github.itzswirlz.slstoof.test;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import net.minecraft.test.GameTest;
import net.minecraft.test.TestContext;
import net.minecraft.util.math.BlockPos;

public class SLSTOOFGameTests {
	@GameTest(templateName = "soletssettheoreonfire:test/copper_fire_ignition")
	public static void copperFireIgnitionTest(TestContext context) {
		context.pushButton(0, 1, 0);
		context.checkBlock(new BlockPos(1, 2, 1), block -> block == SLSTOOFBlocks.COPPER_FIRE.get(), "Fire block generated was not copper fire!");
		context.complete();
	}
}
