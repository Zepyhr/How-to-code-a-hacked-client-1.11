package net.optifine.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragonHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntitySkull;
import net.optifine.Config;
import net.optifine.Reflector;

public class ModelAdapterHeadDragon extends ModelAdapter
{
    public ModelAdapterHeadDragon()
    {
        super(TileEntitySkull.class, "head_dragon", 0.0F);
    }

    public ModelBase makeModel()
    {
        return new ModelDragonHead(0.0F);
    }

    public ModelRenderer getModelRenderer(ModelBase model, String modelPart)
    {
        if (!(model instanceof ModelDragonHead))
        {
            return null;
        }
        else
        {
            ModelDragonHead modeldragonhead = (ModelDragonHead)model;
            return modelPart.equals("head") ? (ModelRenderer)Reflector.getFieldValue(modeldragonhead, Reflector.ModelDragonHead_head) : (modelPart.equals("jaw") ? (ModelRenderer)Reflector.getFieldValue(modeldragonhead, Reflector.ModelDragonHead_jaw) : null);
        }
    }

    public IEntityRenderer makeEntityRender(ModelBase modelBase, float shadowSize)
    {
        TileEntityRendererDispatcher tileentityrendererdispatcher = TileEntityRendererDispatcher.instance;
        TileEntitySpecialRenderer tileentityspecialrenderer = tileentityrendererdispatcher.getSpecialRendererByClass(TileEntitySkull.class);

        if (!(tileentityspecialrenderer instanceof TileEntitySkullRenderer))
        {
            return null;
        }
        else
        {
            if (tileentityspecialrenderer.getEntityClass() == null)
            {
                tileentityspecialrenderer = new TileEntitySkullRenderer();
                tileentityspecialrenderer.setRendererDispatcher(tileentityrendererdispatcher);
            }

            if (!Reflector.TileEntitySkullRenderer_dragonHead.exists())
            {
                Config.warn("Field not found: TileEntitySkullRenderer.dragonHead");
                return null;
            }
            else
            {
                Reflector.setFieldValue(tileentityspecialrenderer, Reflector.TileEntitySkullRenderer_dragonHead, modelBase);
                return tileentityspecialrenderer;
            }
        }
    }
}
