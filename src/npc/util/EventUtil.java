package npc.util;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import npc.NPCLib;

public class EventUtil {
	public static void register(Listener listener) {
		Bukkit.getPluginManager().registerEvents(listener, NPCLib.getInstance());
	}
}
