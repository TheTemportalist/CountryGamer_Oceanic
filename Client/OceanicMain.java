package mods.CountryGamer_Oceanic.Client;

import java.lang.reflect.Field;
import java.util.Map;

import mods.CountryGamer_Oceanic.Blocks.BlockAerateOre;
import mods.CountryGamer_Oceanic.Items.ItemBase;
import mods.CountryGamer_Oceanic.Items.ItemOceanicArmor;
import mods.CountryGamer_Oceanic.Server.CraftingHandler;
import mods.CountryGamer_Oceanic.Server.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementMap;
import net.minecraft.stats.StatList;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = OceanicMain.modid, name=OceanicMain.name, version=OceanicMain.modVersion)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class OceanicMain {
	
	public static final String modid = "CountryGamer_Oceanic";
	public static final String modidLower = modid.toLowerCase();
	public static final String name = "Oceanic Mod";
	public static final String modVersion = "1.0";
	public static final String gameVersion = "1.6.2";
	
	//@Instance
	//public OceanicMain instance = new OceanicMain();
	@SidedProxy(clientSide="mods.CountryGamer_Oceanic.Client.ClientProxy",
				serverSide="mods.CountryGamer_Oceanic.Server.ServerProxy")
	public static ServerProxy proxy;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public static String base_Tex = OceanicMain.modidLower + ":";
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Items */
	public static Item	satLeather,		waterResLeather;
	public static int	satLeatherID,	waterResLeatherID;
	public static Item	wetsuitHead,	wetsuitBody,
						wetsuitLegs,	wetsuitBoots;
	public static int	wetsuitHeadID,	wetsuitBodyID,
						wetsuitLegsID,	wetsuitBootsID;
	public static Item	aeratePiece,	aerateIngot;
	public static int	aeratePieceID,	aerateIngotID;
	public static Item	divingSuitHead,	divingSuitBody,
						divingSuitLegs,	divingSuitBoots;
	public static int	divingSuitHeadID,	divingSuitBodyID,
						divingSuitLegsID,	divingSuitBootsID;
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Blocks */
	public static Block	aerateOre;
	public static int	aerateOreID;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Armor */
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Mobs */
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Other */
	public static CreativeTabs oceanic;
	public static EnumArmorMaterial wetsuitArmor	= EnumHelper.addArmorMaterial("wetsuit", 6, new int[]{1, 3, 2, 1}, 10);
	public static EnumArmorMaterial divingSuitArmor	= EnumHelper.addArmorMaterial("divingSuit", 10, new int[]{3, 5, 4, 3}, 7);
	public static OceanicGenerator oceanGen = new OceanicGenerator();
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Achievements */
	public static CraftingHandler craftHandler = new CraftingHandler();
	public static Achievement diveAchieve;
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@EventHandler
	/**
	 * Before doing things with the mod. Holds Config file setup
	 * @param event
	 */
	public static void preInit(FMLPreInitializationEvent event) {
		/*
		 * Config File Setup
		 */
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		String		itemCate = "Item IDs",	blockCate = "Block IDs",
					general = config.CATEGORY_GENERAL
			;
		config.load();
		
		aerateOreID			= config.get(blockCate,	"Aerate Ore",				600).getInt();
		
		satLeatherID		= config.get(itemCate,	"Saturated Leather",		650).getInt();
		waterResLeatherID	= config.get(itemCate,	"Water Resistant Leather",	651).getInt();
		
		wetsuitHeadID		= config.get(itemCate,	"Wetsuit Armor: Head",		652).getInt();
		wetsuitBodyID		= config.get(itemCate,	"Wetsuit Armor: Body",		653).getInt();
		wetsuitLegsID		= config.get(itemCate,	"Wetsuit Armor: Legs",		654).getInt();
		wetsuitBootsID		= config.get(itemCate,	"Wetsuit Armor: Boots",		655).getInt();
		
		aeratePieceID		= config.get(itemCate,	"Aerate Piece",				656).getInt();
		aerateIngotID		= config.get(itemCate,	"Aerate Ingot",				657).getInt();
		
		divingSuitHeadID	= config.get(itemCate,	"Diving Suit Armor: Head",	658).getInt();
		divingSuitBodyID	= config.get(itemCate,	"Diving Suit Armor: Body",	659).getInt();
		divingSuitLegsID	= config.get(itemCate,	"Diving Suit Armor: Legs",	660).getInt();
		divingSuitBootsID	= config.get(itemCate,	"Diving Suit Armor: Boots",	661).getInt();
		
		
		
		config.save();
		
		/*
		 * Other Things
		 */
		
	}
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.registerThings();
		proxy.registerServerTickHandler();

		oceanic = new CreativeTabs("oceanic") {
			public ItemStack getIconItemStack() {
				return new ItemStack(Item.eyeOfEnder, 1, 0);
			}
		};
		LanguageRegistry.instance().addStringLocalization("itemGroup.oceanic", "Oceanic Mod");
		
		items();
		armor();
		blocks();
		craftSmelt();
		
		achievements();
		
		GameRegistry.registerWorldGenerator(oceanGen);
	}
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event) {
		
	}
	
	public static void armor() {
		int armorAdd;
		armorAdd = proxy.addArmor("wetsuit");
		wetsuitHead = new ItemOceanicArmor(wetsuitHeadID,	wetsuitArmor, armorAdd, 0)
				.setUnlocalizedName("wetsuitHead");
		LanguageRegistry.addName(wetsuitHead, "Wetsuit Helmet");
		wetsuitBody = new ItemOceanicArmor(wetsuitBodyID,	wetsuitArmor, armorAdd, 1)
				.setUnlocalizedName("wetsuitBody");
		LanguageRegistry.addName(wetsuitBody, "Wetsuit Chest");
		wetsuitLegs = new ItemOceanicArmor(wetsuitLegsID,	wetsuitArmor, armorAdd, 2)
				.setUnlocalizedName("wetsuitLegs");
		LanguageRegistry.addName(wetsuitLegs, "Wetsuit Leggings");
		wetsuitBoots = new ItemOceanicArmor(wetsuitBootsID,	wetsuitArmor, armorAdd, 3)
				.setUnlocalizedName("wetsuitBoots");
		LanguageRegistry.addName(wetsuitBoots, "Wetsuit Boots");
		
		armorAdd = proxy.addArmor("divingSuit");
		divingSuitHead = new ItemOceanicArmor(divingSuitHeadID, divingSuitArmor, armorAdd, 0)
				.setUnlocalizedName("divingSuitHead");
		LanguageRegistry.addName(divingSuitHead, "Diving Suit Helmet");
		divingSuitBody = new ItemOceanicArmor(divingSuitBodyID, divingSuitArmor, armorAdd, 0)
				.setUnlocalizedName("divingSuitBody");
		LanguageRegistry.addName(divingSuitBody, "Diving Suit Chest");
		divingSuitLegs = new ItemOceanicArmor(divingSuitLegsID, divingSuitArmor, armorAdd, 0)
				.setUnlocalizedName("divingSuitLegs");
		LanguageRegistry.addName(divingSuitLegs, "Diving Suit Leggings");
		divingSuitBoots = new ItemOceanicArmor(divingSuitBootsID, divingSuitArmor, armorAdd, 0)
				.setUnlocalizedName("divingSuitBoots");
		LanguageRegistry.addName(divingSuitBoots, "Diving Suit Boots");
		
	}
	public static void items() {
		satLeather = new ItemBase(satLeatherID).setUnlocalizedName("satLeather");
		LanguageRegistry.addName(satLeather, "Saturated Leather");
		waterResLeather = new ItemBase(waterResLeatherID).setUnlocalizedName("waterResLeather");
		LanguageRegistry.addName(waterResLeather, "Water Resistant Leather");
		aeratePiece = new ItemBase(aeratePieceID).setUnlocalizedName("aeratePiece");
		LanguageRegistry.addName(aeratePiece, "Aerate Piece");
		aerateIngot = new ItemBase(aerateIngotID).setUnlocalizedName("aerateIngot");
		LanguageRegistry.addName(aerateIngot, "Aerate Ingot");
		
	}
	public static void blocks() {
		aerateOre = new BlockAerateOre(aerateOreID, Material.rock).setUnlocalizedName("aerateOre");
		LanguageRegistry.addName(aerateOre, "Aerate Ore");
		GameRegistry.registerBlock(aerateOre, aerateOre.getUnlocalizedName());
		
	}
	public static void craftSmelt() {
		/** Aerate Block */
		GameRegistry.addSmelting(aerateOre.blockID, new ItemStack(aeratePiece), 0.1f);
		/** Aerate Piece */
		GameRegistry.addSmelting(aeratePiece.itemID, new ItemStack(aerateIngot), 0.1f);
		/** Saturated Leather */
		GameRegistry.addShapelessRecipe(new ItemStack(satLeather, 1), new Object[] {
			Item.leather, (new ItemStack(Item.potion, 0, 1))
		});
		/** Water Resistant Leather */
		GameRegistry.addSmelting(satLeather.itemID, new ItemStack(waterResLeather), 0.1f);
		/** Wetsuit */
		GameRegistry.addRecipe(new ItemStack(wetsuitHead, 1), new Object[] {
			"xxx", "x x", 'x', OceanicMain.waterResLeather
		});
		GameRegistry.addRecipe(new ItemStack(wetsuitBody, 1), new Object[] {
			"x x", "xxx", "xxx", 'x', OceanicMain.waterResLeather
		});
		GameRegistry.addRecipe(new ItemStack(wetsuitLegs, 1), new Object[] {
			"xxx", "x x", "x x", 'x', OceanicMain.waterResLeather
		});
		GameRegistry.addRecipe(new ItemStack(wetsuitBoots, 1), new Object[] {
			"x x", "x x", 'x', OceanicMain.waterResLeather
		});
		/** Diving Suit */
		GameRegistry.addRecipe(new ItemStack(divingSuitHead, 1), new Object[] {
			"xxx", "xcx", 'x', OceanicMain.aerateIngot, 'c', OceanicMain.wetsuitHead
		});
		GameRegistry.addRecipe(new ItemStack(divingSuitBody, 1), new Object[] {
			"xcx", "xxx", "xxx", 'x', OceanicMain.aerateIngot, 'c', OceanicMain.wetsuitBody
		});
		GameRegistry.addRecipe(new ItemStack(divingSuitLegs, 1), new Object[] {
			"xxx", "xcx", "xxx", 'x', OceanicMain.aerateIngot, 'c', OceanicMain.wetsuitLegs
		});
		GameRegistry.addRecipe(new ItemStack(divingSuitBoots, 1), new Object[] {
			"xcx", "x x", 'x', OceanicMain.aerateIngot, 'c', OceanicMain.wetsuitBoots
		});
		
	}
	
	public static void achievements() {
		GameRegistry.registerCraftingHandler(craftHandler);
		diveAchieve = new Achievement(
				2001, "DiveAchieve", 1, -2, Item.eyeOfEnder, null);
		LanguageRegistry.instance().addStringLocalization(
				"achievement.DiveAchieve", "en_US",
				"Got Dive Achieve!");
		LanguageRegistry.instance().addStringLocalization(
				"achievement.DiveAchieve.desc", "en_US",
				"You got the Wetsuit Helmet");
		addHiddenAchievement(diveAchieve);
	}
	public static boolean addHiddenAchievement(Achievement ach) {
	    StatList.allStats.add(ach);
	            
	    Map oneShotStats = null;
	    Field field = null;
	    
	    for (Field f : StatList.class.getDeclaredFields()) {
	        f.setAccessible(true);
	        try {
	                        if (f.getName().equals("oneShotStats") || f.getName().equals("field_75942_a")) {
	                                oneShotStats = (Map)f.get(null);
	                                field = f;
	                        }
	                } catch (Exception ex) {
	                        System.out.println("no field " + ex);
	                        return false;
	                }
	    }
	   
	        
	        if (oneShotStats == null) return false;
	        
	        try {
	                if (oneShotStats.containsKey(Integer.valueOf(ach.statId))) {
	                        System.out.println("Already existing Achievement with this stat id!");
	            return false;
	        }
	                
	                oneShotStats.put(Integer.valueOf(ach.statId), ach);
	        } catch (Exception e) {
	                System.out.println("Failed setting");
	                return false;
	        }
	        
	        
	    ach.statGuid = AchievementMap.getGuid(ach.statId);
	        
	    return true;
	}
	
}
