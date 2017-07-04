package Oneric.MNC.block;

import Oneric.MNC.entity.EntityLostSoul;
import Oneric.MNC.entity.EntitySlaughter;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BlackStone extends MNCBlock{

	public BlackStone(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public static boolean isNormalCube()
	{
		return true;
	}
	
	
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
            float f = 0.0625F;
            return AxisAlignedBB.getBoundingBox((float)par2 + f, par3, (float)par4 + f, (float)(par2 + 1) - f, (float)(par3 + 1) - f, (float)(par4 + 1) - f);
    }
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity entity)
    {
        if(entity instanceof EntitySlaughter || entity instanceof EntityLostSoul || entity instanceof EntityPigZombie)
        {
        	
        } 
        
        else
        {
        	entity.attackEntityFrom(DamageSource.fall, 1);
        }
    	
    	
    }

	

}
