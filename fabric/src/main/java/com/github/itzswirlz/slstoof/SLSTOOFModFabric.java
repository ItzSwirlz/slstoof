package com.github.itzswirlz.slstoof;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.item.SLSTOOFItemGroup;
import com.github.itzswirlz.slstoof.item.SLSTOOFItems;
import com.github.itzswirlz.slstoof.particle.SLSTOOFParticles;
import net.fabricmc.api.ModInitializer;

public class SLSTOOFModFabric implements ModInitializer {

	public static final String MOD_ID = "soletssettheoreonfire";

	@Override
	public void onInitialize() {
		SLSTOOFMod.init();
	}
}
