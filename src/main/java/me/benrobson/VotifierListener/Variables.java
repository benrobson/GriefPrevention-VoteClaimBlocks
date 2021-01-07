package me.benrobson.VotifierListener;

public class Variables {
    static VotifierListenerMain plugin;
    public Variables (VotifierListenerMain plugin) {
        this.plugin = plugin;
    }

    public static String pluginprefix = plugin.getConfig().getString("prefix");
    public static String claimblocks = plugin.getConfig().getString("claimblocks");
}
