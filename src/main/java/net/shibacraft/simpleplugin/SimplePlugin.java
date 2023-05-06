package net.shibacraft.simpleplugin;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;
import lombok.Getter;
import net.shibacraft.api.SimpleApi;
import net.shibacraft.api.SimpleCore;
import net.shibacraft.api.SimpleRegion;
import org.bukkit.plugin.java.JavaPlugin;
import net.shibacraft.simpleplugin.module.MainModule;

public class SimplePlugin extends JavaPlugin {

    @Getter
    static SimplePlugin plugin;
    private MainModule mainModule;

    @Override
    public void onEnable() {
        Injector injector = Guice.createInjector(Stage.PRODUCTION, new InjectSimplePlugin(true));

        SimplePlugin.plugin = this;


        SimplePluginCore simplePluginCore = injector.getInstance(SimplePluginCore.class);
        simplePluginCore.setMessage("prueba");
        SimplePluginRegion simpleRegion = injector.getInstance(SimplePluginRegion.class);
        System.out.println(simpleRegion.isRegion());
        //simpleRegion.setRegion(true);

        mainModule = new MainModule(this, simplePluginCore, simpleRegion);
        mainModule.load();





    }

    @Override
    public void onDisable() {
        mainModule.unload();
    }

}
