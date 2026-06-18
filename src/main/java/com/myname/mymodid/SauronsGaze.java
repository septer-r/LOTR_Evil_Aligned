package com.myname.mymodid;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import ibxm.Player;
import lotr.client.gui.LOTRGuiMap;
import lotr.common.coremod.LOTRReplacedMethods;
import lotr.common.network.LOTRPacketFellowshipDoPlayer;
import lotr.common.world.biome.LOTRBiomeGenIronHills;
import lotr.common.world.biome.LOTRBiomeGenMordor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.world.NoteBlockEvent;

public class SauronsGaze {

    private static final int LOTR_DIMENSION_ID = 100;


//    @SubscribeEvent
//    public void onPlayerUpdate(EntityPlayer player, World world){
//        if(world.isRemote){
//            return;
//        }
//        if(player.dimension == LOTR_DIMENSION_ID){
//
//            int x = (int) player.posX;
//            int z = (int) player.posZ;
//
//            BiomeGenBase biome = world.getBiomeGenForCoords(x,z);
//
//            if(biome instanceof LOTRBiomeGenMordor){
//                if(!player.isPotionActive(Potion.moveSpeed.id)){
//                    player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,300,1));
//                }
//            }
//
//        }
//    }


    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event ){
        if (event.phase != TickEvent.Phase.START){
            return;
        }

        EntityPlayer player = event.player;
        World world = player.worldObj;

        if(world == null || world.isRemote){
            return;
        }

        if(player.dimension == LOTR_DIMENSION_ID){
            int x = (int) player.posX;
            int z = (int) player.posZ;

            BiomeGenBase biome = world.getBiomeGenForCoords(x,z);

            if(biome instanceof LOTRBiomeGenMordor){
                if(!player.isPotionActive(Potion.moveSlowdown)){
                    player.addPotionEffect(new PotionEffect(MyMod.sauronGazeEffect.getId(), 300,0));
                }
            }
        }


    }





}
