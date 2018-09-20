package npc.entities;

import java.lang.reflect.Field;

import org.bukkit.craftbukkit.v1_8_R3.util.UnsafeList;
import org.bukkit.entity.LivingEntity;

import net.minecraft.server.v1_8_R3.EntityBlaze;
import net.minecraft.server.v1_8_R3.PathfinderGoalSelector;
import net.minecraft.server.v1_8_R3.World;
import npc.NPCEntity;
import npc.ReflectionUtil;

public class BlazeNPC extends EntityBlaze {
    public BlazeNPC(World world) {
        super(world);
        try {
            for (String fieldName : new String[]{"b", "c"}) {
                Field field = ReflectionUtil.getDeclaredField(PathfinderGoalSelector.class, fieldName);
                field.setAccessible(true);
                field.set(goalSelector, new UnsafeList<PathfinderGoalSelector>());
                field.set(targetSelector, new UnsafeList<PathfinderGoalSelector>());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void g(double x, double y, double z) {
        LivingEntity livingEntity = (LivingEntity) getBukkitEntity();
        NPCEntity npc = NPCEntity.getNPC(livingEntity);
        if (getBukkitEntity().getTicksLived() <= NPCEntity.ableToMove && npc.getSpawnZombie()) {
        	npc.updateHologram();
            super.g(x, y, z);
        }
    }

    @Override
    public void move(double x, double y, double z) {
        LivingEntity livingEntity = (LivingEntity) getBukkitEntity();
        NPCEntity npc = NPCEntity.getNPC(livingEntity);
        if (getBukkitEntity().getTicksLived() <= NPCEntity.ableToMove && npc.getSpawnZombie()) {
        	npc.updateHologram();
            super.move(x, y, z);
        }
    }
}
