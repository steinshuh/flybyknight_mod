package com.steinshuh.tut.items;

import java.util.HashSet;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
	private static boolean _alreadyPopulated = false;
	// items
	public static Item firstItem; 
	public static Item pokejungeAxe; 
	public static Item awesomebookgirlWand; 

	//lists of blocks and items
	public static HashSet<Item> items = new HashSet<Item>();

	public static void populateItems() {
		if(_alreadyPopulated) {
			System.out.println("ModItems.populateItems: skipped");
			return;
		}
		System.out.println("ModItems.populateItems");
		firstItem = new FirstItem(); 
		items.add(firstItem);
		pokejungeAxe = new PokejungeAxe();
		items.add(pokejungeAxe);
		awesomebookgirlWand = new AwesomebookgirlWand();
		items.add(awesomebookgirlWand);
		_alreadyPopulated=true;
	}


	public static void registerItems(RegistryEvent.Register<Item> event) {
		System.out.println("ModItems.registerItems");
		populateItems();
		IForgeRegistry registry = event.getRegistry();
		for(Item item:items) {
			registry.register(item);
		}	
	}


	public static void onRegisterModels(ModelRegistryEvent event) {
		System.out.println("ModItems.onRegisterModels");
		populateItems();
		for (Item item : items) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
	}
}
