package net.shibacraft.simpleplugin;

import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.binder.AnnotatedBindingBuilder;
import net.shibacraft.api.SimpleApi;
import net.shibacraft.api.SimpleCore;
import net.shibacraft.api.SimpleRegion;

import javax.annotation.OverridingMethodsMustInvokeSuper;

public class InjectSimplePlugin extends AbstractModule {

    private boolean isRegion;

    public InjectSimplePlugin(boolean a) {
        isRegion = a;
    }

    @Override
    //@OverridingMethodsMustInvokeSuper
    protected void configure() {
        bindAndExpose(SimpleCore.class).to(SimplePluginCore.class).in(Singleton.class);
        bindAndExpose(SimpleRegion.class).to(SimplePluginRegion.class);

        requestStaticInjection(SimpleApi.class);
    }

    protected <T> AnnotatedBindingBuilder<T> bindAndExpose(final Class<T> type) {
        //expose(type);
        return bind(type);
    }

    @Provides
    @Singleton
    public SimplePluginRegion provideSimplePluginRegion() {
        return new SimplePluginRegion(isRegion);
    }

}
