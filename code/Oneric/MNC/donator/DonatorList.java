package Oneric.MNC.donator;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import Oneric.MNC.common.mod_netherbr;
import Oneric.MNC.donator.choices.DonatorChoice;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;

import net.minecraft.client.Minecraft;

public class DonatorList {
	
	
	HashMap<String, Donator> donatorList = new HashMap<String, Donator>();
	
	public boolean iDonator = false;
	public String iDonatorName;
	
	
	//public boolean isServer;
	
	
	public DonatorList()
	{
		
	}
	
	
	
	public void addMe(String username)
	{
		if(this.checkDonator(username))
		{
			
			this.addDonator(new Donator(username));
			this.iDonator = true;
			this.iDonatorName = username;
			
			DonatorChoice choiceCape = ChoiceSaver.loadChoice(EnumChoiceType.CAPE);
			if(choiceCape != null)
			{
				this.donatorList.get(username).addChoice(choiceCape);
			}
			
			DonatorChoice choiceHorn = ChoiceSaver.loadChoice(EnumChoiceType.HORN);
			if(choiceHorn != null)
			{
				this.donatorList.get(username).addChoice(choiceHorn);
			}
			
			
		}
	}
	
	
	public boolean checkDonator(String username)
	{
		/*
		if(username.startsWith("Player")) return true; */ 
		
		
		
		HttpURLConnection con;
		try
		{
			
			URL url = new URL("http://www.dailycube.de/partner/cmdmole/MNC/donators.txt");
			
			con = (HttpURLConnection) url.openConnection();
			con.setDoInput(true);
			con.setDoOutput(false);
			con.connect();
			try
			{
				
				InputStream in = con.getInputStream();
				
				InputStreamReader inReader = new InputStreamReader(in/*, "UTF-16"*/);
				BufferedReader reader = new BufferedReader(inReader);
				
				StringBuffer buffer = new StringBuffer();
				String line;
				
				
				while( (line = reader.readLine()) != null)
				{
					if(line.equals(username))
					{
						reader.close();
						inReader.close();
						in.close();
						
						return true;
					}
				}
				
				
				reader.close();
				inReader.close();
				in.close();
				
				
				
				
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			finally{
				
				if(con != null) con.disconnect();
			}
			
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return false;
	}
	
	
	
	public void addDonator(Donator donator)
	{
		this.donatorList.put(donator.username, donator);
	}
	
	
	public Donator getDonatorByName(String name)
	{
		return this.donatorList.get(name);
	}
	
	
	public boolean isDonator(String name)
	{
		return this.donatorList.containsKey(name);
	}
	
	public void addDonatorChoice(String donatorName, DonatorChoice c)
	{
		this.donatorList.get(donatorName).addChoice(c);
	}
	
	public void removeDonator(String name)
	{
		if(name != this.iDonatorName && name != null)
		{
			this.donatorList.remove(name);
		}
	}
	
	
	
	

}
