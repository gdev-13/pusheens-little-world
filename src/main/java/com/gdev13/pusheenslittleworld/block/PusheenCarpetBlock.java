package com.gdev13.pusheenslittleworld.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.redstone.Orientation;

public class PusheenCarpetBlock extends CarpetBlock {
	
	public static final EnumProperty<Direction> FACING =
	        BlockStateProperties.HORIZONTAL_FACING;
	
	public static final BooleanProperty NORTH =
	        BlockStateProperties.NORTH;

	public static final BooleanProperty SOUTH =
	        BlockStateProperties.SOUTH;

	public static final BooleanProperty EAST =
	        BlockStateProperties.EAST;

	public static final BooleanProperty WEST =
	        BlockStateProperties.WEST;
	
	public enum CarpetShape implements StringRepresentable {
	    SINGLE,
	    TWO_BY_ONE_LEFT,
	    TWO_BY_ONE_RIGHT;
	    
	    @Override
	    public String getSerializedName() {
	        return name().toLowerCase();
	    }
	}
	
	public static final EnumProperty<CarpetShape> SHAPE =
	        EnumProperty.create(
	                "shape",
	                CarpetShape.class
	        );

	public PusheenCarpetBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(NORTH, false)
                        .setValue(SOUTH, false)
                        .setValue(EAST, false)
                        .setValue(WEST, false)
                        .setValue(SHAPE, CarpetShape.SINGLE)
        );
    }
	
	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {

	    Direction facing = getConnectedFacing(
	            context.getLevel(),
	            context.getClickedPos(),
	            context.getHorizontalDirection()
	    );

	    BlockState state =
	            this.defaultBlockState()
	                    .setValue(FACING, facing);

	    return updateConnections(
	            state,
	            context.getLevel(),
	            context.getClickedPos()
	    );
	}
	
	@Override
	protected void createBlockStateDefinition(
	        StateDefinition.Builder<Block, BlockState> builder
	) {
	    builder.add(
	            FACING,
	            NORTH,
	            SOUTH,
	            EAST,
	            WEST,
	            SHAPE
	    );
	}
	
	private boolean isCarpet(BlockState state) {
	    return state.getBlock() instanceof PusheenCarpetBlock;
	}
	
	private BlockState updateConnections(BlockState state,
	        LevelAccessor level,
	        BlockPos pos) {

	    boolean north = isCarpet(level.getBlockState(pos.north()));
	    boolean south = isCarpet(level.getBlockState(pos.south()));
	    boolean east = isCarpet(level.getBlockState(pos.east()));
	    boolean west = isCarpet(level.getBlockState(pos.west()));

	    BlockState updatedState = state
	            .setValue(NORTH, north)
	            .setValue(SOUTH, south)
	            .setValue(EAST, east)
	            .setValue(WEST, west);
	    
	    CarpetShape shape = determineShape(updatedState);

	    updatedState = updatedState.setValue(SHAPE, shape);

	    return updatedState;
	}
	
	private boolean hasNeighborOnRight(BlockState state) {

	    Direction facing = state.getValue(FACING);

	    return switch (facing) {
	        case NORTH -> state.getValue(EAST);
	        case SOUTH -> state.getValue(WEST);
	        case EAST -> state.getValue(SOUTH);
	        case WEST -> state.getValue(NORTH);
	        default -> false;
	    };
	}
	
	private boolean hasNeighborOnLeft(BlockState state) {

	    Direction facing = state.getValue(FACING);

	    return switch (facing) {
	        case NORTH -> state.getValue(WEST);
	        case SOUTH -> state.getValue(EAST);
	        case EAST -> state.getValue(NORTH);
	        case WEST -> state.getValue(SOUTH);
	        default -> false;
	    };
	}
	
	private CarpetShape determineShape(BlockState state) {

	    boolean left = hasNeighborOnLeft(state);
	    boolean right = hasNeighborOnRight(state);

	    if (!left && !right) {
	        return CarpetShape.SINGLE;
	    }

	    if (!left && right) {
	        return CarpetShape.TWO_BY_ONE_LEFT;
	    }

	    if (left && !right) {
	        return CarpetShape.TWO_BY_ONE_RIGHT;
	    }

	    return CarpetShape.SINGLE;
	}
	
	@Override
	public void setPlacedBy(
	        Level level,
	        BlockPos pos,
	        BlockState state,
	        LivingEntity placer,
	        ItemStack stack
	) {
	    super.setPlacedBy(level, pos, state, placer, stack);

	    updateNeighbor(level, pos.north());
	    updateNeighbor(level, pos.south());
	    updateNeighbor(level, pos.east());
	    updateNeighbor(level, pos.west());
	}
	
	@Override
	protected void neighborChanged(
	        BlockState state,
	        Level level,
	        BlockPos pos,
	        Block block,
	        Orientation orientation,
	        boolean movedByPiston
	) {
	    super.neighborChanged(
	            state,
	            level,
	            pos,
	            block,
	            orientation,
	            movedByPiston
	    );

	    BlockState updatedState =
	            updateConnections(state, level, pos);

	    if (!updatedState.equals(state)) {
	        level.setBlock(
	                pos,
	                updatedState,
	                Block.UPDATE_ALL
	        );
	    }
	}
	
	private void updateNeighbor(
	        Level level,
	        BlockPos pos
	) {
	    BlockState neighborState = level.getBlockState(pos);

	    if (neighborState.getBlock() instanceof PusheenCarpetBlock carpet) {
	        BlockState updatedState =
	                carpet.updateConnections(
	                        neighborState,
	                        level,
	                        pos
	                );

	        level.setBlock(
	                pos,
	                updatedState,
	                Block.UPDATE_ALL
	        );
	    }
	}
	
	private Direction getConnectedFacing(
	        LevelAccessor level,
	        BlockPos pos,
	        Direction defaultFacing
	) {
	    Direction[] directions = {
	            Direction.NORTH,
	            Direction.SOUTH,
	            Direction.EAST,
	            Direction.WEST
	    };

	    for (Direction direction : directions) {
	        BlockState neighbor = level.getBlockState(pos.relative(direction));

	        if (isCarpet(neighbor)) {
	            return neighbor.getValue(FACING);
	        }
	    }

	    return defaultFacing;
	}
}
