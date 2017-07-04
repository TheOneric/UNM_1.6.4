package Oneric.MNC.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import Oneric.MNC.common.ContainerHellAltar;
import Oneric.MNC.common.TileEntityHellAltar;
import Oneric.MNC.common.mod_netherbr;

public class GuiHellAltar extends GuiContainer
{
	private static TileEntityHellAltar Inventory;
	public static int GuiID = 1;
	private ResourceLocation image = new ResourceLocation(mod_netherbr.getId(), mod_netherbr.LOCATION_GUI + "hellaltar.png");

public GuiHellAltar(EntityPlayer par1InventoryPlayer, TileEntityHellAltar par2TileEntity)
{
	super(new ContainerHellAltar(par1InventoryPlayer.inventory, par2TileEntity));
	this.Inventory = par2TileEntity;
}

/**
* Draw the foreground layer for the GuiContainer (everything in front of the items)
*/
protected void drawGuiContainerForegroundLayer()
{
	this.fontRenderer.drawString(("Hellaltar"), 60, 6, 0xaaaaaa);
	this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
}

/**
* Draw the background layer for the GuiContainer (everything behind the items)
*/
protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
{
	//int var4 = this.mc.renderEngine.getTexture("/img/gui/hellaltar.png");
	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	this.mc.getTextureManager().bindTexture(image);
	int var5 = (this.width - this.xSize) / 2;
	int var6 = (this.height - this.ySize) / 2;
	this.drawTexturedModalRect(var5, var6, 0, 0, this.xSize, this.ySize);
	int var7;

if (this.Inventory.isBurning())
{
var7 = this.Inventory.getBurnTimeRemainingScaled(12);
this.drawTexturedModalRect(var5 + 56, var6 + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
}

var7 = this.Inventory.getCookProgressScaled(24);
this.drawTexturedModalRect(var5 + 79, var6 + 34, 176, 14, var7 + 1, 16);
}
}