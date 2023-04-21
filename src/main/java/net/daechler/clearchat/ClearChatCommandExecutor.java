package net.daechler.clearchat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("clearchat")) {
            if (!(sender instanceof Player)) {
                // If the sender is not a player, display an error message and return false
                sender.sendMessage("This command can only be used by players.");
                return false;
            }

            Player player = (Player) sender;

            // Clear the chat for all players on the server
            for (int i = 0; i < 100; i++) {
                player.sendMessage("");
            }

            // Send a message to the player confirming that the chat has been cleared
            player.sendMessage("Chat has been cleared.");

            return true;
        }

        return false;
    }
}
