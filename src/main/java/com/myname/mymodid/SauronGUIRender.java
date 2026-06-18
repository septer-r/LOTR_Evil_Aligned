package com.myname.mymodid;

import cpw.mods.fml.common.MinecraftDummyContainer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent;
import scala.collection.parallel.ParIterableLike;

import javax.management.monitor.GaugeMonitor;
import java.util.Collection;

public class SauronGUIRender {

    private  static final ResourceLocation TEXTURE_ICON =
        new ResourceLocation(MyMod.MODID,"textures/gui/sauron_eye.png");

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onGuiRender(GuiScreenEvent.DrawScreenEvent.Post event){
        Minecraft mc = Minecraft.getMinecraft();

        if(event.gui instanceof GuiContainer && mc.thePlayer != null){
            GuiContainer gui = (GuiContainer) event.gui;

            if(mc.thePlayer.isPotionActive(MyMod.sauronGazeEffect.id)){

                int x = (gui.width -176)/2 - 124;
                int y = (gui.height - 166)/2;

                Collection<PotionEffect> acvtivePotion = mc.thePlayer.getActivePotionEffects();
                int index = 0;
                for(PotionEffect p: acvtivePotion){
                    if(p.getPotionID() == MyMod.sauronGazeEffect.id){
                        break;
                    }
                }
                y += index*32;

                mc.getTextureManager().bindTexture(TEXTURE_ICON);
                gui.drawTexturedModalRect(x+6,y+7,0,0,18,18);


            }


        }

    }
}
