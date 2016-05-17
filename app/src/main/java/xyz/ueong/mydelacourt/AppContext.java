package xyz.ueong.mydelacourt;

import android.app.Application;
import android.content.Context;
import android.provider.Settings;

/**
 * Created by Ueong on 2016-05-17.
 */
public class AppContext extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        AppContext.context = getApplicationContext();
    }


    public static Context applicationContext() {
        return AppContext.context;
    }
}
