package Oneric.MNC.block;

import java.util.Random;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.MNCItems;
import Oneric.MNC.common.mod_netherbr;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockGrowGold extends MNCBlock{

	public BlockGrowGold(int par1, Material par2Material) {
		super(par1, Material.rock);
		float f = 0.375F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
		setTickRandomly(true);
		this.setCreativeTab(null);
		
	}
	
	
	public void updateTick(World world, int x, int y, int z, Random par5Random)
    {
		if(world.getBlockId(x, y+1, z) == 0 && !(world.getBlockId(x, y-1, z) == this.blockID && world.getBlockId(x, y-2, z) == this.blockID))
		{
			world.setBlock(x, y+1, z, this.blockID, 0, 2);
		}
		
    }
	
	
	@Override
	public void registerIcons(IconRegister registry)
	{
		this.blockIcon = registry.registerIcon(mod_netherbr.getId()+":"+(this.getUnlocalizedName().substring(5)));
	}
	
	
	 public boolean canPlaceBlockAt(World world, int i, int j, int k)
	    {
		 
		 int l = world.getBlockId(i, j - 1, k);

	        if (l == blockID)
	        {
	            return true;
	        }

	        if (l != MNCBlocks.Blackstone.blockID)
	        {
	            return false;
	        }

	        if (world.getBlockMaterial(i - 1, j - 1, k) == Material.lava)
	        {
	            return true;
	        }

	        if (world.getBlockMaterial(i + 1, j - 1, k) == Material.lava)
	        {
	            return true;
	        }

	        if (world.getBlockMaterial(i, j - 1, k - 1) == Material.lava)
	        {
	            return true;
	        }
	        else
	        {
	            return world.getBlockMaterial(i, j - 1, k + 1) == Material.lava;
	        }
		 
	    }
	 
	 
	 
	 @Override
	 public void onNeighborBlockChange(World world, int i, int j, int k, int l)
	    {
	        checkBlockCoordValid(world, i, j, k);
	    }

	    protected final void checkBlockCoordValid(World world, int i, int j, int k)
	    {
	        if (!canBlockStay(world, i, j, k))
	        {
	        	dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
	        	world.setBlock(i, j, k, 0, 0, 3);
	        }
	        
	    }
	    
	    
	    public boolean canBlockStay(World world, int i, int j, int k)
	    {
	        return canPlaceBlockAt(world, i, j, k);
	    }
	    
	    
	    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
	    {
	        return null;
	    }

	    /**
	     * Returns the ID of the items to drop on destruction.
	     */
	    public int idDropped(int i, Random random, int j)
	    {
	        return Item.goldNugget.itemID;
	    }
	    
	    
	    public int quantityDropped(Random par1Random)
	    {
	    
		Random rand = new Random();
		int i = rand.nextInt(8)+2;
		
		
			return i;
	    }

	    /**
	     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
	     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	     */
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }

	    /**
	     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	     */
	    public boolean renderAsNormalBlock()
	    {
	        return false;
	    }

	    /**
	     * The type of render function that is called for this block
	     */
	    public int getRenderType()
	    {
	        return 1;
	    }
	    
	    public int idPicked(World par1World, int par2, int par3, int par4)
	    {
	        return MNCItems.GGold_i.itemID;
	    }
	
	

}
