package Oneric.MNC.common;

import Oneric.MNC.block.BlockPentagram;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.src.*;
import net.minecraft.tileentity.TileEntity;

public class TileEntityHellAltar extends TileEntity implements /*IInventory,*/ ISidedInventory
{
	
    /**
     * The ItemStacks that hold the items currently being used in the HellAltar
     */
    private ItemStack[] HellAltarItemStacks = new ItemStack[3];

    /** The number of ticks that the HellAltar will keep burning */
    public int HellAltarBurnTime = 0;

    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the HellAltar burning for
     */
    public int currentItemBurnTime = 0;

    /** The number of ticks that the current item has been cooking for */
    public int HellAltarCookTime = 0;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.HellAltarItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.HellAltarItemStacks[par1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.HellAltarItemStacks[par1] != null)
        {
            ItemStack var3;

            if (this.HellAltarItemStacks[par1].stackSize <= par2)
            {
                var3 = this.HellAltarItemStacks[par1];
                this.HellAltarItemStacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.HellAltarItemStacks[par1].splitStack(par2);

                if (this.HellAltarItemStacks[par1].stackSize == 0)
                {
                    this.HellAltarItemStacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.HellAltarItemStacks[par1] != null)
        {
            ItemStack var2 = this.HellAltarItemStacks[par1];
            this.HellAltarItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.HellAltarItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "container.HellAltar";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.HellAltarItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.HellAltarItemStacks.length)
            {
                this.HellAltarItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.HellAltarBurnTime = par1NBTTagCompound.getShort("BurnTime");
        this.HellAltarCookTime = par1NBTTagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.HellAltarItemStacks[1]);
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("BurnTime", (short)this.HellAltarBurnTime);
        par1NBTTagCompound.setShort("CookTime", (short)this.HellAltarCookTime);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.HellAltarItemStacks.length; ++var3)
        {
            if (this.HellAltarItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.HellAltarItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
        return this.HellAltarCookTime * par1 / 200;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    public int getBurnTimeRemainingScaled(int par1)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.HellAltarBurnTime * par1 / this.currentItemBurnTime;
    }

    /**
     * Returns true if the HellAltar is currently burning
     */
    public boolean isBurning()
    {
        return this.HellAltarBurnTime > 0;
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
        boolean var1 = this.HellAltarBurnTime > 0;
        boolean var2 = false;

        if (this.HellAltarBurnTime > 0)
        {
            --this.HellAltarBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.HellAltarBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.HellAltarBurnTime = getItemBurnTime(this.HellAltarItemStacks[1]);

                if (this.HellAltarBurnTime > 0)
                {
                    var2 = true;

                    if (this.HellAltarItemStacks[1] != null)
                    {
                        --this.HellAltarItemStacks[1].stackSize;

                        if (this.HellAltarItemStacks[1].stackSize == 0)
                        {
                            this.HellAltarItemStacks[1] = this.HellAltarItemStacks[1].getItem().getContainerItemStack(HellAltarItemStacks[1]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.HellAltarCookTime;

                if (this.HellAltarCookTime == 200)
                {
                    this.HellAltarCookTime = 0;
                    this.smeltItem();
                    var2 = true;
                }
            }
            else
            {
                this.HellAltarCookTime = 0;
            }

            if (var1 != this.HellAltarBurnTime > 0)
            {
                var2 = true;
                BlockPentagram.updateFurnaceBlockState(this.HellAltarBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (var2)
        {
            this.onInventoryChanged();
        }
    }

    /**
     * Returns true if the HellAltar can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.HellAltarItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack var1 = HellAltarRecipes.smelting().getSmeltingResult(this.HellAltarItemStacks[0]);
            if (var1 == null) return false;
            if (this.HellAltarItemStacks[2] == null) return true;
            if (!this.HellAltarItemStacks[2].isItemEqual(var1)) return false;
            int result = HellAltarItemStacks[2].stackSize + var1.stackSize;
            return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
        }
    }

    /**
     * Turn one item from the HellAltar source stack into the appropriate smelted item in the HellAltar result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = HellAltarRecipes.smelting().getSmeltingResult(this.HellAltarItemStacks[0]);

            if (this.HellAltarItemStacks[2] == null)
            {
                this.HellAltarItemStacks[2] = var1.copy();
            }
            else if (this.HellAltarItemStacks[2].isItemEqual(var1))
            {
                HellAltarItemStacks[2].stackSize += var1.stackSize;
            }

            --this.HellAltarItemStacks[0].stackSize;

            if (this.HellAltarItemStacks[0].stackSize <= 0)
            {
                this.HellAltarItemStacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the HellAltar burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack par0ItemStack)
    {
    	if (par0ItemStack == null)
        {
            return 0;
        }
        else
        {
            int var1 = par0ItemStack.getItem().itemID;
            Item var2 = par0ItemStack.getItem();

           
            if (var1 == MNCItems.strange.itemID) return 20000;
            if (var1 == Item.ghastTear.itemID) return 100;
            if (var1 == Item.magmaCream.itemID) return 1600 ;
            //if (var1 == Block.sapling.blockID) return 100;
            if (var1 == Item.blazeRod.itemID) return 2000;
            
            else
            {
            	return 0;
            }
            
        }
    }

    /**
     * Return true if item is a fuel source (getItemBurnTime() > 0).
     */
    public static boolean isItemFuel(ItemStack par0ItemStack)
    {
        return getItemBurnTime(par0ItemStack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}

  
    public int getStartInventorySide(ForgeDirection side)
    {
        if (side == ForgeDirection.DOWN) return 1;
        if (side == ForgeDirection.UP) return 0; 
        return 2;
    }

   
    public int getSizeInventorySide(ForgeDirection side)
    {
        return 1;
    }   
	
    
	@Override
	public boolean isInvNameLocalized() {
		 return false;
	}

	

	@Override
	public boolean isItemValidForSlot(int par1, ItemStack itemstack) {
		
		return par1 == 2 ? false : (par1 == 1 ? isItemFuel(itemstack) : true);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int par1) {
		 return null;
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		
		return false;
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		
		return false;
	}

	

	
}
