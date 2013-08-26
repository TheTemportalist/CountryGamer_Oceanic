package mods.CountryGamer_Oceanic.Items;

import mods.CountryGamer_Oceanic.Client.OceanicMain;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	public ItemBase(int id) {
		super(id);
		this.setMaxStackSize(64);
		this.setCreativeTab(OceanicMain.oceanic);
		if( this.getUnlocalizedName().equals(""))
			this.setUnlocalizedName("genericItem");	
		this.func_111206_d(OceanicMain.base_Tex + this.getUnlocalizedName());
	}
	
	
	
	
	
}
