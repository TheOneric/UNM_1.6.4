package Oneric.MNC.client;

import java.util.EnumSet;

import org.lwjgl.input.Keyboard;

import Oneric.MNC.client.gui.donator.GuiDonator;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class MNCKeyHandler extends KeyHandler {
	
	private static KeyBinding guiBinding = new KeyBinding("Donator Gui", Keyboard.KEY_U);
	
	public MNCKeyHandler()
	{
		super(new KeyBinding[]{guiBinding}, new boolean[]{false});
	}
	

	@Override
	public String getLabel() {
		
		return "UltimateNether-KeyBindings";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
		
		if(FMLClientHandler.instance().getClient().currentScreen == null)
		{
			 FMLClientHandler.instance().getClient().displayGuiScreen(new GuiDonator(FMLClientHandler.instance().getClient().thePlayer));
		}

	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {
		

	}

	@Override
	public EnumSet<TickType> ticks() {
		
		return EnumSet.of(TickType.CLIENT);
	}

}
