package me.benrobson.GriefPreventionVoteClaimBlocks;

import me.benrobson.GriefPreventionVoteClaimBlocks.events.PlayerOnVote;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GriefPreventionVoteClaimBlocksMain extends JavaPlugin {
    public static GriefPreventionVoteClaimBlocksMain plugin;
    public ConfigurationManager configurationManager;

    @Override
    public void onEnable() {
        plugin = this;
        loadConfigurationManager();

        // Init Message
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "\n\nGriefPrevention VoteClaimBlocks has been enabled.\nRunning Version " + plugin.getDescription().getVersion() + "\nGitHub Repository: https://github.com/crafting-for-christ/GriefPrevention-VoteClaimBlocks\nCreated by Ben Robson\n\n");

        // Event Registry
        PluginManager pluginmanager = this.getServer().getPluginManager();
        pluginmanager.registerEvents(new PlayerOnVote(), this);

        saveConfig();
    }

    public void loadConfigurationManager() {
        configurationManager = new ConfigurationManager(plugin);
        configurationManager.loadlocalConfiguration(); // Loading the config.yml
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "\n\nGriefPrevention VoteClaimBlocks has been disabled.\n");
        loadConfigurationManager();
    }
}
