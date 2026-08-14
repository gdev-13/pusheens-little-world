package com.gdev13.pusheenslittleworld.registry;

import com.gdev13.pusheenslittleworld.PusheensLittleWorld;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModParticles {

    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(Registries.PARTICLE_TYPE, PusheensLittleWorld.MODID);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PURRFECT_PAW =
            PARTICLES.register(
                    "purrfect_paw",
                    () -> new SimpleParticleType(false)
            );

    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}