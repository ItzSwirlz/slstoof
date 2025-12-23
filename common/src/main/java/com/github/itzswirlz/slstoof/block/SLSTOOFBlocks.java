package com.github.itzswirlz.slstoof.block;

import java.util.function.ToIntFunction;

import com.github.itzswirlz.slstoof.SLSTOOFMod;
import com.google.common.base.Supplier;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;

public class SLSTOOFBlocks {
	public static final ResourceKey<Block> COPPER_FIRE_KEY = registerKey("copper_fire");
	public static final ResourceKey<Block> COPPER_CAMPFIRE_KEY = registerKey("copper_campfire");

	public static final ResourceKey<Block> IRON_FIRE_KEY = registerKey("iron_fire");
	public static final ResourceKey<Block> IRON_TORCH_KEY = registerKey("iron_torch");
	public static final ResourceKey<Block> IRON_WALL_TORCH_KEY = registerKey("iron_wall_torch");
	public static final ResourceKey<Block> IRON_LANTERN_KEY = registerKey("iron_lantern");
	public static final ResourceKey<Block> IRON_CAMPFIRE_KEY = registerKey("iron_campfire");

	public static final ResourceKey<Block> REDSTONE_FIRE_KEY = registerKey("redstone_fire");
	public static final ResourceKey<Block> REDSTONE_LANTERN_KEY = registerKey("redstone_lantern");
	public static final ResourceKey<Block> REDSTONE_CAMPFIRE_KEY = registerKey("redstone_campfire");


	public static RegistrySupplier<CopperFireBlock> COPPER_FIRE;
	public static RegistrySupplier<IronFireBlock> IRON_FIRE;
	public static RegistrySupplier<RedstoneFireBlock> REDSTONE_FIRE;

	public static RegistrySupplier<SLSTOOFTorchBlock> IRON_TORCH;
	public static RegistrySupplier<SLSTOOFWallTorchBlock> IRON_WALL_TORCH;

	public static RegistrySupplier<CampfireBlock> COPPER_CAMPFIRE;
	public static RegistrySupplier<CampfireBlock> IRON_CAMPFIRE;
	public static RegistrySupplier<RedstoneCampfireBlock> REDSTONE_CAMPFIRE;

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
			BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_CAMPFIRE).setId(COPPER_CAMPFIRE_KEY)));

		IRON_CAMPFIRE = registerBlock("iron_campfire", () -> new CampfireBlock(
			false,
			1,
			BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_CAMPFIRE).setId(IRON_CAMPFIRE_KEY)));

		REDSTONE_CAMPFIRE = registerBlock("redstone_campfire", () -> new RedstoneCampfireBlock(
			false,
			1,
			BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_CAMPFIRE)
				.lightLevel(createLightLevelFromLitBlockState(7))
				.setId(REDSTONE_CAMPFIRE_KEY)));
	}

	private static void registerFireBlocks() {
		COPPER_FIRE = registerBlock("copper_fire", () ->
			new CopperFireBlock(
				BlockBehaviour.Properties.ofFullCopy(Blocks.FIRE)
					.mapColor(MapColor.COLOR_LIGHT_BLUE)
					.lightLevel(state -> 10).setId(COPPER_FIRE_KEY)));

		IRON_FIRE = registerBlock("iron_fire", () -> new IronFireBlock(
			BlockBehaviour.Properties.ofFullCopy(Blocks.FIRE)
				.mapColor(MapColor.GOLD)
				.lightLevel(state -> 10)
				.setId(IRON_FIRE_KEY)));

		REDSTONE_FIRE = registerBlock("redstone_fire", () -> new RedstoneFireBlock(
			BlockBehaviour.Properties.ofFullCopy(Blocks.FIRE)
				.mapColor(MapColor.COLOR_RED)
				.lightLevel(state -> 7)
				.setId(REDSTONE_FIRE_KEY)));
	}

	private static void registerLanternBlocks() {
		IRON_LANTERN = registerBlock("iron_lantern", () -> new LanternBlock(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_LANTERN).setId(IRON_LANTERN_KEY)));

		REDSTONE_LANTERN = registerBlock("redstone_lantern", () -> new RedstoneLanternBlock(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_LANTERN).lightLevel(state ->
				7
			).setId(REDSTONE_LANTERN_KEY)));
	}

	private static void registerTorchBlocks() {
		// Particles are configured during client initialization
		IRON_TORCH = registerBlock("iron_torch", () -> new SLSTOOFTorchBlock(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_TORCH).setId(IRON_TORCH_KEY)));
		IRON_WALL_TORCH = registerBlock("iron_wall_torch", () -> new SLSTOOFWallTorchBlock(
			BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_WALL_TORCH).setId(IRON_WALL_TORCH_KEY)));
	}

	private static <B extends Block> RegistrySupplier<B> registerBlock(String id, Supplier<B> supplier) {
		return SLSTOOFMod.BLOCKS.register(Identifier.fromNamespaceAndPath(SLSTOOFMod.MOD_ID, id), supplier);
	}

	private static ResourceKey<Block> registerKey(String id) {
		return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(SLSTOOFMod.MOD_ID, id));
	}

	private static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
		return (state) ->
			(Boolean) state.getValue(BlockStateProperties.LIT) ? litLevel : 0;
	}
}
