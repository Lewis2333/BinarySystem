package com.github.lewis2333;

import com.github.lewis2333.Command.Cmd;
import com.github.lewis2333.PlayerEvent.EventController;
import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import static com.github.lewis2333.Utils.ConfigManner.loadConfig;
import static com.github.lewis2333.Utils.ConfigManner.testConfig;

/**
 * @author Lewis
 */
public final class Main extends JavaPlugin {

    public static JavaPlugin plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        Bukkit.getPluginCommand("BinarySystem").setExecutor(new Cmd());
        Bukkit.getPluginManager().registerEvents(new EventController(),this);
        saveResource("Settings.yml",false);
        saveResource("Message.yml",false);
        testConfig();
        loadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
