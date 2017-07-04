package Oneric.MNC.block;

import cpw.mods.fml.common.network.PacketDispatcher;
import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.packets.DonatorPacketSender;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockEpicNether extends MNCBlock{

	public BlockEpicNether(int par1) {
		super(par1, Material.iron);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
		
		
		
		if(world.getBlockId(x, y+1, z) == Block.fire.blockID)
		{
			
			MNCBlocks.PortalCrazy.tryToCreatePortal(world, x, y+1, z);
			return true;
			
		}
		
        return false;
    }
	
	public void onNeighborBlockChange(World world, int x, int y, int z, int neighbourID)
	{
		//System.out.println("-------------------NeighbourChange-------------------");
		
		if(world.getBlockId(x, y+1, z) == Block.fire.blockID)
		{
			
			MNCBlocks.PortalCrazy.tryToCreatePortal(world, x, y+1, z);
			
		}
		
	}

}
