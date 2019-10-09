package com.deextinction.init;

import com.deextinction.DeExtinction;
import com.deextinction.client.gui.inventory.GuiCleaningTable;
import com.deextinction.client.gui.inventory.GuiDNADecoder;
import com.deextinction.client.gui.inventory.GuiDNAEditor;
import com.deextinction.client.gui.inventory.GuiDNAExtractor;
import com.deextinction.client.gui.inventory.GuiDeExtinctionMachine;
import com.deextinction.client.gui.inventory.GuiItemDeExtinction;
import com.deextinction.client.gui.inventory.GuiMicroscope;
import com.deextinction.tileentities.TileCleaningTable;
import com.deextinction.tileentities.TileDNADecoder;
import com.deextinction.tileentities.TileDNAEditor;
import com.deextinction.tileentities.TileDNAExtractor;
import com.deextinction.tileentities.TileDeExtinctionMachine;
import com.deextinction.tileentities.TileMicroscope;
import com.deextinction.tileentities.containers.ContainerCleaningTable;
import com.deextinction.tileentities.containers.ContainerDNADecoder;
import com.deextinction.tileentities.containers.ContainerDNAEditor;
import com.deextinction.tileentities.containers.ContainerDNAExtractor;
import com.deextinction.tileentities.containers.ContainerDeExtinctionMachine;
import com.deextinction.tileentities.containers.ContainerItemDeExtincted;
import com.deextinction.tileentities.containers.ContainerMicroscope;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

/**
 * DeGuiHandler is being registered in DeBlocks class.
 */
public class DeGuiHandler implements IGuiHandler
{
	public static final int ID_ITEM_CREATIVE = -1;
	public static final int ID_BLOCK = 0;
	public static final int ID_ENTITY = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == ID_BLOCK)
		{
			TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
			if (tileEntity instanceof TileDNADecoder)
				return new ContainerDNADecoder(player.inventory, (TileDNADecoder) tileEntity);
			else if (tileEntity instanceof TileDeExtinctionMachine)
				return new ContainerDeExtinctionMachine(player.inventory, (TileDeExtinctionMachine) tileEntity);
			else if (tileEntity instanceof TileCleaningTable)
				return new ContainerCleaningTable(player.inventory, (TileCleaningTable) tileEntity);
			else if (tileEntity instanceof TileDNAExtractor)
				return new ContainerDNAExtractor(player.inventory, (TileDNAExtractor) tileEntity);
			else if (tileEntity instanceof TileDNAEditor)
				return new ContainerDNAEditor(player.inventory, (TileDNAEditor) tileEntity);
			else if (tileEntity instanceof TileMicroscope)
				return new ContainerMicroscope(player.inventory, (TileMicroscope) tileEntity);
		}
		else if (ID == ID_ENTITY)
		{

		}
		else if (ID == ID_ITEM_CREATIVE)
		{
			return new ContainerItemDeExtincted();
		}

		System.err.println("ERROR: Invalid ID: " + ID);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if (ID == ID_BLOCK)
		{
			TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
			if (tileEntity instanceof TileDNADecoder)
				return new GuiDNADecoder(player.inventory, (TileDNADecoder) tileEntity);
			else if (tileEntity instanceof TileDeExtinctionMachine)
				return new GuiDeExtinctionMachine(player.inventory, (TileDeExtinctionMachine) tileEntity);
			else if (tileEntity instanceof TileCleaningTable)
				return new GuiCleaningTable(player.inventory, (TileCleaningTable) tileEntity);
			else if (tileEntity instanceof TileDNAExtractor)
				return new GuiDNAExtractor(player.inventory, (TileDNAExtractor) tileEntity);
			else if (tileEntity instanceof TileDNAEditor)
				return new GuiDNAEditor(player.inventory, (TileDNAEditor) tileEntity);
			else if (tileEntity instanceof TileMicroscope)
				return new GuiMicroscope(player.inventory, (TileMicroscope) tileEntity);
		}
		else if (ID == ID_ENTITY)
		{

		}
		else if (ID == ID_ITEM_CREATIVE)
		{
			return new GuiItemDeExtinction();
		}

		System.err.println("ERROR: Invalid ID: " + ID);
		return null;
	}

	/**
	 * Registers the GUI Handler.
	 */
	public static void registerGUIHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(DeExtinction.instance, new DeGuiHandler());
	}
}
