package org.carlgo11.anti.p12a.player;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.carlgo11.anti.p12a.Main;
import org.carlgo11.anti.p12a.randomint;

public class MoveListener implements Listener {
	Main plugin;
    public MoveListener(Main plug) {
            super();
            this.plugin = plug;
    }
    
    @EventHandler
    public void onMove(PlayerMoveEvent e){
    	Player player = e.getPlayer();
    	if(!plugin.getConfig().getString(e.getPlayer().getName()).equals("verified")){
    		Location to = e.getFrom();
    		e.getFrom();
    		e.setTo(to);
    	} else {
    		
    	}
    }
}
