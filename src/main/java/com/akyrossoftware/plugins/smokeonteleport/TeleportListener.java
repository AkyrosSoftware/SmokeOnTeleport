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
    private double offsetX;
    private double offsetY;
    private double offsetZ;
    private double speed;
    private int count;

    public TeleportListener(SmokeOnTeleport plugin, Particle particle,
                            int count, double offsetX, double offsetY,
                            double offsetZ, double speed){
        this.particle = particle;
        this.plugin = plugin;
        this.count = count;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.speed = speed;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onTeleport(PlayerTeleportEvent event){
        plugin.getLogger().info("Player: "
                + event.getPlayer().getDisplayName()
                + " teleported");
        World world = event.getPlayer().getWorld();
        world.spawnParticle(particle, event.getFrom(),
                count, offsetX, offsetY,
                offsetZ, speed);
        if(event.getTo() != null){
            world.spawnParticle(particle, event.getTo(),
                    count, offsetX, offsetY,
                    offsetZ, count);
        }
    }
}
