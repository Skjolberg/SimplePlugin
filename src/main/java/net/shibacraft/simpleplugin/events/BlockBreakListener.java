package net.shibacraft.simpleplugin.events;

import net.shibacraft.simpleplugin.SimplePlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    public BlockBreakListener() {

    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBreak (BlockBreakEvent event) {

        /*if (SimplePlugin.getRegionManager().isRegion(event.getBlock().getLocation())) {
            event.getPlayer().sendMessage("SimplePlugin -> Es una region");
        } else {
            event.getPlayer().sendMessage("SimplePlugin -> No es una region");
        }*/

    }

}
