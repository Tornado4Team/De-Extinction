package com.deextinction.init;

import java.util.HashMap;
import java.util.List;

import com.deextinction.DeExtinction;
import com.deextinction.block.BlockFossil;
import com.deextinction.block.BlockFossilBroken;
import com.deextinction.block.eggs.BlockEgg;
import com.deextinction.block.eggs.BlockFiveEggs;
import com.deextinction.block.eggs.BlockFourEggs;
import com.deextinction.block.eggs.BlockOneEgg;
import com.deextinction.block.eggs.BlockThreeEggs;
import com.deextinction.block.eggs.BlockTwoEggs;
import com.deextinction.block.machines.BlockCleaningTable;
import com.deextinction.block.machines.BlockDNADecoder;
import com.deextinction.block.machines.BlockDNAEditor;
import com.deextinction.block.machines.BlockDNAExtractor;
import com.deextinction.block.machines.BlockDeExtinctionMachine;
import com.deextinction.block.machines.BlockMicroscope;
import com.deextinction.block.plants.BlockBanksia;
import com.deextinction.block.plants.BlockDeExtinctedPlanks;
import com.deextinction.block.plants.BlockDeExtinctedSapling;
import com.deextinction.client.renderer.tileentity.RenderCleaningTable;
import com.deextinction.client.renderer.tileentity.RenderFossilBroken;
import com.deextinction.database.DeExtincted;
import com.deextinction.database.DeExtinctedTree;
import com.deextinction.database.IEgg;
import com.deextinction.tileentities.TileCleaningTable;
import com.deextinction.tileentities.TileDNADecoder;
import com.deextinction.tileentities.TileDNAEditor;
import com.deextinction.tileentities.TileDNAExtractor;
import com.deextinction.tileentities.TileDeExtinctionMachine;
import com.deextinction.tileentities.TileEgg;
import com.deextinction.tileentities.TileFossilBroken;
import com.deextinction.tileentities.TileMicroscope;
import com.deextinction.util.ISubBlock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class DeBlocks
{
	public static BlockFossilBroken fossil_block_broken_stone = new BlockFossilBroken(1.5F, 10.0F, Material.ROCK, SoundType.STONE, null);
	public static BlockFossilBroken fossil_block_broken_diorite = new BlockFossilBroken(1.5F, 10.0F, Material.ROCK, SoundType.STONE, null);
	public static BlockFossilBroken fossil_block_broken_granite = new BlockFossilBroken(1.5F, 10.0F, Material.ROCK, SoundType.STONE, null);
	public static BlockFossilBroken fossil_block_broken_andesite = new BlockFossilBroken(1.5F, 10.0F, Material.ROCK, SoundType.STONE, null);
	public static BlockFossilBroken fossil_block_broken_sandstone = new BlockFossilBroken(1.5F, 10.0F, Material.ROCK, SoundType.STONE, null);

	public static BlockFossil fossil_block_animal = new BlockFossil(BlockFossil.FossilType.ANIMAL, 1.5F, 10.0F, Material.ROCK, SoundType.STONE, DeCreativeTabs.blocks);
	public static BlockFossil fossil_block_plant = new BlockFossil(BlockFossil.FossilType.PLANT, 1.5F, 10.0F, Material.ROCK, SoundType.STONE, DeCreativeTabs.blocks);

	public static BlockCleaningTable cleaning_table_block = new BlockCleaningTable(2.0F, 5.0F, Material.WOOD, SoundType.WOOD, DeCreativeTabs.blocks);
	public static BlockDNAExtractor dna_extractor = new BlockDNAExtractor(2.0F, 5.0F, Material.IRON, SoundType.METAL, DeCreativeTabs.blocks);
	public static BlockDNADecoder dna_decoder = new BlockDNADecoder(2.0F, 5.0F, Material.IRON, SoundType.METAL, DeCreativeTabs.blocks);
	public static BlockDNAEditor dna_editor = new BlockDNAEditor(2.0F, 5.0F, Material.IRON, SoundType.METAL, DeCreativeTabs.blocks);
	public static BlockDeExtinctionMachine de_extinction_machine = new BlockDeExtinctionMachine(2.0F, 5.0F, Material.IRON, SoundType.METAL, DeCreativeTabs.blocks);
	public static BlockMicroscope microscope = new BlockMicroscope(2.0F, 5.0F, Material.IRON, SoundType.METAL, DeCreativeTabs.blocks);

	public static HashMap<String, Block> saplings = new HashMap<String, Block>();
	public static HashMap<String, Block> logs = new HashMap<String, Block>();
	public static HashMap<String, Block> leaves = new HashMap<String, Block>();
	public static HashMap<String, Block> planks = new HashMap<String, Block>();
	public static HashMap<String, Block> stairs = new HashMap<String, Block>();
	public static HashMap<String, Block> slabs_single = new HashMap<String, Block>();
	public static HashMap<String, Block> slabs_double = new HashMap<String, Block>();
	public static HashMap<String, Block> doors = new HashMap<String, Block>();
	public static HashMap<String, Block> trap_doors = new HashMap<String, Block>();
	public static HashMap<String, Block> fences = new HashMap<String, Block>();
	public static HashMap<String, Block> fence_gates = new HashMap<String, Block>();

	public static HashMap<String, BlockEgg> eggs = new HashMap<String, BlockEgg>();

	public static BlockBanksia banksia = new BlockBanksia(DeCreativeTabs.blocks);

	public static void preInitBlocks()
	{
		// Blocks (Eggs) from DeExtincted is automatically registered
		// (BlockEggs)
		GameRegistry.registerTileEntity(TileEgg.class, new ResourceLocation(DeExtinction.MODID, "block_egg"));
		for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
		{
			if (deExtincted instanceof IEgg)
			{
				IEgg iEgg = (IEgg) deExtincted;
				BlockEgg egg = null;
				switch (iEgg.getTotalNumberOfEgg())
				{
					case ONE:
						egg = new BlockOneEgg(deExtincted);
						break;
					case TWO:
						egg = new BlockTwoEggs(deExtincted);
						break;
					case THREE:
						egg = new BlockThreeEggs(deExtincted);
						break;
					case FOUR:
						egg = new BlockFourEggs(deExtincted);
						break;
					case FIVE:
						egg = new BlockFiveEggs(deExtincted);
						break;
				}
				DeBlocks.eggs.put(deExtincted.getName(), egg);
				DeBlocks.registerBlock(egg, "block_egg_" + deExtincted.getName());
			}
		}

		// Trees are automatically registered (Saplings, logs, leaves...)
		for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
		{
			if (deExtincted instanceof DeExtinctedTree)
			{
				DeExtinctedTree tree = (DeExtinctedTree) deExtincted;
				String treeName = tree.getName();

				List<BlockDeExtinctedSapling> saplings = tree.getTreeSaplings();
				for (BlockDeExtinctedSapling sapling : saplings)
				{
					if (sapling != null)
					{
						DeBlocks.saplings.put(treeName, sapling);
						DeBlocks.registerBlock(sapling, "block_" + treeName + "_" + DeExtinctedTree.EnumTreeBlocks.SAPLING.getName() + "_" + sapling.getVariant());
					}
				}

				HashMap<DeExtinctedTree.EnumTreeBlocks, Block> treeBlocks = tree.getTreeBlocks();
				for (DeExtinctedTree.EnumTreeBlocks treeBlock : treeBlocks.keySet())
				{
					switch (treeBlock)
					{
						case LOG:
							DeBlocks.logs.put(treeName, treeBlocks.get(treeBlock));
							break;
						case LEAVES:
							DeBlocks.leaves.put(treeName, treeBlocks.get(treeBlock));
							break;
						case PLANKS:
							DeBlocks.planks.put(treeName, treeBlocks.get(treeBlock));
							break;
						default:
							break;
					}
				}
				for (DeExtinctedTree.EnumTreeBlocks treeBlock : treeBlocks.keySet())
					if (treeBlock != null)
						DeBlocks.registerBlock(treeBlocks.get(treeBlock), "block_" + treeName + "_" + treeBlock.getName());

				HashMap<DeExtinctedTree.EnumTreeBlocks, Block> derivativeBlocks = tree.getTreeBlocksDerivatives((BlockDeExtinctedPlanks) DeBlocks.planks.get(treeName));
				for (DeExtinctedTree.EnumTreeBlocks derivativeBlock : derivativeBlocks.keySet())
				{
					switch (derivativeBlock)
					{
						case STAIRS:
							DeBlocks.stairs.put(treeName, derivativeBlocks.get(derivativeBlock));
							break;
						case SLAB_SINGLE:
							DeBlocks.slabs_single.put(treeName, derivativeBlocks.get(derivativeBlock));
							break;
						case SLAB_DOUBLE:
							DeBlocks.slabs_double.put(treeName, derivativeBlocks.get(derivativeBlock));
							break;
						case DOOR:
							DeBlocks.doors.put(treeName, derivativeBlocks.get(derivativeBlock));
							break;
						case TRAP_DOOR:
							DeBlocks.trap_doors.put(treeName, derivativeBlocks.get(derivativeBlock));
							break;
						case FENCE:
							DeBlocks.fences.put(treeName, derivativeBlocks.get(derivativeBlock));
							break;
						case FENCE_GATE:
							DeBlocks.fence_gates.put(treeName, derivativeBlocks.get(derivativeBlock));
							break;
						default:
							break;
					}
				}
				for (DeExtinctedTree.EnumTreeBlocks derivativeBlock : derivativeBlocks.keySet())
					if (derivativeBlock != null)
						DeBlocks.registerBlock(derivativeBlocks.get(derivativeBlock), "block_" + treeName + "_" + derivativeBlock.getName());
			}
		}

		// Blocks

		// Fossil
		DeBlocks.registerTileEntity(TileFossilBroken.class, "block_fossil_broken");
		DeBlocks.registerBlock(DeBlocks.fossil_block_broken_stone, "block_fossil_broken_stone");
		DeBlocks.registerBlock(DeBlocks.fossil_block_broken_diorite, "block_fossil_broken_diorite");
		DeBlocks.registerBlock(DeBlocks.fossil_block_broken_granite, "block_fossil_broken_granite");
		DeBlocks.registerBlock(DeBlocks.fossil_block_broken_andesite, "block_fossil_broken_andesite");
		DeBlocks.registerBlock(DeBlocks.fossil_block_broken_sandstone, "block_fossil_broken_sandstone");

		DeBlocks.registerBlock(DeBlocks.fossil_block_animal, "block_fossil_animal");
		DeBlocks.registerBlock(DeBlocks.fossil_block_plant, "block_fossil_plant");

		// TileEntities
		DeBlocks.registerBlock(DeBlocks.cleaning_table_block, "block_cleaning_table", TileCleaningTable.class);
		DeBlocks.registerBlock(DeBlocks.dna_extractor, "block_dna_extractor", TileDNAExtractor.class);
		DeBlocks.registerBlock(DeBlocks.dna_decoder, "block_dna_decoder", TileDNADecoder.class);
		DeBlocks.registerBlock(DeBlocks.dna_editor, "block_dna_editor", TileDNAEditor.class);
		DeBlocks.registerBlock(DeBlocks.de_extinction_machine, "block_de_extinction_machine", TileDeExtinctionMachine.class);
		DeBlocks.registerBlock(DeBlocks.microscope, "block_microscope", TileMicroscope.class);

		// Plants
		DeBlocks.registerBlock(DeBlocks.banksia, "block_banksia");

		// Register GUIs
		DeGuiHandler.registerGUIHandler();
	}

	public static void postInitOreDictionaryBlocks()
	{
		for (Block block : DeBlocks.saplings.values())
			OreDictionary.registerOre("treeSapling", block);

		for (Block block : DeBlocks.logs.values())
			OreDictionary.registerOre("logWood", block);

		for (Block block : DeBlocks.leaves.values())
			OreDictionary.registerOre("treeLeaves", block);

		for (Block block : DeBlocks.planks.values())
			OreDictionary.registerOre("plankWood", block);

		for (Block block : DeBlocks.stairs.values())
			OreDictionary.registerOre("stairWood", block);

		for (Block block : DeBlocks.slabs_single.values())
			OreDictionary.registerOre("slabWood", block);

		for (Block block : DeBlocks.doors.values())
			OreDictionary.registerOre("doorWood", block);

		for (Block block : DeBlocks.fences.values())
			OreDictionary.registerOre("fenceWood", block);

		for (Block block : DeBlocks.fence_gates.values())
			OreDictionary.registerOre("fenceGateWood", block);
	}

	public static void postInitTileEntitySpecialRenderer()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileCleaningTable.class, new RenderCleaningTable());
		ClientRegistry.bindTileEntitySpecialRenderer(TileFossilBroken.class, new RenderFossilBroken());
	}

	public static void registerBlock(Block block, String unlocalized_name)
	{
		if (block instanceof ISubBlock)
			DeRegistry.registerBlockWithCustomItem(block, ((ISubBlock) block).getItemBlock(), unlocalized_name);
		else
			DeRegistry.registerBlockWithItem(block, unlocalized_name);
	}

	public static void registerBlock(Block block, String unlocalized_name, Class<? extends TileEntity> tileEntity)
	{
		DeBlocks.registerBlock(block, unlocalized_name, tileEntity, unlocalized_name);
	}

	public static void registerBlock(Block block, String unlocalized_name, Class<? extends TileEntity> tileEntity, String tileEntityName)
	{
		DeBlocks.registerBlock(block, unlocalized_name);
		GameRegistry.registerTileEntity(tileEntity, new ResourceLocation(DeExtinction.MODID, tileEntityName + "_tileentity"));
	}

	public static void registerTileEntity(Class<? extends TileEntity> tileEntity, String tileEntityName)
	{
		GameRegistry.registerTileEntity(tileEntity, new ResourceLocation(DeExtinction.MODID, tileEntityName + "_tileentity"));
	}

	private static void registerTileEntitySpecialRenderer(Class TileEntityClass, TileEntitySpecialRenderer specialRenderer)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityClass, specialRenderer);
	}
}
