package com.github.siloneco;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DisableFriendlyFire extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getLogger().info(getName() + " enabled.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info(getName() + " disabled.");
    }

    @EventHandler(priority = EventPriority.MONITOR)
    public void onDamage(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity attacker = e.getDamager();

        if ( !(ent instanceof Player) || !(attacker instanceof Player) ) {
            return;
        }

        Player p = (Player) ent;

        if ( !p.hasPermission("disablefriendlyfire.apply") ) {
            return;
        }

        e.setCancelled(true);
    }
}
