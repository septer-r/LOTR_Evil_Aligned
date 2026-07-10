package com.myname.mymodid;

import static com.myname.mymodid.RecipeOperations.removeRecipe;

import com.myname.mymodid.Entity.EntitySepteRR;
import com.myname.mymodid.InterferencesWithLOTR.DisabledInvisibilityForROTN;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.EntityRegistry;
import lotr.common.LOTRMod;
import lotr.common.entity.npc.LOTREntityTroll;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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
        ModBlocks.registerBlocks();

        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModedWorldGenerator(), 0);
        FMLCommonHandler.instance().bus().register(new PlayerEntersNewDimension());
        FMLCommonHandler.instance().bus().register(new SauronsGaze());

        int entityId = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerModEntity(EntitySepteRR.class,"SepteRR__",entityId,this,90,3,true);
        registerSpawnEgg(EntitySepteRR.class,0x4A4A4A, 0x1E3F20);


        MinecraftForge.EVENT_BUS.register(new DisabledInvisibilityForROTN());

        if(event.getSide().isClient()){
            MinecraftForge.EVENT_BUS.register(new SauronGUIRender());
        }



        GameRegistry.addRecipe(new ItemStack(ModItems.trollsDesert, 1), new Object[] {
            "  S",
            "  C",
            "  M",
            'S', Items.spider_eye,
            'C', Items.sugar,
            'M', LOTRMod.muttonRaw
        });

        proxy.init(event);

    }

    public static void registerSpawnEgg(Class entityClass, int primaryColor, int seconadryColor){
        int id = EntityRegistry.findGlobalUniqueEntityId();
        EntityList.IDtoClassMapping.put(id,entityClass);
        EntityList.entityEggs.put(id,new EntityList.EntityEggInfo(id,primaryColor,seconadryColor));
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
