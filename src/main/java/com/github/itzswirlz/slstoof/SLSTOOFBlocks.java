package com.github.itzswirlz.slstoof;

import com.github.itzswirlz.slstoof.block.CopperFireBlock;
import com.github.itzswirlz.slstoof.block.IronFireBlock;
import com.github.itzswirlz.slstoof.block.RedstoneLanternBlock;
import com.github.itzswirlz.slstoof.block.RedstoneFireBlock;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CampfireBlock;
import net.minecraft.block.LanternBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class SLSTOOFBlocks {
    // TODO: is there a clean alternative, like a facotry or something?
    public static final RegistryKey<Block> COPPER_FIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_fire"));
    public static final RegistryKey<Block> COPPER_TORCH_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_torch"));
    public static final RegistryKey<Block> COPPER_WALL_TORCH_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_wall_torch"));
    public static final RegistryKey<Block> COPPER_LANTERN_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_lantern"));
    public static final RegistryKey<Block> COPPER_CAMPFIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "copper_campfire"));

    public static final RegistryKey<Block> IRON_FIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_fire"));
    public static final RegistryKey<Block> IRON_TORCH_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_torch"));
    public static final RegistryKey<Block> IRON_WALL_TORCH_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_wall_torch"));
    public static final RegistryKey<Block> IRON_LANTERN_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_lantern"));
    public static final RegistryKey<Block> IRON_CAMPFIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "iron_campfire"));

    public static final RegistryKey<Block> REDSTONE_FIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "redstone_fire"));
    public static final RegistryKey<Block> REDSTONE_LANTERN_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "redstone_lantern"));
    public static final RegistryKey<Block> REDSTONE_CAMPFIRE_KEY = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SLSTOOFMod.MOD_ID, "redstone_campfire"));

    // TODO: Copy settings from other blocks using Block.Settings.copy
    /*
     *  -----------
     *  COPPER FIRE
     *  -----------
     */
    public static final CopperFireBlock COPPER_FIRE = new CopperFireBlock(Block.Settings.create().mapColor(MapColor.TEAL).replaceable().noCollision().breakInstantly().luminance((state) -> {
        return 10;
    }).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY).registryKey(COPPER_FIRE_KEY));

    public static final TorchBlock COPPER_TORCH = new TorchBlock(SLSTOOFParticles.COPPER_FIRE_FLAME, Block.Settings.create().noCollision().breakInstantly().luminance((state) -> {
        return 10;
     }).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY).registryKey(COPPER_TORCH_KEY));
     // TODO: item drop
    public static final TorchBlock COPPER_WALL_TORCH = new WallTorchBlock(SLSTOOFParticles.COPPER_FIRE_FLAME, Block.Settings.create().noCollision().breakInstantly().luminance((state) -> {
        return 10;
     }).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY).registryKey(COPPER_WALL_TORCH_KEY));

     public static final LanternBlock COPPER_LANTERN = new LanternBlock(Block.Settings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
        return 10;
     }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).registryKey(COPPER_LANTERN_KEY));
     public static final CampfireBlock COPPER_CAMPFIRE = new CampfireBlock(false, 1, Block.Settings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).luminance(Blocks.createLightLevelFromLitBlockState(10)).nonOpaque().burnable().registryKey(COPPER_CAMPFIRE_KEY));
     /*
      *  ---------------
      *  END COPPER FIRE
      *  ---------------
      */
      
    /*
     * ----------------
     * IRON FIRE
     * ----------------
     */
    public static final IronFireBlock IRON_FIRE = new IronFireBlock(Block.Settings.create().mapColor(MapColor.GOLD).replaceable().noCollision().breakInstantly().luminance((state) -> {
        return 10;
    }).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY).registryKey(IRON_FIRE_KEY));

    public static final TorchBlock IRON_TORCH = new TorchBlock(SLSTOOFParticles.IRON_FIRE_FLAME, Block.Settings.create().noCollision().breakInstantly().luminance((state) -> {
        return 10;
     }).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY).registryKey(IRON_TORCH_KEY));
     // TODO: item drop
    public static final TorchBlock IRON_WALL_TORCH = new WallTorchBlock(SLSTOOFParticles.IRON_FIRE_FLAME, Block.Settings.create().noCollision().breakInstantly().luminance((state) -> {
        return 10;
     }).sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY).registryKey(IRON_WALL_TORCH_KEY));
    public static final LanternBlock IRON_LANTERN = new LanternBlock(Block.Settings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
        return 10;
    }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).registryKey(IRON_LANTERN_KEY));
    public static final CampfireBlock IRON_CAMPFIRE = new CampfireBlock(false, 1, Block.Settings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).luminance(Blocks.createLightLevelFromLitBlockState(10)).nonOpaque().burnable().registryKey(IRON_CAMPFIRE_KEY));


    /*
     * ------------
     * END IRON FIRE
     * -----------
     */

    /*
     * -----------------
     * REDSTONE FIRE
     * -----------------
     */
    // TODO: map color
    // TODO: emit redstone signals for Campfire depending on what is being cooked? Possibly a gamerule?
    public static final RedstoneFireBlock REDSTONE_FIRE = new RedstoneFireBlock(Block.Settings.create().mapColor(MapColor.RED).replaceable().noCollision().breakInstantly().luminance((state) -> {
        return 7;
    }).sounds(BlockSoundGroup.WOOL).pistonBehavior(PistonBehavior.DESTROY).registryKey(REDSTONE_FIRE_KEY));
    public static final LanternBlock REDSTONE_LANTERN = new RedstoneLanternBlock(Block.Settings.create().mapColor(MapColor.IRON_GRAY).solid().requiresTool().strength(3.5F).sounds(BlockSoundGroup.LANTERN).luminance((state) -> {
        return 7;
    }).nonOpaque().pistonBehavior(PistonBehavior.DESTROY).registryKey(REDSTONE_LANTERN_KEY));
    public static final CampfireBlock REDSTONE_CAMPFIRE = new CampfireBlock(false, 1, Block.Settings.create().mapColor(MapColor.SPRUCE_BROWN).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup.WOOD).luminance(Blocks.createLightLevelFromLitBlockState(10)).nonOpaque().burnable().registryKey(REDSTONE_CAMPFIRE_KEY));
    /*
     * -----------------
     * END REDSTONE FIRE
     * -----------------
     */

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

    // Without this, traits like the smoke particles and being able to cook won't work for our new campfires.
    public static void updateCampfireBlockEntityType() {
        Block[] blocks = new Block[]{COPPER_CAMPFIRE, IRON_CAMPFIRE, REDSTONE_CAMPFIRE};
        for(Block block : blocks) {
            BlockEntityType.CAMPFIRE.addSupportedBlock(block);
        }
    }
}
