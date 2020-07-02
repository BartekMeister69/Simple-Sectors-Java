package com.bartekmajster.opensectors;


import org.bukkit.command.*;
import org.bukkit.entity.*;

public class SectorCommand implements CommandExecutor
{
    Sectors plugin;
    
    public SectorCommand(final Sectors plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("sektor").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        p.sendMessage("Wkrotce!");
        return false;
    }
}
