package net.shibacraft.simpleplugin.module;

import lombok.Getter;
import net.shibacraft.api.SimpleCore;
import net.shibacraft.api.SimpleRegion;
import net.shibacraft.simpleplugin.SimplePlugin;
import net.shibacraft.simpleplugin.SimplePluginRegion;
import net.shibacraft.simpleplugin.commands.Internal.CommandLoader;
import net.shibacraft.simpleplugin.commands.Internal.CommandTranslatorProvider;
import net.shibacraft.simpleplugin.api.loader.Loader;
import net.shibacraft.simpleplugin.events.BlockBreakListener;


public class MainModule implements Loader {

    @Getter
    private static MainModule mainModule;
    private final SimplePlugin plugin;
    private SimpleCore simplePluginCore;
    private SimpleRegion simpleRegion;

    public MainModule(SimplePlugin plugin, SimpleCore simplePluginCore, SimplePluginRegion simpleRegion){
        this.plugin = plugin;
        this.simplePluginCore = simplePluginCore;
        this.simpleRegion = simpleRegion;
    }

    @Override
    public void load() {
        mainModule = this;

        final CommandLoader commandLoader = new CommandLoader(simplePluginCore, simpleRegion);
        commandLoader.load();

        plugin.getServer().getPluginManager().registerEvents(new BlockBreakListener(), plugin);

    }

    @Override
    public void unload() {
    }

    @Override
    public void reload() {
        CommandTranslatorProvider.commandTranslatorProvider.reload();
    }

}
