package CountryGamer_Oceanic.RenderModels;

import CountryGamer_Oceanic.Entities.EntityShark;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderShark extends RenderLiving {
	public RenderShark(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		// TODO Auto-generated constructor stub
	}

/*
	protected ModelShark model;
	 
	public RenderShark (ModelShark modelTutorial, float f)
	{
	 super(modelTutorial, f);
	 model = ((ModelShark)mainModel);
	}


	public void renderTutorial(EntityShark entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRenderLiving(entity, par2, par4, par6, par8, par9);
    }
 
 public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9)
    {
        renderTutorial((EntityShark)par1EntityLiving, par2, par4, par6, par8, par9);
    }
 
 public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        renderTutorial((EntityShark)par1Entity, par2, par4, par6, par8, par9);
    }
*/
@Override
protected ResourceLocation getEntityTexture(Entity entity) {
	// TODO Auto-generated method stub
	return null;
}
 
}
