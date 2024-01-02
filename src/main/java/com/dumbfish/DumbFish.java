package com.dumbfish;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DumbFish implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("dumbfish-mod");
	public static final String MOD_ID = "dumbfish-mod";
	public static final Block nukeBlock = new Nuke();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		EggExplode.registerEggExplode();
		LOGGER.info("MOD INIT");
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "nuke"), nukeBlock);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "nuke"),
				new BlockItem(nukeBlock, new Item.Settings()));
		LOGGER.info("NUKE REGISTERED");
	}
}