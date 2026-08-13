package com.gdev13.pusheenslittleworld;

import org.slf4j.Logger;

import com.gdev13.pusheenslittleworld.registry.ModCreativeTabs;
import com.gdev13.pusheenslittleworld.registry.ModItems;
import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(PusheensLittleWorld.MODID)
public class PusheensLittleWorld {

    public static final String MODID = "pusheenslittleworld";

    public static final Logger LOGGER = LogUtils.getLogger();

    public PusheensLittleWorld(IEventBus modEventBus, ModContainer modContainer) {
        ModItems.register(modEventBus);
        ModCreativeTabs.register(modEventBus);

        LOGGER.info("Pusheen's Little World carregado!");
    }
}