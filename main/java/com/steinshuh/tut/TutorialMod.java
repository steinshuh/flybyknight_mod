package com.steinshuh.tut;
// https://wiki.mcjty.eu/modding/index.php?title=Basic_Mod-1.12

import java.util.HashSet;

import org.apache.logging.log4j.Logger;

import com.steinshuh.tut.blocks.ModBlocks;
import com.steinshuh.tut.items.ModItems;
import com.steinshuh.tut.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;


@Mod(modid=Ref.MODID, name=Ref.NAME, version=Ref.VERSION)
@Mod.EventBusSubscriber
public class TutorialMod {
	public static Logger logger;

	@Mod.Instance
	public static TutorialMod instance;

	@SidedProxy(clientSide=Ref.CLIENT_PROXY, serverSide=Ref.SERVER_PROXY)
	public static CommonProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){
		System.out.println("TutorialMod.preInit");
		logger=event.getModLog();
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		System.out.println("TutorialMod.init");
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		System.out.println("TutorialMod.postInit");
		proxy.postInit(event);
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		System.out.println("TutorialMod.registerBlocks");
		ModBlocks.registerBlocks(event);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		System.out.println("TutorialMod.registerItems");
		ModBlocks.registerItems(event);
		ModItems.registerItems(event);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void onRegisterModels(ModelRegistryEvent event) {
		System.out.println("TutorialMod.onRegisterModels");
		ModBlocks.onRegisterModels(event);
		ModItems.onRegisterModels(event);
	}
	

}
