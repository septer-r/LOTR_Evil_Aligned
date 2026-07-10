package com.myname.mymodid;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class SauronsEffect extends Potion {

    private static final ResourceLocation TEXTURE_ICON =
        new ResourceLocation("mymodid:", "textures/gui/sauron_eye.png");

    public SauronsEffect(int id, boolean isBadEffect, int liquidColor){
        super(id, isBadEffect, liquidColor);
        this.setPotionName("potion.sauronGaze");


        this.setIconIndex(0, 7);
    }

    @Override
    public boolean isReady(int duration, int amplifier){
        return duration > 0;
    }

    @Override
    public void performEffect(EntityLivingBase entity, int amplifier){
        if (!entity.isPotionActive(Potion.moveSlowdown.id)){
            entity.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 2, amplifier + 1, true));
            entity.addPotionEffect(new PotionEffect(Potion.hunger.id, 2, amplifier + 1, true));
        }
    }


}


















