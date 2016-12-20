package xyz.ueong.mydelacourt.presenter;

import xyz.ueong.mydelacourt.model.DelacourtMenu;
import xyz.ueong.mydelacourt.view.DelacourtDetailView;

/**
 * Created by ueong on 16. 5. 28.
 */
public class DelacourtDetailPresenter {
    DelacourtDetailView view;
    DelacourtMenu menu;

    public void setView(DelacourtDetailView view) {
        this.view = view;
    }

    public void setMenu(DelacourtMenu menu) {
        this.menu = menu;
    }

    public void show() {
        if(menu != null) {
            view.show(menu);
        } else {
            view.showError();
            close();
        }
    }

    public void close() {
        view.close();
    }
}
