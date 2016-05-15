package xyz.ueong.mydelacourt;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtInteractor {
//    Retrofit retrofit = new Retrofit.Builder()
//            .baseUrl("http://daag.pe.kr")
//            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .build();
//    DelacourtService service = retrofit.create(DelacourtService.class);
//
//    public DelacourtMenus getMenus() {
//        Observable<List<DelacourtMenu>> menus = service.getMenus();
//        menus.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe();
//
//
/////        return makeHardcodedMenu(context);
//    }

    private DelacourtMenus makeHardcodedMenu(Context context) {
        Gson gson = new Gson();

//        FileReader reader = null;
//        try {
//            reader = new FileReader("./jamsilmenu.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        List<DelacourtMenu> menus = gson.fromJson(new JsonReader(new InputStreamReader(context.getResources().openRawResource(R.raw.jamsilmenu))), new TypeToken<List<DelacourtMenu>>(){}.getType());
        return new DelacourtMenus(menus);
    }
}
