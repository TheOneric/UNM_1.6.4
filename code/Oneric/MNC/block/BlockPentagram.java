package Oneric.MNC.block;

import java.util.Random;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.mod_netherbr;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockPentagram extends MNCBlockContainer{


private Class TileEntityClass;


@SideOnly(Side.CLIENT)
private Icon textureSide;



public BlockPentagram(int par1, Class classt) {
super(par1, Material.rock);
this.setBlockBounds(0, 0, 0, 1, 0.8F, 1);
this.setCreativeTab(CreativeTabs.tabDecorations);
TileEntityClass = classt;
}




@Override
public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
{


	// Just making an instance of the TileEntity that the player clicked on
	TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

	// Checking if the TileEntity is nothing or if the player is sneaking
	if(tile_entity == null || player.isSneaking()){
	// Returns false so it doesn't update anything
	return false;
	}
	// opens the UI if the later is not met, the method player.openGui() has 6 params
	// @param TutorialMod.instance, is just the instance of the TutorialMod
	// @param 0, this is the UI id, this can be changed in the GUI handler, and will open a different UI if chosen to do so
	// @param x, y, z, the players current player x, y, z coords
	player.openGui(mod_netherbr.mod, 0, world, x, y, z);
	// Returns true to force an update
	return true;
     
}

public int idDropped(int par1, Random par2Random, int par3)
{
	return this.blockID;
}


	@Override
	public Icon getIcon(int i, int par2)
	{
		
		if(i == 0)
		{
			return MNCBlocks.NetherBlock.getBlockTextureFromSide(i); // BOTTOM
		}

		if(i == 1)
		{
			return (this.blockIcon); // TOP
		}

		else
		{
		return this.textureSide; //SIDE
		}
		
		


	}
	
	@Override
	public void registerIcons(IconRegister registry)
	{
		this.blockIcon = registry.registerIcon(mod_netherbr.getId()+":mnc_hellAltarTop");
		this.textureSide = registry.registerIcon(mod_netherbr.getId()+":mnc_hellAltarSide");
		
	}




public boolean renderAsNormalBlock()
{
return false;
}

public boolean isOpaqueCube()
{
return false;
}

//public Minecraft mc = Minecraft.getMinecraft();

@Override
public TileEntity createNewTileEntity(World var1) {
try
{
return (TileEntity)TileEntityClass.newInstance();
}
catch(Exception ex)
{
throw new RuntimeException(ex);
}
}


public void breakBlock(World world, int x, int y, int z, int i, int j){
	
	this.dropItems(world, x, y, z);
	
	super.breakBlock(world, x, y, z, i, j);
	}

private void dropItems(World world, int x, int y, int z){
Random rand = new Random();

TileEntity tile_entity = world.getBlockTileEntity(x, y, z);

if(!(tile_entity instanceof IInventory)){
return;
}

IInventory inventory = (IInventory) tile_entity;

for(int i = 0; i < inventory.getSizeInventory(); i++){
ItemStack item = inventory.getStackInSlot(i);

if(item != null && item.stackSize > 0){
float rx = rand.nextFloat() * 0.6F + 0.1F;
float ry = rand.nextFloat() * 0.6F + 0.1F;
float rz = rand.nextFloat() * 0.6F + 0.1F;

EntityItem entity_item = new EntityItem(world, x + rx, y + ry, z + rz, new ItemStack(item.itemID, item.stackSize, item.getItemDamage()));

if(item.hasTagCompound()){
entity_item.getEntityItem().setTagCompound((NBTTagCompound) item.getTagCompound().copy());
}

float factor = 0.5F;

entity_item.motionX = rand.nextGaussian() * factor;
entity_item.motionY = rand.nextGaussian() * factor + 0.2F;
entity_item.motionZ = rand.nextGaussian() * factor;
world.spawnEntityInWorld(entity_item);
item.stackSize = 0;
}
}
}




public static void updateFurnaceBlockState(boolean b, World worldObj,
		int xCoord, int yCoord, int zCoord) {
	
	
}



}