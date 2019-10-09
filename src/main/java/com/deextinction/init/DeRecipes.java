package com.deextinction.init;

import com.deextinction.DeExtinction;

import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DeRecipes
{

	public static void initRecipes()
	{
		ResourceLocation deGroup = new ResourceLocation("de_extinction_group");
		GameRegistry.addShapedRecipe(new ResourceLocation(DeExtinction.prependModID("de_recipe_" + "name")), deGroup, new ItemStack(Items.ENDER_EYE), new Object[] { "AAA", "BBB", "AAA", 'A', Items.BONE, 'B', new ItemStack(Items.DYE, 1, EnumDyeColor.RED.getDyeDamage()) });
	}
}
