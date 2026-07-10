package com.myname.mymodid.Entity;

import com.myname.mymodid.ModItems;
import net.minecraft.block.BlockCake;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntitySepteRR extends EntityMob {

    public EntitySepteRR(World world){
        super(world);
        this.setSize(1.0F,2F);

        this.tasks.addTask(5,new EntityAIWander(this,0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class,8.0F));

        this.targetTasks.addTask(1,new EntityAIHurtByTarget(this,false));
        this.targetTasks.addTask(2,new EntityAINearestAttackableTarget(this, EntityPlayer.class,0,true));
    }

    @Override
    protected void applyEntityAttributes(){
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12D);
    }

    @Override
    protected Item getDropItem(){
        return Items.cake;
    }

    @Override
    protected boolean isValidLightLevel(){
        return true;
    }
}
