package Oneric.MNC.block;

import java.io.IOException;


import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockEnchantedSoulSand extends MNCBlock {

	public BlockEnchantedSoulSand(int par1) {
		super(par1, Material.ground);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	
	 public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
	    {
	        float var5 = 0.125F;
	        return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - var5), (double)(par4 + 1));
	    }

	    /**
	     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
	     */
	    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	    {
	        try{
	        	par5Entity.motionX *= 1.5D;
	        	par5Entity.motionZ *= 1.5D;
	        	
	        	
	        }
	       catch(Exception e)
	       {
	    	   System.out.println("unable to make you faster :(");
	       }
	        
	        
	    }
	    
	
	
	

}
