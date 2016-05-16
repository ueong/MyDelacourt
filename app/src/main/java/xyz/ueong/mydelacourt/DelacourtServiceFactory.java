package xyz.ueong.mydelacourt;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

/**
 * Created by ueong on 16. 5. 16.
 */
public class DelacourtServiceFactory {
    private static Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static DelacourtService createService() {
        return buildRetrofit().create(DelacourtService.class);

    }

    public static DelacourtServiceMock createMockService() {
            MockRetrofit mockRetrofit = new MockRetrofit.Builder(buildRetrofit())
                    .networkBehavior(NetworkBehavior.create())
                    .build();
            final BehaviorDelegate<DelacourtService> delegate = mockRetrofit.create(DelacourtService.class);

            return new DelacourtServiceMock(delegate);
    }
}
