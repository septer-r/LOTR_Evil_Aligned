package com.myname.mymodid.ArmorOnPlayer;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class WickedDwarfArmorRenderGold extends ItemArmor {

    public WickedDwarfArmorRenderGold(ItemArmor.ArmorMaterial material, int renderIndex, int armorType){
        super(material,renderIndex,armorType);
    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
        if(slot==2){
            return "mymodid:textures/models/armor/wicked_dwarven_gold2.png";
        }
        return "mymodid:textures/models/armor/wicked_dwarven_gold1.png";
    }

}
