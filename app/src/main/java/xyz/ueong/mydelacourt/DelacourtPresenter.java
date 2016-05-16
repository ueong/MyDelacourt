package xyz.ueong.mydelacourt;

import android.util.Log;

import java.util.List;

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

    public DelacourtPresenter(DelacourtView view, DelacourtService service) {
        this.view = view;
        this.service = service;
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
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<DelacourtMenu> delacourtMenus) {
                        Log.d(TAG, "getMenus()::onNext()");
                        view.showMenus(delacourtMenus);
                    }
                });
    }


}
