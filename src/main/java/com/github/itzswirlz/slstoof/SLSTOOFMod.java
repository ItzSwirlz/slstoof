package com.github.itzswirlz.slstoof;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.item.SLSTOOFItemGroup;
import com.github.itzswirlz.slstoof.item.SLSTOOFItems;
import com.github.itzswirlz.slstoof.particle.SLSTOOFParticles;

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

		SLSTOOFItemGroup.registerItemGroup();

		SLSTOOFBlocks.updateCampfireBlockEntityType();
	}
}
