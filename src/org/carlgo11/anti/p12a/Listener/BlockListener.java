package org.carlgo11.anti.p12a.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.carlgo11.anti.p12a.antip12a;

public class BlockListener implements Listener {

    antip12a plugin;

    public BlockListener(antip12a plug)
    {
        this.plugin = plug;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e)
    {
        Player player = e.getPlayer();
        if (plugin.randomText != null) {
            if (plugin.randomText.contains(player)) {
            } else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e)
    {
        Player player = e.getPlayer();
        if (plugin.randomText != null) {
            if (!plugin.randomText.contains(player)) {
                e.setCancelled(true);
            }
        }
    }
}
