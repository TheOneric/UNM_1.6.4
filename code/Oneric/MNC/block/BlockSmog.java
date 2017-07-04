package Oneric.MNC.block;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSmog extends MNCBlock 
{
    public static final int bouncingMeta = 1;

    public BlockSmog(int i)
    {
        super(i,  Material.ice);
        setHardness(0.2F);
        setLightOpacity(3);
        setLightValue(0.3F);
        setStepSound(Block.soundClothFootstep);
       // this.blockIndexInTexture = 10;
    }
    
   

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World wld, int posX, int posY, int posZ, Entity entity)
    {
        entity.fallDistance = 0.0F;
        
        

        if (wld.getBlockMetadata(posX, posY, posZ) == 1)
        {
        	Random rand = new Random();
            entity.motionY = 2D;
            entity.fallDistance = -20F;
            
            if(entity instanceof EntityLiving){
            	
            	
            	
                for(int i = 0; i < 3; i++)
                {
                	int dom = rand.nextInt(3);
                	switch(dom){
                	case 0:
                	 wld.spawnParticle("portal", posX + (rand.nextDouble() - 0.5D) , posY + rand.nextDouble(), posZ + (rand.nextDouble() - 0.5D), 0.0D, 0.0D, 0.0D);
                	 break;
                		 
                	case 1:
                	 wld.spawnParticle("bubble", posX + (rand.nextDouble() - 0.5D) , posY + rand.nextDouble(), posZ + (rand.nextDouble() - 0.5D), 0.0D, 0.0D, 0.0D);
                	 break;
                	 
                	case 2:
                	 wld.spawnParticle("splash", posX + (rand.nextDouble() - 0.5D) , posY + rand.nextDouble(), posZ + (rand.nextDouble() - 0.5D), 0.0D, 0.0D, 0.0D);
                	 break;
                	 
                	 default:
                		 wld.spawnParticle("portal", posX + (rand.nextDouble() - 0.5D) , posY + rand.nextDouble(), posZ + (rand.nextDouble() - 0.5D), 0.0D, 0.0D, 0.0D);
                		 break;
                	
                	
                	
                	}
                	
                }
                
               
                
               
                wld.playSoundEffect((double)posX + 0.5D, (double)posY + 0.5D, (double)posZ + 0.5D, "random.drr", 0.5F, wld.rand.nextFloat() * 0.25F + 0.6F);
                }
            

           
        }
        else if (entity.motionY < 0.0D)
        {
            entity.motionY *= 0.0050000000000000001D;
        }
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
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int i)
    {
        return i;
    }

    /**
     * Returns the color this block should be rendered. Used by leaves.
     */
    /*
    public int getRenderColor(int i)
    {
    	
        if (i == 1)
        {
            return 0xaaffff;
        }

        return i != 2 ? 0xffffff : 0xffff80;
        
    }*/

    /**
     * Returns a integer with hex for 0xrrggbb with this color multiplied against the blocks color. Note only called
     * when first determining what to render.
     */
    public int colorMultiplier(IBlockAccess iblockaccess, int i, int j, int k)
    {
        return getRenderColor(iblockaccess.getBlockMetadata(i, j, k));
    }

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess iblockaccess, int i, int j, int k, int l)
    {
        return super.shouldSideBeRendered(iblockaccess, i, j, k, 1 - l);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        if (world.getBlockMetadata(i, j, k) == 1)
        {
            return AxisAlignedBB.getBoundingBox(i, j, k, i, j, k);
        }
        else
        {
            return AxisAlignedBB.getBoundingBox(i, j, k, i + 1, j, k + 1);
        }
    }

    

    /*
    public void addCreativeItems(ArrayList arraylist)
    {
        arraylist.add(new ItemStack(this, 1, 0));
        arraylist.add(new ItemStack(this, 1, 1));
        arraylist.add(new ItemStack(this, 1, 2));
    }
    */
    
    /*
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(int blockID, CreativeTabs creativetab, List list)
    {
        list.add(new ItemStack(blockID, 1, 0));
        list.add(new ItemStack(blockID, 1, 1));
        list.add(new ItemStack(blockID, 1, 2));
        
    } */
}
