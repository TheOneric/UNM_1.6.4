package Oneric.MNC.donator.choices;

import java.util.ArrayList;

import Oneric.MNC.donator.EnumChoiceType;

public class DonatorChoice {
	
	public String name;
	
	public String textureLocalPath;
	public String textureWebPath;
	
	public EnumChoiceType type;
	
	public static ArrayList<DonatorChoice> choices = new ArrayList();
	
	public DonatorChoice(String choiceName, EnumChoiceType choiceType, String fileName)
	{
		this.name = choiceName;
		this.type = choiceType;
		this.textureLocalPath = type.localPath + fileName;
		this.textureWebPath = type.webPath + fileName;
		
		this.choices.add(this);
	}
	
	public boolean isType(EnumChoiceType t)
	{
		return this.type == t;
	}
	
	public static DonatorChoice getChoiceByName(String nameS)
	{
		for(DonatorChoice c : choices)
		{
			System.out.println("--  I  --  t: " + c.name + " ;  -- giv: " + nameS);
			if(c.name.equalsIgnoreCase(nameS))
			{
				System.out.println("Accepted  :::  " + "t: " + c.name + " ;  -- giv: " + nameS);
				return c;
			}
		}
		
		return null;
	}
	

}
