package mods.CountryGamer_Oceanic.Client;

import mods.CountryGamer_Oceanic.Entities.EntityShark;
import mods.CountryGamer_Oceanic.RenderModels.RenderShark;
import mods.CountryGamer_Oceanic.Server.ServerProxy;
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
