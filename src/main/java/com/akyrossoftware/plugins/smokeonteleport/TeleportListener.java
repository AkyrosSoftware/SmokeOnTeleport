package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
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
        World world = event.getPlayer().getWorld();
        ConfigurationSection section = handler.getConfigSection("particle-effects");
        double offsetX = section.getDouble("offsetX", .01);
        double offsetY = section.getDouble("offsetY", .01);
        double offsetZ = section.getDouble("offsetZ", .01);
        double speed = section.getDouble("speed", .01);
        int count = section.getInt("count", 25);
        String particleName = section.getString("particle", "SMOKE_NORMAL").toUpperCase();
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
