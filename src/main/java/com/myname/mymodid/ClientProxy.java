package com.myname.mymodid;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);


        MinecraftForgeClient.registerItemRenderer(ModItems.nerdSword, new NerdSwordRenderer());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

    }
}
