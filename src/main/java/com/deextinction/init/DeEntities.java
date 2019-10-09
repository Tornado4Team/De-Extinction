package com.deextinction.init;

import com.deextinction.DeExtinction;
import com.deextinction.client.renderer.entity.RenderArchaeorhynchus;
import com.deextinction.client.renderer.entity.RenderArctotherium;
import com.deextinction.client.renderer.entity.RenderBasilosaurus;
import com.deextinction.client.renderer.entity.RenderCanisNehringi;
import com.deextinction.client.renderer.entity.RenderFailChicken;
import com.deextinction.client.renderer.entity.RenderFailCow;
import com.deextinction.client.renderer.entity.RenderFailOcelot;
import com.deextinction.client.renderer.entity.RenderFailSheep;
import com.deextinction.client.renderer.entity.RenderGlyptodon;
import com.deextinction.client.renderer.entity.RenderKelenken;
import com.deextinction.client.renderer.entity.RenderLivyatan;
import com.deextinction.client.renderer.entity.RenderMacrauchenia;
import com.deextinction.client.renderer.entity.RenderSebecus;
import com.deextinction.client.renderer.entity.RenderSmilodon;
import com.deextinction.client.renderer.entity.RenderTheriodictis;
import com.deextinction.client.renderer.entity.RenderToxodon;
import com.deextinction.client.renderer.entity.RenderTroodon;
import com.deextinction.database.animals.Archaeorhynchus;
import com.deextinction.database.animals.Arctotherium;
import com.deextinction.database.animals.Basilosaurus;
import com.deextinction.database.animals.CanisNehringi;
import com.deextinction.database.animals.Glyptodon;
import com.deextinction.database.animals.Kelenken;
import com.deextinction.database.animals.Livyatan;
import com.deextinction.database.animals.Macrauchenia;
import com.deextinction.database.animals.Sebecus;
import com.deextinction.database.animals.Smilodon;
import com.deextinction.database.animals.Theriodictis;
import com.deextinction.database.animals.Toxodon;
import com.deextinction.database.animals.Troodon;
import com.deextinction.entity.animal.EntityArchaeorhynchus;
import com.deextinction.entity.animal.EntityArctotherium;
import com.deextinction.entity.animal.EntityBasilosaurus;
import com.deextinction.entity.animal.EntityCanisNehringi;
import com.deextinction.entity.animal.EntityGlyptodon;
import com.deextinction.entity.animal.EntityKelenken;
import com.deextinction.entity.animal.EntityLivyatan;
import com.deextinction.entity.animal.EntityMacrauchenia;
import com.deextinction.entity.animal.EntitySebecus;
import com.deextinction.entity.animal.EntitySmilodon;
import com.deextinction.entity.animal.EntityTheriodictis;
import com.deextinction.entity.animal.EntityToxodon;
import com.deextinction.entity.animal.EntityTroodon;
import com.deextinction.entity.fail.EntityChickenFail;
import com.deextinction.entity.fail.EntityCowFail;
import com.deextinction.entity.fail.EntityOcelotFail;
import com.deextinction.entity.fail.EntitySheepFail;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DeEntities
{
	private static int NEXT_ID = 0;

	public static void preInitEntities()
	{
		DeEntities.registerEntity(Archaeorhynchus.NAME, EntityArchaeorhynchus.class, 64, 0, 0);
		DeEntities.registerEntity(Troodon.NAME, EntityTroodon.class, 64, 0, 0);
		DeEntities.registerEntity(Smilodon.NAME, EntitySmilodon.class, 64, 0, 0);
		DeEntities.registerEntity(Macrauchenia.NAME, EntityMacrauchenia.class, 64, 0, 0);
		DeEntities.registerEntity(Kelenken.NAME, EntityKelenken.class, 64, 0, 0);
		DeEntities.registerEntity(Arctotherium.NAME, EntityArctotherium.class, 64, 0, 0);
		DeEntities.registerEntity(Basilosaurus.NAME, EntityBasilosaurus.class, 64, 0, 0);
		DeEntities.registerEntity(CanisNehringi.NAME, EntityCanisNehringi.class, 64, 0, 0);
		DeEntities.registerEntity(Glyptodon.NAME, EntityGlyptodon.class, 64, 0, 0);
		DeEntities.registerEntity(Livyatan.NAME, EntityLivyatan.class, 64, 0, 0);
		DeEntities.registerEntity(Sebecus.NAME, EntitySebecus.class, 64, 0, 0);
		DeEntities.registerEntity(Theriodictis.NAME, EntityTheriodictis.class, 64, 0, 0);
		DeEntities.registerEntity(Toxodon.NAME, EntityToxodon.class, 64, 0, 0);
	}

	public static void preInitEntityRenderers()
	{

		RenderingRegistry.registerEntityRenderingHandler(EntityArchaeorhynchus.class, new IRenderFactory<EntityArchaeorhynchus>()
		{
			@Override
			public Render<? super EntityArchaeorhynchus> createRenderFor(RenderManager manager)
			{
				return new RenderArchaeorhynchus(manager);
			}
		});	

		RenderingRegistry.registerEntityRenderingHandler(EntityTroodon.class, new IRenderFactory<EntityTroodon>()
		{
			@Override
			public Render<? super EntityTroodon> createRenderFor(RenderManager manager)
			{
				return new RenderTroodon(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityMacrauchenia.class, new IRenderFactory<EntityMacrauchenia>()
		{
			@Override
			public Render<? super EntityMacrauchenia> createRenderFor(RenderManager manager)
			{
				return new RenderMacrauchenia(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntitySmilodon.class, new IRenderFactory<EntitySmilodon>()
		{
			@Override
			public Render<? super EntitySmilodon> createRenderFor(RenderManager manager)
			{
				return new RenderSmilodon(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityKelenken.class, new IRenderFactory<EntityKelenken>()
		{
			@Override
			public Render<? super EntityKelenken> createRenderFor(RenderManager manager)
			{
				return new RenderKelenken(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityArctotherium.class, new IRenderFactory<EntityArctotherium>()
		{
			@Override
			public Render<? super EntityArctotherium> createRenderFor(RenderManager manager)
			{
				return new RenderArctotherium(manager);
			}
		});

		RenderingRegistry.registerEntityRenderingHandler(EntityBasilosaurus.class, new IRenderFactory<EntityBasilosaurus>()
		{
			@Override
			public Render<? super EntityBasilosaurus> createRenderFor(RenderManager manager)
			{
				return new RenderBasilosaurus(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityCanisNehringi.class, new IRenderFactory<EntityCanisNehringi>()
		{
			@Override
			public Render<? super EntityCanisNehringi> createRenderFor(RenderManager manager)
			{
				return new RenderCanisNehringi(manager);
			}
		});
		RenderingRegistry.registerEntityRenderingHandler(EntityGlyptodon.class, new IRenderFactory<EntityGlyptodon>()
		{
			@Override
			public Render<? super EntityGlyptodon> createRenderFor(RenderManager manager)
			{
				return new RenderGlyptodon(manager);}});

		RenderingRegistry.registerEntityRenderingHandler(EntityLivyatan.class, new IRenderFactory<EntityLivyatan>()
		{
			@Override
			public Render<? super EntityLivyatan> createRenderFor(RenderManager manager)
			{
				return new RenderLivyatan(manager);}});

		RenderingRegistry.registerEntityRenderingHandler(EntitySebecus.class, new IRenderFactory<EntitySebecus>()
		{
			@Override
			public Render<? super EntitySebecus> createRenderFor(RenderManager manager)
			{
				return new RenderSebecus(manager);}});

		RenderingRegistry.registerEntityRenderingHandler(EntityTheriodictis.class, new IRenderFactory<EntityTheriodictis>()
		{
			@Override
			public Render<? super EntityTheriodictis> createRenderFor(RenderManager manager)
			{return new RenderTheriodictis(manager);}});

		RenderingRegistry.registerEntityRenderingHandler(EntityToxodon.class, new IRenderFactory<EntityToxodon>()
		{
			@Override
			public Render<? super EntityToxodon> createRenderFor(RenderManager manager)
			{return new RenderToxodon(manager);}});
	}

	private static void registerEntity(String name, Class<? extends Entity> entity, int range)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(DeExtinction.prependModID(name)), entity, name, DeEntities.NEXT_ID++, DeExtinction.instance, range, 1, true);
	}

	private static void registerEntity(String name, Class<? extends Entity> entity, int range, int color, int subcolor)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(DeExtinction.prependModID(name)), entity, name, DeEntities.NEXT_ID++, DeExtinction.instance, range, 1, true, color, subcolor);
	}

	private static void registerEntityRenderer(Class EntityClass, IRenderFactory renderer)
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityClass, renderer);
	}
}
