package Oneric.MNC.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class MNCBlockContainer extends BlockContainer{

	protected MNCBlockContainer(int par1, Material par2Material) {
		super(par1, par2Material);
	}
	
	

	@Override
	public TileEntity createNewTileEntity(World var1) {
		return null;
	}



	

}
