package com.gdev13.pusheenslittleworld.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

public class PurrfectParticle extends TextureSheetParticle {

    private final SpriteSet sprites;
    private final float baseSize;

    public PurrfectParticle(
            ClientLevel level,
            double x,
            double y,
            double z,
            SpriteSet sprites
    ) {
        super(level, x, y, z);

        this.sprites = sprites;

        this.lifetime = 30;

        this.baseSize = 0.08F + this.random.nextFloat() * 0.04F;

        this.quadSize = baseSize;

        this.yd = 0.015D;
        
        setSpriteFromAge(sprites);
    }

    @Override
    public void tick() {
        super.tick();

        float progress = (float) this.age / this.lifetime;

        float pulse = (float) Math.sin(progress * Math.PI);

        this.quadSize = baseSize + pulse * baseSize;

        setSpriteFromAge(sprites);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}