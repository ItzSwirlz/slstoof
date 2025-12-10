package com.github.itzswirlz.slstoof.test;

import net.fabricmc.fabric.api.gametest.v1.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;

public class FireIgnitionTests {
	@GameTest(structure = "soletssettheoreonfire:test/copper_fire_ignition")
	public void copper_fire(GameTestHelper helper) { SLSTOOFFireIgnitionTests.testCopperFireIgnition(helper); }

	@GameTest(structure = "soletssettheoreonfire:test/iron_fire_ignition")
	public void iron_fire(GameTestHelper helper) {
		SLSTOOFFireIgnitionTests.testIronFireIgnition(helper);
	}

	@GameTest(structure = "soletssettheoreonfire:test/redstone_fire_ignition")
	public void redstone_fire(GameTestHelper helper) { SLSTOOFFireIgnitionTests.testRedstoneFireIgnition(helper); }
}
