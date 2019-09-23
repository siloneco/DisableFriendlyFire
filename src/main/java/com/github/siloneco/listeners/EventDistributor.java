package com.github.siloneco.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.AreaEffectCloudApplyEvent;
import org.bukkit.event.entity.EntityCombustByEntityEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PotionSplashEvent;

import com.github.siloneco.DisableFriendlyFire;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EventDistributor implements Listener {

    private final DisableFriendlyFire plugin;
    private final DamageCancelListener listener;

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void entityDamageByEntityEventLowest(EntityDamageByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.LOWEST ) {
            listener.onNormalAttack(e);
            listener.onDamageByArrowOrTrident(e);
        }
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void entityDamageByEntityEventLow(EntityDamageByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.LOW ) {
            listener.onNormalAttack(e);
            listener.onDamageByArrowOrTrident(e);
        }
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void entityDamageByEntityEventNormal(EntityDamageByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.NORMAL ) {
            listener.onNormalAttack(e);
            listener.onDamageByArrowOrTrident(e);
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void entityDamageByEntityEventHigh(EntityDamageByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.HIGH ) {
            listener.onNormalAttack(e);
            listener.onDamageByArrowOrTrident(e);
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void entityDamageByEntityEventHighest(EntityDamageByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.HIGHEST ) {
            listener.onNormalAttack(e);
            listener.onDamageByArrowOrTrident(e);
        }
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void entityDamageByEntityEventMonitor(EntityDamageByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.MONITOR ) {
            listener.onNormalAttack(e);
            listener.onDamageByArrowOrTrident(e);
        }
    }

    /**
     *
     */

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void areaEffectCloudApplyEventLowest(AreaEffectCloudApplyEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.LOWEST )
            listener.onGetPotionEffectFromAreaClouds(e);
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void areaEffectCloudApplyEventLow(AreaEffectCloudApplyEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.LOW )
            listener.onGetPotionEffectFromAreaClouds(e);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void areaEffectCloudApplyEventNormal(AreaEffectCloudApplyEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.NORMAL )
            listener.onGetPotionEffectFromAreaClouds(e);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void areaEffectCloudApplyEventHigh(AreaEffectCloudApplyEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.HIGH )
            listener.onGetPotionEffectFromAreaClouds(e);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void areaEffectCloudApplyEventHighest(AreaEffectCloudApplyEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.HIGHEST )
            listener.onGetPotionEffectFromAreaClouds(e);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void areaEffectCloudApplyEventMonitor(AreaEffectCloudApplyEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.MONITOR )
            listener.onGetPotionEffectFromAreaClouds(e);
    }

    /**
     *
     */

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void potionSplashEventLowest(PotionSplashEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.LOWEST )
            listener.onNegativeEffectBySplashPotion(e);
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void potionSplashEventLow(PotionSplashEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.LOW )
            listener.onNegativeEffectBySplashPotion(e);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void potionSplashEventNormal(PotionSplashEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.NORMAL )
            listener.onNegativeEffectBySplashPotion(e);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void potionSplashEventHigh(PotionSplashEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.HIGH )
            listener.onNegativeEffectBySplashPotion(e);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void potionSplashEventHighest(PotionSplashEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.HIGHEST )
            listener.onNegativeEffectBySplashPotion(e);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void potionSplashEventMonitor(PotionSplashEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.MONITOR )
            listener.onNegativeEffectBySplashPotion(e);
    }


    /**
     *
     */

    @EventHandler
    public void EntityCombustByEntityEventLowest(EntityCombustByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.LOWEST )
            listener.onEntityCombustByEntityEvent(e);
    }

    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void EntityCombustByEntityEventLow(EntityCombustByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.LOW )
            listener.onEntityCombustByEntityEvent(e);
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
    public void EntityCombustByEntityEventNormal(EntityCombustByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.NORMAL )
            listener.onEntityCombustByEntityEvent(e);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void EntityCombustByEntityEventHigh(EntityCombustByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.HIGH )
            listener.onEntityCombustByEntityEvent(e);
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void EntityCombustByEntityEventHighest(EntityCombustByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.HIGHEST )
            listener.onEntityCombustByEntityEvent(e);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void EntityCombustByEntityEventMonitor(EntityCombustByEntityEvent e) {
        if ( plugin.getDefaultConfig().getEventPriority() == EventPriority.MONITOR )
            listener.onEntityCombustByEntityEvent(e);
    }
}
