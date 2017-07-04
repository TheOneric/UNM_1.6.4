package Oneric.MNC.block;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockDungeon extends ItemBlock{

	
	
	public String getTextureFile()
    {
            return "/img/mnc_blocks.png";
    }

    public ItemBlockDungeon(int i)
    {
        super(i);
        setUnlocalizedName("DungeonStone");
        setHasSubtypes(true);
    }

    public String getItemNameIS(ItemStack itemstack)
    {
        int i = itemstack.getItemDamage();

        if (i > 1)
        {
            i = 1;
        }

        return (new StringBuilder()).append(getUnlocalizedName()).append(i).toString();
    }

    public int getColorFromDamage(int i)
    {
        if (i == 1)
        {
            return 0xff8888ff;
        }

        return i != 2 ? -1 : -120;
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int i)
    {
        return i;
    }
	
	
	
}
