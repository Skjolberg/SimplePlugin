package net.shibacraft.simpleplugin.api.banner;

import net.shibacraft.simpleplugin.SimplePlugin;
import net.shibacraft.simpleplugin.api.loader.Loader;
import net.shibacraft.simpleplugin.api.logger.CoreLogger;

public class Banner implements Loader {

    private final SimplePlugin plugin;

    public Banner(SimplePlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public void load() {
        CoreLogger.info("&bPlugin: &e" + plugin.getName());
        CoreLogger.info("&fAuthor: &e" + plugin.getDescription().getAuthors().get(0));
        CoreLogger.info("&fVersion: &e" + plugin.getDescription().getVersion());
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }

}
