package com.deextinction.deextinction.util.handler;

import com.deextinction.deextinction.entity.creature.cenozoic.CarnivoresMammals.EntityArctotherium;
import com.deextinction.deextinction.entity.creature.cenozoic.CarnivoresMammals.EntitySmilodon;
import com.deextinction.deextinction.entity.creature.cenozoic.CarnivorousBirds.EntityKelenken;
import com.deextinction.deextinction.entity.creature.cenozoic.HerbMammals.EntityGlyptodon;
import com.deextinction.deextinction.entity.creature.cenozoic.Reptiles.EntitySebecus;
import com.deextinction.deextinction.entity.creature.defectum.EntityCreepy;
import com.deextinction.deextinction.entity.creature.defectum.EntityFisko;
import com.deextinction.deextinction.entity.creature.defectum.EntityJai;
import com.deextinction.deextinction.entity.creature.defectum.EntityJohn;
import com.deextinction.deextinction.entity.creature.defectum.EntityLucas;
import com.deextinction.deextinction.entity.creature.defectum.EntityRafa;
import com.deextinction.deextinction.entity.creature.defectum.EntityRuroni;
import com.deextinction.deextinction.entity.creature.defectum.EntityZeinner;
import com.deextinction.deextinction.entity.render.RenderArctotherium;
import com.deextinction.deextinction.entity.render.RenderCreepy;
import com.deextinction.deextinction.entity.render.RenderFisko;
import com.deextinction.deextinction.entity.render.RenderGlyptodon;
import com.deextinction.deextinction.entity.render.RenderJai;
import com.deextinction.deextinction.entity.render.RenderJohn;
import com.deextinction.deextinction.entity.render.RenderKelenken;
import com.deextinction.deextinction.entity.render.RenderLucas;
import com.deextinction.deextinction.entity.render.RenderRafa;
import com.deextinction.deextinction.entity.render.RenderRuroni;
import com.deextinction.deextinction.entity.render.RenderSebecus;
import com.deextinction.deextinction.entity.render.RenderSmilodon;
import com.deextinction.deextinction.entity.render.RenderZeinner;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityKelenken.class, new IRenderFactory<EntityKelenken>()
		{
			@Override
			public Render<? super EntityKelenken> createRenderFor(RenderManager manager)
			{
				return new RenderKelenken(manager);
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
		
		RenderingRegistry.registerEntityRenderingHandler(EntityFisko.class, new IRenderFactory<EntityFisko>()
		{
			@Override
			public Render<? super EntityFisko> createRenderFor(RenderManager manager)
			{
				return new RenderFisko(manager);
			}
	    });

		RenderingRegistry.registerEntityRenderingHandler(EntityJai.class, new IRenderFactory<EntityJai>()
		{
			@Override
			public Render<? super EntityJai> createRenderFor(RenderManager manager)
			{
				return new RenderJai(manager);
			}
	    });

		RenderingRegistry.registerEntityRenderingHandler(EntityLucas.class, new IRenderFactory<EntityLucas>()
		{
			@Override
			public Render<? super EntityLucas> createRenderFor(RenderManager manager)
			{
				return new RenderLucas(manager);
			}
	    });
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRafa.class, new IRenderFactory<EntityRafa>()
		{
			@Override
			public Render<? super EntityRafa> createRenderFor(RenderManager manager)
			{
				return new RenderRafa(manager);
			}
	    });
		
		RenderingRegistry.registerEntityRenderingHandler(EntityZeinner.class, new IRenderFactory<EntityZeinner>()
		{
			@Override
			public Render<? super EntityZeinner> createRenderFor(RenderManager manager)
			{
				return new RenderZeinner(manager);
			}
	    });
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCreepy.class, new IRenderFactory<EntityCreepy>()
		{
			@Override
			public Render<? super EntityCreepy> createRenderFor(RenderManager manager)
			{
				return new RenderCreepy(manager);
			}
	    });
		
		RenderingRegistry.registerEntityRenderingHandler(EntityJohn.class, new IRenderFactory<EntityJohn>()
		{
			@Override
			public Render<? super EntityJohn> createRenderFor(RenderManager manager)
			{
				return new RenderJohn(manager);
			}
	    });
		
		RenderingRegistry.registerEntityRenderingHandler(EntityRuroni.class, new IRenderFactory<EntityRuroni>()
		{
			@Override
			public Render<? super EntityRuroni> createRenderFor(RenderManager manager)
			{
				return new RenderRuroni(manager);
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
		
		RenderingRegistry.registerEntityRenderingHandler(EntityGlyptodon.class, new IRenderFactory<EntityGlyptodon>()
		{
			@Override
			public Render<? super EntityGlyptodon> createRenderFor(RenderManager manager)
			{
				return new RenderGlyptodon(manager);
			}
	    });
		
		RenderingRegistry.registerEntityRenderingHandler(EntitySebecus.class, new IRenderFactory<EntitySebecus>()
		{
			@Override
			public Render<? super EntitySebecus> createRenderFor(RenderManager manager)
			{
				return new RenderSebecus(manager);
			}
	    });
		
		
	}
	
}