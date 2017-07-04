package Oneric.MNC.dimensions;

import java.util.List;
import java.util.Random;

import Oneric.MNC.common.MNCBiomes;
import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.world.gen.WorldGenClouds;
import Oneric.MNC.world.gen.WorldGenMineableMadness;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ChunkProviderCrazy implements IChunkProvider
{
    private BiomeGenBase biomesForGeneration[];
    public static int gumCount;
    private Random random;
    private NoiseGeneratorOctaves noiseGenerator1;
    private NoiseGeneratorOctaves noiseGenerator2;
    private NoiseGeneratorOctaves noiseGenerator3;
    private NoiseGeneratorOctaves noiseGenerator4;
    private NoiseGeneratorOctaves noiseGenerator5;
    public NoiseGeneratorOctaves noiseGenerator6;
    public NoiseGeneratorOctaves noiseGenerator7;
    public NoiseGeneratorOctaves noiseGenerator8;
    private World worldObj;
    private double field_28080_q[];
    private double field_28079_r[];
    private double field_28078_s[];
    private double field_28077_t[];
    private MapGenBase mapGenCaves;
    private BiomeGenBase field_28075_v[];
    double field_28093_d[];
    double field_28092_e[];
    double field_28091_f[];
    double field_28090_g[];
    double field_28089_h[];
    int field_28088_i[][];
    private double field_28074_w[];
    public byte topMNCBlock;
    public byte fillerMNCBlock;
    private double stoneNoise[];

    public ChunkProviderCrazy(World world, long l)
    {
        field_28079_r = new double[256];
        field_28078_s = new double[256];
        field_28077_t = new double[256];
        mapGenCaves = new MapGenCaves();
        field_28088_i = new int[32][32];
        worldObj = world;
        random = new Random(l);
        noiseGenerator1 = new NoiseGeneratorOctaves(random, 16);
        noiseGenerator2 = new NoiseGeneratorOctaves(random, 16);
        noiseGenerator3 = new NoiseGeneratorOctaves(random, 8);
        noiseGenerator4 = new NoiseGeneratorOctaves(random, 4);
        noiseGenerator5 = new NoiseGeneratorOctaves(random, 4);
        noiseGenerator6 = new NoiseGeneratorOctaves(random, 10);
        noiseGenerator7 = new NoiseGeneratorOctaves(random, 16);
        noiseGenerator8 = new NoiseGeneratorOctaves(random, 8);
    }

    
    //generate Terrain 
    public void func_28071_a(int i, int j, byte abyte0[])
    {
    	
    	
    	byte byte0 = 2;
        int k = byte0 + 1;
        byte byte1 = 33;
        int l = byte0 + 1;
        field_28080_q = func_28073_a(field_28080_q, i * byte0, 0, j * byte0, k, byte1, l);
        for(int i1 = 0; i1 < byte0; i1++)
        {
            for(int j1 = 0; j1 < byte0; j1++)
            {
                for(int k1 = 0; k1 < 32; k1++)
                {
                    double d = 0.25D;
                    double d1 = field_28080_q[((i1 + 0) * l + (j1 + 0)) * byte1 + (k1 + 0)];
                    double d2 = field_28080_q[((i1 + 0) * l + (j1 + 1)) * byte1 + (k1 + 0)];
                    double d3 = field_28080_q[((i1 + 1) * l + (j1 + 0)) * byte1 + (k1 + 0)];
                    double d4 = field_28080_q[((i1 + 1) * l + (j1 + 1)) * byte1 + (k1 + 0)];
                    double d5 = (field_28080_q[((i1 + 0) * l + (j1 + 0)) * byte1 + (k1 + 1)] - d1) * d;
                    double d6 = (field_28080_q[((i1 + 0) * l + (j1 + 1)) * byte1 + (k1 + 1)] - d2) * d;
                    double d7 = (field_28080_q[((i1 + 1) * l + (j1 + 0)) * byte1 + (k1 + 1)] - d3) * d;
                    double d8 = (field_28080_q[((i1 + 1) * l + (j1 + 1)) * byte1 + (k1 + 1)] - d4) * d;
                    for(int l1 = 0; l1 < 4; l1++)
                    {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * d9;
                        double d13 = (d4 - d2) * d9;
                        for(int i2 = 0; i2 < 8; i2++)
                        {
                            int j2 = i2 + i1 * 8 << 11 | 0 + j1 * 8 << 7 | k1 * 4 + l1;
                            char c = '\200';
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * d14;
                            for(int k2 = 0; k2 < 8; k2++)
                            {
                                int l2 = 0;
                                if(d15 > 0.0D)
                                {
                                    l2 = MNCBlocks.DeadStone.blockID;
                                }
                                abyte0[j2] = (byte)l2;
                                j2 += c;
                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }

                }

            }

        }
    }

    //replace for biomes
    public void func_28072_a(int i, int j, byte abyte0[])
    {
       /**
    	double d = 0.03125D;
        field_28079_r = noiseGenerator4.generateNoiseOctaves(field_28079_r, i * 16, j * 16, 0, 16, 16, 1, d, d, 1.0D);
        field_28078_s = noiseGenerator4.generateNoiseOctaves(field_28078_s, i * 16, 109, j * 16, 16, 1, 16, d, 1.0D, d);
        field_28077_t = noiseGenerator5.generateNoiseOctaves(field_28077_t, i * 16, j * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);

        for (int k = 0; k < 16; k++)
        {
            for (int l = 0; l < 16; l++)
            {
                int i1 = (int)(field_28077_t[k + l * 16] / 3D + 3D + random.nextDouble() * 0.25D);
                int j1 = -1;
                topMNCBlock = (byte)Block.mycelium.blockID;
                fillerMNCBlock = (byte)Block.dirt.blockID;
                byte byte0 = topMNCBlock;
                byte byte1 = fillerMNCBlock;
                byte byte2 = (byte) Block.cobblestoneMossy.blockID;

                if (byte0 < 0)
                {
                    byte0 += 0;
                }

                if (byte1 < 0)
                {
                    byte1 += 0;
                }

                if (byte2 < 0)
                {
                    byte2 += 0;
                }

                for (int k1 = 127; k1 >= 0; k1--)
                {
                    int l1 = (l * 16 + k) * 128 + k1;
                    byte byte3 = abyte0[l1];

                    if (byte3 == 0)
                    {
                        j1 = -1;
                        continue;
                    }

                    if (byte3 != byte2)
                    {
                        continue;
                    }

                    if (j1 == -1)
                    {
                        if (i1 <= 0)
                        {
                            byte0 = 0;
                            byte1 = byte2;
                        }

                        j1 = i1;

                        if (k1 >= 0)
                        {
                            abyte0[l1] = byte0;
                        }
                        else
                        {
                            abyte0[l1] = byte1;
                        }

                        continue;
                    }

                    if (j1 > 0)
                    {
                        j1--;
                        abyte0[l1] = byte1;
                    }
                }
            }
        }
        */
    	
    	 double d = 0.03125D;
         //unusedSandNoise = field_28083_n.generateNoiseOctaves(unusedSandNoise, i * 16, j * 16, 0.0D, 16, 16, 1, d, d, 1.0D);
         //unusedGravelNoise = field_28083_n.generateNoiseOctaves(unusedGravelNoise, i * 16, 109.0134D, j * 16, 16, 1, 16, d, 1.0D, d);
         stoneNoise = noiseGenerator4.generateNoiseOctaves(stoneNoise, i * 16, j * 16, 0, 16, 16, 1, d * 2D, d * 2D, d * 2D);
         for(int k = 0; k < 16; k++)
         {
             for(int l = 0; l < 16; l++)
             {
                 BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k, l);
                 int i1 = (int)(stoneNoise[k + l * 16] / 3D + 3D + random.nextDouble() * 0.25D);
                 int j1 = -1;
                 byte byte0 = biomegenbase.topBlock;
                 byte byte1 = biomegenbase.fillerBlock;
                // byte byte0 = (byte)MNCBlocks.deadGrass.blockID;
                // byte byte1 = (byte)MNCBlocks.deadDirt.blockID;
                 byte byte2 = (byte)MNCBlocks.DeadStone.blockID;

                 if (byte0 < 0)
                 {
                     byte0 += 0;
                 }

                 if (byte1 < 0)
                 {
                     byte1 += 0;
                 }

                 if (byte2 < 0)
                 {
                     byte2 += 0;
                 }

                 for (int k1 = 127; k1 >= 0; k1--)
                 {
                     int l1 = (l * 16 + k) * 128 + k1;
                     byte byte3 = abyte0[l1];

                     if (byte3 == 0)
                     {
                         j1 = -1;
                         continue;
                     }

                     if (byte3 != byte2)
                     {
                         continue;
                     }

                     if (j1 == -1)
                     {
                         if (i1 <= 0)
                         {
                             byte0 = 0;
                             byte1 = byte2;
                         }

                         j1 = i1;

                         if (k1 >= 0)
                         {
                             abyte0[l1] = byte0;
                         }
                         else
                         {
                             abyte0[l1] = byte1;
                         }

                         continue;
                     }

                     if (j1 > 0)
                     {
                         j1--;
                         abyte0[l1] = byte1;
                     }
                 }
             }
         }
    	
    	
    	
    }

    public Chunk prepareChunk(int i, int j)
    {
        return provideChunk(i, j);
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int i, int j)
    {
        random.setSeed((long)i * 0x4f9939f508L + (long)j * 0x1ef1565bd5L);
        byte abyte0[] = new byte[32768];
        func_28071_a(i, j, abyte0);
        func_28072_a(i, j, abyte0);
        //mapGenCaves.generate(this, worldObj, i, j, abyte0);
        Chunk chunk = new Chunk(worldObj, abyte0, i, j);
        chunk.generateSkylightMap();
        return chunk;
    }

    private double[] func_28073_a(double ad[], int i, int j, int k, int l, int i1, int j1)
    {
        if (ad == null)
        {
            ad = new double[l * i1 * j1];
        }

        double d = 684.41200000000003D;
        double d1 = 684.41200000000003D;
        field_28090_g = noiseGenerator6.generateNoiseOctaves(field_28090_g, i, k, l, j1, 1.121D, 1.121D, 0.5D);
        field_28089_h = noiseGenerator7.generateNoiseOctaves(field_28089_h, i, k, l, j1, 200D, 200D, 0.5D);
        d *= 2D;
        field_28093_d = noiseGenerator3.generateNoiseOctaves(field_28093_d, i, j, k, l, i1, j1, d / 80D, d1 / 160D, d / 80D);
        field_28092_e = noiseGenerator1.generateNoiseOctaves(field_28092_e, i, j, k, l, i1, j1, d, d1, d);
        field_28091_f = noiseGenerator2.generateNoiseOctaves(field_28091_f, i, j, k, l, i1, j1, d, d1, d);
        int k1 = 0;
        int l1 = 0;
        int i2 = 16 / l;

        for (int j2 = 0; j2 < l; j2++)
        {
            int k2 = j2 * i2 + i2 / 2;

            for (int l2 = 0; l2 < j1; l2++)
            {
                int i3 = l2 * i2 + i2 / 2;
                double d2 = 1.0D;
                d2 *= d2;
                d2 *= d2;
                d2 = 1.0D - d2;
                double d3 = (field_28090_g[l1] + 256D) / 512D;
                d3 *= d2;

                if (d3 > 1.0D)
                {
                    d3 = 1.0D;
                }

                double d4 = field_28089_h[l1] / 8000D;

                if (d4 < 0.0D)
                {
                    d4 = -d4 * 0.29999999999999999D;
                }

                d4 = d4 * 3D - 2D;

                if (d4 > 1.0D)
                {
                    d4 = 1.0D;
                }

                d4 /= 8D;
                d4 = 0.0D;

                if (d3 < 0.0D)
                {
                    d3 = 0.0D;
                }

                d3 += 0.5D;
                d4 = (d4 * (double)i1) / 16D;
                l1++;
                double d5 = (double)i1 / 2D;

                for (int j3 = 0; j3 < i1; j3++)
                {
                    double d6 = 0.0D;
                    double d7 = (((double)j3 - d5) * 8D) / d3;

                    if (d7 < 0.0D)
                    {
                        d7 *= -1D;
                    }

                    double d8 = field_28092_e[k1] / 512D;
                    double d9 = field_28091_f[k1] / 512D;
                    double d10 = (field_28093_d[k1] / 10D + 1.0D) / 2D;

                    if (d10 < 0.0D)
                    {
                        d6 = d8;
                    }
                    else if (d10 > 1.0D)
                    {
                        d6 = d9;
                    }
                    else
                    {
                        d6 = d8 + (d9 - d8) * d10;
                    }

                    d6 -= 8D;
                    int k3 = 32;

                    if (j3 > i1 - k3)
                    {
                        double d11 = (float)(j3 - (i1 - k3)) / ((float)k3 - 1.0F);
                        d6 = d6 * (1.0D - d11) + -30D * d11;
                    }

                    k3 = 8;

                    if (j3 < k3)
                    {
                        double d12 = (float)(k3 - j3) / ((float)k3 - 1.0F);
                        d6 = d6 * (1.0D - d12) + -30D * d12;
                    }

                    ad[k1] = d6;
                    k1++;
                }
            }
        }

        return ad;
    }

    /**
     * Checks to see if a chunk exists at x, y
     */
    public boolean chunkExists(int i, int j)
    {
        return true;
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider ichunkprovider, int i, int j)
    {
        BiomeGenCrazy biomegencrazy = new BiomeGenCrazy().me;
        BlockSand.fallInstantly = true;
        int k = i * 16;
        int l = j * 16;
        random.setSeed(worldObj.getSeed());
        long l1 = (random.nextLong() / 2L) * 2L + 1L;
        long l2 = (random.nextLong() / 2L) * 2L + 1L;
        random.setSeed((long)i * l1 + (long)j * l2 ^ worldObj.getSeed());
        double d = 0.25D;

        
        /*
        if (random.nextInt(32) == 0)
        {
            int i1 = k + random.nextInt(16);
            int j5 = random.nextInt(64) + 32;
            int j10 = l + random.nextInt(16);
            (new GenerateFloatingTree()).generate(worldObj, random, i1, j5, j10);
        }

        if (gumCount < 800)
        {
            gumCount++;
        }
        else if (random.nextInt(32) == 0)
        {
            boolean flag = false;
            int k5 = k + random.nextInt(16) + 8;
            int k10 = random.nextInt(64) + 32;
            int j15 = l + random.nextInt(16) + 8;
            flag = (new AetherGenGumdrop()).generate(worldObj, random, k5, k10, j15);

            if (flag)
            {
                gumCount = 0;
            }
        }

        for (int j1 = 0; j1 < 20; j1++)
        {
            int l5 = k + random.nextInt(16);
            int l10 = random.nextInt(128);
            int k15 = l + random.nextInt(16);
            (new AetherGenMinable(AetherBlocks.Dirt.blockID, 32)).generate(worldObj, random, l5, l10, k15);
        }

        for (int k1 = 0; k1 < 2; k1++)
        {
            int i6 = k + random.nextInt(16) + 8;
            int i11 = random.nextInt(128);
            int l15 = l + random.nextInt(16) + 8;
            (new AetherGenFlowers(AetherBlocks.WhiteFlower.blockID)).generate(worldObj, random, i6, i11, l15);
        }

        for (int i2 = 0; i2 < 2; i2++)
        {
            if (random.nextInt(2) == 0)
            {
                int j6 = k + random.nextInt(16) + 8;
                int j11 = random.nextInt(128);
                int i16 = l + random.nextInt(16) + 8;
                (new AetherGenFlowers(AetherBlocks.PurpleFlower.blockID)).generate(worldObj, random, j6, j11, i16);
            }
        }

        for (int j2 = 0; j2 < 10; j2++)
        {
            int k6 = k + random.nextInt(16);
            int k11 = random.nextInt(128);
            int j16 = l + random.nextInt(16);
            (new AetherGenMinable(AetherBlocks.Icestone.blockID, 32)).generate(worldObj, random, k6, k11, j16);
        }

*/
        for (int k2 = 0; k2 < 19; k2++)
        {
            int l6 = k + random.nextInt(16);
            int l11 = random.nextInt(128);
            int k16 = l + random.nextInt(16);
            (new WorldGenMineableMadness(MNCBlocks.orePlumbum.blockID, 11)).generate(worldObj, random, l6, l11, k16);
        }
/*
        for (int i3 = 0; i3 < 15; i3++)
        {
            int i7 = k + random.nextInt(16);
            int i12 = random.nextInt(64);
            int l16 = l + random.nextInt(16);
            (new AetherGenMinable(AetherBlocks.ZaniteOre.blockID, 8)).generate(worldObj, random, i7, i12, l16);
        }

        for (int j3 = 0; j3 < 8; j3++)
        {
            int j7 = k + random.nextInt(16);
            int j12 = random.nextInt(32);
            int i17 = l + random.nextInt(16);
            (new AetherGenMinable(AetherBlocks.GravititeOre.blockID, 7)).generate(worldObj, random, j7, j12, i17);
        }

        

*/
        if (random.nextInt(7) == 0)
        {
            int i4 = k + random.nextInt(16);
            int i8 = random.nextInt(64) + 32;
            int i13 = l + random.nextInt(16);
            (new WorldGenClouds(MNCBlocks.Smog.blockID, 10, false)).generate(worldObj, random, i4, i8, i13);
        }

        if (random.nextInt(50) == 0)
        {
            int j4 = k + random.nextInt(16);
            int j8 = random.nextInt(32);
            int j13 = l + random.nextInt(16);
            (new WorldGenClouds(MNCBlocks.Smog.blockID, 64, true)).generate(worldObj, random, j4, j8, j13);
        }
        /*


        if (random.nextInt(500) == 0)
        {
            int l4 = k + random.nextInt(16);
            int l8 = random.nextInt(32) + 64;
            int l13 = l + random.nextInt(16);
            (new AetherGenDungeonSilver(AetherBlocks.LockedDungeonStone.blockID, AetherBlocks.LockedLightDungeonStone.blockID, AetherBlocks.DungeonStone.blockID, AetherBlocks.LightDungeonStone.blockID, AetherBlocks.Holystone.blockID, 2, AetherBlocks.Holystone.blockID, 0, AetherBlocks.Pillar.blockID)).generate(worldObj, random, l4, l8, l13);
        }

        if (random.nextInt(5) == 0)
        {
            for (int i5 = k; i5 < k + 16; i5++)
            {
                for (int i9 = l; i9 < l + 16; i9++)
                {
                    for (int i14 = 0; i14 < 48; i14++)
                    {
                        if (worldObj.getBlockId(i5, i14, i9) == 0 && worldObj.getBlockId(i5, i14 + 1, i9) == AetherBlocks.Grass.blockID && worldObj.getBlockId(i5, i14 + 2, i9) == 0)
                        {
                            (new AetherGenQuicksoil(AetherBlocks.Quicksoil.blockID)).generate(worldObj, random, i5, i14, i9);
                            i14 = 128;
                        }
                    }
                }
            }
        }*/

        d = 0.5D;
        byte byte0 = 3;

        for (int j9 = 0; j9 < byte0; j9++)
        {
            int j14 = k + random.nextInt(16) + 8;
            int k17 = l + random.nextInt(16) + 8;
            WorldGenerator worldgenerator = biomegencrazy.getRandomWorldGenForTrees(random);
            worldgenerator.setScale(1.0D, 1.0D, 1.0D);
            worldgenerator.generate(worldObj, random, j14, worldObj.getHeightValue(j14, k17), k17);
        }

        /*
        if (random.nextInt(64) == 0 && mod_Aether.christmasContent)
        {
            int k9 = k + random.nextInt(16) + 8;
            int k14 = l + random.nextInt(16) + 8;
            GenerateChristmasTree generatechristmastree = new GenerateChristmasTree();
            generatechristmastree.setScale(1.0D, 1.0D, 1.0D);
            generatechristmastree.generate(worldObj, random, k9, worldObj.getHeightValue(k9, k14), k14);
        }

        for (int l9 = 0; l9 < 2; l9++)
        {
            int l14 = k + random.nextInt(16) + 8;
            int l17 = random.nextInt(128);
            int j18 = l + random.nextInt(16) + 8;
            (new AetherGenFlowers(AetherBlocks.BerryBush.blockID)).generate(worldObj, random, l14, l17, j18);
        }

        for (int i10 = 0; i10 < 50; i10++)
        {
            int i15 = k + random.nextInt(16) + 8;
            int i18 = random.nextInt(random.nextInt(120) + 8);
            int k18 = l + random.nextInt(16) + 8;
            (new AetherGenLiquids(Block.waterMoving.blockID)).generate(worldObj, random, i15, i18, k18);
        }*/

        SpawnerAnimals.performWorldGenSpawning(worldObj, biomegencrazy, k + 8, l + 8, 16, 16, random);
        BlockSand.fallInstantly = false;
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate)
    {
        return true;
    }

    /**
     * Unloads the 100 oldest chunks from memory, due to a bug with chunkSet.add() never being called it thinks the list
     * is always empty and will not remove any chunks.
     */
    public boolean unload100OldestChunks()
    {
        return false;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString()
    {
        return "RandomLevelSource";
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave()
    {
        return true;
    }

    /**
     * Returns the location of the closest structure of the specified type. If not found returns null.
     */
    public ChunkPosition findClosestStructure(World world, String s, int i, int j, int k)
    {
        return null;
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int i, int j)
    {
        return provideChunk(i, j);
    }

    /**
     * Returns a list of creatures of the specified type that can spawn at the given location.
     */
    public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i, int j, int k)
    {
        WorldChunkManager worldchunkmanager = worldObj.getWorldChunkManager();
        BiomeGenCrazy biomegenbase = new BiomeGenCrazy().me;

        if (biomegenbase == null)
        {
            return null;
        }
        else
        {
            return biomegenbase.getSpawnableList(enumcreaturetype);
        }
    }

	@Override
	public int getLoadedChunkCount() {
		
		return 0;
	}

	@Override
	public void recreateStructures(int var1, int var2) {
		
		
	}


	@Override
	public boolean unloadQueuedChunks() {
		
		return false;
	}


	@Override
	public void saveExtraData() {
		// TODO Auto-generated method stub
		
	}
}
