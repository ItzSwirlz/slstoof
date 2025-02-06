package com.github.itzswirlz.slstoof;

import com.github.itzswirlz.slstoof.block.CopperFireBlock;
import com.github.itzswirlz.slstoof.block.IronFireBlock;
import com.github.itzswirlz.slstoof.block.RedstoneCampfireBlock;
import com.github.itzswirlz.slstoof.block.RedstoneFireBlock;
import com.github.itzswirlz.slstoof.block.RedstoneLanternBlock;

import net.minecraft.block.AbstractBlock.Settings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class SLSTOOFBlocks {
    // TODO: is there a clean alternative, like a facotry or something?
    public static final RegistryKey<Block> COPPER_FIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "copper_fire"));
    public static final RegistryKey<Block> COPPER_TORCH_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "copper_torch"));
    public static final RegistryKey<Block> COPPER_WALL_TORCH_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "copper_wall_torch"));
    public static final RegistryKey<Block> COPPER_LANTERN_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "copper_lantern"));
    public static final RegistryKey<Block> COPPER_CAMPFIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "copper_campfire"));

    public static final RegistryKey<Block> IRON_FIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "iron_fire"));
    public static final RegistryKey<Block> IRON_TORCH_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "iron_torch"));
    public static final RegistryKey<Block> IRON_WALL_TORCH_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "iron_wall_torch"));
    public static final RegistryKey<Block> IRON_LANTERN_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "iron_lantern"));
    public static final RegistryKey<Block> IRON_CAMPFIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "iron_campfire"));

    public static final RegistryKey<Block> REDSTONE_FIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "redstone_fire"));
    public static final RegistryKey<Block> REDSTONE_LANTERN_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "redstone_lantern"));
    public static final RegistryKey<Block> REDSTONE_CAMPFIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK,
            Identifier.of(SLSTOOFMod.MOD_ID, "redstone_campfire"));

    /*
     * General TODOs:
     * - Fix loot tables (torches/wall torches but also double check lanterns and
     * campfires)
     */

    public static final CopperFireBlock COPPER_FIRE = new CopperFireBlock(Settings.copy(Blocks.FIRE)
            .mapColor(MapColor.TEAL).luminance((state) -> {
                return 10;
            }).registryKey(COPPER_FIRE_KEY));
    public static final TorchBlock COPPER_TORCH = new TorchBlock(SLSTOOFParticles.COPPER_FIRE_FLAME,
            Settings.copy(Blocks.SOUL_TORCH).registryKey(COPPER_TORCH_KEY));
    public static final TorchBlock COPPER_WALL_TORCH = new WallTorchBlock(SLSTOOFParticles.COPPER_FIRE_FLAME,
            Settings.copy(Blocks.SOUL_WALL_TORCH).registryKey(COPPER_WALL_TORCH_KEY));
    public static final LanternBlock COPPER_LANTERN = new LanternBlock(
            Settings.copy(Blocks.SOUL_LANTERN).registryKey(COPPER_LANTERN_KEY));
    public static final CampfireBlock COPPER_CAMPFIRE = new CampfireBlock(false, 1,
            Settings.copy(Blocks.SOUL_CAMPFIRE).registryKey(COPPER_CAMPFIRE_KEY));

    public static final IronFireBlock IRON_FIRE = new IronFireBlock(Settings.copy(Blocks.FIRE).mapColor(MapColor.GOLD)
            .luminance((state) -> {
                return 10;
            }).registryKey(IRON_FIRE_KEY));
    public static final TorchBlock IRON_TORCH = new TorchBlock(SLSTOOFParticles.IRON_FIRE_FLAME,
            Settings.copy(Blocks.SOUL_TORCH).registryKey(IRON_TORCH_KEY));
    public static final TorchBlock IRON_WALL_TORCH = new WallTorchBlock(SLSTOOFParticles.IRON_FIRE_FLAME,
            Settings.copy(Blocks.SOUL_WALL_TORCH).registryKey(IRON_WALL_TORCH_KEY));
    public static final LanternBlock IRON_LANTERN = new LanternBlock(
            Settings.copy(Blocks.SOUL_LANTERN).registryKey(IRON_LANTERN_KEY));
    public static final CampfireBlock IRON_CAMPFIRE = new CampfireBlock(false, 1,
            Settings.copy(Blocks.SOUL_CAMPFIRE).registryKey(IRON_CAMPFIRE_KEY));

    /*
     * Redstone TODOs:
     * - Lantern: Act like torches do (Turn off if next to a redstone source block)
     * - Campfires: Emit signals depending on what is being cooked. Possibly a game
     * rule?
     */

    // Only notable redstone fire difference is that just like torches, the light
    // level is 7
    public static final RedstoneFireBlock REDSTONE_FIRE = new RedstoneFireBlock(Settings.copy(Blocks.FIRE)
            .mapColor(MapColor.RED).luminance((state) -> {
                return 7;
            }).registryKey(REDSTONE_FIRE_KEY));
    public static final LanternBlock REDSTONE_LANTERN = new RedstoneLanternBlock(
            Settings.copy(Blocks.SOUL_LANTERN).luminance((state) -> {
                return 7;
            }).registryKey(REDSTONE_LANTERN_KEY));
    public static final CampfireBlock REDSTONE_CAMPFIRE = new RedstoneCampfireBlock(false, 1,
            Settings.copy(Blocks.SOUL_CAMPFIRE).luminance(Blocks.createLightLevelFromLitBlockState(7))
                    .registryKey(REDSTONE_CAMPFIRE_KEY));

    /* Registration functions */
    public static void registerCopperFireBlocks() {
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_fire"), COPPER_FIRE);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_torch"), COPPER_TORCH);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_wall_torch"), COPPER_WALL_TORCH);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_lantern"), COPPER_LANTERN);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_campfire"), COPPER_CAMPFIRE);
    }

    public static void registerIronFireBlocks() {
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_campfire"), IRON_CAMPFIRE);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_fire"), IRON_FIRE);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_torch"), IRON_TORCH);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_wall_torch"), IRON_WALL_TORCH);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_lantern"), IRON_LANTERN);
    }

    public static void registerRedstoneFireBlocks() {
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "redstone_fire"), REDSTONE_FIRE);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "redstone_lantern"), REDSTONE_LANTERN);
        Registry.register(Registries.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "redstone_campfire"), REDSTONE_CAMPFIRE);
    }

    // Without this, traits like the smoke particles and being able to cook won't
    // work for our new campfires.
    public static void updateCampfireBlockEntityType() {
        Block[] blocks = new Block[] { COPPER_CAMPFIRE, IRON_CAMPFIRE, REDSTONE_CAMPFIRE };
        for (Block block : blocks) {
            BlockEntityType.CAMPFIRE.addSupportedBlock(block);
        }
    }
}
