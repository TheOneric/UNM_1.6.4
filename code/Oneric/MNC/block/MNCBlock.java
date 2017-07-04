package Oneric.MNC.block;

import Oneric.MNC.common.mod_netherbr;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;



public class MNCBlock extends Block{

	public MNCBlock(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(1.0F);
		this.setResistance(1.0F);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	
	
	@Override
	public void registerIcons(IconRegister registry)
	{
		this.blockIcon = registry.registerIcon(mod_netherbr.getId()+":"+(this.getUnlocalizedName().substring(5)));
	}
	
	@Override
	public Block setUnlocalizedName(String name)
	{
		this.setTextureName(name);
		return super.setUnlocalizedName(name);
	}
	
	

}
