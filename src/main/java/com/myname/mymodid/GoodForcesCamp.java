package com.myname.mymodid;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class GoodForcesCamp extends WorldGenerator {

    @Override
    public boolean generate(World world, Random random, int x, int y, int z){

        Block blockBelow = world.getBlock(x,y-1,z);
        if(blockBelow != Blocks.grass && blockBelow != Blocks.dirt){
            return false;
        }
        for(int height = 0; height < 4; height++){
            for(int dx = -1; dx <= 1; dx++){
                for(int dz = -1; dz <= 1; dz++){
                    if(dx == 0 && dz == 0 && height < 3){
                        world.setBlock(x + dx, y +height, z +dz, Blocks.pumpkin);
                    } else{
                        world.setBlock(x + dx, y + height, z +dz, Blocks.coal_block);
                    }
                }
            }
        }
        world.setBlock(x,y,z, Blocks.ender_chest);

        System.out.println("Zespawnowano na: " + x + " " + y + " " + z);
        return true;




    }
}
