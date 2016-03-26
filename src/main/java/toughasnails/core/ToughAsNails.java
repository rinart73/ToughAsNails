package toughasnails.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import toughasnails.command.TANCommand;
import toughasnails.init.ModBlocks;
import toughasnails.init.ModCrafting;
import toughasnails.init.ModEntities;
import toughasnails.init.ModHandlers;
import toughasnails.init.ModItems;
import toughasnails.init.ModPotions;
import toughasnails.init.ModStats;
import toughasnails.init.ModVanillaCompat;

@Mod(modid = ToughAsNails.MOD_ID, name = ToughAsNails.MOD_NAME)
public class ToughAsNails
{
    public static final String MOD_NAME = "Tough As Nails";
    public static final String MOD_ID = "ToughAsNails";
    
    @Instance(MOD_ID)
    public static ToughAsNails instance;
    
    @SidedProxy(clientSide = "toughasnails.core.ClientProxy", serverSide = "toughasnails.core.CommonProxy")
    public static CommonProxy proxy;
    
    public static Logger logger = LogManager.getLogger(MOD_ID);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	ModBlocks.init();
    	ModEntities.init();
        ModItems.init();
        ModStats.init();
        ModPotions.init();
        ModVanillaCompat.init();
        ModHandlers.init();
        
        ModCrafting.init();
        
        proxy.registerRenderers();
    }
    
    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new TANCommand());
    }
}
