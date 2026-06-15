package com.myname.mymodid;

import com.myname.mymodid.ArmorOnPlayer.WickedDwarfArmorRenderDurnor;
import com.myname.mymodid.ArmorOnPlayer.WickedDwarfArmorRenderSilver;
import com.myname.mymodid.ArmorOnPlayer.WickedDwarfArmorRenderGold;
import com.myname.mymodid.ArmorOnPlayer.WickedDwarfArmorRenderMithirll;
import com.myname.mymodid.ArmorOnPlayer.WickedDwarfArmorRender;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ModItems {

    // Krok 1 inicjalizacja zmiennej aka dodanie przedmiotu wstepnie

    // Iroc to dobry ziom

    private static final Log log = LogFactory.getLog(ModItems.class);

    public static Item darkMithirllHelmet;
    public static Item darkMithrillBoots;
    public static Item nerdSword;

    public static Item wickedDwarfHelmet;
    public static Item wickedDwarfChestplate;
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
    public static Item wickedDwarfChestplateDurnor;
    public static Item wicked_Dwarf_Leggings_Durnor;
    public static Item wickedDwarfBootsDurnor;

    public static void registerItems() {

        wicked_Dwarf_Helmet_Silver = new WickedDwarfArmorRenderSilver(ModMaterials.EVIL_DWARF, 1, 0)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Silver")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Helmet_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Silver = new WickedDwarfArmorRenderSilver(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Silver")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Chestplate_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Silver = new WickedDwarfArmorRenderSilver(ModMaterials.EVIL_DWARF, 1, 2)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Silver")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Leggings_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Silver = new WickedDwarfArmorRenderSilver(ModMaterials.EVIL_DWARF, 1, 3)
            .setUnlocalizedName("wicked_Dwarf_Boots_Silver")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Boots_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);

        wicked_Dwarf_Helmet_Gold = new WickedDwarfArmorRenderGold (ModMaterials.EVIL_DWARF, 1, 0)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Gold")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Helmet_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Gold = new WickedDwarfArmorRenderGold (ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Gold")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Chestplate_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Gold = new WickedDwarfArmorRenderGold (ModMaterials.EVIL_DWARF, 1, 2)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Gold")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Leggings_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Gold = new WickedDwarfArmorRenderGold(ModMaterials.EVIL_DWARF, 1, 3)
            .setUnlocalizedName("wicked_Dwarf_Boots_Gold")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Boots_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);

        wicked_Dwarf_Helmet_Mithril = new WickedDwarfArmorRenderMithirll(ModMaterials.EVIL_DWARF, 1, 0)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Mithril")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Helmet_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Mithril = new WickedDwarfArmorRenderMithirll (ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Mithril")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Chestplate_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Mithril = new WickedDwarfArmorRenderMithirll (ModMaterials.EVIL_DWARF, 1, 2)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Mithril")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Leggings_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Mithril = new WickedDwarfArmorRenderMithirll (ModMaterials.EVIL_DWARF, 1, 3)
            .setUnlocalizedName("wicked_Dwarf_Boots_Mithril")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Boots_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);

        wicked_Dwarf_Helmet_Durnor = new WickedDwarfArmorRenderDurnor(ModMaterials.EVIL_DWARF, 1, 0)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Durnor")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Helmet_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);
        wickedDwarfChestplateDurnor = new WickedDwarfArmorRenderDurnor(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wickedDwarfChestplateDurnor")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Chestplate_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Durnor = new WickedDwarfArmorRenderDurnor(ModMaterials.EVIL_DWARF, 1, 2)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Durnor")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Leggings_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);
        wickedDwarfBootsDurnor = new WickedDwarfArmorRenderDurnor(ModMaterials.EVIL_DWARF, 1, 3)
            .setUnlocalizedName("wickedDwarfBootsDurnor")
            .setTextureName(MyMod.MODID+":wicked_Dwarf_Boots_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);

        darkMithrillBoots = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("darkMithrillBoots")
            .setTextureName(MyMod.MODID+":darkMithrillBoots")
            .setCreativeTab(CreativeTabs.tabCombat);
        darkMithirllHelmet = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("darkMithirllHelmet")
            .setTextureName(MyMod.MODID+":dark_Mithirll_Helmet")
            .setCreativeTab(CreativeTabs.tabCombat);

        nerdSword = new ItemNerdSword(ModMaterials.NERD_MATERIAL)
            .setUnlocalizedName("nerdBlorfSword")
            .setTextureName(MyMod.MODID+":nerd_sword")
            .setCreativeTab(CreativeTabs.tabCombat);

        wickedDwarfChestplate = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
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
//
        register(wickedDwarfBootsDurnor, "wicked_Dwarf_Boots_Durnor");





        register(wicked_Dwarf_Helmet_Silver,"wicked_Dwarf_Helmet_Silver");
        register(wicked_Dwarf_Chestplate_Silver,"wicked_Dwarf_Chestplate_Silver");
        register(wicked_Dwarf_Leggings_Silver,"wicked_Dwarf_Leggings_Silver");
        register(wicked_Dwarf_Boots_Silver,"wicked_Dwarf_Boots_Silver");

        register(wicked_Dwarf_Helmet_Gold,"wicked_Dwarf_Helmet_Gold");
        register(wicked_Dwarf_Chestplate_Gold,"wicked_Dwarf_Chestplate_Gold");
        register(wicked_Dwarf_Leggings_Gold,"wicked_Dwarf_Leggings_Gold");
        register(wicked_Dwarf_Boots_Gold,"wicked_Dwarf_Boots_Gold");






        register(wickedDwarfChestplateDurnor,"wicked_Dwarf_Chestplate_Durnor");
        register(darkMithrillBoots, "dark_Mithrill_Boots");
        register(darkMithirllHelmet,"dark_Mithirll_Helmet");
        register(nerdSword, "nerd_sword");
        register(wickedDwarfChestplate, "evil_dwarf_chestplate");
        register(wickedDwarfHelmet,"wicked_dwarf_helmet");
        register(wicked_Dwarf_Leggings_Durnor, "wicked_Dwarf_Leggings_Durnor");
        register(wicked_Dwarf_Helmet_Durnor, "wicked_Dwarf_Helmet_Durnor");
        register(wickedDwarfPants,"wicked_dwarf_pants");
        register(wickedDwarfBoots,"wicked_dwarf_boots");
        register(wicked_Dwarf_Helmet_Mithril, "wicked_Dwarf_Helmet_Mithril");
        register(wicked_Dwarf_Chestplate_Mithril, "wicked_Dwarf_Chestplate_Mithril");
        register(wicked_Dwarf_Leggings_Mithril, "wicked_Dwarf_Leggings_Mithril");
        register(wicked_Dwarf_Boots_Mithril, "wicked_Dwarf_Boots_Mithril");













    }

        private static void register(Item item, String registryName) {
        GameRegistry.registerItem(item, registryName);
    }
}
