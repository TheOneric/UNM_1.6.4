package Oneric.MNC.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundManager;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class MNCSoundManager {
	
	/** Root directory for mod*/
	public static URL jarLocation;
	
	
	static
	{
		try {
			URL location = mod_netherbr.class.getProtectionDomain().getCodeSource().getLocation();
			
			  if (!location.getProtocol().equals("jar")) {
                  File f = new File(location.toURI());
                  String filename = f.getName().toLowerCase();
                  if (filename.endsWith(".jar") || filename.endsWith(".zip"))
                          location = new URL("jar", null, location.toExternalForm().concat("!/"));
                  else {
                          File parent;
                          while ((parent = f.getParentFile()) != null && !(parent.getName().equals("mods") || parent.getName().equals("bin")))
                                  f = parent;
                          if (parent == null)
                                  f = new File(location.toURI());
                          jarLocation = f.toURI().toURL();
                  }
          }
          if (location.getProtocol().equals("jar")) {
                  String path = location.getPath();
                  int i = path.indexOf("!/");
                  jarLocation = new URL("jar", null, path.substring(0, i + 2));
          }
          
          System.out.println(jarLocation.getPath());
          
          
		} catch (Exception e) {
	          e.printStackTrace();
	  }
	}
	
	
	private Minecraft mc;
	
	
	public MNCSoundManager()
	{
		mc = Minecraft.getMinecraft();
	}
		
        
		
  
        
	
	
	@ForgeSubscribe
	public void onSound(SoundLoadEvent event)
	{
		//this.registerSound(event.manager, "achievement/achiev1.ogg", "/resources/newsound/achievement/achiev1.ogg");
		//this.registerSound(event.manager, "achievement/achiev2.ogg", "/resources/newsound/achievement/achiev2.ogg");
		
		/**this.moveSounds("newsound/achievement/achiev1.ogg");
		this.moveSounds("newsound/achievement/achiev2.ogg");*/
		
		this.registerSound(event.manager, "achievement/achiev1", "ogg", "resources/newsound/achievement/achiev1.ogg");
		this.registerSound(event.manager, "achievement/achiev2", "ogg", "resources/newsound/achievement/achiev2.ogg");
	}
	
	
	
	
	/*
	private void registerSound(SoundManager man, String name, String path)
	{
		try
        {
            URL var4 = MNCSoundManager.class.getResource(path);

            if (var4 == null)
            {
                throw new FileNotFoundException();
            }

            man.soundPoolSounds.addSound(name, var4);
        }
        catch (Exception var5)
        {
            System.out.println(String.format("ERROR: Unable to load Sound File %s", new Object[] {path}));
        }
	}*/
	
	
	
	 public final void registerSound(SoundManager manager, String name, String type, String path) {
         /**try {
        	 
        	 URL var4 = new URL(jarLocation, path);
        	 
                 manager.soundPoolSounds.addSound(name + "." + type, var4);
                 System.out.println(new URL(jarLocation, path).getPath());
         } catch (MalformedURLException e) {
                 e.printStackTrace();
         }*/
		 
		 try {
        	 
        	 URL var4 = new URL(this.mc.mcDataDir.toURI().toURL(), path);
        	 
                 //TODO manager.soundPoolSounds.addSound(name + "." + type, var4);
                 System.out.println(var4.getPath());
         } catch (MalformedURLException e) {
                 e.printStackTrace();
         }
 }
	 
	 
	
	
	

}
