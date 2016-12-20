package xyz.ueong.mydelacourt;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    public Gson provideGson() {
        return new Gson();
    }


    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public MockRetrofit provideMockRetrofit(Retrofit retrofit) {
        return new MockRetrofit.Builder(retrofit)
                .networkBehavior(NetworkBehavior.create())
                .build();
    }

    @Provides
    public DelacourtService provideDelacourtService(Retrofit retrofit, Gson gson) {
        if(BuildConfig.FLAVOR.equals("mock")) {
            return provideDelacourtServiceMock(context, gson, provideMockRetrofit(retrofit));
        }
        return retrofit.create(DelacourtService.class);
    }

    @Provides
    public DelacourtServiceMock provideDelacourtServiceMock(Context context, Gson gson, MockRetrofit mockRetrofit) {
        final BehaviorDelegate<DelacourtService> delegate = mockRetrofit.create(DelacourtService.class);
        return new DelacourtServiceMock(context, gson, delegate);
    }

    @Provides
    public DelacourtPresenter provideDelacourtPresenter(DelacourtService delacourtService) {
        return new DelacourtPresenter(delacourtService);
    }

    @Provides
    public DelacourtDetailPresenter provideDelacourtDetailPresenter() {
        return new DelacourtDetailPresenter();
    }

    @Provides
    public DelacourtMenuAdapter provideDelacourtMenuAdapter() {
        return new DelacourtMenuAdapter();
    }
}
