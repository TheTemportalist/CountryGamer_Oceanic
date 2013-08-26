package mods.CountryGamer_Oceanic.Server;

import mods.CountryGamer_Oceanic.Client.OceanicMain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftingHandler implements ICraftingHandler 
{
	//This is how you check if a player has crafted something that returns the block/item you want them to gain an achievement for
	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		if(		item.itemID == OceanicMain.wetsuitHead.itemID ||
				item.itemID == OceanicMain.wetsuitBody.itemID ||
				item.itemID == OceanicMain.wetsuitLegs.itemID ||
				item.itemID == OceanicMain.wetsuitBoots.itemID ) {
			player.addStat(OceanicMain.diveAchieve, 1);
		}
		if(		item.itemID == OceanicMain.divingSuitHead.itemID ||
				item.itemID == OceanicMain.divingSuitBody.itemID ||
				item.itemID == OceanicMain.divingSuitLegs.itemID ||
				item.itemID == OceanicMain.divingSuitBoots.itemID ) {
			player.addStat(OceanicMain.diveAchieve, 1);
		}
	}

        
        //This is how you check if a player has smelted something that returns the block/item you want them to gain an achievement for
        @Override
        public void onSmelting(EntityPlayer player, ItemStack item) 
        {
                
        }
}