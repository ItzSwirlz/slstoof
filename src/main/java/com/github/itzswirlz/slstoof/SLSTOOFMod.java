package com.github.itzswirlz.slstoof;

import net.fabricmc.api.ModInitializer;

public class SLSTOOFMod implements ModInitializer {
	public static final String MOD_ID = "soletssettheoreonfire";

	@Override
	public void onInitialize() {
		SLSTOOFParticles.registerFireParticles();

		SLSTOOFBlocks.registerCopperFireBlocks();
		SLSTOOFItems.registerCopperBlockItems();

		SLSTOOFBlocks.registerIronFireBlocks();
		SLSTOOFItems.registerIronBlockItems();

		SLSTOOFBlocks.registerRedstoneFireBlocks();
		SLSTOOFItems.registerRedstoneBlockItems();

		SLSTOOFItemGroup.registerslstoofItemGroup();

		SLSTOOFBlocks.updateCampfireBlockEntityType();
	}
}
