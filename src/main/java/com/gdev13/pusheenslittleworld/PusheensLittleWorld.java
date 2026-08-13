package com.gdev13.pusheenslittleworld;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(PusheensLittleWorld.MODID)
public class PusheensLittleWorld {

    public static final String MODID = "pusheenslittleworld";

    public static final Logger LOGGER = LogUtils.getLogger();

    public PusheensLittleWorld(IEventBus modEventBus) {
        LOGGER.info("Pusheen's Little World carregado!");
    }
}