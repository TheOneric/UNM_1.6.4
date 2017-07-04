package Oneric.MNC.entity.ai;

import java.util.Random;

import Oneric.MNC.entity.EntityHarpye;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;

public class EntityAIFlyFowards extends EntityAIBase{

	private EntityLiving entity;
	private Random rand;
	private double speed;
	
	private int direction;
	private int timePast;
	
	private World world;
	
	public EntityAIFlyFowards(EntityLiving entity1, double speed1, Random rand1, World world1)
	{
		this.entity = entity1;
		this.rand = rand1;
		this.speed = speed1;
		this.world = world1;
		
		direction = rand.nextInt(3);
	}
	
	@Override
	public boolean shouldExecute() {
		
		return true;
	}
	
	@Override
	public boolean continueExecuting()//returns if the ai code should continue executing
	{
		return true;
	}
	
	 /**
     * Updates the task
     */
	@Override
    public void updateTask()
	{
		//if(!this.entity.getNavigator().tryMoveToEntityLiving(new EntityHarpye(this.world), (float)speed+0.1F))
		//{
		
		entity.motionX += 0.0050000000000000001D * Math.cos(((double)entity.rotationYaw / 180D) * Math.PI) * Math.cos(((double)entity.rotationPitch / 180D) * Math.PI);
		entity.motionY += 0.0050000000000000001D * Math.sin(((double)entity.rotationPitch / 180D) * Math.PI);
		entity.motionZ += 0.0050000000000000001D * Math.sin(((double)entity.rotationYaw / 180D) * Math.PI) * Math.cos(((double)entity.rotationPitch / 180D) * Math.PI);
		entity.motionX *= 0.97999999999999998D;
		entity.motionY *= 0.97999999999999998D;
		entity.motionZ *= 0.97999999999999998D;
		
		entity.moveEntity(entity.motionX, entity.motionY, entity.motionZ);
        
			if(timePast > 150 && rand.nextInt(5) == 0)
			{
				direction = rand.nextInt(3);
				timePast = 0;
			}
			else
			{
				timePast++;
			}
			
			switch(direction)
			{
			case 0:
				//entity.setLocationAndAngles(entity.posX+speed, entity.posY, entity.posZ, 270, entity.rotationPitch);
				entity.setAngles(270, entity.rotationPitch);
				break;
				
			case 1:
				//entity.setLocationAndAngles(entity.posX-speed, entity.posY, entity.posZ, 90, entity.rotationPitch);
				entity.setAngles(90, entity.rotationPitch);
				break;
				
			case 2:
				//entity.setLocationAndAngles(entity.posX, entity.posY, entity.posZ+speed, 0, entity.rotationPitch);
				entity.setAngles(0, entity.rotationPitch);
				break;
				
			case 3:
				//entity.setLocationAndAngles(entity.posX, entity.posY, entity.posZ-speed, 180, entity.rotationPitch);
				entity.setAngles(180, entity.rotationPitch);
				break;
			}
		//}
		
		
		
		
		
		
		
	}

}
