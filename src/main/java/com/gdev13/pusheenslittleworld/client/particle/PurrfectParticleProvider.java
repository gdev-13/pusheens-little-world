package com.gdev13.pusheenslittleworld.client.particle;

import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;

public class PurrfectParticleProvider implements ParticleEngine.SpriteParticleRegistration<SimpleParticleType> {

    @Override
    public ParticleProvider<SimpleParticleType> create(SpriteSet sprites) {
        return (type, level, x, y, z, xSpeed, ySpeed, zSpeed) ->
                new PurrfectParticle(
                        level,
                        x,
                        y,
                        z,
                        sprites
                );
    }
}