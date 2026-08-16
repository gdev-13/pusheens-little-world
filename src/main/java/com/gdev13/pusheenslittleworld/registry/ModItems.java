package com.gdev13.pusheenslittleworld.registry;

import com.gdev13.pusheenslittleworld.PusheensLittleWorld;

import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;
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
                            properties
                                    .food(
                                            new FoodProperties.Builder()
                                                    .nutrition(2)
                                                    .saturationModifier(0.4f)
                                                    .build()
                                    )
                                    .component(
                                            DataComponents.CONSUMABLE,
                                            Consumable.builder()
                                                    .onConsume(
                                                            new ApplyStatusEffectsConsumeEffect(
                                                                    new MobEffectInstance(
                                                                            ModEffects.PURRFECT,
                                                                            100,
                                                                            0,
                                                                            false,
                                                                            false,
                                                                            true
                                                                    ),
                                                                    1.0F
                                                            )
                                                    )
                                                    .build()
                                    )
                    ));
    
    public static final DeferredItem<Item> CUPCAKE =
    		ITEMS.registerItem("cupcake",
    				properties -> new Item(
    						properties
	    						.food(
	    								new FoodProperties.Builder()
	    										.nutrition(3)
	    										.saturationModifier(0.4f)
	    										.build()
	    						)
	    						.component(
	    								DataComponents.CONSUMABLE,
	    								Consumable.builder()
	    								.animation(ItemUseAnimation.EAT)
	    								.sound(SoundEvents.GENERIC_EAT)
	    								.build()
	    						)
    				));
    
    public static final DeferredItem<Item> CHOCOLATE_BAR =
    		ITEMS.registerItem("chocolate_bar",
    				properties -> new Item(
    						properties
	    						.food(
	    								new FoodProperties.Builder()
	    										.nutrition(2)
	    										.saturationModifier(0.3f)
	    										.build()
	    						)
	    						.component(
	    								DataComponents.CONSUMABLE,
	    								Consumable.builder()
	    								.animation(ItemUseAnimation.EAT)
	    								.sound(SoundEvents.GENERIC_EAT)
	    								.build()
	    						)
    				));
    
    public static final DeferredItem<Item> STRAWBERRY_MILK =
            ITEMS.registerItem("strawberry_milk",
                    properties -> new Item(
                            properties
                                    .food(
                                            new FoodProperties.Builder()
                                                    .nutrition(3)
                                                    .saturationModifier(0.5f)
                                                    .build()
                                    )
                                    .component(
                                            DataComponents.CONSUMABLE,
                                            Consumable.builder()
                                                    .animation(ItemUseAnimation.DRINK)
                                                    .sound(SoundEvents.GENERIC_DRINK)
                                                    .build()
                                    )
                    ));
    
    public static final DeferredItem<BlockItem> PUSHEEN_CARPET_SINGLE =
            ITEMS.registerSimpleBlockItem(
                    "pusheen_carpet_single",
                    ModBlocks.PUSHEEN_CARPET_SINGLE,
                    new Item.Properties()
            );
    
    public static final DeferredItem<BlockItem> CARDBOARD_BOX =
            ITEMS.registerSimpleBlockItem(
                    "cardboard_box",
                    ModBlocks.CARDBOARD_BOX
            );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}