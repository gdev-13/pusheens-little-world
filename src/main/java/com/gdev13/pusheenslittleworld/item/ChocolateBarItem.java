package com.gdev13.pusheenslittleworld.item;

import com.gdev13.pusheenslittleworld.registry.ModDataComponents;
import com.gdev13.pusheenslittleworld.registry.ModItems;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChocolateBarItem extends Item {

    public ChocolateBarItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public InteractionResult use(
            Level level,
            Player player,
            InteractionHand hand
    ) {

        if (player.isShiftKeyDown()) {

            ItemStack stack = player.getItemInHand(hand);
            int squaresRemaining = getSquaresRemaining(stack);

            if (squaresRemaining == 2) {

                ItemStack squares = new ItemStack(
                        ModItems.CHOCOLATE_SQUARE.get(),
                        2
                );

                if (stack.getCount() == 1) {
                    player.setItemInHand(hand, squares);
                } else {
                    stack.shrink(1);
                    player.getInventory().placeItemBackInInventory(squares);
                }

                return InteractionResult.SUCCESS;
            }

            ItemStack square = new ItemStack(
                    ModItems.CHOCOLATE_SQUARE.get()
            );

            player.getInventory().placeItemBackInInventory(square);

            removeSquare(stack);

            return InteractionResult.SUCCESS;
        }

        return super.use(level, player, hand);
    }
    
    private int getSquaresRemaining(ItemStack stack) {
        return stack.getOrDefault(
                ModDataComponents.CHOCOLATE_SQUARES_REMAINING,
                12
        );
    }
    
    private void removeSquare(ItemStack stack) {
        int squaresRemaining = getSquaresRemaining(stack);

        if (squaresRemaining > 1) {
            stack.set(
                    ModDataComponents.CHOCOLATE_SQUARES_REMAINING,
                    squaresRemaining - 1
            );
        }
    }
}