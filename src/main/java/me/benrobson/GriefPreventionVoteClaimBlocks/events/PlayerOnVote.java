package me.benrobson.GriefPreventionVoteClaimBlocks.events;

import com.vexsoftware.votifier.model.VotifierEvent;
import me.benrobson.GriefPreventionVoteClaimBlocks.GriefPreventionVoteClaimBlocksMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import static me.benrobson.GriefPreventionVoteClaimBlocks.Variables.claimblocks;
import static me.benrobson.GriefPreventionVoteClaimBlocks.Variables.pluginprefix;

public class PlayerOnVote implements Listener {
    static GriefPreventionVoteClaimBlocksMain plugin;

    @EventHandler
    public void PlayerOnVote(VotifierEvent event) {
        String player = event.getVote().getUsername();
        Player spigotplayer = Bukkit.getPlayer(player);

        plugin.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pluginprefix + " " + ChatColor.AQUA + player + "voted."));

        if (spigotplayer.isOnline()) {
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "adjustbonusclaimblocks " + player + " " +  claimblocks);
            spigotplayer.sendMessage(ChatColor.translateAlternateColorCodes('&', pluginprefix + " Thanks for voting! You have now received " + ChatColor.AQUA + claimblocks + ChatColor.RESET + "."));
        }

        plugin.getServer().broadcastMessage("This has been triggered.");
    }
}