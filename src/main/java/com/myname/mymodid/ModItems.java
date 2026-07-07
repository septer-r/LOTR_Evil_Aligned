package com.myname.mymodid;

import com.myname.mymodid.ArmorOnPlayer.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

    private static final Log log = LogFactory.getLog(ModItems.class);

    public static Item hobbitSlayer;

    public static Item evilQuestBook;

    public static Item isengard_Berserker_Chestplate;
    public static Item isengard_Berserker_Leggings;
    public static Item isengard_Berserker_Boots;

    public static Item morgoth_Helmet;
    public static Item morgoth_Chestplate;
    public static Item morgoth_Leggings;
    public static Item morgoth_Boots;

    public static Item barrow_Wight_Helmet;
    public static Item barrow_Wight_Chestplate;
    public static Item barrow_Wight_Leggings;
    public static Item barrow_Wight_Boots;
    public static Item barrow_Wight_Scraps;

    public static Item darkMithirllHelmet;
    public static Item darkMithrillBoots;

    public static Item nerdSword;

    public static Item wicked_Dwarf_Helmet;
    public static Item wicked_Dwarf_Chestplate;
    public static Item wicked_Dwarf_Leggings;
    public static Item wicked_Dwarf_Boots;

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

    public static Item trollsDesert;

    public static void registerItems() {


        trollsDesert = new ItemFood(3,0.6F,false)
            .setUnlocalizedName("trolls_Desert")
            .setTextureName(MyMod.MODID+ ":trolls_Desert")
            .setCreativeTab(CreativeTabs.tabFood);

        evilQuestBook = new ItemEvilQuestBook().setUnlocalizedName("evilQuestBook")
            .setTextureName(MyMod.MODID + ":evil_Quest_Book")
            .setCreativeTab(CreativeTabs.tabCombat);

        isengard_Berserker_Chestplate = new IsengardBerserkerArmorRender(ModMaterials.ISENGARD_BERSERKER, 1, 1)
            .setUnlocalizedName("isengard_Berserker_Chestplate")
            .setTextureName(MyMod.MODID + ":isengard_Berserker_Chestplate")
            .setCreativeTab(CreativeTabs.tabCombat);
        isengard_Berserker_Leggings = new IsengardBerserkerArmorRender(ModMaterials.ISENGARD_BERSERKER, 2, 2)
            .setUnlocalizedName("isengard_Berserker_Leggings")
            .setTextureName(MyMod.MODID + ":isengard_Berserker_Leggings")
            .setCreativeTab(CreativeTabs.tabCombat);
        isengard_Berserker_Boots = new IsengardBerserkerArmorRender(ModMaterials.ISENGARD_BERSERKER, 1, 3)
            .setUnlocalizedName("isengard_Berserker_Boots")
            .setTextureName(MyMod.MODID + ":isengard_Berserker_Boots")
            .setCreativeTab(CreativeTabs.tabCombat);

        morgoth_Helmet = new MorgothArmorRender(ModMaterials.MORGOTH, 1, 0)
            .setUnlocalizedName("morgoth_Helmet")
            .setTextureName(MyMod.MODID + ":morgoth_Helmet")
            .setCreativeTab(CreativeTabs.tabCombat);
        morgoth_Chestplate = new MorgothArmorRender(ModMaterials.MORGOTH, 1, 1)
            .setUnlocalizedName("morgoth_Chestplate")
            .setTextureName(MyMod.MODID + ":morgoth_Chestplate")
            .setCreativeTab(CreativeTabs.tabCombat);
        morgoth_Leggings = new MorgothArmorRender(ModMaterials.MORGOTH, 2, 2)
            .setUnlocalizedName("morgoth_Leggings")
            .setTextureName(MyMod.MODID + ":morgoth_Leggings")
            .setCreativeTab(CreativeTabs.tabCombat);
        morgoth_Boots = new MorgothArmorRender(ModMaterials.MORGOTH, 1, 3)
            .setUnlocalizedName("morgoth_Boots")
            .setTextureName(MyMod.MODID + ":morgoth_Boots")
            .setCreativeTab(CreativeTabs.tabCombat);

        barrow_Wight_Helmet = new BarrowWightArmorRender(ModMaterials.BARROW_WIGHT, 1, 0)
            .setUnlocalizedName("barrow_Wight_Helmet")
            .setTextureName(MyMod.MODID + ":barrow_Wight_Helmet")
            .setCreativeTab(CreativeTabs.tabCombat);
        barrow_Wight_Chestplate = new BarrowWightArmorRender(ModMaterials.BARROW_WIGHT, 1, 1)
            .setUnlocalizedName("barrow_Wight_Chestplate")
            .setTextureName(MyMod.MODID + ":barrow_Wight_Chestplate")
            .setCreativeTab(CreativeTabs.tabCombat);
        barrow_Wight_Leggings = new BarrowWightArmorRender(ModMaterials.BARROW_WIGHT, 2, 2)
            .setUnlocalizedName("barrow_Wight_Leggings")
            .setTextureName(MyMod.MODID + ":barrow_Wight_Leggings")
            .setCreativeTab(CreativeTabs.tabCombat);
        barrow_Wight_Boots = new BarrowWightArmorRender(ModMaterials.BARROW_WIGHT, 1, 3)
            .setUnlocalizedName("barrow_Wight_Boots")
            .setTextureName(MyMod.MODID + ":barrow_Wight_Boots")
            .setCreativeTab(CreativeTabs.tabCombat);
        barrow_Wight_Scraps = new WickedDwarfArmorRenderSilver(ModMaterials.BARROW_WIGHT, 1, 3)
            .setUnlocalizedName("barrow_Wight_Scraps")
            .setTextureName(MyMod.MODID + ":barrow_Wight_Scraps")
            .setCreativeTab(CreativeTabs.tabCombat);

        wicked_Dwarf_Helmet_Silver = new WickedDwarfArmorRenderSilver(ModMaterials.EVIL_DWARF, 1, 0)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Silver")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Helmet_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Silver = new WickedDwarfArmorRenderSilver(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Silver")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Chestplate_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Silver = new WickedDwarfArmorRenderSilver(ModMaterials.EVIL_DWARF, 1, 2)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Silver")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Leggings_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Silver = new WickedDwarfArmorRenderSilver(ModMaterials.EVIL_DWARF, 1, 3)
            .setUnlocalizedName("wicked_Dwarf_Boots_Silver")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Boots_Silver")
            .setCreativeTab(CreativeTabs.tabCombat);

        wicked_Dwarf_Helmet_Gold = new WickedDwarfArmorRenderGold(ModMaterials.EVIL_DWARF, 1, 0)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Gold")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Helmet_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Gold = new WickedDwarfArmorRenderGold(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Gold")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Chestplate_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Gold = new WickedDwarfArmorRenderGold(ModMaterials.EVIL_DWARF, 1, 2)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Gold")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Leggings_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Gold = new WickedDwarfArmorRenderGold(ModMaterials.EVIL_DWARF, 1, 3)
            .setUnlocalizedName("wicked_Dwarf_Boots_Gold")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Boots_Gold")
            .setCreativeTab(CreativeTabs.tabCombat);
        // Rahahaha Prrrrt 2
        wicked_Dwarf_Helmet_Mithril = new WickedDwarfArmorRenderMithirll(ModMaterials.EVIL_DWARF, 1, 0)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Mithril")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Helmet_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Mithril = new WickedDwarfArmorRenderMithirll(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Mithril")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Chestplate_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Mithril = new WickedDwarfArmorRenderMithirll(ModMaterials.EVIL_DWARF, 1, 2)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Mithril")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Leggings_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Mithril = new WickedDwarfArmorRenderMithirll(ModMaterials.EVIL_DWARF, 1, 3)
            .setUnlocalizedName("wicked_Dwarf_Boots_Mithril")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Boots_Mithril")
            .setCreativeTab(CreativeTabs.tabCombat);

        wicked_Dwarf_Helmet_Durnor = new WickedDwarfArmorRenderDurnor(ModMaterials.EVIL_DWARF, 1, 0)
            .setUnlocalizedName("wicked_Dwarf_Helmet_Durnor")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Helmet_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Chestplate_Durnor = new WickedDwarfArmorRenderDurnor(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate_Durnor")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Chestplate_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings_Durnor = new WickedDwarfArmorRenderDurnor(ModMaterials.EVIL_DWARF, 1, 2)
            .setUnlocalizedName("wicked_Dwarf_Leggings_Durnor")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Leggings_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots_Durnor = new WickedDwarfArmorRenderDurnor(ModMaterials.EVIL_DWARF, 1, 3)
            .setUnlocalizedName("wicked_Dwarf_Boots_Durnor")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Boots_Durnor")
            .setCreativeTab(CreativeTabs.tabCombat);

        darkMithrillBoots = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("darkMithrillBoots")
            .setTextureName(MyMod.MODID + ":darkMithrillBoots")
            .setCreativeTab(CreativeTabs.tabCombat);
        darkMithirllHelmet = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("darkMithirllHelmet")
            .setTextureName(MyMod.MODID + ":dark_Mithirll_Helmet")
            .setCreativeTab(CreativeTabs.tabCombat);

        nerdSword = new ItemNerdSword(ModMaterials.NERD_MATERIAL).setUnlocalizedName("nerdBlorfSword")
            .setTextureName(MyMod.MODID + ":nerd_sword")
            .setCreativeTab(CreativeTabs.tabCombat);

        wicked_Dwarf_Chestplate = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 1)
            .setUnlocalizedName("wicked_Dwarf_Chestplate")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Chestplate")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Helmet = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 0)
            .setUnlocalizedName("wicked_Dwarf_Helmet")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_helmet")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Leggings = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 2, 2)
            .setUnlocalizedName("wicked_Dwarf_Leggings")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Leggings")
            .setCreativeTab(CreativeTabs.tabCombat);
        wicked_Dwarf_Boots = new WickedDwarfArmorRender(ModMaterials.EVIL_DWARF, 1, 3)
            .setUnlocalizedName("wicked_Dwarf_Boots")
            .setTextureName(MyMod.MODID + ":wicked_Dwarf_Boots")
            .setCreativeTab(CreativeTabs.tabCombat);

        register(evilQuestBook, "evil_Quest_Book");

        register(isengard_Berserker_Chestplate, "isengard_Berserker_Chestplate");
        register(isengard_Berserker_Leggings, "isengard_Berserker_Leggings");
        register(isengard_Berserker_Boots, "isengard_Berserker_Boots");

        register(morgoth_Helmet,"morgoth_Helmet");
        register(morgoth_Chestplate, "morgoth_Chestplate");
        register(morgoth_Leggings, "morgoth_Leggings");
        register(morgoth_Boots, "morgoth_Boots");

        register(barrow_Wight_Helmet, "barrow_Wight_Helmet");
        register(barrow_Wight_Chestplate, "barrow_Wight_Chestplate");
        register(barrow_Wight_Leggings, "barrow_Wight_Leggings");
        register(barrow_Wight_Boots, "barrow_Wight_Boots");
        register(barrow_Wight_Scraps, "barrow_Wight_Scraps");

        register(darkMithrillBoots, "dark_Mithrill_Boots");
        register(darkMithirllHelmet, "dark_Mithirll_Helmet");

        register(nerdSword, "nerd_sword");

        register(wicked_Dwarf_Helmet, "wicked_Dwarf_Helmet");
        register(wicked_Dwarf_Chestplate, "wicked_Dwarf_Chestplate");
        register(wicked_Dwarf_Leggings, "wicked_Dwarf_Leggings");
        register(wicked_Dwarf_Boots, "wicked_Dwarf_Boots");

        register(wicked_Dwarf_Helmet_Silver, "wicked_Dwarf_Helmet_Silver");
        register(wicked_Dwarf_Chestplate_Silver, "wicked_Dwarf_Chestplate_Silver");
        register(wicked_Dwarf_Leggings_Silver, "wicked_Dwarf_Leggings_Silver");
        register(wicked_Dwarf_Boots_Silver, "wicked_Dwarf_Boots_Silver");

        register(wicked_Dwarf_Helmet_Gold, "wicked_Dwarf_Helmet_Gold");
        register(wicked_Dwarf_Chestplate_Gold, "wicked_Dwarf_Chestplate_Gold");
        register(wicked_Dwarf_Leggings_Gold, "wicked_Dwarf_Leggings_Gold");
        register(wicked_Dwarf_Boots_Gold, "wicked_Dwarf_Boots_Gold");

        register(wicked_Dwarf_Helmet_Mithril, "wicked_Dwarf_Helmet_Mithril");
        register(wicked_Dwarf_Chestplate_Mithril, "wicked_Dwarf_Chestplate_Mithril");
        register(wicked_Dwarf_Leggings_Mithril, "wicked_Dwarf_Leggings_Mithril");
        register(wicked_Dwarf_Boots_Mithril, "wicked_Dwarf_Boots_Mithril");

        register(wicked_Dwarf_Helmet_Durnor, "wicked_Dwarf_Helmet_Durnor");
        register(wicked_Dwarf_Chestplate_Durnor, "wicked_Dwarf_Chestplate_Durnor");
        register(wicked_Dwarf_Leggings_Durnor, "wicked_Dwarf_Leggings_Durnor");
        register(wicked_Dwarf_Boots_Durnor, "wicked_Dwarf_Boots_Durnor");

        register(trollsDesert,"trolls_Desert");

    }

    private static void register(Item item, String registryName) {
        GameRegistry.registerItem(item, registryName);
    }
}
