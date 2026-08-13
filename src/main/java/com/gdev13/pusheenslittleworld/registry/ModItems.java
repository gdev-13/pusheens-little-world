package com.gdev13.pusheenslittleworld.registry;

import com.gdev13.pusheenslittleworld.PusheensLittleWorld;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
    		DeferredRegister.createItems(PusheensLittleWorld.MODID);

    public static final DeferredItem<Item> PUSHEEN_PLUSH =
    		ITEMS.registerSimpleItem("pusheen_plush");
    
    public static final DeferredItem<Item> PUSHEEN_COOKIE =
            ITEMS.registerItem("pusheen_cookie",
                    properties -> new Item(
                            properties.food(
                                    new FoodProperties.Builder()
                                            .nutrition(2)
                                            .saturationModifier(0.4f)
                                            .build()
                            )
                    ));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}