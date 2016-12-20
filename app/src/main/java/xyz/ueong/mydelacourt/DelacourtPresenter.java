package xyz.ueong.mydelacourt;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtPresenter {
    private static final String TAG = DelacourtPresenter.class.getSimpleName();
    private DelacourtView view;
    private DelacourtService service;

    @Inject
    public DelacourtPresenter(DelacourtService service) {
        this.service = service;
    }

    public void setView(DelacourtView view) {
        this.view = view;
    }

    public void getMenus() {
        view.showProgressBar();
        Observable<List<DelacourtMenu>> menus = service.getMenus();
        menus
                .subscribeOn(AppSchedulers.io())
                .observeOn(AppSchedulers.mainThread())
                .subscribe(new DisposableObserver<List<DelacourtMenu>>() {
                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "getMenus()::onError()");
                        view.hideProgressBar();
                        view.showErrorView();
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "getMenus()::onCompleted()");
                        view.hideProgressBar();
                    }

                    @Override
                    public void onNext(List<DelacourtMenu> delacourtMenus) {
                        Log.d(TAG, "getMenus()::onNext()");
                        if (delacourtMenus != null && delacourtMenus.size() > 0) {
                            view.showMenus(delacourtMenus);
                        } else {
                            view.showEmptyView();
                        }
                    }
                });
    }

    public void showDetail(DelacourtMenu menu) {
        view.showDetailView(menu);
    }
}
