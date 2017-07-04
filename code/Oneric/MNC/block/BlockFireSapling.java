package Oneric.MNC.block;

import java.util.List;
import java.util.Random;

import Oneric.MNC.common.MNCBiomes;
import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.mod_netherbr;
import Oneric.MNC.dimensions.BiomeGenCrazy;
import Oneric.MNC.world.gen.WorldGenDeadTree;
import Oneric.MNC.world.gen.WorldGenFireTree;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.ForgeDirection;

public class BlockFireSapling extends BlockFlower
{
   // public static final String[] WOOD_TYPES = new String[] {"oak", "spruce", "birch", "jungle"};

    public BlockFireSapling(int par1)
    {
        super(par1, Material.plants);
        float var3 = 0.4F;
        this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setStepSound(Block.soundGrassFootstep);
    }
    
    
    
    @Override
	public void registerIcons(IconRegister registry)
	{
		this.blockIcon = registry.registerIcon(mod_netherbr.getId()+":"+(this.getUnlocalizedName().substring(5)));
	}
    
    
    protected boolean canThisPlantGrowOnThisBlockID(int i)
    {
        return (i == Block.slowSand.blockID || i == Block.netherrack.blockID || i == MNCBlocks.deadGrass.blockID);
    }
    
    public boolean canPlaceBlockAt(World wld, int x, int y, int z)
    {
    	return (wld.getBlockId(x, y-1, z) == Block.slowSand.blockID || wld.getBlockId(x, y-1, z) == Block.netherrack.blockID || wld.getBlockId(x, y-1, z) == MNCBlocks.deadGrass.blockID);
    }
    
    public boolean canBlockStay(World wld, int x, int y, int z)
    {
        
        return (wld.getBlockId(x, y-1, z) == Block.slowSand.blockID || wld.getBlockId(x, y-1, z) == Block.netherrack.blockID || wld.getBlockId(x, y-1, z) == MNCBlocks.deadGrass.blockID);
    }
    
    

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            super.updateTick(par1World, par2, par3, par4, par5Random);

            if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 3 && par5Random.nextInt(7) == 0)
            {
                int var6 = par1World.getBlockMetadata(par2, par3, par4);

                if ((var6 & 8) == 0)
                {
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 | 8, 2);
                }
                else
                {
                    this.growTree(par1World, par2, par3, par4, par5Random);
                }
            }
        }
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    /*
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        
        return this.blockIndexInTexture;
    }*/

    /**
     * Attempts to grow a sapling into a tree
     */
    public void growTree(World par1World, int par2, int par3, int par4, Random par5Random)
    {
    	if(par1World.getBiomeGenForCoords(par2, par4) == BiomeGenBase.hell || par1World.getBiomeGenForCoords(par2, par4) instanceof BiomeGenCrazy)
    	{
    		
    		int var6 = par1World.getBlockMetadata(par2, par3, par4) & 3;
            Object var7 = null;
            int var8 = 0;
            int var9 = 0;
            boolean var10 = false;
            BiomeGenBase biome = par1World.getBiomeGenForCoords(par2, par4);

            
                   
               

                if (var7 == null)
                {
                    var9 = 0;
                    var8 = 0;
                    var7 = new WorldGenFireTree(true);
                }
            
            if(biome == BiomeGenBase.hell)
            {
                var7 = new WorldGenFireTree(true);
            }
            else if(biome instanceof BiomeGenCrazy)
            {
            	switch(par1World.rand.nextInt(75))
            	{
            	case 0:
            		var7 = new WorldGenFireTree(true);
            		break;
            		
            	default:
            		var7 = new WorldGenDeadTree(true);	
            		break;
            	}
            }

            if (var10)
            {
                par1World.setBlock(par2 + var8, par3, par4 + var9, 0, 0, 2);
                par1World.setBlock(par2 + var8 + 1, par3, par4 + var9, 0, 0, 2);
                par1World.setBlock(par2 + var8, par3, par4 + var9 + 1, 0, 0, 2);
                par1World.setBlock(par2 + var8 + 1, par3, par4 + var9 + 1, 0, 0, 2);
            }
            else
            {
                par1World.setBlock(par2, par3, par4, 0, 0, 2);
            }

            if (!((WorldGenerator)var7).generate(par1World, par5Random, par2 + var8, par3, par4 + var9))
            {
                if (var10)
                {
                    par1World.setBlock(par2 + var8, par3, par4 + var9, this.blockID, var6, 2);
                    par1World.setBlock(par2 + var8 + 1, par3, par4 + var9, this.blockID, var6, 2);
                    par1World.setBlock(par2 + var8, par3, par4 + var9 + 1, this.blockID, var6, 2);
                    par1World.setBlock(par2 + var8 + 1, par3, par4 + var9 + 1, this.blockID, var6, 2);
                }
                else
                {
                    par1World.setBlock(par2, par3, par4, this.blockID, var6, 2);
                }
            }
    		
    	}
        
    }
    
    
    

    
    

   
}
