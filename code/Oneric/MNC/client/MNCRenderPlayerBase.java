package Oneric.MNC.client;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;

import api.player.render.RenderPlayerAPI;
import api.player.render.RenderPlayerBase;

import Oneric.MNC.common.mod_netherbr;
import Oneric.MNC.donator.EnumChoiceType;
import Oneric.MNC.donator.MNCRank;
import Oneric.MNC.donator.choices.DonatorChoice;
import Oneric.MNC.entity.model.ModelDaemonLord;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class MNCRenderPlayerBase extends RenderPlayerBase{
	
	
	private ModelBiped modelCape = new ModelBiped(1.0F);
	private ModelDaemonLord modelHorns = new ModelDaemonLord();
	
	
	public MNCRenderPlayerBase(RenderPlayerAPI var1) {
		super(var1);
		
		
	}
	
	
	@Override
	public void renderPlayer(AbstractClientPlayer player, double d, double d1, double d2, float f, float f2)
	{
		super.renderPlayer(player, d, d1, d2, f, f2);
	}
	
	@Override
	public void afterRenderSpecials(AbstractClientPlayer player, float f)
	{	
		// System.out.println("---- After Render Special ----");
		
		if(mod_netherbr.donatorList.isDonator( player.username ) )
		{
			// System.out.println("---- Is Donator ----");
			
			//System.out.println(player.worldObj.isRemote);
			//System.out.println("HORN:  " + mod_netherbr.donatorList.getDonatorByName(player.username).getChoiceForType(EnumChoiceType.HORN));
			//System.out.println("CAPE:  " + mod_netherbr.donatorList.getDonatorByName(player.username).getChoiceForType(EnumChoiceType.CAPE));
			
			
			
			if(mod_netherbr.donatorList.getDonatorByName(player.username).hasChooosen(EnumChoiceType.CAPE))
			{
				this.renderCape(player, f);
			}
			
			if(mod_netherbr.donatorList.getDonatorByName(player.username).hasChooosen(EnumChoiceType.HORN))
			{
				this.renderHorns(player, f);
			}
			
		}
		
		
        
	}
	
	
	
	//private float prevRotationYawHead = 0F;
	private void renderHorns(EntityPlayer player, float var2)
	{
		this.renderPlayer.localLoadTexture(new ResourceLocation(mod_netherbr.getId(), mod_netherbr.LOCATION_ENTITIES + "DaemonLord.png"));
		
		
		
		GL11.glPushMatrix();
		
		/*
		double var20 = player.field_71091_bM + (player.field_71094_bP - player.field_71091_bM) * (double) var2 - (player.prevPosX + (player.posX - player.prevPosX) * (double) var2);
		
		double var9 = player.field_71097_bO + (player.field_71085_bR - player.field_71097_bO) * (double) var2 - (player.prevPosZ + (player.posZ - player.prevPosZ) * (double) var2);
		float var11 = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * var2;
		double var12 = (double) MathHelper.sin(var11 * (float) Math.PI / 180.0F);
		double var14 = (double) (-MathHelper.cos(var11 * (float) Math.PI / 180.0F));
		
         float var18 = (float)(var20 * var14 - var9 * var12) * 100.0F;
		*/
         
         /**  
	      GL11.glRotatef( this.renderPlayer.getModelBipedMainField().bipedHead.rotateAngleX, 1.0F, 0.0F, 0.0F);
	      GL11.glRotatef( this.renderPlayer.getModelBipedMainField().bipedHead.rotateAngleY, 0.0F, 1.0F, 0.0F);
	      GL11.glRotatef( this.renderPlayer.getModelBipedMainField().bipedHead.rotateAngleZ, 0.0F, 0.0F, 1.0F);
	      */ 
         
         /*
	      GL11.glRotatef(-var18 / 2.0F, 0.0F, 1.0F, 0.0F);
	      GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);*/
		
	    //GL11.glRotatef(player.rotationYaw / 4, 0F, 1F, 0F);
	      
	      
	      /*
	    double var20Head = player.field_71091_bM + (player.field_71094_bP - player.field_71091_bM) * (double) var2 - (player.prevPosX + (player.posX - player.prevPosX) * (double) var2);	
		double var9Head = player.field_71097_bO + (player.field_71085_bR - player.field_71097_bO) * (double) var2 - (player.prevPosZ + (player.posZ - player.prevPosZ) * (double) var2);
		float var11Head = player.prevRotationYawHead + (player.rotationYawHead - player.prevRotationYawHead) * var2;
		double var12Head = (double) MathHelper.sin(var11Head * (float) Math.PI / 180.0F);
		double var14Head = (double) (-MathHelper.cos(var11Head * (float) Math.PI / 180.0F));
		float var18Head = (float)(var20Head * var14Head - var9Head * var12Head) * 100.0F;
		
		GL11.glRotatef(-var18Head / 2.0F, 0.0F, 1.0F, 0.0F);
	     
		 this.prevRotationYawHead = player.rotationYawHead;*/
		
	      
	     GL11.glRotatef(player.rotationYawHead - player.rotationYaw, 0, 1, 0);
	     //System.out.println(player.rotationYaw);
		 GL11.glRotatef(player.rotationPitch, 1, 0, 0);
		
		this.modelHorns.Horn1Right.render(0.0625F);
		this.modelHorns.Horn2Right.render(0.0625F);
		this.modelHorns.Horn1Left.render(0.0625F);
		this.modelHorns.Horn2Left.render(0.0625F);
		
		GL11.glPopMatrix();
	}
	
	
	
	/**
	 * Args: player: The Player, whose rendered, var2: ??, mode: The Render mode
	 * 
	 * Modes:   0 = Donator
	 * 			1 = Developer, Partner, etc
	 * 			2 = 
	 * */
	private void renderCape(EntityPlayer player, float var2)
	{
		//this.renderPlayer.localLoadTexture("/img/capes/cape_Donator2.png");
		//this.renderPlayer.localLoadDownloadableImageTexture(choice.textureLocalPath, choice.textureWebPath);
		
		if(MNCRank.getRankFromUsername(player.username) == MNCRank.DEVELOPER || MNCRank.getRankFromUsername(player.username) == MNCRank.PARTNER){
			this.renderPlayer.localLoadTexture(new ResourceLocation(mod_netherbr.getId(), mod_netherbr.LOCATION_TEXTURES + "capes/cape_" + player.username + ".png"));
		}
		
		else {
			
			
			DonatorChoice choice = mod_netherbr.donatorList.getDonatorByName(player.username).getChoiceForType(EnumChoiceType.CAPE);
			if(choice == null) return;
			this.renderPlayer.localLoadTexture(new ResourceLocation(mod_netherbr.getId(), choice.textureLocalPath));
			//this.renderPlayer.localLoadTexture("/img/capes/cape_Donator-Blue.png");
			//System.out.println("Cape rend !");
		}
		
		
		GL11.glPushMatrix();
		
		GL11.glTranslatef(0.0F, 0.0F, 0.125F);
		
		GL11.glTranslatef(0.0F, 0.0F, 0.125F);
		double var20 = player.field_71091_bM + (player.field_71094_bP - player.field_71091_bM) * (double) var2 - (player.prevPosX + (player.posX - player.prevPosX) * (double) var2);
		double var21 = player.field_71096_bN + (player.field_71095_bQ - player.field_71096_bN) * (double) var2 - (player.prevPosY + (player.posY - player.prevPosY) * (double) var2);
		double var9 = player.field_71097_bO + (player.field_71085_bR - player.field_71097_bO) * (double) var2 - (player.prevPosZ + (player.posZ - player.prevPosZ) * (double) var2);
		float var11 = player.prevRenderYawOffset + (player.renderYawOffset - player.prevRenderYawOffset) * var2;
		double var12 = (double) MathHelper.sin(var11 * (float) Math.PI / 180.0F);
		double var14 = (double) (-MathHelper.cos(var11 * (float) Math.PI / 180.0F));
		float var16 = (float) var21 * 10.0F;
		
		
		 if (var16 < -6.0F)
         {
             var16 = -6.0F;
         }

         if (var16 > 32.0F)
         {
             var16 = 32.0F;
         }

         float var17 = (float)(var20 * var12 + var9 * var14) * 100.0F;
         float var18 = (float)(var20 * var14 - var9 * var12) * 100.0F;

         if (var17 < 0.0F)
         {
             var17 = 0.0F;
         }

         float var19 = player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * var2;
         var16 += MathHelper.sin((player.prevDistanceWalkedModified + (player.distanceWalkedModified - player.prevDistanceWalkedModified) * var2) * 6.0F) * 32.0F * var19;

         if (player.isSneaking())
         {
             var16 += 25.0F;
         }

         GL11.glRotatef(6.0F + var17 / 2.0F + var16, 1.0F, 0.0F, 0.0F);
         GL11.glRotatef(var18 / 2.0F, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(-var18 / 2.0F, 0.0F, 1.0F, 0.0F);
         GL11.glRotatef(180.0F, 0.0F, 1.0F, 0.0F);
		
		
		modelCape.renderCloak(0.0625F);
		
		GL11.glPopMatrix();
	}
	
	

}
