package com.deextinction.deextinction.init;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.deextinction.blocks.CenozoicFossilBlock;
import com.deextinction.deextinction.blocks.MesozoicFossilBlock;
import com.deextinction.deextinction.blocks.PaleozoicFossilBlock;
import com.deextinction.deextinction.blocks.PermafrostBlock;
import com.deextinction.deextinction.blocks.machine.cleaning.CleaningTableBlock;
import com.deextinction.deextinction.blocks.machine.embryogen.CentrifugeBlock;
import com.deextinction.deextinction.blocks.machine.embryogen.EggMachineBlock;
import com.deextinction.deextinction.blocks.machine.embryogen.EmbryonicMachineBlock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class DeexBlocks
{
     public static final List<Block> BLOCKS = new ArrayList<Block>();
	
     public static final Block CENOZOIC_FOSSIL_BLOCK = new CenozoicFossilBlock("cenozoic_fossil_block", Material.ROCK);	
     public static final Block MESOZOIC_FOSSIL_BLOCK = new MesozoicFossilBlock("mesozoic_fossil_block", Material.ROCK);
     public static final Block PALEOZOIC_FOSSIL_BLOCK = new PaleozoicFossilBlock("paleozoic_fossil_block", Material.ROCK);
     public static final Block PERMAFROST_BLOCK = new PermafrostBlock("permafrost_block", Material.ICE);
    
	public static final  Block CLEANING_TABLE_BLOCK = new CleaningTableBlock("cleaning_table_block", Material.WOOD);
	public static final  Block EMBRYONIC_MACHINE_BLOCK = new EmbryonicMachineBlock("embryonic_machine_block", Material.IRON);
	public static final  Block EGG_MACHINE_BLOCK = new EggMachineBlock("egg_machine_block", Material.IRON);
	public static final  Block CENTRIFUGE_BLOCK = new CentrifugeBlock("centrifuge_block", Material.IRON);
}
