package com.github.itzswirlz.slstoof;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SLSTOOFItemGroup {
    public static final ItemGroup slstoof_ITEM_GROUP = FabricItemGroup.builder()
            .displayName(Text.literal("So Let's Set The Ore On Fire"))
            .icon(() -> new ItemStack(Items.FLINT_AND_STEEL))
            .entries((context, entries) -> {
                entries.add(SLSTOOFItems.COPPER_TORCH);
                entries.add(SLSTOOFBlocks.COPPER_LANTERN);
                entries.add(SLSTOOFItems.COPPER_CAMPFIRE);

                entries.add(SLSTOOFItems.IRON_TORCH);
                entries.add(SLSTOOFItems.IRON_LANTERN);
                entries.add(SLSTOOFItems.IRON_CAMPFIRE);

                entries.add(SLSTOOFItems.REDSTONE_LANTERN);
                entries.add(SLSTOOFItems.REDSTONE_CAMPFIRE);
            }).build();

    public static void registerslstoofItemGroup() {
        Registry.register(Registries.ITEM_GROUP, Identifier.of(SLSTOOFMod.MOD_ID, "soletssettheoreonfire"),
                slstoof_ITEM_GROUP);
    }
}
