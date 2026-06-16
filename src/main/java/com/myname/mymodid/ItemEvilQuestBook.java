package com.myname.mymodid;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.world.World;

public class ItemEvilQuestBook extends ItemBook {

    public ItemEvilQuestBook(){
        super();
        this.setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        if(world.isRemote){
            if(!itemStack.hasTagCompound()){
                itemStack.setTagCompound(new NBTTagCompound());
            }

            NBTTagCompound itemData = itemStack.getTagCompound();

            if(!itemData.hasKey("hobbitsKilled")) itemData.setInteger("hobbitsKilled",0);
            if(!itemData.hasKey("quest_done")) itemData.setBoolean("quest_done",false);

            int killedHobbits = itemData.getInteger("hobbitsKilled");
            boolean q1_done = itemData.getBoolean("quest_done");

            ItemStack visualBook = new ItemStack(Items.writable_book);
            NBTTagCompound nbt = new NBTTagCompound();
            nbt.setString("author","Lord Von Nerdus");
            nbt.setString("title","EvilQuestBook");

            NBTTagList pages = new NBTTagList();

            String strona1 = "§0§lCurrent Missions:§r\\n\\n";
            strona1 += "§6ZEliminate Hobbits:§r\\n\"";

            if(!q1_done){
                strona1 += "Progress: "+ killedHobbits;
                strona1 += "Hobbits can be found in Shire. CHANGE THAT.";
            }
            else{
                strona1 += "Mission Completed";
                strona1 += "Congratulations, you are supossedly not worthless";
            }
            pages.appendTag(new NBTTagString(strona1));

            nbt.setTag("pages",pages);
            visualBook.setTagCompound(nbt);

            player.displayGUIBook(visualBook);



        }
        return itemStack;
    }
}

