package Oneric.MNC.donator;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.Configuration;

import Oneric.MNC.common.mod_netherbr;
import Oneric.MNC.donator.choices.DonatorChoice;

public class ChoiceSaver {
	
	/**
	/**
	 * Loads the choice from the savefile by ChoiceType
	 * *\
	public static synchronized DonatorChoice loadChoice(EnumChoiceType type)
	{
		File file = new File(Minecraft.getMinecraft().mcDataDir, /*"UltimateNether/donator/" + *\ "config/" + type.name + ".mnc-choice");
		
		/*try {
			
			
			
			
			if(!file.exists())
			{
				file.mkdirs();
				file.createNewFile();
				
				DonatorChoice choice = null;
				switch(type)
				{
				case CAPE:
					choice = DonatorChoice.getChoiceByName("CAPE BLUE");
					saveChoice(choice);
					break;
					
				case HORN:
					choice = DonatorChoice.getChoiceByName("HORN CLASSIC");
					saveChoice(choice);
					break;
					
				}
				
				return choice;
			}
			
			FileReader fStream = new FileReader(file);
			BufferedReader reader = new BufferedReader(fStream);
			
			String choiceName = reader.readLine();
			
			reader.close();
			fStream.close();
			
			
			
			
			
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println("Couldn't load your latest choice !");
			
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Couldn't load your latest choice !");
		}*\
		
		Configuration config = new Configuration(file); 
		
		String choiceName;
		
		
		
		
		
		return null;
	}*/
	
	/**
	public static synchronized boolean saveChoice(DonatorChoice choice)
	{
		try 
		{	
			char[] c = Minecraft.getMinecraft().mcDataDir.toURI().toURL().toString().toCharArray();
			char[] s = new char[c.length-1];
			
			for(int i = 0; i < c.length - 1; i++)
			{
				s[i] = c[i];
			}
			
			
			
			File file = new File(s.toString() + /*, /*"UltimateNether/donator/" + *\ "config/" + choice.type.name + ".mnc-choice");
			
			if(!file.exists())
			{
				file.getParentFile().mkdirs();
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);
			
			writer.write(choice.name);
			
			writer.flush();
			writer.close();
			
			
			
			
			
			return true;
			
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
			System.err.println("Failed to save choice !");
		}
		
		return false;
	}*/
	
	
	
	
	public static synchronized DonatorChoice loadChoice(EnumChoiceType type)
	{
		
		String choiceName = null;
		
		mod_netherbr.config.load();
		
		if(type == EnumChoiceType.CAPE)
		{
			choiceName = mod_netherbr.config.get(Configuration.CATEGORY_GENERAL, "choiceCape", ((DonatorChoice)mod_netherbr.donatorChoices.capeChoices.get(0)).name).getString();
		}
		
		else if(type == EnumChoiceType.HORN)
		{
			choiceName = mod_netherbr.config.get(Configuration.CATEGORY_GENERAL, "choiceHorn", ((DonatorChoice)mod_netherbr.donatorChoices.hornChoices.get(0)).name).getString();
		}
		
		mod_netherbr.config.save();
		
		return DonatorChoice.getChoiceByName(choiceName);
	}
	
	public static synchronized boolean saveChoice(EnumChoiceType type, DonatorChoice choice)
	{
		boolean flag = false;
		
		mod_netherbr.config.load();
		
		if(type == EnumChoiceType.CAPE)
		{
			if(choice == null)
			{
				mod_netherbr.config.get(Configuration.CATEGORY_GENERAL, "choiceCape", "NULL");
			} 
			else 
			{
				mod_netherbr.config.get(Configuration.CATEGORY_GENERAL, "choiceCape", choice.name);
			}
			mod_netherbr.config.save();
			flag = true;
		}
		
		else if(type == EnumChoiceType.HORN)
		{
			if(choice == null)
			{
				mod_netherbr.config.get(Configuration.CATEGORY_GENERAL, "choiceCape", "NULL");
			} 
			else 
			{
				mod_netherbr.config.get(Configuration.CATEGORY_GENERAL, "choiceHorn", (choice).name);
			}
			mod_netherbr.config.save();
			flag = true;
		}
		
		mod_netherbr.config.save();
		
		return flag;
		
		
	}
	

}
