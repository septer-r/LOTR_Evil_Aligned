package com.myname.mymodid;

import net.minecraft.init.Items;

public class RecipeOperations {

    public static void removeRecipe(net.minecraft.item.Item itemToRemove) {
        java.util.List<net.minecraft.item.crafting.IRecipe> recipes = net.minecraft.item.crafting.CraftingManager
            .getInstance()
            .getRecipeList();
        java.util.Iterator<net.minecraft.item.crafting.IRecipe> iterator = recipes.iterator();

        while (iterator.hasNext()) {
            net.minecraft.item.crafting.IRecipe recipe = iterator.next();
            net.minecraft.item.ItemStack output = recipe.getRecipeOutput();


            if (output != null && output.getItem() == itemToRemove) {
                iterator.remove();
            }
        }
    }

    public static void changeLOTRRecipe(){

            cpw.mods.fml.common.registry.GameRegistry.addRecipe(
            new net.minecraft.item.ItemStack(lotr.common.LOTRMod.mithrilMail), new Object[] { "D", "D", "S", 'D', Items.brick, 'S', Items.brick, });

        if (cpw.mods.fml.common.Loader.isModLoaded("lotr")) {
            try {

                java.util.List<net.minecraft.item.crafting.IRecipe> angmarList = lotr.common.recipe.LOTRRecipes.angmarRecipes;


                if (angmarList != null) {
                    angmarList.removeIf(
                        recipe -> recipe != null && recipe.getRecipeOutput() != null
                            && recipe.getRecipeOutput()
                            .getItem() == lotr.common.LOTRMod.battleaxeAngmar);
                }


                net.minecraft.item.crafting.IRecipe newRecipe = new net.minecraft.item.crafting.ShapedRecipes(
                    3,
                    3,
                    new net.minecraft.item.ItemStack[] { new net.minecraft.item.ItemStack(lotr.common.LOTRMod.orcSteel),
                        null, new net.minecraft.item.ItemStack(lotr.common.LOTRMod.orcSteel), null,
                        new net.minecraft.item.ItemStack(lotr.common.LOTRMod.orcSteel), null, null,
                        new net.minecraft.item.ItemStack(net.minecraft.init.Items.stick), null },
                    new net.minecraft.item.ItemStack(lotr.common.LOTRMod.battleaxeAngmar) // Wynik craftingu
                );

                angmarList.add(newRecipe);
                System.out.println("⚔️ Sukces! Zmieniono przepis w liście angmarRecipes!");

            } catch (Throwable e) {
                System.out.println("⚠️ Coś poszło nie tak podczas edycji angmarRecipes: " + e.getMessage());
                e.printStackTrace();
            }
        }

    }

}
