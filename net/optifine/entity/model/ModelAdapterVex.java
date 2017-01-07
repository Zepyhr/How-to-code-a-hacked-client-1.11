package net.optifine.entity.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelVex;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderVex;
import net.minecraft.entity.monster.EntityVex;
import net.optifine.Reflector;

public class ModelAdapterVex extends ModelAdapterBiped
{
    public ModelAdapterVex()
    {
        super(EntityVex.class, "vex", 0.3F);
    }

    public ModelRenderer getModelRenderer(ModelBase model, String modelPart)
    {
        if (!(model instanceof ModelVex))
        {
            return null;
        }
        else
        {
            ModelRenderer modelrenderer = super.getModelRenderer(model, modelPart);

            if (modelrenderer != null)
            {
                return modelrenderer;
            }
            else
            {
                ModelVex modelvex = (ModelVex)model;
                return modelPart.equals("left_wing") ? (ModelRenderer)Reflector.getFieldValue(modelvex, Reflector.ModelVex_leftWing) : (modelPart.equals("right_wing") ? (ModelRenderer)Reflector.getFieldValue(modelvex, Reflector.ModelVex_rightWing) : null);
            }
        }
    }

    public ModelBase makeModel()
    {
        return new ModelVex();
    }

    public IEntityRenderer makeEntityRender(ModelBase modelBase, float shadowSize)
    {
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        RenderVex rendervex = new RenderVex(rendermanager);
        rendervex.mainModel = modelBase;
        rendervex.shadowSize = shadowSize;
        return rendervex;
    }
}
