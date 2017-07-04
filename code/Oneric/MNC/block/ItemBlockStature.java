package Oneric.MNC.block;
import java.util.List;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.*;

public class ItemBlockStature extends ItemBlock
{
public ItemBlockStature(int par1)
{
         super(par1);
         this.setMaxDamage(0); //Stops bad things from happening
         this.setHasSubtypes(true); //Tells it that it has metadata versions
}
//@SideOnly(Side.CLIENT)
//public int getIconFromDamage(int par1) //Gets the texture
//{
  //       return TutorialMain.metaBlock.getBlockTextureFromSideAndMetadata(2, par1);
//}
public int getMetadata(int par1) //Returns the metadata value
{
         return par1;
}
public String getItemNameIS(ItemStack is) //Get's the item incode name from an itemstack
{
         String[] types = {"0","1","2", "3"};
         return "Stature" + types[is.getItemDamage()];
}
}