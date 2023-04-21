package net.daechler.clearchat;

import org.bukkit.plugin.java.JavaPlugin;

public class ClearChat extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the command executor
        getCommand("clearchat").setExecutor(new ClearChatCommandExecutor());

        // Plugin startup logic
        getLogger().info("ClearChat has been enabled.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("ClearChat has been disabled.");
    }
}
