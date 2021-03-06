package Oneric.MNC.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;



public class EntityIceBall extends EntityThrowable
{
	 public EntityIceBall(World par1World)
	    {
	        super(par1World);
	    }

	    public EntityIceBall(World par1World, EntityLiving par2EntityLiving)
	    {
	        super(par1World, par2EntityLiving);
	    }

	    public EntityIceBall(World par1World, double par2, double par4, double par6)
	    {
	        super(par1World, par2, par4, par6);
	    }
	    
	   
    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition par1MovingObjectPosition)
    {
        if (par1MovingObjectPosition.entityHit != null)
        {
            byte var2 = 5;

            if (par1MovingObjectPosition.entityHit instanceof EntitySnowman)
            {
                var2 = 0;
            }

            par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
        }

        for (int var3 = 0; var3 < 8; ++var3)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}
