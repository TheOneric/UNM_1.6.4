package Oneric.MNC.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class EBoneMeal extends Item{

	public EBoneMeal(int par1) {
		super(par1);
		this.setCreativeTab(CreativeTabs.tabMaterials);
		
	}
	
	 public boolean hasEffect(ItemStack par1ItemStack)
	 {
		 return true;
	 }
	 
	 public EnumRarity getRarity(ItemStack par1ItemStack)
	 {
		 return EnumRarity.uncommon;
	 }

}
