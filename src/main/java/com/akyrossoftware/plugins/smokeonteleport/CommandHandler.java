package com.akyrossoftware.plugins.smokeonteleport;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class CommandHandler implements CommandExecutor
{
    private SmokeOnTeleport plugin;
    
    public CommandHandler(SmokeOnTeleport plugin){
        this.plugin = plugin;
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
                default:{
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }
}
