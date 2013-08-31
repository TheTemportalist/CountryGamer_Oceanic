package mods.CountryGamer_Oceanic.Server;

import java.util.EnumSet;

import mods.CountryGamer_Oceanic.Client.OceanicMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class ServerTickHandler implements ITickHandler
{
	
	private void onPlayerTick(EntityPlayer player) {
		   
		ItemStack helmet = player.getCurrentItemOrArmor(4);
		ItemStack chest = player.getCurrentItemOrArmor(3);
		ItemStack legs = player.getCurrentItemOrArmor(2);
		ItemStack boots = player.getCurrentItemOrArmor(1);
		if(	helmet != null && helmet.getItem() == OceanicMain.wetsuitHead) {
			//potion id, number of ticks, level + 1
			//ticks can be at 20 because this is updated every tick
			if( player.isInWater() ) {
				//player.setAir(300);
				
				int length = 120, strength = 5;//3
				//player.addPotionEffect((new PotionEffect(Potion.nightVision.getId(), length, strength)));
			}
		}
		if(	chest != null && chest.getItem() == OceanicMain.wetsuitBody) {
			
		}
		if(	legs != null && legs.getItem() == OceanicMain.wetsuitLegs) {
			
		}
		if(	boots != null && boots.getItem() == OceanicMain.wetsuitBoots) {
			
		}
		
		
		if(	helmet != null && helmet.getItem() == OceanicMain.divingSuitHead) {
			
		}
		if(	chest != null && chest.getItem() == OceanicMain.divingSuitBody) {
			
		}
		if(	legs != null && legs.getItem() == OceanicMain.divingSuitLegs) {
			
		}
		if(	boots != null && boots.getItem() == OceanicMain.divingSuitBoots) {
			
		}
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{
		if (type.equals(EnumSet.of(TickType.PLAYER)))
		{
				onPlayerTick((EntityPlayer)tickData[0]);
		}
	}

	@Override
	public EnumSet<TickType> ticks() 
	{
		return EnumSet.of(TickType.PLAYER, TickType.SERVER);
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public String getLabel()
	{
		// TODO Auto-generated method stub
		return null;
	}

}