package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportListener implements Listener {

    private SmokeOnTeleport plugin;
    private Particle particle;

    public TeleportListener(SmokeOnTeleport plugin){
        particle = Particle.SMOKE_NORMAL;
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onTeleport(PlayerTeleportEvent event){
        plugin.getLogger().info("Player: "
                + event.getPlayer().getDisplayName()
                + " teleported");
        World world = event.getPlayer().getWorld();
        world.spawnParticle(particle, event.getFrom(),
                25, 10.0, 10.0,
                10.0, 10.0);
        if(event.getTo() != null){
            world.spawnParticle(particle, event.getFrom(),
                    25, 10.0, 10.0,
                    10.0, 10.0);
        }
    }
}
