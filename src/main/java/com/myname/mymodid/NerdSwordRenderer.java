package com.myname.mymodid;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

public class NerdSwordRenderer implements IItemRenderer {

    private static final ResourceLocation TEKSTURA_W_RECE = new ResourceLocation(
        "mymodid",
        "textures/items/miecz32.png");

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return false;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();


        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(TEKSTURA_W_RECE);


        float scale = 1.7F;
        GL11.glScalef(scale, scale, scale);


        if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            GL11.glTranslatef(-0.25F, -0.15F, 0.0F);
        } else if (type == ItemRenderType.EQUIPPED) {
            GL11.glTranslatef(-0.40F, -0.15F, 0.0025F);
        }


        net.minecraft.client.renderer.ItemRenderer.renderItemIn2D(
            Tessellator.instance,
            1.0F,
            0.0F,
            0.0F,
            1.0F,
            32,
            32,
            0.0625F
        );

        GL11.glPopMatrix();
    }
}
