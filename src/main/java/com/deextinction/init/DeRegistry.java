package com.deextinction.init;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.deextinction.DeExtinction;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class DeRegistry
{
	private static Set<Block> blocksToRegister = new LinkedHashSet<>();
	private static Set<Item> itemsToRegister = new LinkedHashSet<>();
	private static List<SoundEvent> soundsToRegister = new ArrayList<SoundEvent>();

	public static void preInitRegistryEvent()
	{
		MinecraftForge.EVENT_BUS.register(new DeRegistry());
	}

	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(DeRegistry.blocksToRegister.toArray(new Block[DeRegistry.blocksToRegister.size()]));
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(DeRegistry.itemsToRegister.toArray(new Item[DeRegistry.itemsToRegister.size()]));
	}

	@SubscribeEvent
	public static void registerSounds(final RegistryEvent.Register<SoundEvent> event)
	{
		event.getRegistry().registerAll(DeRegistry.soundsToRegister.toArray(new SoundEvent[DeRegistry.soundsToRegister.size()]));
	}

	public static void registerBlock(Block block, String unlocalized_name)
	{
		block.setRegistryName(unlocalized_name);
		block.setUnlocalizedName(unlocalized_name);
		DeRegistry.blocksToRegister.add(block);
	}

	public static void registerBlockWithItem(Block block, String unlocalized_name)
	{
		block.setRegistryName(DeExtinction.MODID, unlocalized_name);
		block.setUnlocalizedName(unlocalized_name);

		ItemBlock item_block = new ItemBlock(block);
		item_block.setRegistryName(DeExtinction.MODID, unlocalized_name);

		DeRegistry.blocksToRegister.add(block);
		DeRegistry.itemsToRegister.add(item_block);
	}

	public static void registerBlockWithCustomItem(Block block, ItemBlock item_block, String unlocalized_name)
	{
		block.setRegistryName(DeExtinction.MODID, unlocalized_name);
		block.setUnlocalizedName(unlocalized_name);
		item_block.setRegistryName(DeExtinction.MODID, unlocalized_name);

		DeRegistry.blocksToRegister.add(block);
		DeRegistry.itemsToRegister.add(item_block);
	}

	public static void registerItem(Item item, String unlocalized_name)
	{
		item.setRegistryName(DeExtinction.MODID, unlocalized_name);
		item.setUnlocalizedName(unlocalized_name);
		DeRegistry.itemsToRegister.add(item);
	}

	public static void registerSound(SoundEvent sound, String name)
	{
		sound.setRegistryName(name);
		DeRegistry.soundsToRegister.add(sound);
	}
}
