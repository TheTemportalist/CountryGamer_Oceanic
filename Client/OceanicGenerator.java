package CountryGamer_Oceanic.Client;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class OceanicGenerator implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
	}

	private void generateEnd(World world, Random random, int i, int j) {}

	private void generateSurface(World world, Random random, int i, int j) {
		String s = world.getBiomeGenForCoords(i + 8, j + 8).biomeName;
		if (s.startsWith("Ocean") || s.startsWith("River")) {
		
			int orePerChunk = 3;
			int orePerVein = 4;
			for(int k = 0; k < orePerChunk; k++) {
				int chunkX = i+random.nextInt(16);
				int chunkY = random.nextInt(60);
				int chunkZ = j+random.nextInt(16);
				(new WorldGenMinable(Block.glowStone.blockID, orePerVein,
						Block.dirt.blockID)).generate(
								world, random, chunkX, chunkY, chunkZ);
				(new WorldGenMinable(Block.glowStone.blockID, orePerVein,
						Block.sand.blockID)).generate(
								world, random, chunkX, chunkY, chunkZ);
				(new WorldGenMinable(Block.glowStone.blockID, orePerVein,
						Block.blockClay.blockID)).generate(
								world, random, chunkX, chunkY, chunkZ);
				(new WorldGenMinable(Block.glowStone.blockID, orePerVein,
						Block.waterStill.blockID)).generate(
								world, random, chunkX, chunkY, chunkZ);
			}
        }
		
		
	}

	private void generateNether(World world, Random random, int i, int j) {}
}