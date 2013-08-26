package mods.CountryGamer_Oceanic.Blocks;

import mods.CountryGamer_Oceanic.Client.OceanicMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


public class BlockBase extends Block {

	public BlockBase(int id, Material mat) {
		super(id, mat);
		this.setCreativeTab(OceanicMain.oceanic);
		this.func_111022_d(OceanicMain.base_Tex + this.getUnlocalizedName());
	}
	
	
	
}
