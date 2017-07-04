package Oneric.MNC.block;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Oneric.MNC.common.BossNameGen;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockStature extends BlockContainer{
	
	private Class StatureEntityClass;
	
	public BlockStature(int i, Class tClass)
	{
		super(i, Material.rock);
		StatureEntityClass = tClass;
		this.setBlockBounds(0, 0, 0, 1, 2, 1);
		this.setCreativeTab(null);
		
		
		
	}

	
	public TileEntity getBlockEntity() {
		
		try{
			
			return (TileEntity)StatureEntityClass.newInstance();
			
			
		}
		catch(Exception exception){
			
			throw new RuntimeException(exception);
			
		}
		
		
	}
	
	
	public int quantityDropped(Random par1Random)
    {
        return 0;
    }
	
	public int damageDropped(int i)
	{
		return i;	
	}
	
	
	public int getRenderType()
    {
        return -1;
    }
	
	 public boolean isOpaqueCube()
	 {
	        return false;
	 }
	 
	/*  public static boolean isNormalCube(int par0)
	    {
	        return false;
	    }*/
	  
	  public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
	  
	  
	 @Override
	 public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	 {
		// String name = BossNameGen.generate();
		// par5EntityPlayer.addChatMessage(name);
		// System.out.println(name);
		 
		 return true;
	 }
	
	
	


	@Override
	public TileEntity createNewTileEntity(World var1) {
		return getBlockEntity();
	}
	
	 public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	 {
		 
	 }
	 
	 
	 @Override
	 public void onBlockAdded(World par1World, int par2, int par3, int par4)
	    {
	        super.onBlockAdded(par1World, par2, par3, par4);
	        //this.setDefaultDirection(par1World, par2, par3, par4);
	    }

	    /**
	     * set a blocks direction
	     */
	 @Override
	   public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entityliving, ItemStack par6ItemStack)
       {
               int l = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 2.5D) & 3;
               world.setBlockMetadataWithNotify(i, j, k, l, 2);
               
       }
	   
	   
	   /*
	   @SideOnly(Side.CLIENT)
	    public void getSubBlocks(int blockID, CreativeTabs creativetab, List list)
	    {
	        list.add(new ItemStack(blockID, 1, 0));
	        list.add(new ItemStack(blockID, 1, 1));
	        list.add(new ItemStack(blockID, 1, 2));
	        list.add(new ItemStack(blockID, 1, 3));
	        
	    }
	    */ 
	   
	 
	
	@Override
	public void registerIcons(IconRegister reg)
	{
		this.blockIcon = Block.stone.getIcon(0, 0);
	}
	
	

}
