package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SmokeOnTeleport extends JavaPlugin {
    
    private ConfigHandler configHandler;

    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        reloadConfig();
        
        this.getCommand("smoketp").setExecutor(new CommandHandler(this));
        
        TeleportListener listener = new TeleportListener(
                this, configHandler
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
