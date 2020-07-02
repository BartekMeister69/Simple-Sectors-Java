package com.bartekmajster.opensectors;

import org.bukkit.plugin.java.*;
import org.bukkit.plugin.*;

/*
 * Siemano Tutaj BartekMajster
 * Hello there BartekMajster
 * Halo!
 */
public class Sectors extends JavaPlugin
{
    BlockListener blockListener;
    MoveListener moveListener;
    SectorCommand sector;
    SectorInfoCommand info;
    public ConfigManager config;
    
    public void onEnable() {
        System.out.println("[" + ConfigManager.Nazwa + "]" + " Loading Sectors...");
        this.saveDefaultConfig();
        System.out.println("[" + ConfigManager.Nazwa + "]" + " Loaded Config and Language");
        (this.config = new ConfigManager(this)).reload();
        this.blockListener = new BlockListener(this);
        this.moveListener = new MoveListener(this);
        this.sector = new SectorCommand(this);
        this.info = new SectorInfoCommand(this);
        this.getServer().getMessenger().registerOutgoingPluginChannel((Plugin)this, "BungeeCord");
        System.out.println("[" + ConfigManager.Nazwa + "]" + " Bungee Verify Sucess");
    }
}
