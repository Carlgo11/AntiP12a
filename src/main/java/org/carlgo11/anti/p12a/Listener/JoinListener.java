package org.carlgo11.anti.p12a.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.carlgo11.anti.p12a.RandomString;
import org.carlgo11.anti.p12a.antip12a;

import java.util.ArrayList;

/**
 * Bukkit Plugin
 * Plugin Name: antip12a
 * Author: tryy3
 * Date: 2013-10-26
 * Time: 13:27
 */
public class JoinListener implements Listener {
    antip12a plugin;

    public JoinListener (antip12a plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        if ((!plugin.randomText.contains(p)) || (!p.hasPermission("AntiP12a.ignoreplayer")))
        {
            RandomString.getDifficulty();
            String rand = RandomString.string;

            plugin.randomText.add(p + " " + rand);
            plugin.save();

            p.sendMessage(plugin.pre + ChatColor.RED +
                    "Welcome to the server Sir! To see that you know how to play on a server we want you to type this command in the chat: " +
                    ChatColor.AQUA + "/verify " + rand + ".");
        }

    }
}
