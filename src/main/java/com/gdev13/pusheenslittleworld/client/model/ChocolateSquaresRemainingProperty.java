package com.gdev13.pusheenslittleworld.client.model;

import com.mojang.serialization.MapCodec;

import com.gdev13.pusheenslittleworld.registry.ModDataComponents;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public record ChocolateSquaresRemainingProperty() implements RangeSelectItemModelProperty {

    public static final MapCodec<ChocolateSquaresRemainingProperty> MAP_CODEC =
            MapCodec.unit(new ChocolateSquaresRemainingProperty());

    @Override
    public float get(
            ItemStack stack,
            @Nullable ClientLevel level,
            @Nullable LivingEntity entity,
            int seed
    ) {
        return stack.getOrDefault(
                ModDataComponents.CHOCOLATE_SQUARES_REMAINING,
                12
        );
    }

    @Override
    public MapCodec<ChocolateSquaresRemainingProperty> type() {
        return MAP_CODEC;
    }
}