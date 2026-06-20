package com.myname.mymodid;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {

    public static final ToolMaterial NERD_MATERIAL = EnumHelper
        .addToolMaterial("NERD_MATERIAL", 3, 3000, 12.0F, 15.0F, 30);

    public static final ArmorMaterial EVIL_DWARF = EnumHelper
        .addArmorMaterial("EVIL_DWARF", 20, new int[] { 3, 8, 6, 3 }, 12);

    public static final ArmorMaterial BARROW_WIGHT = EnumHelper
        .addArmorMaterial("BARROW_WIGHT", 20, new int[] { 2, 4, 3, 2 }, 12);

    public static final ArmorMaterial MORGOTH = EnumHelper
        .addArmorMaterial("MORGOTH", 20, new int[] { 2, 4, 3, 2 }, 12);

    public static final ArmorMaterial ISENGARD_BERSERKER = EnumHelper
        .addArmorMaterial("ISENGARD_BERSERKER", 20, new int[] { 3, 8, 7, 3 }, 12);
}
