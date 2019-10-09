package com.deextinction.block.machines;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.DeExtinction;
import com.deextinction.block.BlockContainerHorizontal;
import com.deextinction.tileentities.TileMicroscope;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityHusk;
import net.minecraft.entity.monster.EntityIllusionIllager;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntityShulker;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityStray;
import net.minecraft.entity.monster.EntityVex;
import net.minecraft.entity.monster.EntityVindicator;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMicroscope extends BlockContainerHorizontal
{

	public BlockMicroscope(float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(hardness, resistance, material, soundType, tab);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileMicroscope();
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	public static enum MicroscopeSample implements IStringSerializable
	{
		NONE(0, "none", 1.0D, EntitySnowman.class, EntityIronGolem.class, EntityWitherSkeleton.class, EntitySkeleton.class, EntitySkeletonHorse.class, EntityStray.class, EntityBlaze.class, EntityShulker.class),
		BLOOD(1, "blood", 1.0D, EntityGhast.class, EntityDonkey.class, EntityMule.class, EntityPigZombie.class, EntityDragon.class, EntityBat.class, EntityWitch.class, EntityGuardian.class, EntityElderGuardian.class, EntityPig.class, EntitySheep.class, EntityCow.class, EntityChicken.class, EntitySquid.class, EntityWolf.class, EntityMooshroom.class, EntityOcelot.class, EntityHorse.class, EntityRabbit.class, EntityPolarBear.class, EntityLlama.class, EntityParrot.class, EntityVillager.class),
		BLOOD_DECAYED(2, "blood_decayed", 1.0D, EntityHusk.class, EntityZombieVillager.class, EntityZombieHorse.class, EntityZombie.class, EntityGiantZombie.class, EntityEvoker.class, EntityVex.class, EntityVindicator.class, EntityIllusionIllager.class),
		HEMOLYMPH(3, "hemolymph", 1.0D, EntitySpider.class, EntitySilverfish.class, EntityCaveSpider.class),
		BLOOD_ENDER(4, "blood_ender", 1.0D, EntityEndermite.class, EntityEnderman.class),
		SLIME(5, "blood_slime", 0.2D, EntitySlime.class, EntityMagmaCube.class),
		BLOOD_CREEPER(6, "blood_creeper", 1.0D, EntityCreeper.class),
		BLOOD_WITHER(7, "blood_wither", 1.0D, EntityWither.class);

		private MicroscopeSample(int metadata, String unlocalizedName, double friction, Class... clazzes)
		{
			this.metadata = metadata;
			this.unlocalizedName = unlocalizedName;
			this.friction = friction;
			this.entityList = new ArrayList<String>();
			for (Class clazz : clazzes)
				this.entityList.add(DeExtinction.getNameFromEntityClass(clazz));
		}

		public int getMetadata()
		{
			return this.metadata;
		}

		public double getFriction()
		{
			return this.friction;
		}

		public List<String> getEntityList()
		{
			return this.entityList;
		}

		@Override
		public String getName()
		{
			return this.unlocalizedName;
		}

		@Override
		public String toString()
		{
			return this.unlocalizedName;
		}

		public static BlockMicroscope.MicroscopeSample byMetadata(int meta)
		{
			if (meta < 0 || meta >= BlockMicroscope.MicroscopeSample.META_LOOKUP.length)
				meta = 0;

			return BlockMicroscope.MicroscopeSample.META_LOOKUP[meta];
		}

		private final int metadata;
		private final double friction;
		private final String unlocalizedName;
		private final List<String> entityList;
		private static final BlockMicroscope.MicroscopeSample[] META_LOOKUP = new BlockMicroscope.MicroscopeSample[values().length];
		static
		{
			for (MicroscopeSample samples : values())
				BlockMicroscope.MicroscopeSample.META_LOOKUP[samples.getMetadata()] = samples;
		}
	}
}
