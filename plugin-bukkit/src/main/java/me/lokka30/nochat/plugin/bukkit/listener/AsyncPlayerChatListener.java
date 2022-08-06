package me.lokka30.nochat.plugin.bukkit.listener;

import javax.annotation.Nonnull;
import me.lokka30.nochat.plugin.bukkit.NoChat;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncPlayerChatListener implements Listener {

    private final NoChat main;
    public AsyncPlayerChatListener(final @Nonnull NoChat main) {
        this.main = main;
    }

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onAsyncPlayerChat(final @Nonnull AsyncPlayerChatEvent event) {
        if(event.getPlayer().hasPermission("nochat.bypass")) return;

        event.setCancelled(true);

        main.getConfig().getStringList("cancellation-message").forEach(msg ->
            event.getPlayer().sendMessage(
                ChatColor.translateAlternateColorCodes('&', msg)
            )
        );
    }

}
