package xyz.ueong.mydelacourt.view;

import xyz.ueong.mydelacourt.model.DelacourtMenu;

/**
 * Created by ueong on 16. 5. 27.
 */
public interface DelacourtDetailView {
    void show(DelacourtMenu menu);
    void showError();
    void close();
}
