package com.github.siloneco.listeners;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageCancelListener implements Listener {

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

    @EventHandler(priority = EventPriority.MONITOR)
    public void onDamageByArrowOr(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity attacker = e.getDamager();

        if ( !(ent instanceof Player) ) {
            return;
        }

        if ( !(attacker instanceof Trident) && !(attacker instanceof Arrow) ) {
            return;
        }

        if ( attacker instanceof Arrow ) {

            Arrow arrow = (Arrow) attacker;

            if ( !(arrow.getShooter() instanceof Player) ) {
                return;
            }
        } else if ( attacker instanceof Trident ) {
            Trident trident = (Trident) attacker;

            if ( !(trident.getShooter() instanceof Player) ) {
                return;
            }
        } else {
            return;
        }

        Player p = (Player) ent;
        if ( !p.hasPermission("disablefriendlyfire.apply") ) {
            return;
        }

        e.setCancelled(true);
    }
}
