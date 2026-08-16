package com.gdev13.pusheenslittleworld.registry;

import com.gdev13.pusheenslittleworld.PusheensLittleWorld;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PusheensLittleWorld.MODID);

    public static final DeferredBlock<Block> PUSHEEN_CARPET_SINGLE =
            BLOCKS.register(
                    "pusheen_carpet_single",
                    registryName -> new CarpetBlock(
                            BlockBehaviour.Properties.of()
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    registryName
                                            )
                                    )
                    )
            );
    
    public static final DeferredBlock<Block> CARDBOARD_BOX =
            BLOCKS.register(
                    "cardboard_box",
                    registryName -> new Block(
                            BlockBehaviour.Properties.of()
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    registryName
                                            )
                                    )
                    )
            );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}