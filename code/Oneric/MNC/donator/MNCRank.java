package Oneric.MNC.donator;

import java.util.ArrayList;

public enum MNCRank {
	
	DEVELOPER(new String[]{"nkioe"}),
	PARTNER(new String[]{"DerGoliHerr", "batmany12"}),
	DEFAULT(new String[0]);
	
	ArrayList<String> members = new ArrayList();
	
	private MNCRank(String[] s)
	{
		for(int i = 0; i < s.length; i++)
		{
			members.add(s[i]);
		}
	}
	
	
	public static MNCRank getRankFromUsername(String name)
	{
		for(int i = 0; i < values().length; i++)
		{
			if(values()[i].members.contains(name)) return values()[i];
		}
		
		return DEFAULT;
	}
	

}
