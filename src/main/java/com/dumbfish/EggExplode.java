package com.dumbfish;

import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.minecraft.item.Items;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;
public class EggExplode {
    private static final Random random = new Random();
    public static void registerEggExplode() {
        UseItemCallback.EVENT.register((player, world, hand) -> {
            if (player.getStackInHand(hand).getItem() == Items.EGG) {
                // Generate a random number between 0 (inclusive) and 4 (exclusive)
                int chance = random.nextInt(4);

                // Only explode if the random number is 0 (1/4 chance)
                if (chance == 0) {
                    world.createExplosion(null,
                            player.getX(), player.getY(), player.getZ(),
                            2.0f, World.ExplosionSourceType.TNT);
                }

                return TypedActionResult.success(player.getStackInHand(hand));
            }

            return TypedActionResult.pass(player.getStackInHand(hand));
        });
    }
}
