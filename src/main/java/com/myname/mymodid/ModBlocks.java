package com.myname.mymodid;

import com.myname.mymodid.Blocks.ChalkiteOre;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModBlocks {

    public static Block ChalkiteOre;

    public static void registerBlocks(){

        ChalkiteOre = new ChalkiteOre(Material.cactus)
            .setBlockName("chalkiteOre")
            .setBlockTextureName(MyMod.MODID + ":chalkiteOre")
            .setCreativeTab(CreativeTabs.tabBlock);


       register(ChalkiteOre,"chalkiteOre");

    }




    private static void register(Block block, String registry){
        GameRegistry.registerBlock(block,registry);
    }

}

