package com.github.itzswirlz.slstoof;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.item.SLSTOOFItemGroup;
import com.github.itzswirlz.slstoof.item.SLSTOOFItems;

public final class SLSTOOFMod {

	public static final String MOD_ID = "soletssettheoreonfire";

	public static void init() {
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
