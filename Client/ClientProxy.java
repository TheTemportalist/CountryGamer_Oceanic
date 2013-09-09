package CountryGamer_Oceanic.Client;

import CountryGamer_Oceanic.Entities.EntityShark;
import CountryGamer_Oceanic.RenderModels.RenderShark;
import CountryGamer_Oceanic.Server.ServerProxy;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	
	@Override
	public void registerThings() {
		//RenderingRegistry.registerEntityRenderingHandler(EntityShark.class, new RenderShark(new ModelShark(), 0.3F));
	}
	
	@Override
	public int addArmor(String armor) {
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	
}
