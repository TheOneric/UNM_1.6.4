package Oneric.MNC.block;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.mod_netherbr;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDeadGrass extends MNCBlock
{
	@SideOnly(Side.CLIENT)
    private Icon iconGrassTop;


	public BlockDeadGrass(int par1)
    {
        super(par1, Material.grass);
        
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

  
    

   

    /**
    @SideOnly(Side.CLIENT)
    public int getBlockColor()
    {
        
        return 0x5F04B4;
    }
    */

    

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    /*
    public int getRenderColor(int par1)
    {
        return this.getBlockColor();
    }
    */

    /*
    @SideOnly(Side.CLIENT)

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     *\
    public int colorMultiplier(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;

        for (int var8 = -1; var8 <= 1; ++var8)
        {
            for (int var9 = -1; var9 <= 1; ++var9)
            {
                int var10 = par1IBlockAccess.getBiomeGenForCoords(par2 + var9, par4 + var8).getBiomeGrassColor();
                var5 += (var10 & 16711680) >> 16;
                var6 += (var10 & 65280) >> 8;
                var7 += var10 & 255;
            }
        }

        return (var5 / 9 & 255) << 16 | (var6 / 9 & 255) << 8 | var7 / 9 & 255;
    }
    */

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            if (par1World.getBlockLightValue(par2, par3 + 1, par4) < 4 && par1World.getBlockLightOpacity(par2, par3 + 1, par4) > 2)
            {
                par1World.setBlock(par2, par3, par4, MNCBlocks.deadDirt.blockID, 0, 2);
            }
            else if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9)
            {
                for (int var6 = 0; var6 < 4; ++var6)
                {
                    int var7 = par2 + par5Random.nextInt(3) - 1;
                    int var8 = par3 + par5Random.nextInt(5) - 3;
                    int var9 = par4 + par5Random.nextInt(3) - 1;
                    int var10 = par1World.getBlockId(var7, var8 + 1, var9);

                    if (par1World.getBlockId(var7, var8, var9) == MNCBlocks.deadDirt.blockID && par1World.getBlockLightValue(var7, var8 + 1, var9) >= 4 && par1World.getBlockLightOpacity(var7, var8 + 1, var9) <= 2)
                    {
                        par1World.setBlock(var7, var8, var9, MNCBlocks.deadGrass.blockID, var10, var10);
                    }
                }
            }
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return MNCBlocks.deadDirt.blockID;
    }
    
    @Override
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(mod_netherbr.getId()+":mnc_deadGrassSide");
        this.iconGrassTop = par1IconRegister.registerIcon(mod_netherbr.getId()+":mnc_deadGrassTop");
       
    }
    
    
    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    @Override
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par5 == 1)
        {
        	return this.blockIcon;
        }
        else if (par5 == 0)
        {
        	return MNCBlocks.deadDirt.getBlockTextureFromSide(par5);
        }
        else
        {
        	return this.iconGrassTop;
        }
    }
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
    	int par5 = par1;
    	
    	if (par5 == 1)
        {
        	return this.blockIcon;
        }
        else if (par5 == 0)
        {
        	return MNCBlocks.deadDirt.getBlockTextureFromSide(par5);
        }
        else
        {
        	return this.iconGrassTop;
        }
    }
    
    
    @Override
    public Icon getIcon(int par1, int par2)
    {
    	return this.getBlockTextureFromSideAndMetadata(par1, par2);
    }
    
    
}
