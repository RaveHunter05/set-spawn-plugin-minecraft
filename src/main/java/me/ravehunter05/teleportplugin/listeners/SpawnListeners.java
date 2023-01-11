package me.ravehunter05.teleportplugin.listeners;

import me.ravehunter05.teleportplugin.TeleportPlugin;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {
    private final TeleportPlugin plugin;

    public SpawnListeners(TeleportPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if(!e.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");
            if(location != null){
                player.teleport(location);
                player.sendMessage("Has sido teletransportado al mas allá :000");
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e){
       Location location = plugin.getConfig().getLocation("spawn");

       if(location != null){
           e.setRespawnLocation(location);
       }
    }
}
