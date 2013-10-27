package org.carlgo11.anti.p12a.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.carlgo11.anti.p12a.antip12a;

/**
 * Bukkit Plugin
 * Plugin Name: antip12a
 * Author: tryy3
 * Date: 2013-10-26
 * Time: 13:27
 */
public class MoveListener implements Listener
{
    antip12a plugin;

    public MoveListener (antip12a plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();


        if (!plugin.randomText.contains(p))
        {
            e.setCancelled(true);
        }
    }
}
