package mods.CountryGamer_Oceanic.Server;

import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ServerProxy {
	
	public void registerThings() {}
	
	public int addArmor(String armor) {
		return 0;
	}
	
	public void registerServerTickHandler() {
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
	}
	
}
