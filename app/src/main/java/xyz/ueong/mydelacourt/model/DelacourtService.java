package xyz.ueong.mydelacourt.model;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by ueong on 16. 5. 15.
 */
public interface DelacourtService {
    @Headers("Accept: application/json")
    @GET("/")
    Observable<List<DelacourtMenu>> getMenus();
}