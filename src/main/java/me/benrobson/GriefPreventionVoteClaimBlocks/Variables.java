package me.benrobson.GriefPreventionVoteClaimBlocks;

public class Variables {
    static GriefPreventionVoteClaimBlocksMain plugin;
    public Variables (GriefPreventionVoteClaimBlocksMain plugin) {
        this.plugin = plugin;
    }

    public static String pluginprefix = plugin.getConfig().getString("prefix");
    public static String claimblocks = plugin.getConfig().getString("claimblocks");
}
