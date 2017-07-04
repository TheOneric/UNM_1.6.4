package Oneric.MNC.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Oneric.MNC.common.MNCItems;
import Oneric.MNC.common.mod_netherbr;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.src.*;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockHellPilz extends BlockFlower
{
	
	
	@SideOnly(Side.CLIENT)
	private Icon[] stageTextures;
	
	
    public BlockHellPilz(int par1)
    {
        super(par1);
        
        setTickRandomly(true);
        float f = 0.5F;
        setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
    }
    
     

    /**
     * Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
     * blockID passed in. Args: blockID
     */
    @Override
    protected boolean canThisPlantGrowOnThisBlockID(int par1)
    {
        return par1 == Block.netherrack.blockID;
    }
    
    
    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
    	return (world.getBlockId(x, y-1, z) == Block.netherrack.blockID);
    }
    

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 2)
        {
            int i = par1World.getBlockMetadata(par2, par3, par4);

            if (i < 7)
            {
                float f = getGrowthRate(par1World, par2, par3, par4);

                if (par5Random.nextInt((int)(25F / f) + 1) == 0)
                {
                    i++;
                    par1World.setBlockMetadataWithNotify(par2, par3, par4, i, 2);
                }
            }
        }
    }

    /**
     * Apply bonemeal to the crops.
     */
    public void fertilize(World par1World, int par2, int par3, int par4)
    {
    	int meta = par1World.getBlockMetadata(par2, par3, par4); 
    	if(meta < 6)
    	{
    		
    		if(meta < 4)
            {
            	if(par1World.rand.nextInt(meta + 1) == 0)
            	{
                	par1World.setBlockMetadataWithNotify(par2, par3, par4, (meta+1), 2);
                	par1World.spawnParticle("largeexplode", par2 + 0.5D, par3 + 0.2D, par4 + 0.5D, 0.0D, 0.0D, 0.0D);
            	}
            	else
            	{
            		par1World.spawnParticle("mobSpell", par2 + 0.5D, par3 + 0.2D, par4 + 0.5D, 0.0D, 0.0D, 0.0D);
            	}
            }
            
            else
            {
            	if(par1World.rand.nextInt((meta*2)) == 0)
           		{
                	par1World.setBlockMetadataWithNotify(par2, par3, par4, (meta+1), 2);
                	par1World.spawnParticle("largeexplode", par2 + 0.5D, par3 + 0.2D, par4 + 0.5D, 0.0D, 0.0D, 0.0D);
            	}
            	else
            	{
            		par1World.spawnParticle("mobSpell", par2 + 0.5D, par3 + 0.2D, par4 + 0.5D, 0.0D, 0.0D, 0.0D);
            	}
            }
    		
    	}
        
        else
        {
        	if(par1World.rand.nextInt(100) == 0)
        	{
        		par1World.setBlockMetadataWithNotify(par2, par3, par4, (7), 2);
            	par1World.spawnParticle("largeexplode", par2 + 0.5D, par3 + 0.2D, par4 + 0.5D, 0.0D, 0.0D, 0.0D);
        	}
        	else
        	{
        		par1World.spawnParticle("mobSpell", par2 + 0.5D, par3 + 0.2D, par4 + 0.5D, 0.0D, 0.0D, 0.0D);
        	}
        	
        }
    }

    /**
     * Gets the growth rate for the crop. Setup to encourage rows by halving growth rate if there is diagonals, crops on
     * different sides that aren't opposing, and by adding growth for every crop next to this one (and for crop below
     * this one). Args: x, y, z
     */
    private float getGrowthRate(World par1World, int par2, int par3, int par4)
    {
        float f = 1.0F;
        int i = par1World.getBlockId(par2, par3, par4 - 1);
        int j = par1World.getBlockId(par2, par3, par4 + 1);
        int k = par1World.getBlockId(par2 - 1, par3, par4);
        int l = par1World.getBlockId(par2 + 1, par3, par4);
        int i1 = par1World.getBlockId(par2 - 1, par3, par4 - 1);
        int j1 = par1World.getBlockId(par2 + 1, par3, par4 - 1);
        int k1 = par1World.getBlockId(par2 + 1, par3, par4 + 1);
        int l1 = par1World.getBlockId(par2 - 1, par3, par4 + 1);
        boolean flag = k == blockID || l == blockID;
        boolean flag1 = i == blockID || j == blockID;
        boolean flag2 = i1 == blockID || j1 == blockID || k1 == blockID || l1 == blockID;

        for (int i2 = par2 - 1; i2 <= par2 + 1; i2++)
        {
            for (int j2 = par4 - 1; j2 <= par4 + 1; j2++)
            {
                int k2 = par1World.getBlockId(i2, par3 - 1, j2);
                float f1 = 0.0F;

                if (k2 == Block.netherrack.blockID)
                {
                    f1 = 1.0F;

                    if (par1World.getBlockMetadata(i2, par3 - 1, j2) > 0)
                    {
                        f1 = 3F;
                    }
                }

                if (i2 != par2 || j2 != par4)
                {
                    f1 /= 4F;
                }

                f += f1;
            }
        }

        if (flag2 || flag && flag1)
        {
            f /= 2.0F;
        }

        return f;
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int i, int j)
    {
    	
    	if(j == 0){ return this.stageTextures[0];}
    	if(j == 1){ return this.stageTextures[0];}
    	if(j == 2){ return this.stageTextures[0];}
    	if(j == 3){ return this.stageTextures[1];}
    	if(j == 4){ return this.stageTextures[1];}
    	if(j == 5){ return this.stageTextures[1];}
    	if(j == 6){ return this.stageTextures[1];}
    	if(j == 7){ return this.stageTextures[2];}
    	
    	return this.stageTextures[0];
    	
    	
    }
    
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister)
    {
       
       this.stageTextures = new Icon[3];
       
       for(int i = 0; i < this.stageTextures.length; i++)
       {
    	   int j = i + 1;
    	   this.stageTextures[i] = par1IconRegister.registerIcon(mod_netherbr.getId()+":mnc_HellPilz-" + (j)); 
       }
    }
    
    /**
     *Returns the texture for the given State of the Hell-Pilz. Args: state 
     */
    public Icon getTexture(int i)
    {
    	return this.stageTextures[i];
    }
    
    @Override
	public Icon getIcon(int i, int par2)
	{
    	return this.getBlockTextureFromSideAndMetadata(i, par2);
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 1;
    }

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, 0);

        if (par1World.isRemote)
        {
            return;
        }

        int i = 3 + par7;

        for (int j = 0; j < i; j++)
        {
            if (par1World.rand.nextInt(15) <= par5)
            {
                float f = 0.7F;
                float f1 = par1World.rand.nextFloat() * f + (1.0F - f) * 0.5F;
                float f2 = par1World.rand.nextFloat() * f + (1.0F - f) * 0.5F;
                float f3 = par1World.rand.nextFloat() * f + (1.0F - f) * 0.5F;
                EntityItem entityitem = new EntityItem(par1World, (float)par2 + f1, (float)par3 + f2, (float)par4 + f3, new ItemStack(MNCItems.HellPilz_Samen));
                entityitem.delayBeforeCanPickup = 10;
                par1World.spawnEntityInWorld(entityitem);
            }
        }
    }
    
    
    

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if (par1 == 7)
        {
            return MNCItems.HellPilz.itemID;
            
        }
        else
        {
            return Item.gunpowder.itemID;
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
    	 return 1 + par1Random.nextInt(2);
    }
    
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return MNCItems.HellPilz_Samen.itemID;
    }
    
  
}
