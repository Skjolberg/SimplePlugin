package net.shibacraft.simpleplugin;

import com.google.inject.Singleton;
import net.shibacraft.api.SimpleCore;

@Singleton
public class SimplePluginCore implements SimpleCore {

    public String str;

    public SimplePluginCore() {

    }

    @Override
    public String getMessage() {
        return str;
    }

    @Override
    public void setMessage(String str) {
        this.str = str;
    }

}
