package net.shibacraft.simpleplugin;

import net.byteflux.libby.BukkitLibraryManager;
import net.byteflux.libby.Library;
import net.shibacraft.simpleplugin.api.loader.Loader;

public class ManagerLib implements Loader {

    private final SimplePlugin plugin;

    public ManagerLib(SimplePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void load() {
        final BukkitLibraryManager bukkitLibraryManager = new BukkitLibraryManager(plugin, "libs");
        bukkitLibraryManager.addJitPack();

        final Library sbrAPI = Library.builder()
                .groupId("com{}github{}Skjolberg")
                .artifactId("SimpleBlockRegenAPI")
                .version("0.2.0-R16")
                .id("sbrAPI")
                .build();

        //bukkitLibraryManager.loadLibrary(sbrAPI);
    }

    @Override
    public void unload() {

    }

    @Override
    public void reload() {

    }

}
