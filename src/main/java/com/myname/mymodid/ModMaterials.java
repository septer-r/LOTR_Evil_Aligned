package com.myname.mymodid;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {

    public static final ToolMaterial NERD_MATERIAL = EnumHelper
        .addToolMaterial("NERD_MATERIAL", 3, 3000, 12.0F, 15.0F, 30);

    public static final ArmorMaterial EVIL_DWARF = EnumHelper
        .addArmorMaterial("EVIL_DWARF", 20, new int[] { 3, 8, 6, 3 }, 12);

}
