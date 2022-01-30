package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.Particle;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SmokeOnTeleport extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        ConfigHandler yamlHandler = new ConfigHandler(this);
        double offsetX = yamlHandler.getConfigSection().getDouble("offsetX", .01);
        double offsetY = yamlHandler.getConfigSection().getDouble("offsetY", .01);
        double offsetZ = yamlHandler.getConfigSection().getDouble("offsetZ", .01);
        double speed = yamlHandler.getConfigSection().getDouble("speed", .01);
        int count = yamlHandler.getConfigSection().getInt("count", 25);
        String particleName = yamlHandler.getConfigSection().getString("particle", "SMOKE_NORMAL");
        Particle particle = Particle.valueOf(particleName);
        TeleportListener listener = new TeleportListener(
                this, particle, count,
                offsetX, offsetY, offsetZ, speed
        );
        pm.registerEvents(listener, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
