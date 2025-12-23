package com.github.itzswirlz.slstoof.item;

import com.github.itzswirlz.slstoof.SLSTOOFMod;
import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.google.common.base.Supplier;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;

public class SLSTOOFItems {
	public static final ResourceKey<Item> COPPER_CAMPFIRE_KEY = registerKey("copper_campfire");
	public static final ResourceKey<Item> COPPER_LANTERN_KEY = registerKey("copper_lantern");
	public static final ResourceKey<Item> COPPER_TORCH_KEY = registerKey("copper_torch");

	public static final ResourceKey<Item> IRON_CAMPFIRE_KEY = registerKey("iron_campfire");
	public static final ResourceKey<Item> IRON_LANTERN_KEY = registerKey("iron_lantern");
	public static final ResourceKey<Item> IRON_TORCH_KEY = registerKey("iron_torch");

	public static final ResourceKey<Item> REDSTONE_CAMPFIRE_KEY = registerKey("redstone_campfire");
	public static final ResourceKey<Item> REDSTONE_LANTERN_KEY = registerKey("redstone_lantern");


	public static RegistrySupplier<StandingAndWallBlockItem> COPPER_TORCH;
	public static RegistrySupplier<StandingAndWallBlockItem> IRON_TORCH;

	public static RegistrySupplier<BlockItem> COPPER_CAMPFIRE;
	public static RegistrySupplier<BlockItem> IRON_CAMPFIRE;
	public static RegistrySupplier<BlockItem> REDSTONE_CAMPFIRE;

	public static RegistrySupplier<BlockItem> COPPER_LANTERN;
	public static RegistrySupplier<BlockItem> IRON_LANTERN;
	public static RegistrySupplier<BlockItem> REDSTONE_LANTERN;


	public static void registerItems() {
		registerCampfireItems();
		registerLanternItems();
		registerTorchItems();
	}

	private static void registerCampfireItems() {
		COPPER_CAMPFIRE = registerItem("copper_campfire", () -> new BlockItem(SLSTOOFBlocks.COPPER_CAMPFIRE.get(),
			new Item.Properties().setId(COPPER_CAMPFIRE_KEY)));

		IRON_CAMPFIRE = registerItem("iron_campfire", () -> new BlockItem(SLSTOOFBlocks.IRON_CAMPFIRE.get(),
			new Item.Properties().setId(IRON_CAMPFIRE_KEY)));

		REDSTONE_CAMPFIRE = registerItem("redstone_campfire", () -> new BlockItem(SLSTOOFBlocks.REDSTONE_CAMPFIRE.get(),
			new Item.Properties().setId(REDSTONE_CAMPFIRE_KEY)));
	}

	private static void registerLanternItems() {
		COPPER_LANTERN = registerItem("copper_lantern", () -> new BlockItem(SLSTOOFBlocks.COPPER_LANTERN.get(),
			new Item.Properties().setId(COPPER_LANTERN_KEY)));

		IRON_LANTERN = registerItem("iron_lantern", () -> new BlockItem(SLSTOOFBlocks.IRON_LANTERN.get(),
			new Item.Properties().setId(IRON_LANTERN_KEY)));

		REDSTONE_LANTERN = registerItem("redstone_lantern", () -> new BlockItem(SLSTOOFBlocks.REDSTONE_LANTERN.get(),
			new Item.Properties().setId(REDSTONE_LANTERN_KEY)));
	}

	private static void registerTorchItems() {
		COPPER_TORCH = registerItem("copper_torch", () -> new
			StandingAndWallBlockItem(
			SLSTOOFBlocks.COPPER_TORCH.get(), SLSTOOFBlocks.COPPER_WALL_TORCH.get(),
			Direction.DOWN,
			new Item.Properties().setId(COPPER_TORCH_KEY)));

		IRON_TORCH = registerItem("iron_torch", () -> new StandingAndWallBlockItem(SLSTOOFBlocks.IRON_TORCH.get(), SLSTOOFBlocks.IRON_WALL_TORCH.get(), Direction.DOWN,
			new Item.Properties().setId(IRON_TORCH_KEY)));
	}

	private static <I extends Item> RegistrySupplier<I> registerItem(String id, Supplier<I> supplier) {
		return SLSTOOFMod.ITEMS.register(Identifier.fromNamespaceAndPath(SLSTOOFMod.MOD_ID, id), supplier);
	}

	private static ResourceKey<Item> registerKey(String id) {
		return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(SLSTOOFMod.MOD_ID, id));
	}
}
