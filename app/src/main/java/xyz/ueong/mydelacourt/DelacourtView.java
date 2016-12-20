package xyz.ueong.mydelacourt;

import java.util.List;

/**
 * Created by ueong on 16. 5. 15.
 */
public interface DelacourtView {
    void showMenus(List<DelacourtMenu> menus);
    void showEmptyView();
    void hideEmptyView();
    void showErrorView();
    void hideErrorView();
    void showDetailView(DelacourtMenu menu);
    void showProgressBar();
    void hideProgressBar();
}
