package org.carlgo11.anti.p12a.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.carlgo11.anti.p12a.Main;

public class QuitListener implements Listener {
	
	Main plugin;
    public QuitListener(Main plug) {
            super();
            this.plugin = plug;
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
    // I don't know what to add here. Any ideas?
    	
    }

}
