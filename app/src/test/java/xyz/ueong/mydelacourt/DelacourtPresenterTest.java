package xyz.ueong.mydelacourt;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import xyz.ueong.mydelacourt.util.SynchronousSchedulers;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ueong on 16. 5. 15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DelacourtPresenterTest {
    DelacourtPresenter presenter;
    @Mock
    DelacourtView view;
    @Mock
    DelacourtService service;

    // replace all schedulers to Schedulers.immidiate()
    @Rule
    public SynchronousSchedulers schedulers = new SynchronousSchedulers();

    @Before
    public void setup() {
        presenter = new DelacourtPresenter(service);
        presenter.setView(view);
    }

    @Test
    public void shouldShowEmptyViewWhenMenuIsEmpty() throws Exception {
        List<DelacourtMenu> emptyMenus = new ArrayList<>();
        when(service.getMenus()).thenReturn(Observable.just(emptyMenus));
        presenter.getMenus();
        verify(view).hideProgressBar();
        verify(view).showEmptyView();
    }

    @Test
    public void shouldShowMenusCalledWhenGetMenuIsCalled() throws Exception {
        List<DelacourtMenu> mockMenus = makeMenuListFromJson();
        when(service.getMenus()).thenReturn(Observable.just(mockMenus));
        presenter.getMenus();
        verify(view).hideProgressBar();
        verify(view).showMenus(mockMenus);
    }

    @Test
    public void shouldShowDetailViewWhenUserClickedListItem() throws Exception {
        DelacourtMenu menu = makeMenuListFromJson().get(0);
        presenter.showDetail(menu);
        verify(view).showDetailView(menu);
    }

    @Test
    public void shouldShowErrorViewWhenErrorOccured() throws Exception {
        when(service.getMenus()).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return Observable.error(new DelacourtException("Just error"));
            }
        });
        presenter.getMenus();
        verify(view).hideProgressBar();
        verify(view).showErrorView();
    }

    public List<DelacourtMenu> makeMenuListFromJson() {
        String jsonStr = "";
        try {
            InputStream jsonInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/src/main/res/raw/jamsil_20160513_lunch.json"));
            jsonStr = convertStreamToString(jsonInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        return gson.fromJson(jsonStr, new TypeToken<List<DelacourtMenu>>() {
        }.getType());
    }

    private String convertStreamToString(final InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is, "utf-8").useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
