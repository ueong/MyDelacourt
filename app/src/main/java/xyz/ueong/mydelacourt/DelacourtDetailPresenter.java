package xyz.ueong.mydelacourt;

/**
 * Created by ueong on 16. 5. 28.
 */
public class DelacourtDetailPresenter {
    DelacourtDetailView view;
    DelacourtMenu menu;

    public DelacourtDetailPresenter(DelacourtDetailView view) {
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
