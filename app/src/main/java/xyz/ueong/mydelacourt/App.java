package xyz.ueong.mydelacourt;

import android.app.Application;

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
