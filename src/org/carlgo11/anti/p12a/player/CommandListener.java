package org.carlgo11.anti.p12a.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.carlgo11.anti.p12a.Main;

public class CommandListener implements Listener {
	
	Main plugin;
    public CommandListener(Main plug) {
            super();
            this.plugin = plug;
    }
    
    @EventHandler
    public void onCMD(PlayerCommandPreprocessEvent e){
    	String prefix = ChatColor.GREEN + "[" + plugin.getDescription().getName() + "] ";
    	Player player = e.getPlayer();
    	
    	if(!plugin.getConfig().getString(player.getName()).equals("verified")){
    		if(!e.getMessage().contains("verify")){
    		e.setCancelled(true);
    		player.sendMessage(prefix + ChatColor.RED + "To see that you're not a bot we want you to type this command in the chat: " + ChatColor.AQUA + "/verify " + plugin.getConfig().getInt(player.getName()) + ". " + ChatColor.RED + "\n ");
    		}
    	} else {
    		
    	}
    	
    }

}
