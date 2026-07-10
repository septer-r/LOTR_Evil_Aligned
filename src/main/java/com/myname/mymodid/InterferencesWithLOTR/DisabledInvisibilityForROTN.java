package com.myname.mymodid.InterferencesWithLOTR;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import lotr.common.entity.npc.LOTREntityRangerNorth;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class DisabledInvisibilityForROTN {

    @SubscribeEvent

    public void onRangerUpdate(LivingUpdateEvent event){
        EntityLivingBase entity = event.entityLiving;

        if(entity instanceof LOTREntityRangerNorth){
            LOTREntityRangerNorth ranger = (LOTREntityRangerNorth) entity;

            ranger.setRangerSneaking(false);

            if(ranger.isPotionActive(net.minecraft.potion.Potion.invisibility.id)){
                ranger.removePotionEffect(net.minecraft.potion.Potion.invisibility.id);
            }

        }
    }


}
