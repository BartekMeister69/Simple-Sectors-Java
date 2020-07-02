package com.bartekmajster.opensectors;


import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SectorInfoCommand implements CommandExecutor
{
    Sectors plugin;
    
    public SectorInfoCommand(final Sectors plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("sektorinfo").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        p.sendMessage("Open Sector Plugin by BartekMajster");
        p.sendMessage("Version: 1.0");
        p.sendMessage("API: api.sm-pack.xyz");
        p.sendMessage("Server IP: " + ConfigManager.Adres + "");
        return false;
    }
}
