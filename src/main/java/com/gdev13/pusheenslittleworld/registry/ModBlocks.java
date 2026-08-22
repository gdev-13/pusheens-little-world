package com.gdev13.pusheenslittleworld.registry;

import com.gdev13.pusheenslittleworld.PusheensLittleWorld;
import com.gdev13.pusheenslittleworld.block.CardboardBoxBlock;
import com.gdev13.pusheenslittleworld.block.PusheenCarpetBlock;
import com.gdev13.pusheenslittleworld.block.PusheenMugBlock;
import com.gdev13.pusheenslittleworld.block.YarnBallBlock;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PusheensLittleWorld.MODID);
    
    public static final EnumProperty<Direction> FACING =
            BlockStateProperties.HORIZONTAL_FACING;

    public static final DeferredBlock<Block> PUSHEEN_CARPET =
            BLOCKS.register(
                    "pusheen_carpet",
                    registryName -> new PusheenCarpetBlock(
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
                    registryName -> new CardboardBoxBlock(
                            BlockBehaviour.Properties.of()
                            		.noOcclusion()
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    registryName
                                            )
                                    )
                    )
            );
    
    public static final DeferredBlock<Block> PUSHEEN_MUG =
            BLOCKS.register(
                    "pusheen_mug",
                    registryName -> new PusheenMugBlock(
                            BlockBehaviour.Properties.of()
                            		.noOcclusion()
                                    .setId(
                                            ResourceKey.create(
                                                    Registries.BLOCK,
                                                    registryName
                                            )
                                    )
                    )
            );
    
    public static final DeferredBlock<Block> YARN_BALL = 
    		BLOCKS.register(
    				"yarn_ball", 
    				registryName -> new YarnBallBlock(
    						BlockBehaviour.Properties.of()
    								.noOcclusion()
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