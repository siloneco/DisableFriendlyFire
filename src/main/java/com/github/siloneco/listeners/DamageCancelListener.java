package com.github.siloneco.listeners;

import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ThrownPotion;
import org.bukkit.entity.Trident;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.siloneco.config.DefaultConfig;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DamageCancelListener {

    private final DefaultConfig config;

    public void onNormalAttack(EntityDamageByEntityEvent e) {
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

    public void onDamageByArrowOrTrident(EntityDamageByEntityEvent e) {
        Entity ent = e.getEntity();
        Entity attacker = e.getDamager();

        if ( !(ent instanceof Player) ) {
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

    public void onNegativeEffectBySplashPotion(PotionSplashEvent e) {

        ThrownPotion pot = e.getPotion();
        if ( !(pot.getShooter() instanceof Player) ) {
            return;
        }
        Player shooter = (Player) pot.getShooter();

        boolean includeNegativePotionEffect = false;
        for ( PotionEffect eff : e.getPotion().getEffects() ) {
            if ( isNegativePotionEffect(eff.getType()) ) {
                includeNegativePotionEffect = true;
                break;
            }
        }
        if ( !includeNegativePotionEffect ) {
            return;
        }

        for ( LivingEntity ent : e.getAffectedEntities() ) {
            if ( !(ent instanceof Player) ) {
                continue;
            }

            Player p = (Player) ent;

            if ( p == shooter ) {
                continue;
            }
            if ( !p.hasPermission("disablefriendlyfire.apply") ) {
                continue;
            }

            e.setIntensity(ent, 0);
        }
    }

    public void onGetPotionEffectFromAreaClouds(AreaEffectCloudApplyEvent e) {
        AreaEffectCloud potion = e.getEntity();
        if ( !(potion.getSource() instanceof Player) ) {
            return;
        }

        Player shooter = (Player) potion.getSource();

        boolean includeNegativePotionEffect = false;

        if ( isNegativePotionEffect(potion.getBasePotionData().getType().getEffectType()) ) {
            includeNegativePotionEffect = true;
        }
        if ( !includeNegativePotionEffect ) {
            for ( PotionEffect eff : potion.getCustomEffects() ) {
                if ( isNegativePotionEffect(eff.getType()) ) {
                    includeNegativePotionEffect = true;
                    break;
                }
            }
        }
        if ( !includeNegativePotionEffect ) {
            return;
        }

        for ( LivingEntity entity : e.getAffectedEntities() ) {
            if ( !(entity instanceof Player) ) {
                continue;
            }

            Player p = (Player) entity;

            if ( p == shooter ) {
                continue;
            }
            if ( !p.hasPermission("disablefriendlyfire.apply") ) {
                continue;
            }

            e.setCancelled(true);
        }
    }

    private boolean isNegativePotionEffect(PotionEffectType type) {
        return config.getNegativePotionEffectTypes().contains(type);
    }
}
