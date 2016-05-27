package xyz.ueong.mydelacourt;

import java.io.Serializable;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtMenu implements Serializable {
    String id;
    String title_kor;
    String title_eng;
    String kcal;
    boolean soldout;
    boolean very_low_cal;
    boolean low_cal;
    boolean high_cal;
    String price;
    String payments;
    String img_src;
    String corner;
    String floor;

    public DelacourtMenu(String id, String title_kor, String title_eng, String kcal, boolean soldout, boolean low_cal, boolean high_cal, String price, String payments, String img_src, String corner, String floor) {
        this.id = id;
        this.title_kor = title_kor;
        this.title_eng = title_eng;
        this.kcal = kcal;
        this.soldout = soldout;
        this.low_cal = low_cal;
        this.high_cal = high_cal;
        this.price = price;
        this.payments = payments;
        this.img_src = img_src;
        this.corner = corner;
        this.floor = floor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle_kor() {
        return title_kor;
    }

    public void setTitle_kor(String title_kor) {
        this.title_kor = title_kor;
    }

    public String getTitle_eng() {
        return title_eng;
    }

    public void setTitle_eng(String title_eng) {
        this.title_eng = title_eng;
    }

    public String getKcal() {
        return kcal;
    }

    public void setKcal(String kcal) {
        this.kcal = kcal;
    }

    public boolean isSoldout() {
        return soldout;
    }

    public void setSoldout(boolean soldout) {
        this.soldout = soldout;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPayments() {
        return payments;
    }

    public void setPayments(String payments) {
        this.payments = payments;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

    public String getCorner() {
        return corner;
    }

    public void setCorner(String corner) {
        this.corner = corner;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public boolean isLow_cal() {
        return low_cal;
    }

    public void setLow_cal(boolean low_cal) {
        this.low_cal = low_cal;
    }

    public boolean isHigh_cal() {
        return high_cal;
    }

    public void setHigh_cal(boolean high_cal) {
        this.high_cal = high_cal;
    }

    public boolean isVery_low_cal() {
        return very_low_cal;
    }

    public void setVery_low_cal(boolean very_low_cal) {
        this.very_low_cal = very_low_cal;
    }
}
