package mods.CountryGamer_Oceanic.Client;

import java.lang.reflect.Field;
import java.util.Map;

import mods.CountryGamer_Core.BlockBase;
import mods.CountryGamer_Core.ItemBase;
import mods.CountryGamer_Oceanic.Blocks.BlockAerateOre;
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
import net.minecraftforge.common.MinecraftForge;
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
	public static Item	wetsuitHead,	wetsuitBody;
	public static Item	wetsuitLegs,	wetsuitBoots;
	public static int	wetsuitHeadID,	wetsuitBodyID;
	public static int	wetsuitLegsID,	wetsuitBootsID;
	public static Item	aeratePiece,	aerateIngot;
	public static int	aeratePieceID,	aerateIngotID;
	public static Item	divingSuitHead,	divingSuitBody;
	public static Item	divingSuitLegs,	divingSuitBoots;
	public static int	divingSuitHeadID,	divingSuitBodyID;
	public static int	divingSuitLegsID,	divingSuitBootsID;
	public static Item	derrAerate;
	public static int	derrAerateID;
	public static Item	compAerate;
	public static int	compAerateID;
	public static Item	hardAerate;
	public static int	hardAerateID;
	public static Item	waterSuitHead,	waterSuitBody;
	public static Item	waterSuitLegs,	waterSuitBoots;
	public static int	waterSuitHeadID,	waterSuitBodyID;
	public static int	waterSuitLegsID,	waterSuitBootsID;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Blocks */
	public static Block	aerateOre;
	public static int	aerateOreID;
	public static Block	aerateBlock, aerateBlockHard;
	public static int	aerateBlockID, aerateBlockHardID;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Armor */
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Mobs */
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	/** Other */
	public static CreativeTabs oceanic;
	public static EnumArmorMaterial wetsuitArmor	= EnumHelper.addArmorMaterial("wetsuit", 6, new int[]{1, 3, 2, 1}, 10);
	public static EnumArmorMaterial divingSuitArmor	= EnumHelper.addArmorMaterial("divingSuit", 10, new int[]{5, 7, 6, 5}, 7);
	public static EnumArmorMaterial waterSuitArmor	= EnumHelper.addArmorMaterial("waterSuit", 8, new int[]{3, 5, 4, 3}, 5);
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
		aerateBlockID		= config.get(blockCate,	"Aerate Block",				601).getInt();
		aerateBlockHardID	= config.get(blockCate,	"Hardened Aerate Block",	602).getInt();

		
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
		
		derrAerateID		= config.get(itemCate,	"Derrived Aerate",			662).getInt();
		
		//waterSuitHeadID		= config.get(itemCate,	"Water Suit Armor: Head",	663).getInt();
		//waterSuitBodyID		= config.get(itemCate,	"Water Suit Armor: Body",	664).getInt();
		//waterSuitLegsID		= config.get(itemCate,	"Water Suit Armor: Legs",	665).getInt();
		//waterSuitBootsID	= config.get(itemCate,	"Water Suit Armor: Boots",	666).getInt();
		
		
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
		MinecraftForge.EVENT_BUS.register(new OceanicEventHandler());
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
		divingSuitBody = new ItemOceanicArmor(divingSuitBodyID, divingSuitArmor, armorAdd, 1)
				.setUnlocalizedName("divingSuitBody");
		LanguageRegistry.addName(divingSuitBody, "Diving Suit Chest");
		divingSuitLegs = new ItemOceanicArmor(divingSuitLegsID, divingSuitArmor, armorAdd, 2)
				.setUnlocalizedName("divingSuitLegs");
		LanguageRegistry.addName(divingSuitLegs, "Diving Suit Leggings");
		divingSuitBoots = new ItemOceanicArmor(divingSuitBootsID, divingSuitArmor, armorAdd, 3)
				.setUnlocalizedName("divingSuitBoots");
		LanguageRegistry.addName(divingSuitBoots, "Diving Suit Boots");
		/*
		armorAdd = proxy.addArmor("waterSuit");
		waterSuitHead = new ItemOceanicArmor(waterSuitHeadID, waterSuitArmor, armorAdd, 0)
				.setUnlocalizedName("waterSuitHead");
		LanguageRegistry.addName(waterSuitHead, "Water Suit Helmet");
		waterSuitBody = new ItemOceanicArmor(waterSuitBodyID, waterSuitArmor, armorAdd, 1)
				.setUnlocalizedName("waterSuitBody");
		LanguageRegistry.addName(waterSuitBody, "Water Suit Chest");
		waterSuitLegs = new ItemOceanicArmor(waterSuitLegsID, waterSuitArmor, armorAdd, 2)
				.setUnlocalizedName("waterSuitLegs");
		LanguageRegistry.addName(waterSuitLegs, "Water Suit Leggings");
		waterSuitBoots = new ItemOceanicArmor(waterSuitBootsID, waterSuitArmor, armorAdd, 3)
				.setUnlocalizedName("waterSuitBoots");
		LanguageRegistry.addName(waterSuitBoots, "Water Suit Boots");
		*/
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
		derrAerate = new ItemBase(derrAerateID).setUnlocalizedName("derrAerate");
		LanguageRegistry.addName(derrAerate, "Derrived Aerate");
		compAerate = new ItemBase(compAerateID).setUnlocalizedName("compAerate");
		LanguageRegistry.addName(compAerate, "Compressed Aerate");
		hardAerate = new ItemBase(hardAerateID).setUnlocalizedName("hardAerate");
		LanguageRegistry.addName(hardAerate, "Hardened Aerate");
		
		
	}
	public static void blocks() {
		aerateOre = new BlockAerateOre(aerateOreID, Material.rock).setUnlocalizedName("aerateOre");
		LanguageRegistry.addName(aerateOre, "Aerate Ore");
		GameRegistry.registerBlock(aerateOre, aerateOre.getUnlocalizedName());
		
		aerateBlock = new BlockBase(aerateBlockID, Material.rock).setUnlocalizedName("aerateBlock");
		LanguageRegistry.addName(aerateBlock, "Aerate Block");
		GameRegistry.registerBlock(aerateBlock, aerateBlock.getUnlocalizedName());
		aerateBlockHard = new BlockAerateOre(aerateBlockHardID, Material.rock).setUnlocalizedName("aerateBlockHard");
		LanguageRegistry.addName(aerateBlockHard, "Hardened Aerate Block");
		GameRegistry.registerBlock(aerateBlockHard, aerateBlockHard.getUnlocalizedName());
		
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
		/** Water Suit *//*
		GameRegistry.addRecipe(new ItemStack(waterSuitHead, 1), new Object[] {
			"ccc", " x ", 'x', OceanicMain.divingSuitHead, 'c', Item.feather
		});
		GameRegistry.addRecipe(new ItemStack(waterSuitBody, 1), new Object[] {
			"c c", "cxc", "ccc", 'x', OceanicMain.divingSuitBody, 'c', Item.feather
		});
		GameRegistry.addRecipe(new ItemStack(waterSuitLegs, 1), new Object[] {
			"ccc", " x ", "c c", 'x', OceanicMain.divingSuitLegs, 'c', Item.feather
		});
		GameRegistry.addRecipe(new ItemStack(waterSuitBoots, 1), new Object[] {
			"cxc", "c c", 'x', OceanicMain.divingSuitBoots, 'c', Item.feather
		});*/
		/** Aerate */
		GameRegistry.addRecipe(new ItemStack(compAerate, 1), new Object[] {
			"xxx", "xxx", "xxx", 'x', OceanicMain.aerateIngot
		});
		GameRegistry.addSmelting(compAerate.itemID, new ItemStack(hardAerate), 0.1f);
		GameRegistry.addRecipe(new ItemStack(aerateBlockHard, 1), new Object[] {
			"xxx", "xxx", "xxx", 'x', OceanicMain.hardAerate
		});
		GameRegistry.addShapelessRecipe(new ItemStack(hardAerate, 9), new Object[] {
			OceanicMain.aerateBlockHard
		});
		GameRegistry.addRecipe(new ItemStack(aerateBlock, 1), new Object[] {
			"xxx", "xxx", "xxx", 'x', OceanicMain.aerateIngot
		});
		GameRegistry.addSmelting(aerateBlock.blockID, new ItemStack(aerateBlockHard), 0.1f);
		GameRegistry.addShapelessRecipe(new ItemStack(aerateIngot, 9), new Object[] {
			OceanicMain.aerateBlock
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
