package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigHandler {

    private YamlConfiguration yamlFile;
    private SmokeOnTeleport plugin;

    public ConfigHandler(SmokeOnTeleport plugin){
        this.plugin = plugin;
        yamlFile = new YamlConfiguration();
        try{
            yamlFile.load(plugin.getConfig().getCurrentPath());
        }
        catch(Exception ex){
            plugin.getLogger().config(ex.getMessage());
        }
    }

    public ConfigurationSection getConfigSection(){
        return yamlFile.getConfigurationSection("particle-effects");
    }
}
