package npc.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import npc.NPCEntity;

public class NPCClickedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Player player = null;
    private NPCEntity npc = null;
    private boolean cancelled = false;
    
    public NPCClickedEvent(Player player, NPCEntity npc) {
    	this.player = player;
    	this.npc = npc;
    }
    
    public Player getPlayer() {
    	return this.player;
    }
    
    public NPCEntity getNPC() {
    	return this.npc;
    }
    
    public boolean isCancelled() {
    	return this.cancelled;
    }
    
    public void setCancelled(boolean cancelled) {
    	this.cancelled = cancelled;
    }
    
    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
 
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
