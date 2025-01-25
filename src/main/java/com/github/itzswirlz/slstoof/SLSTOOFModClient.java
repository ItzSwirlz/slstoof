package com.github.itzswirlz.slstoof;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.render.RenderLayer;

public class SLSTOOFModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(SLSTOOFParticles.COPPER_FIRE_FLAME, FlameParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(SLSTOOFParticles.IRON_FIRE_FLAME, FlameParticle.Factory::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), new Block[] {
                SLSTOOFBlocks.COPPER_CAMPFIRE,
                SLSTOOFBlocks.COPPER_FIRE,
                SLSTOOFBlocks.COPPER_LANTERN,
                SLSTOOFBlocks.COPPER_TORCH,
                SLSTOOFBlocks.COPPER_WALL_TORCH,

                SLSTOOFBlocks.IRON_CAMPFIRE,
                SLSTOOFBlocks.IRON_FIRE,
                SLSTOOFBlocks.IRON_LANTERN,
                SLSTOOFBlocks.IRON_TORCH,
                SLSTOOFBlocks.IRON_WALL_TORCH,

                SLSTOOFBlocks.REDSTONE_FIRE,
                SLSTOOFBlocks.REDSTONE_LANTERN,
                SLSTOOFBlocks.REDSTONE_CAMPFIRE
        });
    }

}
