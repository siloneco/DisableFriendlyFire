package com.github.siloneco.config;

import org.bukkit.event.EventPriority;

import com.github.siloneco.DisableFriendlyFire;

import lombok.Getter;
import lombok.NonNull;
import lombok.SneakyThrows;

@Getter
public class DefaultConfig extends Config {

    @Getter
    private EventPriority eventPriority = EventPriority.MONITOR;

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
    }
}