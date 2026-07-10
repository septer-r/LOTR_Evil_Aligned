package com.myname.mymodid;

import com.myname.mymodid.Entity.EntitySepteRR;
import com.myname.mymodid.EntityRender.RenderSepteRR;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraftforge.client.MinecraftForgeClient;

import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        MinecraftForgeClient.registerItemRenderer(ModItems.nerdSword, new NerdSwordRenderer());
        RenderingRegistry.registerEntityRenderingHandler(EntitySepteRR.class, new RenderSepteRR());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);

    }
}
