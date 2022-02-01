package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SmokeOnTeleport extends JavaPlugin {
    
    private ConfigHandler configHandler;
    private CommandHandler commandHandler;

    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        reloadConfig();
        
        commandHandler = new CommandHandler(this);
        this.getCommand("smoketp").setExecutor(commandHandler);
        this.getCommand("smoketp").setTabCompleter(commandHandler);
        
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
    
    @Override
    public FileConfiguration getConfig(){
        return configHandler.getConfig();
    }
}
