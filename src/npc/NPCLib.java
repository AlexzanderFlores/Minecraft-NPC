package npc;

import org.bukkit.plugin.java.JavaPlugin;

public class NPCLib extends JavaPlugin {
	private static NPCLib instance = null;
	
	@Override
	public void onEnable() {
		instance = this;
	}
	
	@Override
	public void onDisable() {
		NPCEntity.removeAll();
	}
	
	public static NPCLib getInstance() {
		return instance;
	}
}
