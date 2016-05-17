package xyz.ueong.mydelacourt;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.InputStream;
import java.util.List;

import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtServiceMock implements DelacourtService {
    private final BehaviorDelegate<DelacourtService> delegate;

    public DelacourtServiceMock(BehaviorDelegate<DelacourtService> delegate) {
        this.delegate = delegate;
    }
    @Override
    public Observable<List<DelacourtMenu>> getMenus() {
        return delegate.returningResponse(makeMock()).getMenus();
    }

    public List<DelacourtMenu> makeMock() {
        InputStream jsonInputStream = AppContext.applicationContext().getResources().openRawResource(R.raw.jamsil_20160513_lunch);

        Gson gson = new Gson();
        return gson.fromJson(convertStreamToString(jsonInputStream), new TypeToken<List<DelacourtMenu>>(){}.getType());
    }

    private String convertStreamToString(final InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is, "utf-8").useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
