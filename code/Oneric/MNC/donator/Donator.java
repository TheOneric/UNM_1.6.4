package Oneric.MNC.donator;

import java.util.HashMap;

import Oneric.MNC.donator.choices.DonatorChoice;

public class Donator {
	
	
	String username;
	HashMap choices = new HashMap<EnumChoiceType, DonatorChoice>();
	
	public Donator(String name)
	{
		this.username = name;
	}
	
	
	public DonatorChoice getChoiceForType(EnumChoiceType t)
	{
		return this.choices.get(t) != null ? (DonatorChoice)this.choices.get(t) : null;
	}
	
	public boolean hasChooosen(EnumChoiceType t)
	{
		return this.choices.get(t) != null;
	}
	
	public void addChoice(DonatorChoice c)
	{	
		if (this.choices.get(c.type) != null)
        {
            this.choices.remove(c.type);
        }

        this.choices.put(c.type, c);
	}
	
	public void removeChoiceForType(EnumChoiceType type)
	{
		this.choices.remove(type);
	}
	
	public String getUserName()
	{
		return this.username;
	}
	
	

}
