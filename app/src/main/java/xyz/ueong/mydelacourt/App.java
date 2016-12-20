package xyz.ueong.mydelacourt;

import android.app.Application;

import xyz.ueong.mydelacourt.common.AppComponent;
import xyz.ueong.mydelacourt.common.AppModule;
import xyz.ueong.mydelacourt.common.DaggerAppComponent;

/**
 * Created by Ueong on 2016-05-17.
 */
public class App extends Application {
    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
