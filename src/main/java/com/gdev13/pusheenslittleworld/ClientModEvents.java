package com.gdev13.pusheenslittleworld;

import com.gdev13.pusheenslittleworld.client.model.ChocolateSquaresRemainingProperty;
import com.gdev13.pusheenslittleworld.client.particle.PurrfectParticle;
import com.gdev13.pusheenslittleworld.registry.ModParticles;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.event.RegisterRangeSelectItemModelPropertyEvent;

@EventBusSubscriber(modid = PusheensLittleWorld.MODID)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(
                ModParticles.PURRFECT_PAW.get(),
                sprites -> (type, level, x, y, z, xSpeed, ySpeed, zSpeed) ->
                        new PurrfectParticle(
                                level,
                                x,
                                y,
                                z,
                                sprites
                        )
        );
    }
    
    @SubscribeEvent
    public static void registerRangeSelectItemModelProperties(
            RegisterRangeSelectItemModelPropertyEvent event
    ) {
        event.register(
                ResourceLocation.fromNamespaceAndPath(
                        PusheensLittleWorld.MODID,
                        "chocolate_squares_remaining"
                ),
                ChocolateSquaresRemainingProperty.MAP_CODEC
        );
    }
}