package com.bartekmajster.opensectors;


import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import com.connorlinfoot.actionbarapi.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.*;
import java.io.*;

public class MoveListener implements Listener
{
    Sectors plugin;
    Location center;
    
    public MoveListener(final Sectors plugin) {
        this.plugin = plugin;
        this.center = this.plugin.config.center;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent event) {
        final Location from = event.getFrom();
        final Location to = event.getTo();
        if (from.getBlockX() != to.getBlockX() || from.getBlockY() != to.getBlockY() || from.getBlockZ() != to.getBlockZ()) {
            final Location ploc = event.getPlayer().getLocation();
            final int distX = this.distX(ploc);
            final int distZ = this.distZ(ploc);
            final Player p = event.getPlayer();
            if (distX > 500 || distZ > 500) {
                String server = "";
                if (distX >= distZ) {
                    final int xC = ploc.getBlockX() - this.plugin.config.center.getBlockX();
                    if (xC > 0) {
                        server = this.plugin.config.northServer;
                    }
                    else if (xC < 0) {
                        server = this.plugin.config.southServer;
                    }
                }
                else if (distZ > distX) {
                    final int zC = ploc.getBlockZ() - this.plugin.config.center.getBlockZ();
                    if (zC > 0) {
                        server = this.plugin.config.eastServer;
                    }
                    else if (zC < 0) {
                        server = this.plugin.config.westServer;
                    }
                }
                if (server.equalsIgnoreCase("border")) {
                    ActionBarAPI.sendActionBar(p, "§9## §cOsiagnales limit swiata! ##");
                    p.sendMessage("## §cOsiagnales limit swiata! ##");
                    ActionBarAPI.sendActionBar(p, "");
                    p.teleport(from);
                    return;
                }
                this.teleportServer(p, server);
            }
            else if (distX >= 469 || distZ >= 469) {
                int distance = 0;
                if (distX >= distZ) {
                    distance = 500 - distX;
                }
                else if (distZ > distX) {
                    distance = 500 - distZ;
                }
                if (distX == 469 || distZ == 469) {
                    ActionBarAPI.sendActionBar(p, "§c");
                    return;
                }
                if (distance >= 30) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:§8:::::::::::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 29) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::§8::::::::::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 28) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::§8:::::::::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 27) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::§8::::::::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 26) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::§8:::::::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 25) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::§8::::::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 24) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::§8:::::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 23) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::§8::::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 22) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::§8:::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 21) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::§8::::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 20) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::§8:::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 19) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::§8::::::::::::::::::§f}");
                    return;
                }
                if (distance >= 18) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::::§8:::::::::::::::::§f}");
                    return;
                }
                if (distance >= 17) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::::§8::::::::::::::::§f}");
                    return;
                }
                if (distance >= 16) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::::::§8:::::::::::::::§f}");
                    return;
                }
                if (distance >= 15) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::::::§8::::::::::::::§f}");
                    return;
                }
                if (distance >= 14) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::::::::§8:::::::::::::§f}");
                    return;
                }
                if (distance >= 13) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::::::::§8::::::::::::§f}");
                    return;
                }
                if (distance >= 12) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::::::::::§8:::::::::::§f}");
                    return;
                }
                if (distance >= 11) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::::::::::§8::::::::::§f}");
                    return;
                }
                if (distance >= 10) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::::::::::::§8:::::::::§f}");
                    return;
                }
                if (distance >= 9) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::::::::::::§8::::::::§f}");
                    return;
                }
                if (distance >= 8) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::::::::::::::§8:::::::§f}");
                    return;
                }
                if (distance >= 7) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::::::::::::::§8::::::§f}");
                    return;
                }
                if (distance >= 6) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::::::::::::::::§8:::::§f}");
                    return;
                }
                if (distance >= 5) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::::::::::::::::§8::::§f}");
                    return;
                }
                if (distance >= 4) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::::::::::::::::::§8:::§f}");
                    return;
                }
                if (distance >= 3) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::::::::::::::::::§8::§f}");
                    return;
                }
                if (distance >= 2) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c:::::::::::::::::::::::::::::§8:§f}");
                    return;
                }
                if (distance > 1) {
                    ActionBarAPI.sendActionBar(p, "§c§lGranica sektora! §a§n" + distance + "§f §f{§c::::::::::::::::::::::::::::::§f}");
                    return;
                }
                if (distance > 0) {
                    ActionBarAPI.sendActionBar(p, "§c§lPrzekierowywanie na sektor: §9§l§nGLOBAL");
                }
            }
        }
    }
    
    public void teleportServer(final Player p, final String server) {
        Bukkit.getMessenger().registerOutgoingPluginChannel((Plugin)this.plugin, "BungeeCord");
        final ByteArrayOutputStream b = new ByteArrayOutputStream();
        final DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        }
        catch (IOException ex) {}
        p.sendPluginMessage((Plugin)this.plugin, "BungeeCord", b.toByteArray());
    }
    
    public int distX(final Location loc) {
        return (int)Math.sqrt(Math.pow(loc.getX() - this.center.getX(), 2.0));
    }
    
    public int distZ(final Location loc) {
        return (int)Math.sqrt(Math.pow(loc.getZ() - this.center.getZ(), 2.0));
    }
}
