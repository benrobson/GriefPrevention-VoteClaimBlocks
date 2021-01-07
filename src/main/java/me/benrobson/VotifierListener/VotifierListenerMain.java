package me.benrobson.VotifierListener;

import me.benrobson.VotifierListener.events.PlayerOnVote;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class VotifierListenerMain extends JavaPlugin {
    public static VotifierListenerMain plugin;

    @Override
    public void onEnable() {
        plugin = this;
        loadlocalConfiguration();

        // Init Message
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nVotifierListener has been enabled.\nRunning Version " + plugin.getDescription().getVersion() + "\nGitHub Repository: https://github.com/benrobson/VotifierListener\nCreated by Ben Robson\n\n");

        // Event Registry
        PluginManager pluginmanager = this.getServer().getPluginManager();
        pluginmanager.registerEvents(new PlayerOnVote(), this);

        saveConfig();
    }

    public void loadlocalConfiguration() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        plugin.saveConfig();
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nVotifierListener has been disabled.\n");
    }
}
