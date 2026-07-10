package com.myname.mymodid.Blocks;

import com.myname.mymodid.ModItems;
import com.myname.mymodid.MyMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class ChalkiteOre extends Block {

    public ChalkiteOre(Material material){
        super(material);

        this.setHardness(20.0F);
        this.setResistance(5);
        this.setStepSound(soundTypeStone);

        this.setHarvestLevel("pickaxe",8);
    }

    @Override
    public Item getItemDropped(int metadata, Random random, int fortune){
        return ModItems.nerdSword;
    }

    @Override
    public int quantityDropped(Random random){
        return 3 + random.nextInt(3);
    }
}
