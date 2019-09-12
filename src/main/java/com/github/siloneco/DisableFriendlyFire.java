package com.github.siloneco;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.siloneco.config.DefaultConfig;
import com.github.siloneco.listeners.DamageCancelListener;
import com.github.siloneco.listeners.EventDistributor;

import lombok.Getter;

public class DisableFriendlyFire extends JavaPlugin {

    @Getter
    private DefaultConfig defaultConfig;

    @Override
    public void onEnable() {
        defaultConfig = new DefaultConfig(this);
        defaultConfig.loadConfig();

        Bukkit.getPluginManager().registerEvents(new EventDistributor(this, new DamageCancelListener()), this);

        Bukkit.getLogger().info(getName() + " enabled.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(getName() + " disabled.");
    }
}
