package com.deextinction.client.renderer.tileentity;

import com.deextinction.ClientOnlyProxy;
import com.deextinction.block.machines.BlockCleaningTable;
import com.deextinction.init.DeBlocks;
import com.deextinction.tileentities.TileCleaningTable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class RenderCleaningTable extends TileEntitySpecialRenderer<TileCleaningTable>
{

	@Override
	public void render(TileCleaningTable tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		IBlockState state = tileEntity.getWorld().getBlockState(tileEntity.getPos());
		if (state.getBlock() == DeBlocks.cleaning_table_block)
		{
			ClientOnlyProxy.MC.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
			RenderItem renderItem = ClientOnlyProxy.MC.getRenderItem();

			float scale = 0.25F;
			EnumFacing value = state.getValue(BlockCleaningTable.FACING);
			if (value == EnumFacing.NORTH || value == EnumFacing.SOUTH)
				value = value.getOpposite();

			GlStateManager.pushMatrix();

			GlStateManager.translate(x + 0.5F, y + 1.2F, z + 0.5F);
			GlStateManager.rotate(90 * value.getHorizontalIndex(), 0.0F, 1.0F, 0.0F);
			GlStateManager.scale(-scale, -scale, scale);
			GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);

			ItemStack itemStack = tileEntity.getStackInSlot(TileCleaningTable.SLOT_INDEX_BRUSH);
			if (!itemStack.isEmpty())
			{
				GlStateManager.pushMatrix();
				GlStateManager.translate(-0.25F / scale, 0.25F / scale, 0.0F);
				renderItem.renderItem(itemStack, renderItem.getItemModelMesher().getItemModel(itemStack));
				GlStateManager.popMatrix();
			}

			itemStack = tileEntity.getStackInSlot(TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY);
			if (!itemStack.isEmpty())
			{
				GlStateManager.pushMatrix();
				GlStateManager.translate(0.0F, 0.25F / scale, 0.0F);
				renderItem.renderItem(itemStack, renderItem.getItemModelMesher().getItemModel(itemStack));
				GlStateManager.popMatrix();
			}

			GlStateManager.translate(-0.25F / scale, -0.05F / scale, -0.2F / scale);

			scale = 1.0F / scale;
			GlStateManager.scale(scale, scale, scale);

			scale = 0.125F;
			GlStateManager.scale(scale, scale, scale);

			for (int index = 2; index < tileEntity.getSlots().size(); index++)
			{
				itemStack = tileEntity.getStackInSlot(index);
				if (!itemStack.isEmpty())
				{
					GlStateManager.pushMatrix();
					if (index > 6)
						GlStateManager.translate((0.075F + 0.125F * (index - 7)) / scale, -0.2F / scale, 0.0F);
					else
						GlStateManager.translate((0.0F + 0.125F * (index - 2)) / scale, 0.0F, 0.0F);

					renderItem.renderItem(itemStack, renderItem.getItemModelMesher().getItemModel(itemStack));
					GlStateManager.popMatrix();
				}
			}

			GlStateManager.popMatrix();
		}
	}
}
