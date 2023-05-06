package net.shibacraft.simpleplugin.commands.Internal;

import me.fixeddev.commandflow.CommandManager;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilder;
import me.fixeddev.commandflow.annotated.AnnotatedCommandTreeBuilderImpl;
import me.fixeddev.commandflow.annotated.part.PartInjector;
import me.fixeddev.commandflow.annotated.part.SimplePartInjector;
import me.fixeddev.commandflow.annotated.part.defaults.DefaultsModule;
import me.fixeddev.commandflow.bukkit.BukkitCommandManager;
import me.fixeddev.commandflow.bukkit.factory.BukkitModule;
import me.fixeddev.commandflow.translator.DefaultTranslator;
import net.shibacraft.api.SimpleCore;
import net.shibacraft.api.SimpleRegion;
import net.shibacraft.simpleplugin.SimplePlugin;
import net.shibacraft.simpleplugin.api.loader.Loader;
import net.shibacraft.simpleplugin.commands.MainCommand;

public class CommandLoader implements Loader {

    private final CommandManager commandManager;
    private SimpleCore simplePluginCore;
    private SimpleRegion simpleRegion;

    public CommandLoader(SimpleCore simplePluginCore, SimpleRegion simpleRegion) {
        this.commandManager = new BukkitCommandManager(SimplePlugin.getPlugin().getName());
        commandManager.setTranslator(new DefaultTranslator(new CommandTranslatorProvider()));
        this.simplePluginCore = simplePluginCore;
        this.simpleRegion = simpleRegion;
    }

    @Override
    public void load() {
        PartInjector partInjector = new SimplePartInjector();
        partInjector.install(new DefaultsModule());
        partInjector.install(new BukkitModule());

        AnnotatedCommandTreeBuilder treeBuilder = new AnnotatedCommandTreeBuilderImpl(partInjector);

        commandManager.registerCommands(treeBuilder.fromClass(new MainCommand(simplePluginCore, simpleRegion)));


    }

    @Override
    public void unload() {
        commandManager.unregisterAll();
    }

    @Override
    public void reload() {

    }

}
