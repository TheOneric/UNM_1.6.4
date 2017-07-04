package Oneric.MNC.block;


import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockDungeonStone extends MNCBlock{

	public BlockDungeonStone(int par1) {
		super(par1, Material.rock);
		this.setResistance(2000F);
		
	}
	
	@Override
	public float getBlockHardness(World world, int x, int y, int z)
    {
		
		float i = 0.8F;
		
		switch(world.getBlockMetadata(x, y, z))
		{
		
		case 0:
			i = 0.8F;
			break;
		case 1:
			i = -1.0F;
			
			break;
		
		}
		
		return i;
        
    }
	
	
	/*@Override
	public float getExplosionResistance(Entity par1Entity)
    {
        
    }*/
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(int blockID, CreativeTabs creativetab, List list)
    {
        list.add(new ItemStack(blockID, 1, 0));
        list.add(new ItemStack(blockID, 1, 1));
        
        
    } 

}
