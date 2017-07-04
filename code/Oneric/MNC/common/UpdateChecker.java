package Oneric.MNC.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;

public class UpdateChecker {
	
	
	
	public static synchronized void checkForUpdates()
	{
		if(mod_netherbr.updateCheck)
		{
			HttpURLConnection con;
			try
			{
				
				URL url = new URL("http://www.dailycube.de/partner/cmdmole/MNC/version.txt");
				
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
						buffer.append(line);
					}
					
					
					reader.close();
					inReader.close();
					in.close();
					
					String[] newVersion = (buffer.toString()).split(":");
					String[] actualVersion = "1:8:6".split(":");
					/*
					System.out.println("---------------------------------");
					System.out.println(newVersion.length);
					System.out.println(newVersion);
					System.out.println("---------------------------------");
					System.out.println(actualVersion.length);
					System.out.println(actualVersion);
					System.out.println("---------------------------------");
					System.out.println("Actual Version : ");
					for(int i = 0; i < actualVersion.length; i++)
					{
						System.out.println(actualVersion[i]);
					}
					System.out.println("---------------------------------");
					System.out.println("New Version : ");
					for(int i = 0; i < newVersion.length; i++)
					{
						System.out.println(newVersion[i]);
					}
					System.out.println("---------------------------------");
					*/
					boolean newVersionExists;
					for(int i = 0; i < 3; i++)
					{
						if(Integer.parseInt(newVersion[i]) > Integer.parseInt(actualVersion[i]))
						{
							FMLLog.getLogger().info("[UltimateNetherMod] New Version exists ! Download it from minecraftforum.net");
							if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT)
							{
								mod_netherbr.reportNewVersion = true;
								mod_netherbr.newVersionAviable = true;
							}
							
						}
					}
					
					
					
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
		}
	}
	
	

}
