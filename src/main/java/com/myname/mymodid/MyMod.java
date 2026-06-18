package com.myname.mymodid;

import static com.myname.mymodid.RecipeOperations.removeRecipe;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.potion.Potion;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(
    modid = MyMod.MODID,
    version = Tags.VERSION,
    name = "mymodid",
    acceptedMinecraftVersions = "[1.7.10]",
    dependencies = "required-after:lotr")
public class MyMod {

    public static Potion sauronGazeEffect;

    public static final String MODID = "mymodid";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(clientSide = "com.myname.mymodid.ClientProxy", serverSide = "com.myname.mymodid.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // Uruchamiamy rejestrator przedmiotów z osobnej klasy
        int customPotionId = 28;

        sauronGazeEffect = new SauronsEffect(customPotionId, true, 0x4a000000);

        ModItems.registerItems();

        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModedWorldGenerator(), 0);
        FMLCommonHandler.instance().bus().register(new PlayerEntersNewDimension());
        FMLCommonHandler.instance().bus().register(new SauronsGaze());
        if(event.getSide().isClient()){
            MinecraftForge.EVENT_BUS.register(new SauronGUIRender());
        }

        proxy.init(event);

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        removeRecipe(lotr.common.LOTRMod.mithrilMail);

        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }

}
