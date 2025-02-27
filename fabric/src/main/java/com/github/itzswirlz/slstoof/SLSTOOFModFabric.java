package com.github.itzswirlz.slstoof;

import net.fabricmc.api.ModInitializer;

public class SLSTOOFModFabric implements ModInitializer {

	public static final String MOD_ID = "soletssettheoreonfire";

	@Override
	public void onInitialize() {
		SLSTOOFMod.init();
	}
}
