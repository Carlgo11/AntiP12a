package org.carlgo11.anti.p12a.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.carlgo11.anti.p12a.antip12a;

/**
 * Bukkit Plugin
 * Plugin Name: antip12a
 * Author: tryy3
 * Date: 2013-10-26
 * Time: 13:26
 */
public class BlockListener implements Listener
{
    antip12a plugin;

    public BlockListener(antip12a plug)
    {
        this.plugin = plug;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (!plugin.randomText.contains(player))
        {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        Player player = e.getPlayer();
        if (!plugin.randomText.contains(player))
        {
            e.setCancelled(true);
        }
    }
}
