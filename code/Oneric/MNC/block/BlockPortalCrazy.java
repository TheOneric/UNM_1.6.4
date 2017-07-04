package Oneric.MNC.block;

import Oneric.MNC.common.MNCBiomes;
import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.mod_netherbr;
import Oneric.MNC.dimensions.TeleporterCrazy;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.server.FMLServerHandler;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.BlockPortal;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockPortalCrazy extends BlockPortal
{
	private int cooldown = 0;
	private final int cooldownMAX = 800;
	
    public BlockPortalCrazy(int par1)
    {
        super(par1/*, "mnc_portal", Material.portal, false*/);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    @Override
	public void registerIcons(IconRegister registry)
	{
		this.blockIcon = registry.registerIcon(mod_netherbr.getId()+":"+(this.getUnlocalizedName().substring(5)));
	}
   
    
    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        super.updateTick(par1World, par2, par3, par4, par5Random);

        if (par1World.provider.isSurfaceWorld() && par5Random.nextInt(2000) < par1World.difficultySetting)
        {
            int var6;

            for (var6 = par3; !par1World.doesBlockHaveSolidTopSurface(par2, var6, par4) && var6 > 0; --var6)
            {
                ;
            }

            if (var6 > 0 && !par1World.isBlockNormalCube(par2, var6 + 1, par4))
            {
                Entity var7 = ItemMonsterPlacer.spawnCreature(par1World, 66,(double)par2 + 0.5D, (double)var6 + 1.1D, (double)par4 + 0.5D);

                if (var7 != null)
                {
                    var7.timeUntilPortal = var7.getPortalCooldown();
                }
            }
        }
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        float var5;
        float var6;

        if (par1IBlockAccess.getBlockId(par2 - 1, par3, par4) != this.blockID && par1IBlockAccess.getBlockId(par2 + 1, par3, par4) != this.blockID)
        {
            var5 = 0.125F;
            var6 = 0.5F;
            this.setBlockBounds(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
        }
        else
        {
            var5 = 0.5F;
            var6 = 0.125F;
            this.setBlockBounds(0.5F - var5, 0.0F, 0.5F - var6, 0.5F + var5, 1.0F, 0.5F + var6);
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
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * Checks to see if this location is valid to create a portal and will return True if it does. Args: world, x, y, z
     */
    public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
    {
        byte var5 = 0;
        byte var6 = 0;

        if (par1World.getBlockId(par2 - 1, par3, par4) == MNCBlocks.NetherBlock.blockID || par1World.getBlockId(par2 + 1, par3, par4) == MNCBlocks.NetherBlock.blockID)
        {
            var5 = 1;
        }

        if (par1World.getBlockId(par2, par3, par4 - 1) == MNCBlocks.NetherBlock.blockID || par1World.getBlockId(par2, par3, par4 + 1) == MNCBlocks.NetherBlock.blockID)
        {
            var6 = 1;
        }

        if (var5 == var6)
        {
            return false;
        }
        else
        {
            if (par1World.getBlockId(par2 - var5, par3, par4 - var6) == 0)
            {
                par2 -= var5;
                par4 -= var6;
            }

            int var7;
            int var8;

            for (var7 = -1; var7 <= 2; ++var7)
            {
                for (var8 = -1; var8 <= 3; ++var8)
                {
                    boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;

                    if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3)
                    {
                        int var10 = par1World.getBlockId(par2 + var5 * var7, par3 + var8, par4 + var6 * var7);

                        if (var9)
                        {
                            if (var10 != MNCBlocks.NetherBlock.blockID)
                            {
                                return false;
                            }
                        }
                        else if (var10 != 0 && var10 != Block.fire.blockID)
                        {
                            return false;
                        }
                    }
                }
            }

          
            for (var7 = 0; var7 < 2; ++var7)
            {
                for (var8 = 0; var8 < 3; ++var8)
                {
                    par1World.setBlock(par2 + var5 * var7, par3 + var8, par4 + var6 * var7, MNCBlocks.PortalCrazy.blockID, 0, 2);
                }
            }

           
            return true;
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        byte var6 = 0;
        byte var7 = 1;

        if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
        {
            var6 = 1;
            var7 = 0;
        }

        int var8;

        for (var8 = par3; par1World.getBlockId(par2, var8 - 1, par4) == this.blockID; --var8)
        {
            ;
        }

        if (par1World.getBlockId(par2, var8 - 1, par4) != MNCBlocks.NetherBlock.blockID)
        {
            par1World.setBlock(par2, par3, par4, 0, 0, 2);
        }
        else
        {
            int var9;

            for (var9 = 1; var9 < 4 && par1World.getBlockId(par2, var8 + var9, par4) == this.blockID; ++var9)
            {
                ;
            }

            if (var9 == 3 && par1World.getBlockId(par2, var8 + var9, par4) == MNCBlocks.NetherBlock.blockID)
            {
                boolean var10 = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
                boolean var11 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

                if (var10 && var11)
                {
                    par1World.setBlock(par2, par3, par4, 0, 0, 2);
                }
                else
                {
                    if ((par1World.getBlockId(par2 + var6, par3, par4 + var7) != MNCBlocks.NetherBlock.blockID || par1World.getBlockId(par2 - var6, par3, par4 - var7) != this.blockID) && (par1World.getBlockId(par2 - var6, par3, par4 - var7) != MNCBlocks.NetherBlock.blockID || par1World.getBlockId(par2 + var6, par3, par4 + var7) != this.blockID))
                    {
                        par1World.setBlock(par2, par3, par4, 0, 0, 2);
                    }
                }
            }
            else
            {
                par1World.setBlock(par2, par3, par4, 0, 0, 2);
            }
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if the given side of this block type should be rendered, if the adjacent block is at the given
     * coordinates.  Args: blockAccess, x, y, z, side
     */
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        if (par1IBlockAccess.getBlockId(par2, par3, par4) == this.blockID)
        {
            return false;
        }
        else
        {
            boolean var6 = par1IBlockAccess.getBlockId(par2 - 1, par3, par4) == this.blockID && par1IBlockAccess.getBlockId(par2 - 2, par3, par4) != this.blockID;
            boolean var7 = par1IBlockAccess.getBlockId(par2 + 1, par3, par4) == this.blockID && par1IBlockAccess.getBlockId(par2 + 2, par3, par4) != this.blockID;
            boolean var8 = par1IBlockAccess.getBlockId(par2, par3, par4 - 1) == this.blockID && par1IBlockAccess.getBlockId(par2, par3, par4 - 2) != this.blockID;
            boolean var9 = par1IBlockAccess.getBlockId(par2, par3, par4 + 1) == this.blockID && par1IBlockAccess.getBlockId(par2, par3, par4 + 2) != this.blockID;
            boolean var10 = var6 || var7;
            boolean var11 = var8 || var9;
            return var10 && par5 == 4 ? true : (var10 && par5 == 5 ? true : (var11 && par5 == 2 ? true : var11 && par5 == 3));
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	if(par5Entity instanceof EntityLivingBase)
    	{
    		EntityLivingBase entity = (EntityLivingBase)par5Entity;
    		entity.addPotionEffect(new PotionEffect(Potion.confusion.getId(), 100, 10, true));
    		entity.addPotionEffect(new PotionEffect(Potion.blindness.getId(), 20, 1, true));
    	}
    	
    	
    	
    	if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
        {
            
            
        }
    	
    	
    	
    	
    	if(cooldown == cooldownMAX)
    	{
    		
    		if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
      	  {
    			
    			//if Player
      	   if (par5Entity instanceof EntityPlayerMP)
      	   {
      		   
      	        EntityPlayerMP thePlayer = (EntityPlayerMP) par5Entity;
      	        
      	        if (par5Entity.dimension != MNCBiomes.CrazyDimID)
      	        {
      	        	
      	        		thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, MNCBiomes.CrazyDimID, new TeleporterCrazy(thePlayer.mcServer.worldServerForDimension(MNCBiomes.CrazyDimID)));
      	        	
      	         
      	        	
      	         
      	         
      	        }
      	        else
      	        {
      	        	
      	        		thePlayer.mcServer.getConfigurationManager().transferPlayerToDimension(thePlayer, 0, new TeleporterCrazy(thePlayer.mcServer.worldServerForDimension(0)));
      	        	
      	        		//par5Entity.mcServer.getConfigurationManager().transferEntityToWorld(par5Entity, par5Entity.dimension, thePlayer.mcServer.worldServerForDimension(par5Entity.dimension), thePlayer.mcServer.worldServerForDimension(MNCBiomes.CrazyDimID), new TeleporterCrazy(thePlayer.mcServer.worldServerForDimension(MNCBiomes.CrazyDimID)));
      	        	
      	         
      	        }
      	   }
      	   
      	   
      	   //all other entitys
      	   else
      	   {
      		   
      		 if (par5Entity.timeUntilPortal <= 0)
             {
                 this.teleportEntity(par5Entity);
             }
      		   
      		 //MinecraftServer ms = FMLCommonHandler.instance().getMinecraftServerInstance();
      		 //ServerConfigurationManager scm = ms.getConfigurationManager();
      		   
      		 if (par5Entity.dimension != MNCBiomes.CrazyDimID)
   	        {
      			//par5Entity.travelToDimension(MNCBiomes.CrazyDimID);
      			 //scm.transferEntityToWorld(par5Entity, par5Entity.dimension, ms.worldServerForDimension(par5Entity.dimension), ms.worldServerForDimension(MNCBiomes.CrazyDimID), new TeleporterCrazy(ms.worldServerForDimension(MNCBiomes.CrazyDimID)));
   	        }
      		 
      		else
      		{
      			 //par5Entity.travelToDimension(0);
      			//scm.transferEntityToWorld(par5Entity, par5Entity.dimension, ms.worldServerForDimension(par5Entity.dimension), ms.worldServerForDimension(0), new TeleporterCrazy(ms.worldServerForDimension(0 )));
      		}
      		 
      	   }
      	   
      	  }
    		
    		cooldown = 0;
    		
    	}
    	
    	else
    	{
    		cooldown++;
    	}
        
    }
    
    
    
    public void teleportEntity(Entity var0)
    {
        if (!var0.worldObj.isRemote && !var0.isDead)
        {
            boolean var1 = false;
            int var2 = var0.dimension;
            byte var8;

            if (var2 == 0)
            {
                var8 = (byte) MNCBiomes.CrazyDimID;
            }
            else if (var2 == MNCBiomes.CrazyDimID)
            {
                var8 = 0;
            }
            else
            {
                var8 = (byte) MNCBiomes.CrazyDimID;
            }

            var0.worldObj.theProfiler.startSection("changeDimension");
            MinecraftServer var3 = MinecraftServer.getServer();
            WorldServer var4 = var3.worldServerForDimension(var2);
            WorldServer var5 = var3.worldServerForDimension(var8);
            TeleporterCrazy var6 = new TeleporterCrazy(MinecraftServer.getServer().worldServerForDimension(var8));
            var0.dimension = var8;
            var0.worldObj.removeEntity(var0);
            var0.isDead = false;
            var0.worldObj.theProfiler.startSection("reposition");
            var3.getConfigurationManager().transferEntityToWorld(var0, var2, var4, var5, var6);
            var0.worldObj.theProfiler.endStartSection("reloading");
            Entity var7 = EntityList.createEntityByName(EntityList.getEntityString(var0), var5);

            if (var7 != null)
            {
                var7.copyDataFrom(var0, true);
                var7.timeUntilPortal = var0.getPortalCooldown();
                var5.spawnEntityInWorld(var7);
            }

            var0.isDead = true;
            var0.worldObj.theProfiler.endSection();
            var4.resetUpdateEntityTick();
            var5.resetUpdateEntityTick();
            var0.worldObj.theProfiler.endSection();
        }
    }
    
    
    
    
    
    
    
    

    @SideOnly(Side.CLIENT)

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
    public int getRenderBlockPass()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par5Random.nextInt(100) == 0)
        {
            par1World.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
        }

        for (int var6 = 0; var6 < 4; ++var6)
        {
            double var7 = (double)((float)par2 + par5Random.nextFloat());
            double var9 = (double)((float)par3 + par5Random.nextFloat());
            double var11 = (double)((float)par4 + par5Random.nextFloat());
            double var13 = 0.0D;
            double var15 = 0.0D;
            double var17 = 0.0D;
            int var19 = par5Random.nextInt(2) * 2 - 1;
            var13 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            var15 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            var17 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;

            if (par1World.getBlockId(par2 - 1, par3, par4) != this.blockID && par1World.getBlockId(par2 + 1, par3, par4) != this.blockID)
            {
                var7 = (double)par2 + 0.5D + 0.25D * (double)var19;
                var13 = (double)(par5Random.nextFloat() * 2.0F * (float)var19);
            }
            else
            {
                var11 = (double)par4 + 0.5D + 0.25D * (double)var19;
                var17 = (double)(par5Random.nextFloat() * 2.0F * (float)var19);
            }

            par1World.spawnParticle("portal", var7, var9, var11, var13, var15, var17);
        }
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     */
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return 0;
    }
}
