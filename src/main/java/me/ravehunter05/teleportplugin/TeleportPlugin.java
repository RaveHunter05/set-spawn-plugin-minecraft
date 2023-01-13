package me.ravehunter05.teleportplugin;

import me.ravehunter05.teleportplugin.commands.SetSpawnCommand;
import me.ravehunter05.teleportplugin.commands.SpawnCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class TeleportPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));
    }

    @Override
    public void onDisable() {
        System.out.println("My first pluggin has stopped");
    }
}
