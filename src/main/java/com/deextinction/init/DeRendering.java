package com.deextinction.init;

import com.deextinction.DeExtinction;
import com.deextinction.block.BlockFossil;
import com.deextinction.block.plants.BlockBanksia;
import com.deextinction.util.MultipartStateMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = DeExtinction.MODID, value = Side.CLIENT)
public class DeRendering
{
	public static void preInitRegistryEvent()
	{
		MinecraftForge.EVENT_BUS.register(new DeRendering());
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void registerRenderers(ModelRegistryEvent event)
	{
		// ====================================================================================================
		// Fossil Blocks
		// ====================================================================================================
		for (BlockFossil.BaseBlockType type : BlockFossil.BaseBlockType.values())
			DeRendering.registerBlockRenderer(DeBlocks.fossil_block_animal, type.getMetadata(), DeBlocks.fossil_block_animal.getUnlocalizedName().substring("tile.".length()) + "_" + type.getName());
		for (BlockFossil.BaseBlockType type : BlockFossil.BaseBlockType.values())
			DeRendering.registerBlockRenderer(DeBlocks.fossil_block_plant, type.getMetadata(), DeBlocks.fossil_block_plant.getUnlocalizedName().substring("tile.".length()) + "_" + type.getName());

		DeRendering.registerBlockRenderer(DeBlocks.fossil_block_broken_stone);
		DeRendering.registerBlockRenderer(DeBlocks.fossil_block_broken_diorite);
		DeRendering.registerBlockRenderer(DeBlocks.fossil_block_broken_granite);
		DeRendering.registerBlockRenderer(DeBlocks.fossil_block_broken_andesite);
		DeRendering.registerBlockRenderer(DeBlocks.fossil_block_broken_sandstone);

		// ====================================================================================================
		// Egg Blocks
		// ====================================================================================================
		for (Block egg : DeBlocks.eggs.values())
			DeRendering.registerBlockRenderer(egg);

		// ====================================================================================================
		// Tree Blocks
		// ====================================================================================================
		for (Block sapling : DeBlocks.saplings.values())
			DeRendering.registerBlockRenderer(sapling);
		for (Block log : DeBlocks.logs.values())
			DeRendering.registerBlockRenderer(log);
		for (Block leaves : DeBlocks.leaves.values())
			DeRendering.registerBlockRenderer(leaves);
		for (Block planks : DeBlocks.planks.values())
			DeRendering.registerBlockRenderer(planks);
		for (Block stairs : DeBlocks.stairs.values())
			DeRendering.registerBlockRenderer(stairs);
		for (Block slab_single : DeBlocks.slabs_single.values())
			DeRendering.registerBlockRenderer(slab_single);
		for (Block slab_double : DeBlocks.slabs_double.values())
			DeRendering.registerBlockRenderer(slab_double);
		for (Block door : DeBlocks.doors.values())
		{
			ModelLoader.setCustomStateMapper(door, new StateMap.Builder().ignore(BlockDoor.POWERED).build());
			DeRendering.registerBlockRenderer(door);
		}
		for (Block trap_door : DeBlocks.trap_doors.values())
			DeRendering.registerBlockRenderer(trap_door);
		for (Block fence : DeBlocks.fences.values())
		{
			ModelLoader.setCustomStateMapper(fence, new MultipartStateMap());
			DeRendering.registerBlockRenderer(fence);
		}
		for (Block fence_gate : DeBlocks.fence_gates.values())
		{
			ModelLoader.setCustomStateMapper(fence_gate, new StateMap.Builder().ignore(BlockFenceGate.POWERED).build());
			DeRendering.registerBlockRenderer(fence_gate);
		}

		// ====================================================================================================
		// Plant Blocks
		// ====================================================================================================
		for (BlockBanksia.EnumTypes type : BlockBanksia.EnumTypes.values())
			DeRendering.registerBlockRenderer(DeBlocks.banksia, type.getMetadata(), DeBlocks.banksia.getUnlocalizedName().substring("tile.".length()) + "_" + type.getName());

		// ====================================================================================================
		// TileEntities
		// ====================================================================================================
		DeRendering.registerBlockRenderer(DeBlocks.cleaning_table_block);
		DeRendering.registerBlockRenderer(DeBlocks.dna_extractor);
		DeRendering.registerBlockRenderer(DeBlocks.dna_decoder);
		DeRendering.registerBlockRenderer(DeBlocks.dna_editor);
		DeRendering.registerBlockRenderer(DeBlocks.de_extinction_machine);
		DeRendering.registerBlockRenderer(DeBlocks.microscope);

		// ====================================================================================================
		// Dirty Fossils
		// ====================================================================================================
		for (Item fossil_dirty : DeItems.fossils_dirty.values())
			DeRendering.registerItemRenderer(fossil_dirty);

		// ====================================================================================================
		// Cleaned Fossils
		// ====================================================================================================
		for (Item fossil_clean : DeItems.fossils_clean.values())
			DeRendering.registerItemRenderer(fossil_clean);

		// ====================================================================================================
		// DNA Bottles
		// ====================================================================================================
		for (Item dna_bottle : DeItems.dna_bottles.values())
			DeRendering.registerItemRenderer(dna_bottle);

		// ====================================================================================================
		// Floppy Disks
		// ====================================================================================================
		for (Item dna_floppy_disk : DeItems.dna_floppy_disks.values())
			DeRendering.registerItemRenderer(dna_floppy_disk);

		// ====================================================================================================
		// Syringes
		// ====================================================================================================
		for (Item syringe : DeItems.syringes.values())
			DeRendering.registerItemRenderer(syringe);

		// ====================================================================================================
		// Other Items
		// ====================================================================================================
		DeRendering.registerItemRenderer(DeItems.dna_floppy_disk_empty);
		DeRendering.registerItemRenderer(DeItems.rockpick);
		DeRendering.registerItemRenderer(DeItems.brush);
		DeRendering.registerItemRenderer(DeItems.syringe);
		DeRendering.registerItemRenderer(DeItems.syringe_blood);
		DeRendering.registerItemRenderer(DeItems.guide);
	}

	public static void registerItemRenderer(Item item, int meta, String path)
	{
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(DeExtinction.prependModID(path), "inventory"));
	}

	public static void registerItemRenderer(Item item, String path)
	{
		DeRendering.registerItemRenderer(item, 0, path);
	}

	public static void registerItemRenderer(Item item)
	{
		DeRendering.registerItemRenderer(item, item.getUnlocalizedName().substring("item.".length()));
	}

	public static void registerBlockRenderer(Block block, int meta, String path)
	{
		DeRendering.registerItemRenderer(Item.getItemFromBlock(block), meta, path);
	}

	public static void registerBlockRenderer(Block block, String path)
	{
		DeRendering.registerBlockRenderer(block, 0, path);
	}

	public static void registerBlockRenderer(Block block)
	{
		DeRendering.registerBlockRenderer(block, block.getUnlocalizedName().substring("tile.".length()));
	}
}
