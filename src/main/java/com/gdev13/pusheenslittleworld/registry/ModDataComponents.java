package com.gdev13.pusheenslittleworld.registry;

import com.gdev13.pusheenslittleworld.PusheensLittleWorld;

import com.mojang.serialization.Codec;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModDataComponents {

    public static final DeferredRegister.DataComponents COMPONENTS =
            DeferredRegister.createDataComponents(
                    Registries.DATA_COMPONENT_TYPE,
                    PusheensLittleWorld.MODID
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> CHOCOLATE_SQUARES_REMAINING =
            COMPONENTS.registerComponentType(
                    "chocolate_squares_remaining",
                    builder -> builder
                            .persistent(Codec.INT)
                            .networkSynchronized(ByteBufCodecs.INT)
            );

    public static void register(IEventBus eventBus) {
        COMPONENTS.register(eventBus);
    }
}