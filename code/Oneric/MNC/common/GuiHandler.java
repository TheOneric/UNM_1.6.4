package Oneric.MNC.common;

import Oneric.MNC.client.gui.GuiHellAltar;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity tileentity = world.getBlockTileEntity(x, y, z);
		
		if(tileentity instanceof TileEntityHellAltar)
		{

			return new ContainerHellAltar(player.inventory, (TileEntityHellAltar) tileentity);
			
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity tile_entity = world.getBlockTileEntity(x, y, z);
		
		if(tile_entity instanceof TileEntityHellAltar){
			
			return new GuiHellAltar(player, (TileEntityHellAltar) tile_entity);
			}
		
		return null;
	}

}
