package Oneric.MNC.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;


public class SlotHellAltar extends Slot
{

        public SlotHellAltar(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
        {
                super(iinventory, i, j, k);
        }

        public boolean isItemValid(ItemStack itemstack)
        {
                return false;
        }

        public void onPickupFromSlot(ItemStack itemstack)
        {
               // super.onPickupFromSlot(itemstack);
        }
}