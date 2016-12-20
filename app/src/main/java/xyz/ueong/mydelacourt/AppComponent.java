package xyz.ueong.mydelacourt;

import dagger.Component;

/**
 * Created by actmember on 12/20/16.
 */

@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DelacourtViewImpl view);
    void inject(DelacourtDetailViewImpl view);
}
