package net.daechler.clearchat;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class ClearChat extends JavaPlugin {

    // Called when the plugin is enabled
    @Override
    public void onEnable() {
        // Register the command executor for the /clearchat command
        this.getCommand("clearchat").setExecutor(new ClearChatCommandExecutor());

        // Send the enabled message
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + getName() + " has been enabled!");
    }

    // Called when the plugin is disabled
    @Override
    public void onDisable() {
        // Send the disabled message
        getServer().getConsoleSender().sendMessage(ChatColor.RED + getName() + " has been disabled!");
    }

    // This class will handle the /clearchat command
    private class ClearChatCommandExecutor implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            // Only clear the chat if the sender is a player (not a console or command block)
            if (sender instanceof Player) {
                // Clear chat for all players on the server
                for (Player player : getServer().getOnlinePlayers()) {
                    for(int i = 0; i < 1000; i++) {
                        player.sendMessage(" ");
                    }
                    // Send a red message stating the chat has been cleared
                    player.sendMessage(ChatColor.RED + "The chat has been cleared!");
                }
            }
            return true;
        }
    }

}
