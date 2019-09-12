package com.github.siloneco.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.bukkit.event.EventPriority;
import org.bukkit.potion.PotionEffectType;

import com.github.siloneco.DisableFriendlyFire;

import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;

@Getter
public class DefaultConfig extends Config {

    @Getter
    private EventPriority eventPriority = EventPriority.MONITOR;
    @Getter
    private List<PotionEffectType> negativePotionEffectTypes = new ArrayList<PotionEffectType>(Arrays.asList(
            PotionEffectType.BLINDNESS,
            PotionEffectType.CONFUSION,
            PotionEffectType.GLOWING,
            PotionEffectType.HARM,
            PotionEffectType.HUNGER,
            PotionEffectType.LEVITATION,
            PotionEffectType.POISON,
            PotionEffectType.SLOW,
            PotionEffectType.SLOW_DIGGING,
            PotionEffectType.UNLUCK,
            PotionEffectType.WEAKNESS,
            PotionEffectType.WITHER));

    public DefaultConfig(@NonNull DisableFriendlyFire plugin) {
        super(plugin, "configs/config.yml", "config.yml");
    }

    @SneakyThrows(value = { Exception.class })
    @Override
    public void loadConfig() {
        super.loadConfig();

        if ( !config.isSet("EventPriority") ) {
            config.set("EventPriority", eventPriority.name());
            saveConfig(false);
        } else {
            String value = config.getString("EventPriority");

            try {
                eventPriority = EventPriority.valueOf(value.toUpperCase());
            } catch ( Exception e ) {
                config.set("EventPriority", eventPriority.name());
                saveConfig(false);
            }
        }

        if ( !config.isSet("NegativePotionEffects") ) {
            config.set("NegativePotionEffects", negativePotionEffectTypes.stream()
                    .map(PotionEffectType::getName)
                    .collect(Collectors.toList()));
            saveConfig(false);
        } else {
            negativePotionEffectTypes.clear();

            for ( String typeStr : config.getStringList("NegativePotionEffects") ) {
                try {
                    PotionEffectType type = PotionEffectType.getByName(typeStr);
                    if ( type != null && !negativePotionEffectTypes.contains(type) ) {
                        negativePotionEffectTypes.add(type);
                    }
                } catch ( Exception e ) {
                    plugin.getLogger().warning("Failed to convert PotionEffectType (" + typeStr + ")");
                }
            }
        }
    }
}