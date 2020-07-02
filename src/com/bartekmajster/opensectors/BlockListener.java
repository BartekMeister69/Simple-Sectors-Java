package com.bartekmajster.opensectors;

import org.bukkit.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.block.*;

public class BlockListener implements Listener
{
    Sectors plugin;
    Location center;
    
    public BlockListener(final Sectors plugin) {
        this.plugin = plugin;
        this.center = this.plugin.config.center;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onBreak(final BlockBreakEvent event) {
        if (!this.canBuild(event.getBlock().getLocation())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("§cNie mozesz niszczyc blokow na granicy sektora.");
        }
    }
    
    @EventHandler
    public void onPlace(final BlockPlaceEvent event) {
        if (!this.canBuild(event.getBlock().getLocation())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("§cNie mozesz budowac na granicy sektora.");
        }
    }
    
    public int distX(final Location loc) {
        return (int)Math.sqrt(Math.pow(loc.getX() - this.center.getX(), 2.0));
    }
    
    public int distZ(final Location loc) {
        return (int)Math.sqrt(Math.pow(loc.getZ() - this.center.getZ(), 2.0));
    }
    
    public boolean canBuild(final Location ploc) {
        final int distX = this.distX(ploc);
        final int distZ = this.distZ(ploc);
        return distX <= 480 && distZ <= 480;
    }
}
