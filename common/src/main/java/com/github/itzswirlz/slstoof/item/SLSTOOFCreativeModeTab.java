package com.github.itzswirlz.slstoof.item;

import com.github.itzswirlz.slstoof.SLSTOOFMod;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class SLSTOOFCreativeModeTab {
	public static RegistrySupplier<CreativeModeTab> SLSTOOF;

	public static void registerItemGroup() {
		SLSTOOF = SLSTOOFMod.CREATIVE_MODE_TABS.register(Identifier.fromNamespaceAndPath(SLSTOOFMod.MOD_ID, "slstoof"), () ->
			// row "null" and column "-1" is what Fabric does with its builder
			CreativeModeTab.builder(null, -1).title(Component.translatable("itemGroup.soletssettheoreonfire"))
				.icon(() -> new ItemStack(Items.FLINT_AND_STEEL))
				.displayItems((displayParameters, output) -> {
					output.accept(SLSTOOFItems.IRON_TORCH.get());

					output.accept(SLSTOOFItems.IRON_LANTERN.get());
					output.accept(SLSTOOFItems.REDSTONE_LANTERN.get());

					output.accept(SLSTOOFItems.COPPER_CAMPFIRE.get());
					output.accept(SLSTOOFItems.IRON_CAMPFIRE.get());
					output.accept(SLSTOOFItems.REDSTONE_CAMPFIRE.get());
				}).build());
	}
}
