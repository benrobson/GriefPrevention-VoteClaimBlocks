package me.benrobson.GriefPreventionVoteClaimBlocks;

public class ConfigurationManager {
    private GriefPreventionVoteClaimBlocksMain plugin;
    public ConfigurationManager(GriefPreventionVoteClaimBlocksMain plugin) {
        this.plugin = plugin;
    }

    public void loadlocalConfiguration() {
        plugin.saveDefaultConfig();
        plugin.reloadConfig();
        plugin.saveConfig();
    }
}
