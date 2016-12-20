package xyz.ueong.mydelacourt.common;

import dagger.Component;
import xyz.ueong.mydelacourt.view.DelacourtDetailViewImpl;
import xyz.ueong.mydelacourt.view.DelacourtViewImpl;

/**
 * Created by actmember on 12/20/16.
 */

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DelacourtViewImpl view);
    void inject(DelacourtDetailViewImpl view);
}
