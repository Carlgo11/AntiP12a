package org.carlgo11.anti.p12a.player;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.carlgo11.anti.p12a.Main;
import org.carlgo11.anti.p12a.randomint;


public class JoinListener implements Listener {
	 Main plugin;
	    public JoinListener(Main plug) {
	            super();
	            this.plugin = plug;
	    }
	    
	    @EventHandler
	    public void onPlayerJoin(final PlayerJoinEvent e){
	    	Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Testing");
	    	final String prefix = ChatColor.GREEN + "[" + plugin.getDescription().getName() + "] ";
	    	if(!plugin.getConfig().contains(e.getPlayer().getName())){
	    		int rand = randomint.number;
	    		plugin.getConfig().set(e.getPlayer().getName(), rand);
	    		plugin.saveConfig();
	    		System.out.println("Okay! he is added the the config.yml!");
	    	}
	    	
	    	if(!plugin.getConfig().getString(e.getPlayer().getName()).equals("verified")){
	    		randomint.onInt();
	    		
	    		plugin.getConfig().set(e.getPlayer().getName(), randomint.number);
	    		System.out.println("Number: " + randomint.number);
	    		System.out.println("Config: " + plugin.getConfig().getString(e.getPlayer().getName()));
	    		plugin.saveConfig();
	    		System.out.println("Already added to the config");
	    		//plugin.getConfig().set("Carl", "hi");
	    		plugin.saveConfig();
	    	System.out.println("Random: " + randomint.number);
	    		for(final Player p : Bukkit.getOnlinePlayers()){
					 
	    			Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){

						@Override
						public void run() {
							 if(p.getName().equals(e.getPlayer().getName())){
					               p.sendMessage(prefix + ChatColor.RED + "Welcome to the server Sir! To see that you're not a bot we want you to type this command in the chat: " + ChatColor.AQUA + "/verify " + randomint.number + ". " + ChatColor.RED + "Type the number with actual numbers!");
					            }
							
						}
	    				
	    			}, 20L);
	    		}    
	    	}
	    }

}
