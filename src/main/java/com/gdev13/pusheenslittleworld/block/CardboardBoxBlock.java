package com.gdev13.pusheenslittleworld.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class CardboardBoxBlock extends Block {

	public static final EnumProperty<Direction> FACING =
			BlockStateProperties.HORIZONTAL_FACING;
	
	private static final VoxelShape SHAPE =
	        Block.box(0, 0, 0, 16, 10, 16);
	
	public CardboardBoxBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }
	
	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
	    builder.add(FACING);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
	    return this.defaultBlockState()
	            .setValue(FACING, context.getHorizontalDirection());
	}
	
	@Override
	protected VoxelShape getShape(
	        BlockState state,
	        BlockGetter level,
	        BlockPos pos,
	        CollisionContext context) {

	    return SHAPE;
	}
}
