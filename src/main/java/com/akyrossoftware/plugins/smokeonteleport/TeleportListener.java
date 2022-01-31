package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TeleportListener implements Listener {

    private SmokeOnTeleport plugin;
    private ConfigHandler handler;

    public TeleportListener(SmokeOnTeleport plugin, ConfigHandler handler){
        this.plugin = plugin;
        this.handler = handler;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onTeleport(PlayerTeleportEvent event){
        plugin.getLogger().info("Player: "
                + event.getPlayer().getDisplayName()
                + " teleported");
        World world = event.getPlayer().getWorld();
        double offsetX = handler.getConfigSection().getDouble("offsetX", .01);
        double offsetY = handler.getConfigSection().getDouble("offsetY", .01);
        double offsetZ = handler.getConfigSection().getDouble("offsetZ", .01);
        double speed = handler.getConfigSection().getDouble("speed", .01);
        int count = handler.getConfigSection().getInt("count", 25);
        String particleName = handler.getConfigSection().getString("particle", "SMOKE_NORMAL").toUpperCase();
        Particle particle = Particle.valueOf(particleName);
        world.spawnParticle(particle, event.getFrom(),
                count, offsetX, offsetY,
                offsetZ, speed);
        if(event.getTo() != null){
            world.spawnParticle(particle, event.getTo(),
                    count, offsetX, offsetY,
                    offsetZ, speed);
        }
    }
}
