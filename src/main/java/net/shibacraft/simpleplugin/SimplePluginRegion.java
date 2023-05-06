package net.shibacraft.simpleplugin;

import com.google.inject.Singleton;
import net.shibacraft.api.SimpleCore;
import net.shibacraft.api.SimpleRegion;

@Singleton
public class SimplePluginRegion implements SimpleRegion {

    public boolean isRegion;
    private boolean otherRegion;

    public SimplePluginRegion(boolean a) {
        otherRegion = a;
    }

    @Override
    public boolean isRegion() {
        return otherRegion;
    }

    @Override
    public void setRegion(boolean isRegion) {
        this.otherRegion = isRegion;
    }
}
