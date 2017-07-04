package Oneric.MNC.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Oneric.MNC.common.MNCItems;
import Oneric.MNC.common.mod_netherbr;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoor_MNC extends BlockDoor{
	
	
	private boolean isDoorOpen = false;
	
	private static final String[] field_94467_a = new String[] {"mnc_GDoorBottom", "mnc_GDoorTop", "mnc_NDoorBottom", "mnc_NDoorTop", "mnc_NWDoorBottom", "mnc_NWDoorTop"};
    private final int field_94465_b;
    @SideOnly(Side.CLIENT)
    private Icon[] iconArray;

	public BlockDoor_MNC(int par1, Material material) {
		super(par1, material);
		
		
		if(material == Material.rock)
		{
			field_94465_b = 2;
		}
		else if(material == Material.glass)
		{
			field_94465_b = 0;
		}
		else
		{
			field_94465_b = 4;
		}
		
	}
	
	
	 @SideOnly(Side.CLIENT)

	    /**
	     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	     */
	    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	    {
	        return this.iconArray[this.field_94465_b];
	    }
	 
	 @Override
	    public Icon getIcon(int par1, int par2)
	    {
	    	return this.getBlockTextureFromSideAndMetadata(par1, par2);
	    }
	
	
	@SideOnly(Side.CLIENT)

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par5 != 1 && par5 != 0)
        {
            int i1 = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
            int j1 = i1 & 3;
            boolean flag = (i1 & 4) != 0;
            boolean flag1 = false;
            boolean flag2 = (i1 & 8) != 0;

            if (flag)
            {
                if (j1 == 0 && par5 == 2)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && par5 == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && par5 == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && par5 == 4)
                {
                    flag1 = !flag1;
                }
            }
            else
            {
                if (j1 == 0 && par5 == 5)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 1 && par5 == 3)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 2 && par5 == 4)
                {
                    flag1 = !flag1;
                }
                else if (j1 == 3 && par5 == 2)
                {
                    flag1 = !flag1;
                }

                if ((i1 & 16) != 0)
                {
                    flag1 = !flag1;
                }
            }

            return this.iconArray[this.field_94465_b + (flag1 ? field_94467_a.length : 0) + (flag2 ? 1 : 0)];
        }
        else
        {
            return this.iconArray[this.field_94465_b];
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.iconArray = new Icon[field_94467_a.length * 2];

        for (int i = 0; i < field_94467_a.length; ++i)
        {
            this.iconArray[i] = par1IconRegister.registerIcon(mod_netherbr.getId()+":"+field_94467_a[i]);
            this.iconArray[i + field_94467_a.length] = new IconFlipped(this.iconArray[i], true, false);
        }
    }
	
	

	
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if ((par1 & 8) != 0)
        {
            return 0;
        }

        if (blockMaterial == Material.glass)
        {
            return MNCItems.GDoorItem.itemID;
        }
        else if(blockMaterial == Material.rock)
        {
            return MNCItems.NDoorItem.itemID;
        }
        else
        {
        	return MNCItems.NWDoorItem.itemID;
        }
    }
   
    
    
    
    
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
    	 if (blockMaterial == Material.glass)
         {
             return MNCItems.GDoorItem.itemID;
         }
         else if(blockMaterial == Material.rock)
         {
             return MNCItems.NDoorItem.itemID;
         }
         else
         {
         	return MNCItems.NWDoorItem.itemID;
         }
    }
    
    
}