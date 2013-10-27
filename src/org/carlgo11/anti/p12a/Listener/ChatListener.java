package org.carlgo11.anti.p12a.Listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.carlgo11.anti.p12a.antip12a;

public class ChatListener implements Listener {

    antip12a plugin;

    public ChatListener(antip12a plug)
    {
        this.plugin = plug;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
        Player player = e.getPlayer();
        if (plugin.randomText != null) {
            if (!plugin.randomText.contains(player)) {
                e.setCancelled(true);
            }
        }
    }
}
