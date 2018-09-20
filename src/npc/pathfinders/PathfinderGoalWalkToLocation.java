package npc.pathfinders;

import org.bukkit.Location;

import net.minecraft.server.v1_8_R3.EntityInsentient;
import net.minecraft.server.v1_8_R3.PathfinderGoal;

public class PathfinderGoalWalkToLocation extends PathfinderGoal {
	private EntityInsentient entityInsentient;
	private float speed;
	private Location location;
	
	public PathfinderGoalWalkToLocation(EntityInsentient entityInsentient, float speed, Location location) {
		this.entityInsentient = entityInsentient;
		this.speed = speed;
		this.location = location;
	}
	
	private Location getLocation() {
		return location;
	}
	
	@Override
	public boolean a() {
		c();
		return true;
	}
	
	@Override
	public void c() {
		int x = getLocation().getBlockX();
		int y = getLocation().getBlockY();
		int z = getLocation().getBlockZ();
		this.entityInsentient.world.getWorld().loadChunk(x, z);
		this.entityInsentient.getNavigation().a(x, y, z, speed);
	}
}
