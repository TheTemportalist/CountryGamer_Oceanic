package CountryGamer_Oceanic.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class EntDec {
	
	static int startEntityId = 300;
	public void mobs() {
		int mobID = 499;
		EntityRegistry.registerModEntity(EntityShark.class, "Shark", ++mobID, this, 80, 3, true);
		EntityRegistry.addSpawn(EntityShark.class, 10, 2, 4, EnumCreatureType.monster, BiomeGenBase.ocean);	
		LanguageRegistry.instance().addStringLocalization("entity.Shark.Tutorial.name", "Shark");
		registerEntityEgg(EntityShark.class, 0xffffff, 0x000000);
		
	}
	
	
	public static int getUniqueEntityId() 
	 {
	  do 
	  {
	   startEntityId++;
	  } 
	  while (EntityList.getStringFromID(startEntityId) != null);

	   return startEntityId;
	 }
	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor) 
	 {
	  int id = getUniqueEntityId();
	  EntityList.IDtoClassMapping.put(id, entity);
	  EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
	 }
	
}
