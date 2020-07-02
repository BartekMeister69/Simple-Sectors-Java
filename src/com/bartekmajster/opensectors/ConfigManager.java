package com.bartekmajster.opensectors;


import org.bukkit.*;

public class ConfigManager
{
    Sectors plugin;
    public String server;
    public Location center;
    public String northServer;
    public String eastServer;
    public String southServer;
    public String westServer;
    public static String Nazwa;
    public static String Adres;
    
    public ConfigManager(final Sectors plugin) {
        this.plugin = plugin;
    }
    
    public void load() {
        this.server = this.plugin.getConfig().getString("config.server.name");
        this.center = SectorUtil.StringToLocation(this.plugin.getConfig().getString("config.server.center"));
        this.northServer = this.plugin.getConfig().getString("config.servers.north");
        this.eastServer = this.plugin.getConfig().getString("config.servers.east");
        this.southServer = this.plugin.getConfig().getString("config.servers.south");
        this.westServer = this.plugin.getConfig().getString("config.servers.west");
        this.Nazwa = this.plugin.getConfig().getString("config.other.pluginname");
        this.Adres = this.plugin.getConfig().getString("config.other.serverIP");
    }
    
    public void reload() {
        this.load();
    }
}
