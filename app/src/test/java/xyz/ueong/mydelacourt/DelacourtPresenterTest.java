package xyz.ueong.mydelacourt;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertNotNull;
import static org.mockito.Mockito.verify;

/**
 * Created by ueong on 16. 5. 15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DelacourtPresenterTest {
    DelacourtPresenter presenter;
    @Mock
    DelacourtView view;
    @Mock
    DelacourtInteractor service;

    DelacourtMenus hardcodedMenus;
    @Before
    public void setup() {
        presenter = new DelacourtPresenter(view, service);
//        hardcodedMenus = makeHardcodedMenu();
    }

//    @Test
//    public void shouldShowMenusCalledWhenGetMenuIsCalled() throws Exception {
//        when(service.getMenus()).thenReturn(hardcodedMenus);
//        presenter.getMenus();
//        verify(view).showMenus(hardcodedMenus);
//    }
//
//    private DelacourtMenus makeHardcodedMenu() {
//        Gson gson = new Gson();
//
//        FileReader reader = null;
//        try {
//            reader = new FileReader("./jamsilmenu.json");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        List<DelacourtMenu> menus = gson.fromJson(new JsonReader(reader), new TypeToken<List<DelacourtMenu>>(){}.getType());
//        return new DelacourtMenus(menus);
//    }

}
