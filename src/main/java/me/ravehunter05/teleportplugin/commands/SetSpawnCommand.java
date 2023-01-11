package me.ravehunter05.teleportplugin.commands;

import me.ravehunter05.teleportplugin.TeleportPlugin;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionDefault;

import java.util.logging.Logger;

public class SetSpawnCommand implements CommandExecutor {

    private final TeleportPlugin plugin;

    public SetSpawnCommand(TeleportPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Logger log = Bukkit.getLogger();

        if (sender instanceof Player) {
            Player player = (Player) sender;

            Location location = player.getLocation();

            if (player.hasPermission(String.valueOf(PermissionDefault.OP))) {
                plugin.getConfig().set("spawn", location);

                plugin.saveConfig();

                log.info("Spawn establecido.");
            } else {
                player.sendMessage("No sos admin, anda, anda pa sha bobo");
            }


        } else {
            log.info("Bruh wth you're doing outside the server");
        }
        return true;
    }
}
