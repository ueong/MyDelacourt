package xyz.ueong.mydelacourt;

import java.util.Arrays;
import java.util.List;

import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelecourtServiceMock implements DelacourtService {
    private final BehaviorDelegate<DelacourtService> delegate;

    public DelecourtServiceMock(BehaviorDelegate<DelacourtService> delegate) {
        this.delegate = delegate;
    }
    @Override
    public Observable<List<DelacourtMenu>> getMenus() {
        return delegate.returningResponse(makeMock()).getMenus();
    }

    private List<DelacourtMenu> makeMock() {
        return Arrays.asList(
            new DelacourtMenu("bc84c12fc721ac1cc7a5","버섯육개장","Spicy Beef Soup","758",false,false,false, "5500","2500","http://www.sdsfoodmenu.co.kr:9106//foodcourt/menu?menuId=PROD007230", "KOREAN 1", "b2")
        );
    }
}
