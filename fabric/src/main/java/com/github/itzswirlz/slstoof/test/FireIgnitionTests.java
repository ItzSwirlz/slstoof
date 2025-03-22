package com.github.itzswirlz.slstoof.test;

import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.test.TestContext;

public class FireIgnitionTests {
	@GameTest(structure = "soletssettheoreonfire:test/copper_fire_ignition")
	public void copper_fire(TestContext context) {
		SLSTOOFFireIgnitionTests.testCopperFireIgnition(context);
	}

	@GameTest(structure = "soletssettheoreonfire:test/iron_fire_ignition")
	public void iron_fire(TestContext context) {
		SLSTOOFFireIgnitionTests.testIronFireIgnition(context);
	}

	@GameTest(structure = "soletssettheoreonfire:test/redstone_fire_ignition")
	public void redstone_fire(TestContext context) {
		SLSTOOFFireIgnitionTests.testRedstoneFireIgnition(context);
	}
}
