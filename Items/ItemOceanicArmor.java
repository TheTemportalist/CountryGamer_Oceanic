package mods.CountryGamer_Oceanic.Items;

import mods.CountryGamer_Oceanic.Client.OceanicMain;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class ItemOceanicArmor extends ItemArmor {

	public ItemOceanicArmor(int id, EnumArmorMaterial mat,
			int render, int index) {
		super(id, mat, render, index);
		this.setCreativeTab(OceanicMain.oceanic);
		this.setTextureName(OceanicMain.base_Tex + this.getUnlocalizedName());
	}

}
