package com.github.itzswirlz.slstoof.test;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import net.minecraft.test.GameTest;
import net.minecraft.test.TestContext;
import net.minecraft.util.math.BlockPos;

public class FireIgnitionTests {
	@GameTest(templateName = "soletssettheoreonfire:test/copper_fire_ignition")
	public static void copper_fire(TestContext context) {
		context.pushButton(0, 1, 0);
		context.expectBlockAtEnd(SLSTOOFBlocks.COPPER_FIRE.get(), new BlockPos(1, 2, 1));
		context.complete();
	}

	@GameTest(templateName = "soletssettheoreonfire:test/iron_fire_ignition")
	public static void iron_fire(TestContext context) {
		context.pushButton(0, 1, 0);
		context.expectBlockAtEnd(SLSTOOFBlocks.IRON_FIRE.get(), new BlockPos(1, 2, 1));
		context.complete();
	}

	@GameTest(templateName = "soletssettheoreonfire:test/redstone_fire_ignition")
	public static void redstone_fire(TestContext context) {
		context.pushButton(0, 1, 0);
		context.expectBlockAtEnd(SLSTOOFBlocks.REDSTONE_FIRE.get(), new BlockPos(1, 2, 1));
		context.complete();
	}
}
