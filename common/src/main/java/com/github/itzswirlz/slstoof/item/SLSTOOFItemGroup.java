package com.github.itzswirlz.slstoof.item;

import com.github.itzswirlz.slstoof.SLSTOOFMod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SLSTOOFItemGroup {
    public static final RegistryKey<ItemGroup> SLSTOOF = registerKey("slstoof");

    // From the mappings
    private static RegistryKey<ItemGroup> registerKey(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(SLSTOOFMod.MOD_ID, id));
    }

    public static ItemGroup registerItemGroup() {
        return Registry.register(Registries.ITEM_GROUP, SLSTOOF,
                // row "null" and column "-1" is what Fabric does with its builder
                ItemGroup.create(null, -1).displayName(Text.literal("So Let's Set The Ore On Fire"))
                        .icon(() -> new ItemStack(Items.FLINT_AND_STEEL))
                        .entries((context, entries) -> {
                             entries.add(SLSTOOFItems.COPPER_TORCH);
                            entries.add(SLSTOOFItems.COPPER_LANTERN);
                            entries.add(SLSTOOFItems.COPPER_CAMPFIRE);

                             entries.add(SLSTOOFItems.IRON_TORCH);
                            entries.add(SLSTOOFItems.IRON_LANTERN);
                            entries.add(SLSTOOFItems.IRON_CAMPFIRE);

                            entries.add(SLSTOOFItems.REDSTONE_LANTERN);
                            entries.add(SLSTOOFItems.REDSTONE_CAMPFIRE);
                        }).build());
    }
}
