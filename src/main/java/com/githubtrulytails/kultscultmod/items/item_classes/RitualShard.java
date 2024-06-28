package com.githubtrulytails.kultscultmod.items.item_classes;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RitualShard extends Item {
    public RitualShard(Settings settings) {
        super(settings);
    }


   //when right click action
   @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(),
                SoundEvents.ENTITY_WITHER_HURT, SoundCategory.NEUTRAL, 0.3F, 0.9F / (world.getRandom().nextFloat() * 0.4F + 0.8F));

       return TypedActionResult.success(itemStack);
    }


}
