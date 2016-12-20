package xyz.ueong.mydelacourt.view;

import java.util.List;

import xyz.ueong.mydelacourt.model.DelacourtMenu;

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
