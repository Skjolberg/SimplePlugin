package net.shibacraft.simpleplugin.commands;

import lombok.Getter;
import me.fixeddev.commandflow.annotated.CommandClass;
import me.fixeddev.commandflow.annotated.annotation.Command;
import me.fixeddev.commandflow.annotated.annotation.Named;
import me.fixeddev.commandflow.bukkit.annotation.Sender;
import net.shibacraft.api.SimpleCore;
import net.shibacraft.api.SimpleRegion;
import net.shibacraft.simpleplugin.module.MainModule;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Command(names = {"simpleplugin"}, permission = "simpleplugin.use", desc = "SimplePlugin main command")
public class MainCommand implements CommandClass {

    @Getter
    public static final Set<UUID> drop = new HashSet<>();
    private final MainModule mainModule;
    private final SimpleCore simplePluginCore;
    private final SimpleRegion simpleRegion;

    public MainCommand(SimpleCore simplePluginCore, SimpleRegion simpleRegion){
        this.mainModule = MainModule.getMainModule();
        this.simplePluginCore = simplePluginCore;
        this.simpleRegion = simpleRegion;
    }

    @Command(names = "")
    public void onMainCommand(@Sender CommandSender sender) {
        sender.sendMessage("It needs arguments.");
    }

    @Command(names = "apiset")
    public void onSetCommand(@Sender Player player, @Named("value") boolean value) {
        simpleRegion.setRegion(value);
    }

    @Command(names = "apiget")
    public void onGetCommand(@Sender Player player) {
        player.sendMessage("Mensaje: " + simpleRegion.isRegion());
    }
}
