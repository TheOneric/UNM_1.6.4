package Oneric.MNC.common.packets.handler;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import Oneric.MNC.packets.MNCPacket;
import Oneric.MNC.packets.RegisteredPacketList;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientPacketHandler implements IPacketHandler{

	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload payload, Player player) {
		
		//DataInputStream data = new DataInputStream(new ByteArrayInputStream(payload.data));
		
		if(payload.channel.equals("MNC-thunder"))
		{
			//String singleplayer = "s";
			/*if(FMLCommonHandler.instance().getEffectiveSide().isClient()) {
				this.handleThunderSP(payload, player);
			} else {
				this.handleThunderMP(payload, player);
			}*/
			
			this.handleThunder(payload, player);
				
		}
		else if(payload.channel.equals("MNC-Donator"))
		{
			this.handleDonatorPacket(payload, player);
		}
		else
		{
			System.out.println("Unknown Packet !  :   " + payload.getClass().getName());
		}
	
	}
	
	
	private void handleDonatorPacket(Packet250CustomPayload DonatorPacket, Player player)
	{
		DataInputStream stream = new DataInputStream(new ByteArrayInputStream(DonatorPacket.data));
		byte id;
		try {
			id = stream.readByte();
			
			ArrayList<MNCPacket> list = RegisteredPacketList.getPackets();
			
			for(MNCPacket packet : list)
			{
				if(packet.packetID == id)
				{
					System.out.println("Packet get !");
					packet.onPacketData(DonatorPacket, player);
					return;
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	//@SideOnly(Side.CLIENT)
	private void handleThunderSP(Packet250CustomPayload packet, Player playerMS)
	{
		EntityClientPlayerMP player = (EntityClientPlayerMP)playerMS;
		
		if((player.rayTrace(200, 1.0F) != null)){

			double blockHitX = player.rayTrace(200, 1.0F).blockX;

        	double blockHitY = player.rayTrace(200, 1.0F).blockY;

       		double blockHitZ = player.rayTrace(200, 1.0F).blockZ;

       		double blockHitSide = player.rayTrace(200, 1.0F).sideHit;

       		int blockHitX1 = player.rayTrace(200, 1.0F).blockX;

       		int blockHitY1 = player.rayTrace(200, 1.0F).blockY;

       		int blockHitZ1 = player.rayTrace(200, 1.0F).blockZ;
       		
       		
       		//send position to server
       		ByteArrayOutputStream bos = new ByteArrayOutputStream(24);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
				
					outputStream.writeByte(1);
					outputStream.writeDouble(blockHitX);
					outputStream.writeDouble(blockHitY);
					outputStream.writeDouble((double)blockHitZ1);
				
			        
			        
			} catch (Exception ex) {
			        ex.printStackTrace();
			}

			Packet250CustomPayload packetSend = new Packet250CustomPayload();
			packetSend.channel = "MNC-thunder";
			packetSend.data = bos.toByteArray();
			packetSend.length = bos.size();
			
			
			
			EntityClientPlayerMP playerSMP = (EntityClientPlayerMP)playerMS;
			PacketDispatcher.sendPacketToServer(packetSend);
			//playerSMP.sendQueue.addToSendQueue(packetSend);
		}
	}
	
	private void handleThunderMP(Packet250CustomPayload packet, Player player)
	{
		double posX;
		double posY;
		double posZ;
		
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		
		try {
			data.readByte();
			posX = data.readDouble();
			posY = data.readDouble();
			posZ = data.readDouble();
			
			EntityPlayerMP playerMP = (EntityPlayerMP)player;
			World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(playerMP.dimension);
			world.addWeatherEffect((new EntityLightningBolt(world, posX , posY , posZ)));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void handleThunder(Packet250CustomPayload packet, Player player) 
	{
		DataInputStream stream = new DataInputStream(new ByteArrayInputStream(packet.data));
		byte id;
		try {
			
			id = stream.readByte();
			if(id == (byte)0)
			{
				this.handleThunderSP(packet, player);
				System.out.println("Client packet arrived");
			}
			else if(id == (byte)1)
			{
				this.handleThunderMP(packet, player);
				System.out.println("Server packet arrived");
			}
			else
			{
				System.err.println("Wrong id, weird !! D:");
			}
			
		} catch (Exception ex) {
		}
	}
	

	

}
