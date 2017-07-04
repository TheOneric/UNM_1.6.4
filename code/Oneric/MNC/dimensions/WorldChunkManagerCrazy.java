package Oneric.MNC.dimensions;

import java.util.*;

import Oneric.MNC.common.MNCBiomes;

import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class WorldChunkManagerCrazy extends WorldChunkManager
{
    private BiomeGenBase biomeGenerator;
    private GenLayer  genBiomes;
    private GenLayer  biomeIndexLayer;
    private BiomeCache biomeCache;

    public WorldChunkManagerCrazy(double d)
    {
        biomeGenerator = MNCBiomes.crazy;
        
        WorldType type = new WorldTypeCrazy();
        long seed = new Random().nextLong();
        
        GenLayer[] var4 = GenLayer.initializeAllBiomeGenerators(seed, type);
        var4 = getModdedBiomeGenerators(type, seed, var4);
        this.genBiomes = var4[0];
        this.biomeIndexLayer = var4[1];
        this.biomeCache = new BiomeCache(this);
    }
    

  /* @Override
    public BiomeGenBase getBiomeGenAtChunkCoord(ChunkCoordIntPair chunkcoordintpair)
    {
        return biomeGenerator;
    }*/
    
   

    @Override
    /**
     * Returns the BiomeGenBase related to the x, z position on the world.
     */
    public BiomeGenBase getBiomeGenAt(int i, int j)
    {
        return biomeGenerator;
    }

    @Override
    /**
     * Returns a list of temperatures to use for the specified blocks.  Args: listToReuse, x, y, width, length
     */
    public float[] getTemperatures(float af[], int i, int j, int k, int l)
    {
        if (af == null || af.length < k * l)
        {
            af = new float[k * l];
        }

        Arrays.fill(af, 0, k * l, 1.0F);
        return af;
    }

    //@Override
   // public float[] func_40539_b(int i, int j, int k, int l)
    //{
     //   return getTemperatures(new float[k * l], i, j, k, l);
    //}

    @Override
    /**
     * Returns a list of rainfall values for the specified blocks. Args: listToReuse, x, z, width, length.
     */
    public float[] getRainfall(float af[], int i, int j, int k, int l)
    {
        if (af == null || af.length < k * l)
        {
            af = new float[k * l];
        }

        Arrays.fill(af, 0, k * l, 0.0F);
        return af;
    }

    @Override
    /**
     * Finds a valid position within a range, that is once of the listed biomes.
     */
    public ChunkPosition findBiomePosition(int i, int j, int k, List list, Random random)
    {
        if (list.contains(biomeGenerator))
        {
            return new ChunkPosition((i - k) + random.nextInt(k * 2 + 1), 0, (j - k) + random.nextInt(k * 2 + 1));
        }
        else
        {
            return null;
        }
    }

    @Override
    /**
     * Return a list of biomes for the specified blocks. Args: listToReuse, x, y, width, length, cacheFlag (if false,
     * don't check biomeCache to avoid infinite loop in BiomeCacheBlock)
     */
    public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6)
    {
        IntCache.resetIntCache();

        if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
        {
            par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
        }

        if (par6 && par4 == 16 && par5 == 16 && (par2 & 15) == 0 && (par3 & 15) == 0)
        {
            BiomeGenBase[] var9 = this.biomeCache.getCachedBiomes(par2, par3);
            System.arraycopy(var9, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
            return par1ArrayOfBiomeGenBase;
        }
        else
        {
            int[] var7 = this.biomeIndexLayer.getInts(par2, par3, par4, par5);

            for (int var8 = 0; var8 < par4 * par5; ++var8)
            {
                par1ArrayOfBiomeGenBase[var8] = MNCBiomes.CrazyBiomeList[var7[var8]];
            }

            return par1ArrayOfBiomeGenBase;
        }
    }

    @Override
    /**
     * checks given Chunk's Biomes against List of allowed ones
     */
    public boolean areBiomesViable(int i, int j, int k, List list)
    {
        return list.contains(biomeGenerator);
    }

    //@Override
    //public float func_35558_c(int i, int j)
    //{
    //    return 0.0F;
    //}

    @Override
    /**
     * Returns biomes to use for the blocks and loads the other data like temperature and humidity onto the
     * WorldChunkManager Args: oldBiomeList, x, z, width, depth
     */
    public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase abiomegenbase[], int i, int j, int k, int l)
    {
        if (abiomegenbase == null || abiomegenbase.length < k * l)
        {
            abiomegenbase = new BiomeGenBase[k * l];
        }

        Arrays.fill(abiomegenbase, 0, k * l, biomeGenerator);
        return abiomegenbase;
    }
}
