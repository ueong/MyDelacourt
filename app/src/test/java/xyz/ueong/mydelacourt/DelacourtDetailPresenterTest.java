package xyz.ueong.mydelacourt;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import xyz.ueong.mydelacourt.model.DelacourtMenu;
import xyz.ueong.mydelacourt.presenter.DelacourtDetailPresenter;
import xyz.ueong.mydelacourt.util.SynchronousSchedulers;
import xyz.ueong.mydelacourt.view.DelacourtDetailView;

import static org.mockito.Mockito.verify;


/**
 * Created by ueong on 16. 5. 15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DelacourtDetailPresenterTest {
    DelacourtDetailPresenter presenter;
    @Mock
    DelacourtDetailView view;

    // replace all schedulers to Schedulers.immidiate()
    @Rule
    public SynchronousSchedulers schedulers = new SynchronousSchedulers();

    @Before
    public void setup() {
        presenter = new DelacourtDetailPresenter();
        presenter.setView(view);
    }

    @Test
    public void shouldShowErrorAndClosedWhenMenuIsEmpty() throws Exception {
        presenter.setMenu(null);
        presenter.show();
        verify(view).showError();
        verify(view).close();
    }

    @Test
    public void shouldShowMenuWhenMenuIsExists() throws Exception {
        DelacourtMenu menu = makeMenuListFromJson().get(0);
        presenter.setMenu(menu);
        presenter.show();
        verify(view).show(menu);
    }

    @Test
    public void shouldClosedWhenCloseMethodCalled() throws Exception {
        presenter.close();
        verify(view).close();
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
        return gson.fromJson(jsonStr, new TypeToken<List<DelacourtMenu>>(){}.getType());
    }

    private String convertStreamToString(final InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is, "utf-8").useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
