package com.deextinction.deextinction.client;



import com.deextinction.deextinction.init.DeexBlocks;
import com.deextinction.deextinction.proxy.CommonProxy;
import com.deextinction.deextinction.tab.ModTab;
import com.deextinction.deextinction.util.handler.RegistryHandler;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Deextinction.MODID, name = Deextinction.MODNAME, version = Deextinction.MODVERSION)
public class Deextinction {
	
	
	public static final CreativeTabs modtab = new ModTab("modtab");
    public static final String MODID = "deextinction";
    public static final String MODNAME = "De-Extinction Mod";
    public static final String MODVERSION = "0.0.1";
    public static final int ENTITY_KELENKEN = 250;
    public static final int ENTITY_SMILODON = 251;
    public static final int ENTITY_FISKO = 252;
    public static final int ENTITY_JAI = 253;
    public static final int ENTITY_LUCAS = 254;
    public static final int ENTITY_RAFA = 255;
    public static final int ENTITY_ZEINNER = 256;
    public static final int ENTITY_JOHN = 257;
    public static final int ENTITY_RURONI = 258;
    public static final int ENTITY_CREEPY = 259;
    public static final int ENTITY_ARCTOTHERIUM = 260;
    public static final int ENTITY_GLYPTODON = 261;
    public static final int ENTITY_SEBECUS = 262;
    

    @SidedProxy(clientSide = "com.deextinction.deextinction.proxy.ClientProxy", serverSide = "com.deextinction.deextinction.proxy.ServerProxy")
    public static CommonProxy proxy;

   
    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
    	RegistryHandler.preInitRegistries();
            
    }

    

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    	


    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
      
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
     
    }
    
    @Instance (Deextinction.MODID)
    public static Deextinction modInstance;
    
    
    
    
}