package Oneric.MNC.common;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PlayerTypeCheck {
	
	
	
	public static synchronized EnumPlayerType checkPlayerType(String name)
	{
		
		
		
		//CHECK IF it's an developer
		HttpURLConnection con1;
		try
		{
			
			URL url = new URL("http://www.dailycube.de/partner/cmdmole/MNC/developers.txt");
			
			con1 = (HttpURLConnection) url.openConnection();
			con1.setDoInput(true);
			con1.setDoOutput(false);
			con1.connect();
			try
			{
				
				InputStream in = con1.getInputStream();
				
				InputStreamReader inReader = new InputStreamReader(in/*, "UTF-16"*/);
				BufferedReader reader = new BufferedReader(inReader);
				
				
				String line;
				
				
				while( (line = reader.readLine()) != null)
				{
					if(line.trim().equals(name))
					{
						return EnumPlayerType.DEVELOPER;
					}
				}
				
				
				reader.close();
				inReader.close();
				in.close();
			}finally
			{
				if(con1 != null)
				{
					con1.disconnect();
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		//CHECK IF it's a parnter
		HttpURLConnection con2;
		try {

			URL url = new URL(
					"http://www.dailycube.de/partner/cmdmole/MNC/partners.txt");

			con2 = (HttpURLConnection) url.openConnection();
			con2.setDoInput(true);
			con2.setDoOutput(false);
			con2.connect();
			try {

				InputStream in = con2.getInputStream();

				InputStreamReader inReader = new InputStreamReader(in/*,"UTF-16"*/);
				BufferedReader reader = new BufferedReader(inReader);

				String line;

				while ((line = reader.readLine()) != null) {
					if (line.trim().equals(name)) {
						return EnumPlayerType.PARTNER;
					}
				}

				reader.close();
				inReader.close();
				in.close();
			} finally {
				if (con2 != null) {
					con2.disconnect();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		//CHECK IF it's a parnter
				HttpURLConnection con;
				try {

					URL url = new URL(
							"http://www.dailycube.de/partner/cmdmole/MNC/donators.txt");

					con = (HttpURLConnection) url.openConnection();
					con.setDoInput(true);
					con.setDoOutput(false);
					con.connect();
					try {

						InputStream in = con.getInputStream();

						InputStreamReader inReader = new InputStreamReader(in/*,"UTF-16"*/);
						BufferedReader reader = new BufferedReader(inReader);

						String line;

						while ((line = reader.readLine()) != null) {
							if (line.trim().equals(name)) {
								return EnumPlayerType.DONATOR;
							}
						}

						reader.close();
						inReader.close();
						in.close();
					} finally {
						if (con != null) {
							con.disconnect();
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
				
				//If All others failed
				return EnumPlayerType.NORMAL;
		
		
		
		
		
		
		
		
		
	}
	
	

}
