package com.gdev13.pusheenslittleworld.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;

public class PurrfectParticle extends TextureSheetParticle {

    private final SpriteSet sprites;

    public PurrfectParticle(
            ClientLevel level,
            double x,
            double y,
            double z,
            SpriteSet sprites
    ) {
        super(level, x, y, z);
        this.sprites = sprites;
        setSpriteFromAge(sprites);

        this.lifetime = 20;
        this.quadSize = 0.2F;
    }

    @Override
    public void tick() {
        super.tick();

        float progress = (float) this.age / this.lifetime;

        this.quadSize = 0.2F + progress * 0.1F;

        setSpriteFromAge(sprites);
    }
    
    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}