package com.myname.mymodid;

import com.myname.mymodid.ArmorOnPlayer.WickedDwarfArmorRender;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ModItems {

    // Krok 1 inicjalizacja zmiennej aka dodanie przedmiotu wstepnie


    private static final Log log = LogFactory.getLog(ModItems.class);

    public static Item darkMithirllHelmet;
    public static Item darkMithrillBoots;
    public static Item nerdSword;

    public static Item wickedDwarfHelmet;
    public static Item evilDwarfChestPlate;
    public static Item wickedDwarfPants;
    public static Item wickedDwarfBoots;

    public static Item wicked_Dwarf_Helmet_Silver;
    public static Item wicked_Dwarf_Chestplate_Silver;
    public static Item wicked_Dwarf_Leggings_Silver;
    public static Item wicked_Dwarf_Boots_Silver;

    public static Item wicked_Dwarf_Helmet_Gold;
    public static Item wicked_Dwarf_Chestplate_Gold;
    public static Item wicked_Dwarf_Leggings_Gold;
    public static Item wicked_Dwarf_Boots_Gold;

    public static Item wicked_Dwarf_Helmet_Mithril;
    public static Item wicked_Dwarf_Chestplate_Mithril;
    public static Item wicked_Dwarf_Leggings_Mithril;
    public static Item wicked_Dwarf_Boots_Mithril;

    public static Item wicked_Dwarf_Helmet_Durnor;
    public static Item wicked_Dwarf_Chestplate_Durnor;
    public static Item wicked_Dwarf_Leggings_Durnor;
    public static Item wicked_Dwarf_Boots_Durnor;

    public static void registerItems() {

        wicked_Dwarf_Helmet_Silver = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Silver")
            .setTextureName("mymod:wicked_Dwarf_Helmet_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Silver = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Silver")
            .setTextureName("mymod:wicked_Dwarf_Chestplate_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Silver = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Silver")
            .setTextureName("mymod:wicked_Dwarf_Leggings_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Silver = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Boots_Silver")
            .setTextureName("mymod:wicked_Dwarf_Boots_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);

        wicked_Dwarf_Helmet_Gold = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Gold")
            .setTextureName("mymod:wicked_Dwarf_Helmet_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Gold = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Gold")
            .setTextureName("mymod:wicked_Dwarf_Chestplate_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Gold = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Gold")
            .setTextureName("mymod:wicked_Dwarf_Leggings_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Gold = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Boots_Gold")
            .setTextureName("mymod:wicked_Dwarf_Boots_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);

        wicked_Dwarf_Helmet_Mithril = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Mithril")
            .setTextureName("mymod:wicked_Dwarf_Helmet_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Mithril = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Mithril")
            .setTextureName("mymod:wicked_Dwarf_Chestplate_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Mithril = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Mithril")
            .setTextureName("mymod:wicked_Dwarf_Leggings_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Mithril = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Boots_Mithril")
            .setTextureName("mymod:wicked_Dwarf_Boots_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);.coś

        wicked_Dwarf_Helmet_Durnor = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Durnor")
            .setTextureName("mymod:wicked_Dwarf_Helmet_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Durnor = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Durnor")
            .setTextureName("mymod:wicked_Dwarf_Chestplate_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Durnor = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Durnor")
            .setTextureName("mymod:wicked_Dwarf_Leggings_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Durnor = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Boots_Durnor")
            .setTextureName("mymod:wicked_Dwarf_Boots_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);

        darkMithrillBoots = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("darkMithrillBoots")
            .setTextureName("mymod:darkMithrillBoots")
            .setCreativeTab(CreativeTabs.tabCombat);
        darkMithirllHelmet = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("darkMithirllHelmet")
            .setTextureName("mymodid:dark_Mithirll_Helmet")
            .setCreativeTab(CreativeTabs.tabCombat);

        nerdSword = new ItemNerdSword(ModMaterials.NERD_MATERIAL)
            .setUnlocalizedName("nerdBlorfSword")
            .setTextureName("mymodid:nerd_sword")
            .setCreativeTab(CreativeTabs.tabCombat);

        evilDwarfChestPlate = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("evilDwarfChestPlate")
            .setTextureName(MyMod.MODID + ":evil_dwarf_chestplate")
            .setCreativeTab(CreativeTabs.tabCombat);
        wickedDwarfHelmet = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF,1,0)
            .setUnlocalizedName("wickedDwarfHelmet")
            .setTextureName(MyMod.MODID + ":wicked_dwarf_helmet")
            .setCreativeTab(CreativeTabs.tabCombat);
        wickedDwarfPants = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF,2,2)
            .setUnlocalizedName("wickedDwarfPants")
            .setTextureName(MyMod.MODID+":wicked_dwarf_pants")
            .setCreativeTab(CreativeTabs.tabCombat);
        wickedDwarfBoots = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF,1,3)
            .setUnlocalizedName("wickedDwarfBoots")
            .setTextureName(MyMod.MODID+":wicked_dwarf_boots")
            .setCreativeTab(CreativeTabs.tabCombat);

        register(darkMithrillBoots, "dark_Mithrill_Boots");
        register(darkMithirllHelmet,"dark_Mithirll_Helmet");
        register(nerdSword, "nerd_sword");
        register(evilDwarfChestPlate, "evil_dwarf_chestplate");
        register(wickedDwarfHelmet,"wicked_dwarf_helmet");
        register(wickedDwarfPants,"wicked_dwarf_pants");
        register(wickedDwarfBoots,"wicked_dwarf_boots");
    }


    private static void register(Item item, String registryName) {
        GameRegistry.registerItem(item, registryName);
    }
}
