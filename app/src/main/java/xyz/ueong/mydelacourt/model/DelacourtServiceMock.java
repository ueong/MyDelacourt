package xyz.ueong.mydelacourt.model;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.mock.BehaviorDelegate;
import xyz.ueong.mydelacourt.R;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtServiceMock implements DelacourtService {
    private BehaviorDelegate<DelacourtService> delegate;
    private Gson gson;
    private Context context;

    @Inject
    public DelacourtServiceMock(Context context, Gson gson, BehaviorDelegate<DelacourtService> delegate) {
        this.delegate = delegate;
        this.gson = gson;
        this.context = context;
    }

    @Override
    public Observable<List<DelacourtMenu>> getMenus() {
        return delegate.returningResponse(makeMock()).getMenus();
    }

    public List<DelacourtMenu> makeMock() {
        InputStream jsonInputStream = context.getResources().openRawResource(R.raw.jamsilmenu);
        return gson.fromJson(convertStreamToString(jsonInputStream), new TypeToken<List<DelacourtMenu>>(){}.getType());
    }

    private String convertStreamToString(final InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is, "utf-8").useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
