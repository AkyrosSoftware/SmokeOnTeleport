package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.Particle;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SmokeOnTeleport extends JavaPlugin {
    
    private ConfigHandler configHandler;

    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        reloadConfig();
        double offsetX = configHandler.getConfigSection().getDouble("offsetX", .01);
        double offsetY = configHandler.getConfigSection().getDouble("offsetY", .01);
        double offsetZ = configHandler.getConfigSection().getDouble("offsetZ", .01);
        double speed = configHandler.getConfigSection().getDouble("speed", .01);
        int count = configHandler.getConfigSection().getInt("count", 25);
        String particleName = configHandler.getConfigSection().getString("particle", "SMOKE_NORMAL");
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
    
    @Override
    public void reloadConfig(){
        if(configHandler == null){
            configHandler = new ConfigHandler(this);
        }
        configHandler.loadConfig();
    }
}
