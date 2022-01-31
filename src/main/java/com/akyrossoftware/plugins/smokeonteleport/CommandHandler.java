package com.akyrossoftware.plugins.smokeonteleport;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;


public class CommandHandler implements CommandExecutor, TabCompleter
{
    private SmokeOnTeleport plugin;
    private List<String> commands;
    private List<String> particles;
    
    public CommandHandler(SmokeOnTeleport plugin){
        this.plugin = plugin;
        commands = new ArrayList<>();
        commands.add("reload");
        commands.add("particle");
        particles = new ArrayList<>();
        Particle[] enumList = Particle.values();
        for (Particle particle : enumList)
        {
            particles.add(particle.toString().toUpperCase());
        }
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings)
    {
        //check for args
        if(strings.length > 0){
            //check first arg only
            String arg = strings[0];
            //check arg with current available commands
            switch(arg.toLowerCase()){
                case "reload":{
                    plugin.reloadConfig();
                    return true;
                }
                case "particle":{
                    if(strings.length >= 2){
                        String nextArg = strings[1].toUpperCase();
                        if(particles.contains(nextArg)){
                            plugin.getConfig().getConfigurationSection("particle-effects").set("particle", nextArg);
                            plugin.saveConfig();
                            plugin.reloadConfig();
                            return true;
                        }
                        else{
                            return false;
                        }
                    }
                    else{
                        return false;
                    }
                }
                default:{
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender cs, Command cmnd, String string, String[] strings)
    {
        if(strings.length == 0){
            return commands;
        }
        else if(strings[0].equals("particle")){
            return particles;
        }
        else{
            return null;
        }
    }
}
