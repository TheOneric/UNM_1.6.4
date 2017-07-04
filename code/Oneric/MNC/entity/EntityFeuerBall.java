package Oneric.MNC.entity;

import org.lwjgl.opengl.GL11;

import Oneric.MNC.entity.boss.EntityDaemonLord;
import Oneric.MNC.entity.model.ModelFeuerBall;
import Oneric.MNC.entity.render.RenderFeuerBall;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityFlying;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityFeuerBall extends EntityFlying{
	
	public int lifeTime;
	public int life; 
	
	public double sMotionX;
	public double sMotionY;
	public double sMotionZ;
	
	

	public EntityFeuerBall(World par1World, double x, double y, double z) {
		this(par1World);
		
		this.setPositionAndUpdate(x, y, z);
		
        
        // 1.6.1  this.texture = "/mnc/feuerball.png";

	}
	
	public EntityFeuerBall(World world)
	{
		super(world);
		
		this.isImmuneToFire = true;
		
		lifeTime = 9999999;
		life = lifeTime;
		
		sMotionX = (0.2D + (double)rand.nextFloat() * 0.15D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        sMotionY = 0D;
        sMotionZ = (0.2D + (double)rand.nextFloat() * 0.15D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
	}

	@Override
	protected void applyEntityAttributes()
    {
       
		super.applyEntityAttributes();
        // Max Health - default 20.0D - min 0.0D - max Double.MAX_VALUE
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(5.0D);
        
      }
	
	@Override
	protected void entityInit()
    {
            super.entityInit();
            this.dataWatcher.addObject(16, new Byte((byte)0));
    }
	
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		
		/*life--;
		if(life < 0)
		{
			this.letItDie();
		}*/
		
		
		
		
		
		 double d = (rand.nextFloat() - 0.5F) * 0.5F;
         double d1 = (rand.nextFloat() - 0.5F) * 0.5F;
         double d2 = (rand.nextFloat() - 0.5F) * 0.5F;
		 
         //this.worldObj.spawnParticle("flame", posX, posY, posZ, d, d1, d2);
         this.worldObj.spawnParticle("smoke", posX+05D, posY+05D, posZ+05D, d, d1, d2);
         worldObj.playSoundAtEntity(this, "random.fizz", 0.5F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.2F);
         System.out.println("Particle+Noise");
		
	}
	
	
	public void letItDie()
	{
		
		this.worldObj.spawnParticle("largesmoke", this.posX, this.posY, this.posZ, (double)(this.rand.nextInt(5) / 10D), (double)(this.rand.nextInt(5) / 10D), (double)(this.rand.nextInt(5) / 10D));
		
		this.setDead();
	}
	
	@Override
	public void updateEntityActionState()
	{
		super.updateEntityActionState();
		
		
		motionX = sMotionX;
		motionY = sMotionY;
		motionZ = sMotionZ;
		
		
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource damagesource, float i)
    {
		if(damagesource.getEntity() != null)
		{
			Vec3 vec = damagesource.getEntity().getLookVec();
			
			if(vec != null)
			{
				sMotionX = vec.xCoord;
				sMotionY = vec.xCoord;
				sMotionZ = vec.xCoord;
			}
			
			this.worldObj.playSoundAtEntity(this, "random.explode", 0.4F, 1.0F);
			
			return true;
		}
		else
		{
			return false;
		}
    }
	
	
	 @SideOnly(Side.CLIENT)
	 public float getShadowSize()
	 {
		 return 1.0F;
	 }

	 /**
	  * Gets how bright this entity is.
	  **\
	 public float getBrightness(float par1)
	 {
		 return 1.0F;
	 }

}


/**

import java.util.Random;

public class EntityFeuerBall extends EntityFlying
{
   
    public double smotionX;
    public double smotionY;
    public double smotionZ;
    public int life;
    public int lifeSpan;
    public boolean frosty;
    public boolean smacked;
    public boolean fromCloud;
    private static final double topSpeed = 0.125D;
    private static final float sponge = (180F / (float)Math.PI);

    public EntityFeuerBall(World world)
    {
        super(world);
        texture = "/mnc/feuerball.png";
        lifeSpan = 300;
        life = lifeSpan;
        setSize(0.9F, 0.9F);
        sinage = new float[3];
        isImmuneToFire = true;

        for (int i = 0; i < 3; i++)
        {
            sinage[i] = rand.nextFloat() * 6F;
        }
    }

    public int getMaxHealth()
    {
        return 5;
    }
    
    public String getTexture()
    {
        return "/mnc/feuerball.png";
    }

    public EntityFeuerBall(World world, double d, double d1, double d2, boolean flag)
    {
        super(world);
        texture = "/mnc/feuerball.png";
        lifeSpan = 300;
        life = lifeSpan;
        setSize(0.9F, 0.9F);
        setPositionAndRotation(d, d1, d2, rotationYaw, rotationPitch);
        sinage = new float[3];
        isImmuneToFire = true;

        for (int i = 0; i < 3; i++)
        {
            sinage[i] = rand.nextFloat() * 6F;
        }

        smotionX = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        smotionY = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        smotionZ = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);

        if (flag)
        {
            frosty = true;
            texture = "/mnc/feuerball.png";;
            smotionX /= 3D;
            smotionY = 0.0D;
            smotionZ /= 3D;
        }
    }

    public EntityFeuerBall(World world, double d, double d1, double d2, boolean flag, boolean flag1)
    {
        super(world);
        texture = "/mnc/feuerball.png";;
        lifeSpan = 300;
        life = lifeSpan;
        setSize(0.9F, 0.9F);
        setPositionAndRotation(d, d1, d2, rotationYaw, rotationPitch);
        sinage = new float[3];
        isImmuneToFire = true;

        for (int i = 0; i < 3; i++)
        {
            sinage[i] = rand.nextFloat() * 6F;
        }

        smotionX = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        smotionY = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);
        smotionZ = (0.20000000000000001D + (double)rand.nextFloat() * 0.14999999999999999D) * (rand.nextInt(2) != 0 ? -1D : 1.0D);

        if (flag)
        {
            frosty = true;
            texture = "/mnc/feuerball.png";;
            smotionX /= 3D;
            smotionY = 0.0D;
            smotionZ /= 3D;
        }

        fromCloud = flag1;
    }

    /**
     * Called to update the entity's position/logic.
     *\
    public void onUpdate()
    {
        super.onUpdate();
        life--;

        if (life <= 0)
        {
            fizzle();
            isDead = true;
        }
    }

    public void fizzle()
    {
        if (frosty)
        {
            worldObj.playSoundAtEntity(this, "random.glass", 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.2F);
        }
        else
        {
            worldObj.playSoundAtEntity(this, "random.fizz", 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.2F);
        }

        for (int i = 0; i < 16; i++)
        {
            double d = posX + (double)(rand.nextFloat() - rand.nextFloat()) * 0.25D;
            double d1 = posY + (double)(rand.nextFloat() - rand.nextFloat()) * 0.25D;
            double d2 = posZ + (double)(rand.nextFloat() - rand.nextFloat()) * 0.25D;

            if (!frosty)
            {
                worldObj.spawnParticle("largesmoke", d, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }
    }

    public void splode()
    {
        if (frosty)
        {
            worldObj.playSoundAtEntity(this, "random.glass", 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.2F);
        }
        else
        {
            worldObj.playSoundAtEntity(this, "random.explode", 2.0F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.2F);
        }

        for (int i = 0; i < 40; i++)
        {
            double d = (rand.nextFloat() - 0.5F) * 0.5F;
            double d1 = (rand.nextFloat() - 0.5F) * 0.5F;
            double d2 = (rand.nextFloat() - 0.5F) * 0.5F;

            if (frosty)
            {
                d *= 0.5D;
                d1 *= 0.5D;
                d2 *= 0.5D;
                worldObj.spawnParticle("snowshovel", posX, posY, posZ, d, d1 + 0.125D, d2);
            }
            else
            {
                worldObj.spawnParticle("flame", posX, posY, posZ, d, d1, d2);
            }
        }
    }

    public void updateAnims()
    {
        if (!frosty)
        {
            for (int i = 0; i < 3; i++)
            {
                sinage[i] += 0.3F + (float)i * 0.13F;

                if (sinage[i] > ((float)Math.PI * 2F))
                {
                    sinage[i] -= ((float)Math.PI * 2F);
                }
            }
        }
    }

    public void updateEntityActionState()
    {
        motionX = smotionX;
        motionY = smotionY;
        motionZ = smotionZ;

        if (isCollided)
        {
            if (frosty && smacked)
            {
                splode();
                fizzle();
                isDead = true;
            }
            else
            {
                int i = MathHelper.floor_double(posX);
                int j = MathHelper.floor_double(boundingBox.minY);
                int k = MathHelper.floor_double(posZ);

                if (smotionX > 0.0D && worldObj.getBlockId(i + 1, j, k) != 0)
                {
                    motionX = smotionX = -smotionX;
                }
                else if (smotionX < 0.0D && worldObj.getBlockId(i - 1, j, k) != 0)
                {
                    motionX = smotionX = -smotionX;
                }

                if (smotionY > 0.0D && worldObj.getBlockId(i, j + 1, k) != 0)
                {
                    motionY = smotionY = -smotionY;
                }
                else if (smotionY < 0.0D && worldObj.getBlockId(i, j - 1, k) != 0)
                {
                    motionY = smotionY = -smotionY;
                }

                if (smotionZ > 0.0D && worldObj.getBlockId(i, j, k + 1) != 0)
                {
                    motionZ = smotionZ = -smotionZ;
                }
                else if (smotionZ < 0.0D && worldObj.getBlockId(i, j, k - 1) != 0)
                {
                    motionZ = smotionZ = -smotionZ;
                }
            }
        }

        updateAnims();
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     *\
    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
    {
        super.writeEntityToNBT(nbttagcompound);
        nbttagcompound.setShort("LifeLeft", (short)life);
        nbttagcompound.setTag("SeriousKingVampire", newDoubleNBTList(new double[]
                {
                    smotionX, smotionY, smotionZ
                }));
        nbttagcompound.setBoolean("Frosty", frosty);
        nbttagcompound.setBoolean("FromCloud", fromCloud);
        nbttagcompound.setBoolean("Smacked", smacked);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     *\
    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
    {
        super.readEntityFromNBT(nbttagcompound);
        life = nbttagcompound.getShort("LifeLeft");
        frosty = nbttagcompound.getBoolean("Frosty");
        fromCloud = nbttagcompound.getBoolean("FromCloud");

        if (frosty)
        {
            texture = "/aether/mobs/iceyball.png";
        }

        smacked = nbttagcompound.getBoolean("Smacked");
        NBTTagList nbttaglist = nbttagcompound.getTagList("SeriousKingVampire");
        smotionX = (float)((NBTTagDouble)nbttaglist.tagAt(0)).data;
        smotionY = (float)((NBTTagDouble)nbttaglist.tagAt(1)).data;
        smotionZ = (float)((NBTTagDouble)nbttaglist.tagAt(2)).data;
    }

    /**
     * Applies a velocity to each of the entities pushing them away from each other. Args: entity
     *\
    public void applyEntityCollision(Entity entity)
    {
        super.applyEntityCollision(entity);
        boolean flag = false;

        if (entity != null && (entity instanceof EntityLiving) && !(entity instanceof EntityFeuerBall))
        {
            if (frosty && (!(entity instanceof EntityDaemonLord) || smacked && !fromCloud))
            {
                flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), 5);
            }
            else if (!frosty && !(entity instanceof EntityDaemonLord))
            {
                flag = entity.attackEntityFrom(DamageSource.causeMobDamage(this), 5);

                if (flag)
                {
                    setFire(100);
                }
            }
        }

        if (flag)
        {
            splode();
            fizzle();
            isDead = true;
        }
    }

    /**
     * Called when the entity is attacked.
     *\
    public boolean attackEntityFrom(DamageSource damagesource, int i)
    {
        if (damagesource.getEntity() != null)
        {
            Vec3 vec3d = damagesource.getEntity().getLookVec();

            if (vec3d != null)
            {
                smotionX = vec3d.xCoord;
                smotionY = vec3d.yCoord;
                smotionZ = vec3d.zCoord;
            }

            smacked = true;
            return true;
        }
        else
        {
            return false;
        }
    }*/
}



