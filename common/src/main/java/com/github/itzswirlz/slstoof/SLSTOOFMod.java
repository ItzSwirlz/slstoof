package com.github.itzswirlz.slstoof;

import com.github.itzswirlz.slstoof.block.SLSTOOFBlocks;
import com.github.itzswirlz.slstoof.item.SLSTOOFItemGroup;
import com.github.itzswirlz.slstoof.item.SLSTOOFItems;
import com.github.itzswirlz.slstoof.particle.SLSTOOFParticles;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import net.minecraft.block.Block;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.RegistryKeys;

public final class SLSTOOFMod {
	public static final String MOD_ID = "soletssettheoreonfire";

	public static final Supplier<RegistrarManager> MANAGER = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));
	public static final Registrar<Block> BLOCKS = MANAGER.get().get(RegistryKeys.BLOCK);
	public static final Registrar<Item> ITEMS = MANAGER.get().get(RegistryKeys.ITEM);
	public static final Registrar<ItemGroup> ITEM_GROUPS = MANAGER.get().get(RegistryKeys.ITEM_GROUP);
	public static final Registrar<ParticleType<?>> PARTICLES = MANAGER.get().get(RegistryKeys.PARTICLE_TYPE);

	public static void init() {
		// GO GO GO
		SLSTOOFParticles.registerFireParticles();  // Must be done first because items/blocks rely on this
		SLSTOOFBlocks.registerBlocks();
		SLSTOOFItems.registerItems();
		SLSTOOFItemGroup.registerItemGroup();
	}

	public static void initClient() {
		// Each platform handles adding blocks that have a BlockEntityType differently, so specifically for the campfires, check the individual handling.
		// Also: Until Architectury's ParticleProviderRegistry is working, particle providers are provided per client

		// Now that we are registered we can set our particles
		SLSTOOFBlocks.COPPER_TORCH.get().replacementParticle = SLSTOOFParticles.COPPER_FIRE_FLAME.get();
		SLSTOOFBlocks.COPPER_WALL_TORCH.get().replacementParticle = SLSTOOFParticles.COPPER_FIRE_FLAME.get();

		SLSTOOFBlocks.IRON_TORCH.get().replacementParticle = SLSTOOFParticles.IRON_FIRE_FLAME.get();
		SLSTOOFBlocks.IRON_WALL_TORCH.get().replacementParticle = SLSTOOFParticles.IRON_FIRE_FLAME.get();

		RenderTypeRegistry.register(BlockRenderLayer.CUTOUT, SLSTOOFBlocks.COPPER_FIRE.get(), SLSTOOFBlocks.IRON_FIRE.get(), SLSTOOFBlocks.REDSTONE_FIRE.get(), SLSTOOFBlocks.COPPER_CAMPFIRE.get(), SLSTOOFBlocks.IRON_CAMPFIRE.get(), SLSTOOFBlocks.REDSTONE_CAMPFIRE.get());
	}
}
