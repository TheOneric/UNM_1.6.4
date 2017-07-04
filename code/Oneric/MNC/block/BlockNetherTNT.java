package Oneric.MNC.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockNetherTNT extends Block{

	public BlockNetherTNT(int par1) {
		super(par1, Material.ground);
		
		this.setCreativeTab(CreativeTabs.tabRedstone);
		
		
	}
	
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (par5 > 0 && Block.blocksList[par5].canProvidePower() && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
            this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 1);
            par1World.setBlock(par2, par3, par4, 0, 0, 2);
        }
    }
	
	 public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	    {
	        if (!par1World.isRemote)
	        {
	            if ((par5 & 1) == 1)
	            {
	                EntityTNTPrimed var6 = new EntityTNTPrimed(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), null);
	                par1World.spawnEntityInWorld(var6);
	                par1World.playSoundAtEntity(var6, "random.fuse", 1.0F, 1.0F);
	            }
	        }
	    }
	 
	 @Override
	 public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	 {
		 this.blockIcon = Block.gravel.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 return blockIcon;
	 }
	 
	 @Override
	 public Icon getIcon(int par1, int par2)
	 {
		 this.blockIcon = Block.gravel.getBlockTextureFromSide(par1);
		 return blockIcon;
	 }
	 
	 @Override
	 public void registerIcons(IconRegister reg)
	 {
		 
	 }

}
