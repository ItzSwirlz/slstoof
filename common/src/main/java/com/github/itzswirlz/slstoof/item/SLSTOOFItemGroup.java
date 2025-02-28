package com.github.itzswirlz.slstoof.item;

import com.github.itzswirlz.slstoof.SLSTOOFMod;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SLSTOOFItemGroup {
	public static RegistrySupplier<ItemGroup> SLSTOOF;

	public static void registerItemGroup() {
		SLSTOOF = SLSTOOFMod.ITEM_GROUPS.register(Identifier.of(SLSTOOFMod.MOD_ID, "slstoof"), () ->
			// row "null" and column "-1" is what Fabric does with its builder
			ItemGroup.create(null, -1).displayName(Text.translatable("itemGroup.soletssettheoreonfire"))
				.icon(() -> new ItemStack(Items.FLINT_AND_STEEL))
				.entries((context, entries) -> {
					entries.add(SLSTOOFItems.COPPER_TORCH.get());
					entries.add(SLSTOOFItems.IRON_TORCH.get());

					entries.add(SLSTOOFItems.COPPER_LANTERN.get());
					entries.add(SLSTOOFItems.IRON_LANTERN.get());
					entries.add(SLSTOOFItems.REDSTONE_LANTERN.get());

					entries.add(SLSTOOFItems.COPPER_CAMPFIRE.get());
					entries.add(SLSTOOFItems.IRON_CAMPFIRE.get());
					entries.add(SLSTOOFItems.REDSTONE_CAMPFIRE.get());
				}).build());
	}
}
