package Oneric.MNC.common;

import java.util.Random;

public class BossNameGen {
	
	//"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
	
	
	private static String[] begin = 
		{
			"Gol", "Bil", "Fro", "Ha", "", "Pos", "Zeu", "Quetz", "Kan", "Man", "Schi", "Fio", "Ni", "Ol", "Ker", "Her",
			"Xen", "Xan", "Zer", "Zar"
		};
	
	
	
	
	private static String[] middle = 
		{
			"ina", "ion", "tom", "kar", "mar", "nar", "iom", "in", "ko", "slo", "gor", "per", "pat", "tim", "gin", "sin",
			"fer", "la", "el", "sche", "scho", "scha", "the", "ut", "joe", "on", "no", "jem", "fra", "la", "em", "en",
			"sen", "sem", "sam", "kam", "lor", "sor", "hed", "wig", "gop", "gep", "sle", "sla", "sli", "po", "pa", "pi",
			"xen", "xan", "xin", "zen", "zan", "zin", "lef", "quel", "soram", "sorem", "leif", "sko", "flu", "fli", "fla", "ber"
		};
	
	
	
	
	private static String[] end = 
		{
			"en", "em", "im", "in", "ef", "na", "la", "is", "ich", "co", "el", "ke", "ka", "ne", "me", "pe",
		};
	
	
	
	
	
	
	
	public static synchronized String generate()
	{
		Random rand = new Random();
		StringBuilder builder = new StringBuilder();
		
		//Anfang
		builder.append(begin[rand.nextInt(begin.length)]);
		
		//Mitte
		int j = 3 + rand.nextInt(2);
		for(int i = 0; i < j; i++)
		{
			builder.append(middle[rand.nextInt(middle.length)]);
		}
		
		
		//Ende
		builder.append(end[rand.nextInt(end.length)]);
		
		
		return builder.toString();
	}
	

}
