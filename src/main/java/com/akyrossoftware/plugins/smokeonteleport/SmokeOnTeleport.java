package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SmokeOnTeleport extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new TeleportListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
