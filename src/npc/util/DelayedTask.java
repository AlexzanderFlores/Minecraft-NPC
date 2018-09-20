package npc.util;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import npc.NPCLib;

public class DelayedTask implements Listener {
	public DelayedTask(Runnable runnable) {
		this(runnable, 1);
	}
	
	public DelayedTask(Runnable runnable, long delay) {
		NPCLib instance = NPCLib.getInstance();
		if(instance.isEnabled()) {
			Bukkit.getScheduler().scheduleSyncDelayedTask(instance, runnable, delay);
		} else {
			runnable.run();
		}
	}
}
