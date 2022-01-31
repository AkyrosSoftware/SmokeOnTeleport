package com.akyrossoftware.plugins.smokeonteleport;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;


public class ConfigHandler {

    private YamlConfiguration yamlFile;
    private SmokeOnTeleport plugin;

    public ConfigHandler(SmokeOnTeleport plugin){
        this.plugin = plugin;
        yamlFile = new YamlConfiguration();
    }
    
    public void loadConfig(){
        File folder = createDataFolder();
        File config = new File(folder, "config.yml");
        if (!config.exists()) {
            plugin.getLogger().info("No config-file found. Creating default...");
            plugin.saveDefaultConfig();
        }
        try
        {
            yamlFile.load(config);
        }
        catch (IOException | InvalidConfigurationException ex)
        {
            throw new IllegalStateException("Failed to load config-file", ex);
        }
    }

    public ConfigurationSection getConfigSection(){
        return yamlFile.getConfigurationSection("particle-effects");
    }
    
    private File createDataFolder() {
        File folder = plugin.getDataFolder();
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                throw new IllegalStateException("Failed to create data folder");
            }
        }
        return folder;
    }
}
