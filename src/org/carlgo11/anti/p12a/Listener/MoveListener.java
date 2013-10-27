package org.carlgo11.anti.p12a.Listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.carlgo11.anti.p12a.antip12a;

public class MoveListener implements Listener {

    antip12a plugin;

    public MoveListener(antip12a plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e)
    {
        Player p = e.getPlayer();

        if (plugin.randomText != null) {
            if (!plugin.randomText.contains(p)) {
                e.setCancelled(true);
            }
        }
    }
}
