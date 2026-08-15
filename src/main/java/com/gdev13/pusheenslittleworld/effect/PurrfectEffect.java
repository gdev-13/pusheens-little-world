package com.gdev13.pusheenslittleworld.effect;

import com.gdev13.pusheenslittleworld.PusheensLittleWorld;
import com.gdev13.pusheenslittleworld.registry.ModParticles;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class PurrfectEffect extends MobEffect {

    public PurrfectEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xA9A9A9);

        this.addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                ResourceLocation.fromNamespaceAndPath(
                        PusheensLittleWorld.MODID,
                        "purrfect_speed"
                ),
                0.05,
                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
        );
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return duration % 5 == 0;
    }

    @Override
    public boolean applyEffectTick(
            ServerLevel level,
            LivingEntity entity,
            int amplifier
    ) {
        entity.heal(1.0F);

        double x = entity.getX() + (level.random.nextDouble() - 0.5D) * 1.2D;
        double y = entity.getY() + 0.3D + level.random.nextDouble() * 1.2D;
        double z = entity.getZ() + (level.random.nextDouble() - 0.5D) * 1.2D;

        level.sendParticles(
                ModParticles.PURRFECT_PAW.get(),
                x,
                y,
                z,
                1,
                0.0D,
                0.0D,
                0.0D,
                0.0D
        );

        return true;
    }
}