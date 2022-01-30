package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.Effect;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportListener implements Listener {

    private SmokeOnTeleport plugin;

    public TeleportListener(SmokeOnTeleport plugin){
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onTeleport(PlayerTeleportEvent event){
        plugin.getLogger().info("Player: "
                + event.getPlayer().getDisplayName()
                + " teleported");
        World world = event.getPlayer().getWorld();
        world.playEffect(event.getFrom(), Effect.SMOKE, 0, 5);
        if(event.getTo() != null){
            world.playEffect(event.getTo(), Effect.SMOKE, 0, 5);
        }
    }
}
