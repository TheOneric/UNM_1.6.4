package Oneric.MNC.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import Oneric.MNC.entity.ai.EntityAIFlyFowards;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityHarpye extends EntityBat{

	
	
	
	public EntityHarpye(World world) {
		
		super(world);
		 // 1.6.1  this.texture = "/mnc/Errinnyen.png";
		// 1.6.1  this.moveSpeed = 0.5F;
		
		float i = (4 + (2/7));
		this.setSize(0.5F*i, 0.9F*i);
		
		 
		
		//this.tasks.addTask(0, new EntityAIFlyFowards(this, 0.2D, this.rand, world));
		//this.tasks.addTask(0, new EntityAIMoveTowardsTarget(this, 0.5D, this.rand));
		
	}
	
	
	@Override
	protected void applyEntityAttributes()
    {
            super.applyEntityAttributes();
            // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D);
            // Follow Range - default 32.0D - min 0.0D - max 2048.0D
            this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(32.0D);
            // Knockback Resistance - default 0.0D - min 0.0D - max 1.0D
            this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(0.0D);
            // Movement Speed - default 0.699D - min 0.0D - max Double.MAX_VALUE
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.5D);
            
    }
	
	@SideOnly(Side.CLIENT)

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        return "/mnc/Errinnyen.png";
    }
	
	protected int getExperiencePoints(EntityPlayer par1EntityPlayer)
    {
        return 1;
    }
	
	public EnumCreatureAttribute getCreatureAttribute()
    {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	



}
