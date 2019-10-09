package com.deextinction.world.gen.structures.villagers;

import java.util.List;
import java.util.Random;

import com.deextinction.DeExtinction;
import com.deextinction.init.DeVillagerRegistry;
import com.deextinction.util.MathHelper;
import com.deextinction.world.DeBlockProcessorVillageResearchLab;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

/**
 * Structure Block (Left corner) pointing to North and House entrance pointing
 * to South!
 * 
 * @author rafa_
 *
 */
public class VillageResearchLabComponent extends StructureVillagePieces.Village
{
	public static final ResourceLocation RESEARCH_LAB_CHEST = LootTableList.register(new ResourceLocation(DeExtinction.MODID, "village/research_lab_0"));
	public static final ResourceLocation RESEARCH_LAB_STRUCTURE = new ResourceLocation(DeExtinction.MODID, "researchlab");

	public static final int SIZE_X = 13;
	public static final int SIZE_Y = 8;
	public static final int SIZE_Z = 15;
	public static final int OFFSET_Y = -1;
	public static final int MAX_VILLAGERS = 2;

	public EnumFacing coordBaseMode;
	public Rotation rotation;
	public Mirror mirror;
	public int villagerCount;

	public VillageResearchLabComponent()
	{

	}

	public VillageResearchLabComponent(StructureVillagePieces.Start start, int type, StructureBoundingBox boundingBox, EnumFacing facing)
	{
		super(start, type);
		this.setCoordBaseMode(facing);
		this.boundingBox = boundingBox;
		this.villagerCount = 0;
	}

	@Override
	public void setCoordBaseMode(EnumFacing facing)
	{
		super.setCoordBaseMode(facing);
		this.coordBaseMode = facing;
		this.mirror = MathHelper.RAND.nextBoolean() ? Mirror.NONE : Mirror.LEFT_RIGHT;

		if (this.mirror == Mirror.NONE)
		{
			switch (facing)
			{
				case EAST:
					this.rotation = Rotation.CLOCKWISE_90;
					break;
				case SOUTH:
					this.rotation = Rotation.CLOCKWISE_180;
					break;
				case WEST:
					this.rotation = Rotation.COUNTERCLOCKWISE_90;
					break;
				default:
					this.rotation = Rotation.NONE;
					break;
			}
		}
		else if (this.mirror == Mirror.LEFT_RIGHT)
		{
			switch (facing)
			{
				case EAST:
					this.rotation = Rotation.COUNTERCLOCKWISE_90;
					break;
				case SOUTH:
					this.rotation = Rotation.NONE;
					break;
				case WEST:
					this.rotation = Rotation.CLOCKWISE_90;
					break;
				default:
					this.rotation = Rotation.CLOCKWISE_180;
					break;
			}
		}
	}

	@Override
	public boolean addComponentParts(World world, Random random, StructureBoundingBox bounds)
	{
		if (world == null)
			return false;

		TemplateManager templateManager = world.getSaveHandler().getStructureTemplateManager();
		PlacementSettings settings = new PlacementSettings().setRotation(this.rotation).setMirror(this.mirror);
		Template template = templateManager.getTemplate(world.getMinecraftServer(), VillageResearchLabComponent.RESEARCH_LAB_STRUCTURE);
		template.setAuthor("RafaMv");

		if (this.averageGroundLvl < 0)
		{
			this.averageGroundLvl = this.getAverageGroundLevel(world, bounds);
			if (this.averageGroundLvl < 0)
				return false;

			this.boundingBox.offset(0, this.averageGroundLvl - this.boundingBox.maxY + VillageResearchLabComponent.SIZE_Y + VillageResearchLabComponent.OFFSET_Y, 0);
		}

		BlockPos generationPosition = new BlockPos(this.boundingBox.minX, this.boundingBox.minY, this.boundingBox.minZ);
		if (this.mirror == Mirror.NONE)
		{
			switch (this.coordBaseMode)
			{
				case EAST:
					generationPosition = new BlockPos(this.getXWithOffset(0, template.getSize().getZ()), this.getYWithOffset(VillageResearchLabComponent.OFFSET_Y), this.getZWithOffset(0, 0));
					break;
				case SOUTH:
					generationPosition = new BlockPos(this.getXWithOffset(template.getSize().getX(), 0), this.getYWithOffset(VillageResearchLabComponent.OFFSET_Y), this.getZWithOffset(0, template.getSize().getZ()));
					break;
				case WEST:
					generationPosition = new BlockPos(this.getXWithOffset(0, template.getSize().getZ()), this.getYWithOffset(VillageResearchLabComponent.OFFSET_Y), this.getZWithOffset(template.getSize().getX(), 0));
					break;
				default:
					generationPosition = new BlockPos(this.getXWithOffset(0, 0), this.getYWithOffset(VillageResearchLabComponent.OFFSET_Y), this.getZWithOffset(0, template.getSize().getZ()));
					break;
			}
		}
		else if (this.mirror == Mirror.LEFT_RIGHT)
		{
			int roadCorrectionX = -1;

			switch (this.coordBaseMode)
			{
				case EAST:
					generationPosition = new BlockPos(this.getXWithOffset(0, template.getSize().getZ()), this.getYWithOffset(VillageResearchLabComponent.OFFSET_Y), this.getZWithOffset(template.getSize().getX() + roadCorrectionX, 0));
					break;
				case SOUTH:
					generationPosition = new BlockPos(this.getXWithOffset(0, 0), this.getYWithOffset(VillageResearchLabComponent.OFFSET_Y), this.getZWithOffset(0, template.getSize().getZ()));
					break;
				case WEST:
					generationPosition = new BlockPos(this.getXWithOffset(0, template.getSize().getZ()), this.getYWithOffset(VillageResearchLabComponent.OFFSET_Y), this.getZWithOffset(0, 0));
					break;
				default:
					generationPosition = new BlockPos(this.getXWithOffset(template.getSize().getX() + roadCorrectionX, 0), this.getYWithOffset(VillageResearchLabComponent.OFFSET_Y), this.getZWithOffset(0, template.getSize().getZ()));
					break;
			}
		}

		settings.setBoundingBox(this.boundingBox);
		template.addBlocksToWorld(world, generationPosition, new DeBlockProcessorVillageResearchLab(generationPosition, settings, VillageResearchLabComponent.RESEARCH_LAB_CHEST, this, world.getBiome(generationPosition)), settings, 2);

		if (this.villagerCount == 0)
		{
			for (int i = 0; i < VillageResearchLabComponent.MAX_VILLAGERS; i++)
			{
				if (random.nextBoolean())
				{
					EntityVillager villager = new EntityVillager(world);
					villager.setProfession(DeVillagerRegistry.RESEARCHER_PROFESSION);
					villager.setLocationAndAngles(generationPosition.getX() + 0.5D, generationPosition.getY() + 1.0D, generationPosition.getZ() + 0.5D, (1.0F - 2.0F * random.nextFloat()) * 180.0F, 0.0F);
					world.spawnEntity(villager);
					this.villagerCount++;
				}
			}
		}

		return true;
	}

	public EnumFacing rotateFacing(EnumFacing facing, boolean clockwise)
	{
		if (clockwise)
			return facing.rotateY();
		else
			return facing.rotateYCCW();
	}

	protected VillagerRegistry.VillagerProfession chooseForgeProfession(int count, VillagerRegistry.VillagerProfession profession)
	{
		return VillagerRegistry.getById(chooseProfession(count, VillagerRegistry.getId(profession)));
	}

	public static class VillageResearchLabHandler implements VillagerRegistry.IVillageCreationHandler
	{
		public static final VillageResearchLabHandler VILLAGE_RESEARCH_LAB_HANDLER = new VillageResearchLabHandler();
		public static final int WEIGHT = 35;
		public static final int COUNT = 1;

		@Override
		public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int size)
		{
			return new StructureVillagePieces.PieceWeight(VillageResearchLabComponent.class, VillageResearchLabHandler.WEIGHT, VillageResearchLabHandler.COUNT);
		}

		@Override
		public Class<?> getComponentClass()
		{
			return VillageResearchLabComponent.class;
		}

		@Override
		public StructureVillagePieces.Village buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List<StructureComponent> pieces, Random random, int minX, int minY, int minZ, EnumFacing facing, int componentType)
		{
			StructureBoundingBox bounds = StructureBoundingBox.getComponentToAddBoundingBox(minX, minY, minZ, 0, 0, 0, VillageResearchLabComponent.SIZE_X, VillageResearchLabComponent.SIZE_Y, VillageResearchLabComponent.SIZE_Z, facing);
			return StructureComponent.findIntersecting(pieces, bounds) == null ? new VillageResearchLabComponent(startPiece, componentType, bounds, facing) : null;
		}
	}
}
