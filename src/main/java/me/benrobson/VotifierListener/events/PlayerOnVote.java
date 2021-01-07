package me.benrobson.VotifierListener.events;

import com.vexsoftware.votifier.model.VotifierEvent;
import me.benrobson.VotifierListener.Variables;
import me.benrobson.VotifierListener.VotifierListenerMain;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

import static me.benrobson.VotifierListener.Variables.*;

public class PlayerOnVote implements Listener {
    static VotifierListenerMain plugin;

    @EventHandler
    public void PlayerOnVote(VotifierEvent event) {
        String player = event.getVote().getUsername();
        Player spigotplayer = Bukkit.getPlayer(player);
        String playeruuid = spigotplayer.getUniqueId().toString();
        String playerusername = spigotplayer.getDisplayName();


//        int get = random.nextInt(plugin.configurationManager.getAnnouncements().getInt("announcement.max"));
//        String announcement = ChatColor.translateAlternateColorCodes('&', Variables.pluginprefix + " " + plugin.configurationManager.getAnnouncements().getString("announcement." + get));
//        ProxyServer.getInstance().broadcast(announcement); // Broadcast to all Servers

        plugin.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', pluginprefix + " " + ChatColor.AQUA + player + "voted, distributing awards."));

        if (spigotplayer.isOnline()) {
//            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), "adjustbonusclaimblocks " + player + " " +  claimblocks);
            spigotplayer.sendMessage(ChatColor.translateAlternateColorCodes('&', pluginprefix + " Thanks for voting! You have now received your voting rewards."));
        }

        plugin.getServer().broadcastMessage("This has been triggered.");
    }
}