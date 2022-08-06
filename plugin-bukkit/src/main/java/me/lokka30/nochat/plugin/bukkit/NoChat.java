package me.lokka30.nochat.plugin.bukkit;

import me.lokka30.nochat.plugin.bukkit.listener.AsyncPlayerChatListener;
import org.bukkit.plugin.java.JavaPlugin;

public class NoChat extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager()
            .registerEvents(new AsyncPlayerChatListener(this), this);
    }

}
