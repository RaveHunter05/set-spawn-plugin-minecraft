package me.ravehunter05.teleportplugin.commands;

import me.ravehunter05.teleportplugin.TeleportPlugin;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    private final TeleportPlugin plugin;

    public SpawnCommand(TeleportPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            Location location = plugin.getConfig().getLocation("spawn");
            plugin.getConfig().getLocation("spawn");

            if(location != null){
                player.teleport(location);
                player.sendMessage("Has sido transportado al spawn.");
            }
            else {
                player.sendMessage("No hay spawn establecido. Usa /setspawn para establecer uno.");
            }
        }

        return true;
    }
}
