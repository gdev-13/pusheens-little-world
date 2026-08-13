package com.gdev13.pusheenslittleworld.registry;

import com.gdev13.pusheenslittleworld.PusheensLittleWorld;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
    		DeferredRegister.createItems(PusheensLittleWorld.MODID);

    public static final DeferredItem<Item> PUSHEEN_PLUSH =
    		ITEMS.registerSimpleItem("pusheen_plush");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}