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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class YarnBallBlock extends Block {
	
	public static final EnumProperty<Direction> FACING = 
			BlockStateProperties.HORIZONTAL_FACING;

	private static final VoxelShape SHAPE = Shapes.or(
		    Block.box(6, 0, 6, 10, 5, 10),
		    Block.box(5, 1, 6, 11, 4, 10),
		    Block.box(6, 1, 5, 10, 4, 11)
		);
	
    public YarnBallBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            CollisionContext context) {

        return SHAPE;
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
}
