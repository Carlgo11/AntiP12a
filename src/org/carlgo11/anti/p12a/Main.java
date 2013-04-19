package org.carlgo11.anti.p12a;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.carlgo11.anti.p12a.player.*;

public class Main extends JavaPlugin{
	
	
	public void onEnable(){
		File config = new File(this.getDataFolder(), "config.yml");
		if(!config.exists()){
			this.saveDefaultConfig();
			System.out.println("[AntiP12a] No config.yml detected, config.yml created");
		}
		System.out.println("[" + getDescription().getName() + "] " + "is enabled");
		getServer().getPluginManager().registerEvents(new JoinListener(this), this);
		getServer().getPluginManager().registerEvents(new QuitListener(this), this);
		getServer().getPluginManager().registerEvents(new ChatListener(this), this);
		getServer().getPluginManager().registerEvents(new MoveListener(this), this);
		getServer().getPluginManager().registerEvents(new CommandListener(this), this);
		getServer().getPluginManager().registerEvents(new BlockListener(this), this);
		
	}
	
	public void onDisalbe(){
		
	}
	
	public boolean onCommand(final CommandSender sender, Command cmd, String commandLabel, String[] args){
		String prefix = ChatColor.GREEN + "[" + getDescription().getName() + "] ";
		if(cmd.getName().equalsIgnoreCase("p12a")){
			sender.sendMessage("Damn right you are! :P");
		}
		if(cmd.getName().equalsIgnoreCase("verify")){
			if(args.length == 0){
				sender.sendMessage(prefix + ChatColor.YELLOW + "Think you messed something up! Try again");
			} else {
				if(args.length == 1){
					//Verify code
					if(getConfig().getString(sender.getName()).equalsIgnoreCase(args[0])){
						getConfig().set(sender.getName(), "verified");
						saveConfig();
						sender.sendMessage(prefix + "Okay! Go ahead!");
						System.out.println("[" + getDescription().getName() + "] " + sender.getName() + " is not a p12a!");
					} else {
					sender.sendMessage(prefix + ChatColor.YELLOW + "Think you messed something up! Try again");
					}
				} else {
					sender.sendMessage(prefix + ChatColor.YELLOW + "Think you messed something up! Try again");
				}
			}
			
		}
		
		return true;
	}
	
	static public String playername = null;
}