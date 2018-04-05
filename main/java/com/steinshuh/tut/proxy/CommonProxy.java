package com.steinshuh.tut.proxy;

import java.io.File;

import com.steinshuh.tut.Config;
import com.steinshuh.tut.blocks.FirstBlock;
import com.steinshuh.tut.blocks.ModBlocks;
import com.steinshuh.tut.items.FirstItem;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class CommonProxy {
	//Config instance
	public static Configuration config;

	public void preInit(FMLPreInitializationEvent e) {
		System.out.println("CommonProxy.preInit");
		File directory = e.getModConfigurationDirectory();
		try {
			System.out.println("  modConfigurationDirectory: "+directory.getCanonicalPath());
		}catch(Exception exp) {
			
		}
		config = new Configuration(new File(directory.getPath(), "TutorialMod.cfg"));
		Config.readConfig();
	}

	public void init(FMLInitializationEvent e) {
		System.out.println("CommonProxy.init");
	}

	public void postInit(FMLPostInitializationEvent e) {
		System.out.println("CommonProxy.postInit");
	}

	

}
