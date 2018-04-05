package com.steinshuh.tut.blocks;

import java.util.HashSet;

import com.steinshuh.tut.Ref;
import com.steinshuh.tut.items.FirstItem;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
	private static boolean _alreadyPopulated = false;
	//blocks and block items
	public static Block firstBlock; public static Item firstBlockI;
	
	//lists of blocks and items
	public static HashSet<Block> blocks = new HashSet<Block>();
	public static HashSet<Item> blockIs = new HashSet<Item>();

	public static void populateBlocks() {
		if(_alreadyPopulated) {
			System.out.println("ModBlocks.populateBlocks: skipped");
			return;
		}
		System.out.println("ModBlocks.populateBlocks");
		firstBlock = new FirstBlock(); 
		firstBlockI=new ItemBlock(firstBlock);
		firstBlockI.setRegistryName(firstBlock.getRegistryName());
		blocks.add(firstBlock); blockIs.add(firstBlockI);
		_alreadyPopulated=true;
	}


	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		System.out.println("ModBlocks.registerBlocks");
		populateBlocks();
		IForgeRegistry registry = event.getRegistry();
		for(Block block:blocks) {
			registry.register(block);
		}	
	}

	public static void registerItems(RegistryEvent.Register<Item> event) {
		System.out.println("ModBlocks.registerItems");
		populateBlocks();
		IForgeRegistry registry = event.getRegistry();
		for(Item blockI:blockIs) {
			registry.register(blockI);
		}	
	}


	public static void onRegisterModels(ModelRegistryEvent event) {
		for (Block block : blocks) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}
		for (Item item : blockIs) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
}

