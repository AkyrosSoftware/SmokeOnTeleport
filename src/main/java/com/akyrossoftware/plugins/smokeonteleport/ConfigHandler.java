package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;


public class ConfigHandler {

    private FileConfiguration yamlFile;
    private SmokeOnTeleport plugin;

    public ConfigHandler(SmokeOnTeleport plugin){
        this.plugin = plugin;
        yamlFile = plugin.getConfig();
    }

    public ConfigurationSection getConfigSection(){
        return yamlFile.getConfigurationSection("particle-effects");
    }
}
