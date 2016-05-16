package xyz.ueong.mydelacourt;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.MockRetrofit;
import retrofit2.mock.NetworkBehavior;
import rx.Scheduler;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;
import rx.schedulers.TestScheduler;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * Created by ueong on 16. 5. 15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DelacourtPresenterTest {
    DelacourtPresenter presenter;
    TestSubscriber<List<DelacourtMenu>> testSubscriber = TestSubscriber.create();
    @Mock
    DelacourtView view;
    DelacourtServiceMock service;

    @Before
    public void setup() {
        service = DelacourtServiceFactory.createMockService();
        presenter = new DelacourtPresenter(view, service);
    }


    @Test
    public void shouldShowMenusCalledWhenGetMenuIsCalled() throws Exception {
        presenter.getMenus();
        verify(view).showMenus(service.makeMock()); //TODO: the test is failing now because of scheduler problem. fix it.
    }

//    class TestRxAndroidSchedulersHook extends RxAndroidSchedulersHook {
//        @Override
//        public Scheduler getMainThreadScheduler() {
//            return Schedulers.immediate();
//        }
//    }
}
