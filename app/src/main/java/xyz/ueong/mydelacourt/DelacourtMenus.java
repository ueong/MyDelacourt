package xyz.ueong.mydelacourt;

import java.util.List;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtMenus {
    List<DelacourtMenu> menus;

    public DelacourtMenus(List<DelacourtMenu> menus) {
        this.menus = menus;
    }

    public List<DelacourtMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<DelacourtMenu> menus) {
        this.menus = menus;
    }
}
