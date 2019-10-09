package com.deextinction.client.renderer.tileentity;

import com.deextinction.ClientOnlyProxy;
import com.deextinction.block.BlockFossilBroken;
import com.deextinction.database.FossilRenderInfo;
import com.deextinction.tileentities.TileFossilBroken;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class RenderFossilBroken extends TileEntitySpecialRenderer<TileEntity>
{

	@Override
	public void render(TileEntity tileEntity, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		if (tileEntity instanceof TileFossilBroken)
		{
			TileFossilBroken fossilBroken = (TileFossilBroken) tileEntity;
			if (fossilBroken.hasFossilInfo())
			{
				FossilRenderInfo fossilInfo = fossilBroken.getFossilInfo();
				float scale = 0.5F;
				float uniquePosX = fossilBroken.getUniquePosition1();
				float uniquePosZ = fossilBroken.getUniquePosition2();
				float uniqueRot = fossilBroken.getUniqueRotation();

				GlStateManager.pushMatrix();

				EnumFacing facing = fossilBroken.getWorld().getBlockState(fossilBroken.getPos()).getValue(BlockFossilBroken.FACING);
				switch (facing)
				{
					case NORTH:
						GlStateManager.translate(x + 0.5F, y + 0.5F, z + 0.375F);
						GlStateManager.rotate(90.0F, -1.0F, 0.0F, 0.0F);
						GlStateManager.translate(uniquePosX, 0.0F, uniquePosZ);
						GlStateManager.rotate(uniqueRot, 0.0F, 1.0F, 0.0F);
						GlStateManager.scale(scale, scale, scale);
						break;
					case SOUTH:
						GlStateManager.translate(x + 0.5F, y + 0.5F, z + 0.625F);
						GlStateManager.rotate(90.0F, -1.0F, 0.0F, 0.0F);
						GlStateManager.translate(uniquePosX, 0.0F, uniquePosZ);
						GlStateManager.rotate(uniqueRot, 0.0F, 1.0F, 0.0F);
						GlStateManager.scale(scale, scale, scale);
						break;
					case EAST:
						GlStateManager.translate(x + 0.625F, y + 0.5F, z + 0.5F);
						GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
						GlStateManager.translate(uniquePosX, 0.0F, uniquePosZ);
						GlStateManager.rotate(uniqueRot, 0.0F, 1.0F, 0.0F);
						GlStateManager.scale(scale, scale, scale);
						break;
					case WEST:
						GlStateManager.translate(x + 0.375F, y + 0.5F, z + 0.5F);
						GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
						GlStateManager.translate(uniquePosX, 0.0F, uniquePosZ);
						GlStateManager.rotate(uniqueRot, 0.0F, 1.0F, 0.0F);
						GlStateManager.scale(scale, scale, scale);
						break;
					case DOWN:
						GlStateManager.translate(x + 0.5F, y + 0.375F, z + 0.5F);
						GlStateManager.translate(uniquePosX, 0.0F, uniquePosZ);
						GlStateManager.rotate(uniqueRot, 0.0F, 1.0F, 0.0F);
						GlStateManager.scale(scale, scale, scale);
						break;
					case UP:
						GlStateManager.translate(x + 0.5F, y + 0.625F, z + 0.5F);
						GlStateManager.translate(uniquePosX, 0.0F, uniquePosZ);
						GlStateManager.rotate(uniqueRot, 0.0F, 1.0F, 0.0F);
						GlStateManager.scale(scale, scale, scale);
						break;
				}

				ClientOnlyProxy.MC.getTextureManager().bindTexture(fossilInfo.getTexture());
				fossilInfo.getModel().render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);

				GlStateManager.popMatrix();
			}
			else
			{
				ItemStack fossilStack = fossilBroken.getFossilStack();
				if (!fossilStack.isEmpty())
				{
					ClientOnlyProxy.MC.getTextureManager().bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
					RenderItem renderItem = ClientOnlyProxy.MC.getRenderItem();
					float scale = fossilBroken.getUniqueScale();
					float uniquePosX = fossilBroken.getUniquePosition1();
					float uniquePosZ = fossilBroken.getUniquePosition2();
					float uniqueRot = fossilBroken.getUniqueRotation();

					GlStateManager.pushMatrix();

					EnumFacing facing = fossilBroken.getWorld().getBlockState(fossilBroken.getPos()).getValue(BlockFossilBroken.FACING);
					switch (facing)
					{
						case NORTH:
							GlStateManager.translate(x + 0.5F, y + 0.5F, z + 0.375F);
							GlStateManager.rotate(90.0F, 0.0F, 0.0F, -1.0F);
							GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
							GlStateManager.translate(uniquePosX, uniquePosZ, 0.0F);
							GlStateManager.rotate(uniqueRot, 0.0F, 0.0F, -1.0F);
							GlStateManager.scale(scale, scale, scale);
							break;
						case SOUTH:
							GlStateManager.translate(x + 0.5F, y + 0.5F, z + 0.625F);
							GlStateManager.rotate(90.0F, 0.0F, 0.0F, -1.0F);
							GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
							GlStateManager.translate(uniquePosX, uniquePosZ, 0.0F);
							GlStateManager.rotate(uniqueRot, 0.0F, 0.0F, -1.0F);
							GlStateManager.scale(scale, scale, scale);
							break;
						case EAST:
							GlStateManager.translate(x + 0.625F, y + 0.5F, z + 0.5F);
							GlStateManager.rotate(90.0F, 0.0F, -1.0F, 0.0F);
							GlStateManager.translate(uniquePosX, uniquePosZ, 0.0F);
							GlStateManager.rotate(uniqueRot, 0.0F, 0.0F, -1.0F);
							GlStateManager.scale(scale, scale, scale);
							break;
						case WEST:
							GlStateManager.translate(x + 0.375F, y + 0.5F, z + 0.5F);
							GlStateManager.rotate(90.0F, 0.0F, -1.0F, 0.0F);
							GlStateManager.translate(uniquePosX, uniquePosZ, 0.0F);
							GlStateManager.rotate(uniqueRot, 0.0F, 0.0F, -1.0F);
							GlStateManager.scale(scale, scale, scale);
							break;
						case DOWN:
							GlStateManager.translate(x + 0.5F, y + 0.375F, z + 0.5F);
							GlStateManager.rotate(90.0F, -1.0F, 0.0F, 0.0F);
							GlStateManager.translate(uniquePosX, uniquePosZ, 0.0F);
							GlStateManager.rotate(uniqueRot, 0.0F, 0.0F, -1.0F);
							GlStateManager.scale(scale, scale, scale);
							break;
						case UP:
							GlStateManager.translate(x + 0.5F, y + 0.625F, z + 0.5F);
							GlStateManager.rotate(90.0F, -1.0F, 0.0F, 0.0F);
							GlStateManager.translate(uniquePosX, uniquePosZ, 0.0F);
							GlStateManager.rotate(uniqueRot, 0.0F, 0.0F, -1.0F);
							GlStateManager.scale(scale, scale, scale);
							break;
					}

					renderItem.renderItem(fossilStack, renderItem.getItemModelMesher().getItemModel(fossilStack));

					GlStateManager.popMatrix();
				}
			}
		}
	}
}
