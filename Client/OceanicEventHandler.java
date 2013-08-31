package mods.CountryGamer_Oceanic.Client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.BreakSpeed;

public class OceanicEventHandler {
	
	// Example use
	// http://www.minecraftforum.net/topic/1952901-eventhandler-and-iextendedentityproperties/
	@ForgeSubscribe
	public void onLivingUpdateEvent(LivingUpdateEvent event) {
		if( event.entity instanceof EntityPlayer ) {
			EntityPlayer player = (EntityPlayer)event.entity;
			if( player.isInWater() ) {
				ItemStack helmet = player.getCurrentItemOrArmor(4);
				ItemStack chest = player.getCurrentItemOrArmor(3);
				ItemStack legs = player.getCurrentItemOrArmor(2);
				ItemStack boots = player.getCurrentItemOrArmor(1);
				
				if( helmet != null) {
					if( helmet.itemID == OceanicMain.wetsuitHead.itemID ) {
						if( player.getAir() % 256 == 0 ) { // 32 keeps it at full
							player.setAir(player.getAir()+30);
						}
					}
					if( helmet.itemID == OceanicMain.divingSuitHead.itemID ) {
						player.setAir(300);
						player.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 10, 1));
					}else{
						player.removePotionEffect(Potion.nightVision.getId());
					}
				}
				if( legs != null) {
					
					if( legs.itemID == OceanicMain.wetsuitLegs.itemID ) {
						
					}
					if( legs.itemID == OceanicMain.divingSuitLegs.itemID ) {
						
					}
				}
				if( boots != null) {
					
					if( boots.itemID == OceanicMain.wetsuitBoots.itemID ) {
						
					}
					if( boots.itemID == OceanicMain.divingSuitBoots.itemID ) {
						
					}
				}

			}
		}
		
	}
	
	@ForgeSubscribe
	public void onBreaking(BreakSpeed event) {
		if( event.entity instanceof EntityPlayer ) {
			EntityPlayer player = (EntityPlayer)event.entity;
			if( player.isInWater() ) {
				ItemStack chest = player.getCurrentItemOrArmor(3);
				if( chest != null ) {
					float speed1 = event.originalSpeed;
					if( chest.itemID == OceanicMain.wetsuitBody.itemID ) {
						event.newSpeed = speed1+(speed1*2F);//0.5F);
					}
					if( chest.itemID == OceanicMain.divingSuitBody.itemID ) {
						event.newSpeed = speed1*4F;//2F;
					}
				}
			}
		}
		
		
	}
	
}
