package Oneric.MNC.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class MNCAchievementPage extends AchievementPage{

	public MNCAchievementPage(String name, Achievement[] achievements) {
		super(name, achievements);
		
	}
	
	
	/*
	public int bgGetSprite(Random random, int i, int j)
    {
        int k = Block.sand.blockIndexInTexture;
        int l = random.nextInt(1 + j) + j / 2;

        if (l > 37 || j == 35)
        {
            k = MNCBlocks.NetherGold.blockIndexInTexture;
        }
        else if (l == 22)
        {
            k = /*random.nextInt(2) == 0 ? *\Block.glowStone.blockIndexInTexture/* : BlockHolystone.sprMossy*\;
        }
        else if (l == 10)
        {
            k = Block.lavaStill.blockIndexInTexture;
        }
        else if (l == 8)
        {
            k = MNCBlocks.Netherplanks.blockIndexInTexture;
        }
        else if (l > 4)
        {
            k = Block.netherrack.blockIndexInTexture;
        }
        else if (l > 0)
        {
            k = Block.slowSand.blockIndexInTexture;
        }

        return k;
    }
    */

}
