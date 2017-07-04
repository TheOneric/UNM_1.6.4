/**package Oneric.MNC.entity.boss;

import Oneric.MNC.common.BossNameGen;
import Oneric.MNC.common.mod_netherbr;
import Oneric.MNC.entity.EnumBoss;
import Oneric.MNC.entity.IBoss;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class EntityHellStature extends EntityMob implements IBoss{

	
	private String bossName;
	
	private int maxBossHealth;
	
	public EntityHellStature(World par1World) {
		super(par1World);
		
		bossName = BossNameGen.generate();
		maxBossHealth = 1000;
		this.moveSpeed = 0.1F;
	}

	//Attack-Strenght
		@Override
	    public int getAttackStrength(Entity par1Entity) {
	    	return 8;
	    	
	    }
		
		
		
		/*
		 * Called when the mob is falling. Calculates and applies fall damage.
	     *\
		@Override
	    public void fall(float f)
	    {
	    }
		
		
		
		
		@Override
		public int getBossHP() {
			
			return this.health;
		}

		@Override
		public int getBossMaxHP() {
			
			return maxBossHealth;
		}

		@Override
		public String getBossName() {
			
			return this.bossName;
		}

		@Override
		public Enum<EnumBoss> getBossType() {
			
			return EnumBoss.MiniBoss;
		}

		@Override
		public int getBossEntityID() {
			
			return this.entityId;
		}

		@Override
		public Entity getBossEntity() {
			
			return this;
			
		}

		@Override
		public boolean isCurrentBoss() {
			
			if(worldObj.isRemote && this.equals(mod_netherbr.currentBoss))
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}

		@Override
		public int getMaxHealth() {
			
			return maxBossHealth;
		}

}*/
