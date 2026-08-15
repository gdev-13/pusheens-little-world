package com.gdev13.pusheenslittleworld.registry;

import com.gdev13.pusheenslittleworld.PusheensLittleWorld;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PusheensLittleWorld.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PUSHEEN_TAB =
            CREATIVE_MODE_TABS.register("pusheen_tab", () -> CreativeModeTab.builder()
                    .title(Component.literal("Pusheen's Little World"))
                    .icon(() -> new ItemStack(ModItems.PUSHEEN_PLUSH.get()))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.PUSHEEN_PLUSH.get());
                        output.accept(ModItems.PUSHEEN_COOKIE.get());
                        output.accept(ModItems.STRAWBERRY_MILK.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}