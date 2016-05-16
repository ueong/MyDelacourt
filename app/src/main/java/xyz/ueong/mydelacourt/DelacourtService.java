package xyz.ueong.mydelacourt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;

/**
 * Created by ueong on 16. 5. 15.
 */
public interface DelacourtService {
    @Headers("Accept: application/json")
    @GET("/")
    Observable<List<DelacourtMenu>> getMenus();
}