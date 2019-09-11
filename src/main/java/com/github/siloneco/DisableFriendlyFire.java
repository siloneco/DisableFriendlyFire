package com.github.siloneco;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.siloneco.listeners.DamageCancelListener;

public class DisableFriendlyFire extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new DamageCancelListener(), this);
        Bukkit.getLogger().info(getName() + " enabled.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(getName() + " disabled.");
    }
}
