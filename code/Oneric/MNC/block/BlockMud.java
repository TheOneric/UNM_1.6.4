package Oneric.MNC.block;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockMud extends MNCBlock{

	public BlockMud(int par1) {
		super(par1, Material.sand);
		
	}
	
	
	@Override
	public void onEntityCollidedWithBlock(World world, int i, int j, int k, Entity entity)
	{
	
		if(entity instanceof EntityItem)
		{
			
			entity.motionX = 0.1D;
	        entity.motionY = 0.070000000745058064D;
	        entity.fallDistance = 0.0F;
	        entity.motionZ = 0.0D;
			
		}
		
		
		else
		{
			
			entity.motionX = 0.0D;
	        entity.motionY = 0.070000000745058064D;
	        entity.fallDistance = 0.0F;
	        entity.motionZ = 0.0D;
			
		}
		
		
    }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
	{
		return null;
	}

}
