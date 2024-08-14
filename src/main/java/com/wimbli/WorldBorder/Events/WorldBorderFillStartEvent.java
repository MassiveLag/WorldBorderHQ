package com.wimbli.WorldBorder.Events;

import com.wimbli.WorldBorder.WorldFillTask;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


/**
 * Created by Maximvdw on 12.01.2016.
 */
public class WorldBorderFillStartEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final WorldFillTask fillTask;

    public WorldBorderFillStartEvent(WorldFillTask worldFillTask) {
        this.fillTask = worldFillTask;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public WorldFillTask getFillTask() {
        return this.fillTask;
    }
}
