package org.carlgo11.anti.p12a.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.carlgo11.anti.p12a.Main;
import org.carlgo11.anti.p12a.randomint;

public class ChatListener implements Listener {
	
	 Main plugin;
	    public ChatListener(Main plug) {
	            super();
	            this.plugin = plug;
	    }
	    
	    @EventHandler
	    public void onChat(AsyncPlayerChatEvent e){
	    	String in = e.getMessage();
	    	String prefix = ChatColor.GREEN + "[" + plugin.getDescription().getName() + "] ";
	    	Player player = e.getPlayer();
	    	if(!plugin.getConfig().getString(player.getName()).equals("verified")){
	    		e.setCancelled(true);
	    		player.sendMessage(prefix + ChatColor.RED + "To see that you're not a bot we want you to type this command in the chat: " + ChatColor.AQUA + "/verify " + randomint.number + ". " + ChatColor.RED + "Type the number with actual numbers!");
	    	}
	    }

}
