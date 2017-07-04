package Oneric.MNC.common;

import Oneric.MNC.packets.DonatorPacketSender;
import net.minecraft.client.Minecraft;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.NetLoginHandler;
import net.minecraft.network.packet.NetHandler;
import net.minecraft.network.packet.Packet1Login;
import net.minecraft.server.MinecraftServer;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IConnectionHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class MNCConectionHandler implements IConnectionHandler{

	
	@Override
	public String connectionReceived(NetLoginHandler netHandler, INetworkManager manager) {
		return null;
	}
	
	@Override
	public void playerLoggedIn(Player player, NetHandler netHandler, INetworkManager manager) { /*SERVER SIDE*/ }

	

	@Override
	public void connectionOpened(NetHandler netClientHandler, String server, int port, INetworkManager manager) { /*CLIENT SIDE*/ }

	@Override
	public void connectionOpened(NetHandler netClientHandler, MinecraftServer server, INetworkManager manager) { }

	@Override
	public void connectionClosed(INetworkManager manager) 
	{
		System.out.println("Event Started");
		//ALL SIDE
		/** Fired when a connection is closed */
		if(FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			System.out.println("Event is Client");
			if(!Minecraft.getMinecraft().isSingleplayer())
			{
				System.out.println("Event isn't SinglePlayer");
				PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendRemoveDonator(mod_netherbr.proxy.getClientSessionUsername()));
				System.out.println("PacketSend from:  " + mod_netherbr.proxy.getClientSessionUsername());
			}
		}
	}

	@Override
	public void clientLoggedIn(NetHandler clientHandler, INetworkManager manager, Packet1Login login) 
	{
	
		//CLIENT SIDE
		/**Fired when Client connect to external Server*/
		
		PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendAddDonatorPacket(mod_netherbr.proxy.getClientSessionUsername()));
		PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendDonatorChoiceAdd(mod_netherbr.proxy.getClientSessionUsername(), "CAPE BLUE"));
   	 	PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendDonatorChoiceAdd(mod_netherbr.proxy.getClientSessionUsername(), "HORN CLASSIC"));
   	 	
   	 	PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendDonatorRequest(mod_netherbr.proxy.getClientSessionUsername()));
   	 	
		
		System.out.println("PacketSend from:  " + mod_netherbr.proxy.getClientSessionUsername());
		
	}

}
