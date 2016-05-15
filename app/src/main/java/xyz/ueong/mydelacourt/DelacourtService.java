package xyz.ueong.mydelacourt;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by ueong on 16. 5. 15.
 */
public interface DelacourtService {
    @GET("/")
    Observable<List<DelacourtMenu>> getMenus();
}