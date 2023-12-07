package com.dumbfish;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Nuke extends Block {

    public Nuke() {
        super(FabricBlockSettings.create().strength(4.0f));
    }

    public void explode(World world, BlockPos position) {
        DumbFish.LOGGER.info("PERFORMING EXPLOSION " + DumbFish.MOD_ID);
        world.createExplosion(null,
                position.getX() + 0.5, position.getY() + 0.5, position.getZ() + 0.5,
                2000.0f, World.ExplosionSourceType.TNT);
        world.setBlockState(position, Blocks.AIR.getDefaultState(), 3);

    }
//    @Override
//    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
//        DumbFish.LOGGER.info("STEPPED ON");
//        super.onSteppedOn(world, pos, state, entity);
//        explode(world, pos);
//    }
    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        DumbFish.LOGGER.info("PLACED " + DumbFish.MOD_ID);
        super.onPlaced(world, pos, state, placer, itemStack);
        if(world.isReceivingRedstonePower(pos)) {
            explode(world, pos);
        }
    }
}

