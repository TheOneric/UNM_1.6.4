package Oneric.MNC.donator.choices;

import java.util.ArrayList;

public class DonatorChoices {
	
	public ArrayList hornChoices = new ArrayList();
	public ArrayList capeChoices = new ArrayList();

	
	public DonatorChoices()
	{
		this.hornChoices.add(new HornClassicChoice());
		
		this.capeChoices.add(new CapeRedChoice());
		this.capeChoices.add(new CapeBlueChoice());
	}
	
}
