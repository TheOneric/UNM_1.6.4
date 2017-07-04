package Oneric.MNC.donator;

import Oneric.MNC.common.mod_netherbr;

public enum EnumChoiceType {
	
	
	CAPE("CAPE", mod_netherbr.LOCATION_TEXTURES + "capes/cape_", "http://www.dailycube.de/partner/cmdmole/MNC/doantors/skins/cape_"),
	HORN("HORN", mod_netherbr.LOCATION_ENTITIES + "DaemonLord.png", "http://www.dailycube.de/partner/cmdmole/MNC/doantors/skins/horn_");
	
	
	public String localPath;
	public String webPath;
	public String name;
	
	private EnumChoiceType(String nameTmp, String local, String web)
	{
		this.name = nameTmp;
		this.localPath = local;
		this.webPath = web;
	}
	
	
	/**
	 * Returns the Enum associated with this name or null if there's no Enum with this name
	 * */
	public static EnumChoiceType getTypeByName(String nameOf)
	{
		EnumChoiceType[] list = values();
		
		for(int i = 0; i < list.length; i++)
		{
			if(list[i].name.equals(nameOf))
			{
				return list[i];
			}
		}
		
		return null;
		
	}
	
	
	

}
