package com.myname.mymodid.EntityRender;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSepteRR extends RenderBiped {

    private static final ResourceLocation TEXTURE =
        new ResourceLocation("mymodid","textures/entity/septerr.png");


    public RenderSepteRR(){
        super(new ModelBiped(), 0.5F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity){
        return TEXTURE;
    }
}
