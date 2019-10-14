package com.deextinction.init;

import java.util.HashMap;
import java.util.Locale;

import com.deextinction.database.DeExtincted;
import com.deextinction.database.ISyringe;
import com.deextinction.item.ItemBasic;
import com.deextinction.item.ItemBrush;
import com.deextinction.item.ItemDNABottle;
import com.deextinction.item.ItemFloppyDisk;
import com.deextinction.item.ItemFloppyDiskEmpty;
import com.deextinction.item.ItemFossilClean;
import com.deextinction.item.ItemFossilDirty;
import com.deextinction.item.ItemGuide;
import com.deextinction.item.ItemRockPick;
import com.deextinction.item.ItemSyringe;
import com.deextinction.item.ItemSyringeBlood;
import com.deextinction.item.ItemSyringeMammal;

import net.minecraft.item.Item;

public class DeItems
{
	public static HashMap<String, ItemFossilDirty> fossils_dirty = new HashMap<String, ItemFossilDirty>();
	public static HashMap<String, ItemFossilClean> fossils_clean = new HashMap<String, ItemFossilClean>();
	public static HashMap<String, ItemDNABottle> dna_bottles = new HashMap<String, ItemDNABottle>();
	public static HashMap<String, ItemFloppyDisk> dna_floppy_disks = new HashMap<String, ItemFloppyDisk>();
	public static HashMap<String, ItemSyringeMammal> syringes = new HashMap<String, ItemSyringeMammal>();

	public static ItemFloppyDiskEmpty dna_floppy_disk_empty = new ItemFloppyDiskEmpty(DeCreativeTabs.items);
	public static ItemRockPick rockpick = new ItemRockPick(DeCreativeTabs.items);
	public static ItemBrush brush = new ItemBrush(DeCreativeTabs.items);
	public static ItemSyringe syringe = new ItemSyringe(DeCreativeTabs.items);
	public static ItemSyringeBlood syringe_blood = new ItemSyringeBlood(null);
	
	
	public static ItemGuide guide = new ItemGuide(DeCreativeTabs.items);

	public static void preInitItems()
	{
		DeItems.registerItem(DeItems.dna_floppy_disk_empty, "item_floppy_disk_empty");
		DeItems.registerItem(DeItems.rockpick, "item_rockpick");
		DeItems.registerItem(DeItems.brush, "item_brush");
		DeItems.registerItem(DeItems.guide, "item_guide");
		DeItems.registerItem(DeItems.syringe, "item_syringe");
		DeItems.registerItem(DeItems.syringe_blood, "item_syringe_blood");

		// Items from DeExtincted is automatically registered
		for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
		{
			String deExtinctedName = deExtincted.getName();

			ItemFossilDirty fossil_dirty = new ItemFossilDirty(deExtincted, DeCreativeTabs.research);
			DeItems.fossils_dirty.put(deExtinctedName, fossil_dirty);
			DeItems.registerItem(fossil_dirty, "item_fossil_dirty_" + deExtinctedName);

			ItemFossilClean fossil_clean = new ItemFossilClean(deExtincted, DeCreativeTabs.research);
			DeItems.fossils_clean.put(deExtinctedName, fossil_clean);
			DeItems.registerItem(fossil_clean, "item_fossil_clean_" + deExtinctedName);

			ItemDNABottle dna_bottle = new ItemDNABottle(deExtincted, DeCreativeTabs.research);
			DeItems.dna_bottles.put(deExtinctedName, dna_bottle);
			DeItems.registerItem(dna_bottle, "item_dna_bottle_" + deExtinctedName);

			ItemFloppyDisk dna_floppy_disk = new ItemFloppyDisk(deExtincted, DeCreativeTabs.research);
			DeItems.dna_floppy_disks.put(deExtinctedName, dna_floppy_disk);
			DeItems.registerItem(dna_floppy_disk, "item_floppy_disk_" + deExtinctedName);

			if (deExtincted instanceof ISyringe)
			{
				ItemSyringeMammal syringe = new ItemSyringeMammal(deExtincted, DeCreativeTabs.items);
				DeItems.syringes.put(deExtinctedName, syringe);
				DeItems.registerItem(syringe, "item_syringe_" + deExtinctedName);
			}
		}

		// Remember to add item renderer in DeRendering class;
	}

	public static void postInitOreDictionaryItems()
	{

	}

	public static void registerItem(Item item, String unlocalized_name)
	{
		String formattedName = unlocalized_name.toLowerCase(Locale.ENGLISH).replaceAll(" ", "_").replaceAll("'", "");
		item.setUnlocalizedName(formattedName);
		DeRegistry.registerItem(item, formattedName);
	}
}
