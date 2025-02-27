package com.github.itzswirlz.slstoof.block;

import java.util.function.ToIntFunction;

import com.github.itzswirlz.slstoof.SLSTOOFMod;
import com.google.common.base.Supplier;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.MapColor;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class SLSTOOFBlocks {
	public static final RegistryKey<Block> COPPER_FIRE_KEY = registerKey("copper_fire");
	public static final RegistryKey<Block> COPPER_TORCH_KEY = registerKey("copper_torch");
	public static final RegistryKey<Block> COPPER_WALL_TORCH_KEY = registerKey("copper_wall_torch");
	public static final RegistryKey<Block> COPPER_LANTERN_KEY = registerKey("copper_lantern");
	public static final RegistryKey<Block> COPPER_CAMPFIRE_KEY = registerKey("copper_campfire");

	public static final RegistryKey<Block> IRON_FIRE_KEY = registerKey("iron_fire");
	public static final RegistryKey<Block> IRON_TORCH_KEY = registerKey("iron_torch");
	public static final RegistryKey<Block> IRON_WALL_TORCH_KEY = registerKey("iron_wall_torch");
	public static final RegistryKey<Block> IRON_LANTERN_KEY = registerKey("iron_lantern");
	public static final RegistryKey<Block> IRON_CAMPFIRE_KEY = registerKey("iron_campfire");

	public static final RegistryKey<Block> REDSTONE_FIRE_KEY = registerKey("redstone_fire");
	public static final RegistryKey<Block> REDSTONE_LANTERN_KEY = registerKey("redstone_lantern");
	public static final RegistryKey<Block> REDSTONE_CAMPFIRE_KEY = registerKey("redstone_campfire");

	
	public static RegistrySupplier<CopperFireBlock> COPPER_FIRE;
	public static RegistrySupplier<IronFireBlock> IRON_FIRE;
	public static RegistrySupplier<RedstoneFireBlock> REDSTONE_FIRE;

	public static RegistrySupplier<SLSTOOFTorchBlock> COPPER_TORCH;
	public static RegistrySupplier<SLSTOOFWallTorchBlock> COPPER_WALL_TORCH;
	public static RegistrySupplier<SLSTOOFTorchBlock> IRON_TORCH;
	public static RegistrySupplier<SLSTOOFWallTorchBlock> IRON_WALL_TORCH;

	public static RegistrySupplier<CampfireBlock> COPPER_CAMPFIRE;
	public static RegistrySupplier<CampfireBlock> IRON_CAMPFIRE;
	public static RegistrySupplier<RedstoneCampfireBlock> REDSTONE_CAMPFIRE;

	public static RegistrySupplier<LanternBlock> COPPER_LANTERN;
	public static RegistrySupplier<LanternBlock> IRON_LANTERN;
	public static RegistrySupplier<RedstoneLanternBlock> REDSTONE_LANTERN;

	/*
	 * Redstone TODOs:
	 * - Lantern: Act like torches do (Turn off if next to a redstone source block)
	 * - Campfires: Emit signals depending on what is being cooked. Possibly a game
	 * rule?
	 */

	public static void registerBlocks() {
		registerCampfireBlocks();
		registerFireBlocks();
		registerLanternBlocks();
		registerTorchBlocks();
	}

	private static void registerCampfireBlocks() {
		COPPER_CAMPFIRE = registerBlock("copper_campfire", () -> new CampfireBlock(
			false,
			1,
			Settings.copy(Blocks.SOUL_CAMPFIRE).registryKey(COPPER_CAMPFIRE_KEY)));

		IRON_CAMPFIRE = registerBlock("iron_campfire", () -> new CampfireBlock(
			false,
			1,
			Settings.copy(Blocks.SOUL_CAMPFIRE).registryKey(IRON_CAMPFIRE_KEY)));

		REDSTONE_CAMPFIRE = registerBlock("redstone_campfire", () -> new RedstoneCampfireBlock(
			false,
			1,
			Settings.copy(Blocks.SOUL_CAMPFIRE)
				.luminance(createLightLevelFromLitBlockState(7))
				.registryKey(REDSTONE_CAMPFIRE_KEY)));
	}

	private static void registerFireBlocks() {
		COPPER_FIRE = registerBlock("copper_fire", () ->
			new CopperFireBlock(
				Settings.copy(Blocks.FIRE)
					.mapColor(MapColor.TEAL)
					.luminance(state -> 10).registryKey(COPPER_FIRE_KEY)));

		IRON_FIRE = registerBlock("iron_fire", () -> new IronFireBlock(
			Settings.copy(Blocks.FIRE)
				.mapColor(MapColor.GOLD)
				.luminance(state -> 10)
				.registryKey(IRON_FIRE_KEY)));

		REDSTONE_FIRE = registerBlock("redstone_fire", () -> new RedstoneFireBlock(
			Settings.copy(Blocks.FIRE)
				.mapColor(MapColor.RED)
				.luminance(state -> 7)
				.registryKey(REDSTONE_FIRE_KEY)));
	}

	private static void registerLanternBlocks() {
		COPPER_LANTERN = registerBlock("copper_lantern", () -> new LanternBlock(
			Settings.copy(Blocks.SOUL_LANTERN).registryKey(COPPER_LANTERN_KEY)));

		IRON_LANTERN = registerBlock("iron_lantern", () -> new LanternBlock(
			Settings.copy(Blocks.SOUL_LANTERN).registryKey(IRON_LANTERN_KEY)));

		REDSTONE_LANTERN = registerBlock("redstone_lantern", () -> new RedstoneLanternBlock(
			Settings.copy(Blocks.SOUL_LANTERN).luminance(state ->
				7
			).registryKey(REDSTONE_LANTERN_KEY)));
	}

	private static void registerTorchBlocks() {
		// Particles are configured during client initialization
		COPPER_TORCH = registerBlock("copper_torch", () -> new SLSTOOFTorchBlock(
			Settings.copy(Blocks.SOUL_TORCH).registryKey(COPPER_TORCH_KEY)
		));
		COPPER_WALL_TORCH = registerBlock("copper_wall_torch", () ->
			new SLSTOOFWallTorchBlock(
				Settings.copy(Blocks.SOUL_WALL_TORCH).registryKey(COPPER_WALL_TORCH_KEY)));

		IRON_TORCH = registerBlock("iron_torch", () -> new SLSTOOFTorchBlock(
			Settings.copy(Blocks.SOUL_TORCH).registryKey(IRON_TORCH_KEY)));
		IRON_WALL_TORCH = registerBlock("iron_wall_torch", () -> new SLSTOOFWallTorchBlock(
			Settings.copy(Blocks.SOUL_WALL_TORCH).registryKey(IRON_WALL_TORCH_KEY)));
	}

	private static <B extends Block> RegistrySupplier<B> registerBlock(String id, Supplier<B> supplier) {
		return SLSTOOFMod.BLOCKS.register(Identifier.of(SLSTOOFMod.MOD_ID, id), supplier);
	}

	private static RegistryKey<Block> registerKey(String id) {
		return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, id));
	}

	private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
		return (state) ->
			(Boolean) state.get(Properties.LIT) ? litLevel : 0;
	}
}
