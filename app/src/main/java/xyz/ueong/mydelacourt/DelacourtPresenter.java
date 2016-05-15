package xyz.ueong.mydelacourt;

import android.util.Log;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtPresenter {
    private static final String TAG = "DelacourtPresenter";
    private DelacourtView view;
    private DelacourtService service;

    public DelacourtPresenter(DelacourtView view) {
        this.view = view;
        this.service = createService(true);
    }

    private DelacourtService createService(boolean isMock) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://daag.pe.kr")
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit).build();
        final BehaviorDelegate<DelacourtService> delegate = mockRetrofit.create(DelacourtService.class);

        return isMock? new DelecourtServiceMock(delegate) : retrofit.create(DelacourtService.class);

    }

    public void getMenus() {
        Observable<List<DelacourtMenu>> menus = service.getMenus();
        menus.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<DelacourtMenu>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "getMenus()::onCompleted()");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "getMenus()::onError()");
                    }

                    @Override
                    public void onNext(List<DelacourtMenu> delacourtMenus) {
                        Log.d(TAG, "getMenus()::onNext()");
                        view.showMenus(delacourtMenus);
                    }
                });
    }


}
