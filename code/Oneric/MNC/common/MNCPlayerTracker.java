package Oneric.MNC.common;

import Oneric.MNC.donator.EnumChoiceType;
import Oneric.MNC.donator.choices.DonatorChoice;
import Oneric.MNC.packets.DonatorPacketSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.ServerConfigurationManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.IPlayerTracker;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;

public class MNCPlayerTracker implements IPlayerTracker{

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		
		 MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
	     ServerConfigurationManager confMan = server.getConfigurationManager();
	     
	     
	     if(confMan.playerEntityList.size() == 1)
	     {
	    	 
	     }
	    
	     
		EntityPlayerMP cPlayer;
	     
	     for (int var4 = 0; var4 < confMan.playerEntityList.size(); ++var4)
	     {
	    	 
	    	 
	    	 //System.out.println("-------------------- 3 Packets send");
	    	 
	    	 cPlayer = (EntityPlayerMP)confMan.playerEntityList.get(var4);
	    	 
	    	if(mod_netherbr.donatorList.checkDonator(cPlayer.username))
	    	{
	    		 ((EntityPlayerMP)player).playerNetServerHandler.sendPacketToPlayer(DonatorPacketSender.sendAddDonatorPacket(cPlayer.username));
	    		 
	    		 ((EntityPlayerMP)player).playerNetServerHandler.sendPacketToPlayer(DonatorPacketSender.sendDonatorChoiceAdd(cPlayer.username, ((DonatorChoice)mod_netherbr.donatorChoices.capeChoices.get(0)).name));
	    		 ((EntityPlayerMP)player).playerNetServerHandler.sendPacketToPlayer(DonatorPacketSender.sendDonatorChoiceAdd(cPlayer.username, ((DonatorChoice)mod_netherbr.donatorChoices.hornChoices.get(0)).name));
	    		 
	    		 cPlayer.playerNetServerHandler.sendPacketToPlayer(DonatorPacketSender.sendDonatorRequest(player.username));
	    	}
	    		 
	    	//if()
	    	//{
	    		cPlayer.playerNetServerHandler.sendPacketToPlayer(DonatorPacketSender.sendAddDonatorPacket(player.username));
	    		if(mod_netherbr.donatorList.iDonator)
	    		{
	    			if(mod_netherbr.donatorList.getDonatorByName(player.username).hasChooosen(EnumChoiceType.CAPE))
	    			cPlayer.playerNetServerHandler.sendPacketToPlayer(DonatorPacketSender.sendDonatorChoiceAdd(player.username, mod_netherbr.donatorList.getDonatorByName(player.username).getChoiceForType(EnumChoiceType.CAPE).name ));
	    			if(mod_netherbr.donatorList.getDonatorByName(player.username).hasChooosen(EnumChoiceType.HORN))
		    		cPlayer.playerNetServerHandler.sendPacketToPlayer(DonatorPacketSender.sendDonatorChoiceAdd(player.username, mod_netherbr.donatorList.getDonatorByName(player.username).getChoiceForType(EnumChoiceType.HORN).name ));
	    		}
	    		
	    		
	    	//}
	    		 
	    		 
	    		 
	    	
	    	 
	     }
		
		
		
		
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {
		
		if(mod_netherbr.donatorList.isDonator(player.username))
		{
			PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendRemoveDonator(player.username));
		}
		
		//System.out.println("--RemovePacket sent !");
		
	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {
		
		if(player !=  null && mod_netherbr.achievementsEnabled)
    	{
    		if(player.dimension == -1)
    		{
    			mod_netherbr.proxy.triggerAchievement(MNCAchievements.enterTheNether, player);
    		}
    		
    		else if(player.dimension == MNCBiomes.CrazyDimID)
    		{
    			mod_netherbr.proxy.triggerAchievement(MNCAchievements.enterTheFallenSky, player);
    		}
    		
    		
    	}
		
	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {
		
	}

}
