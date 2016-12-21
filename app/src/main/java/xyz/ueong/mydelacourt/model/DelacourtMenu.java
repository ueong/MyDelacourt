package xyz.ueong.mydelacourt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ueong on 16. 5. 15.
 */
public class DelacourtMenu implements Parcelable {
    String id;
    @SerializedName("title_kor")
    String titleKor;
    @SerializedName("title_eng")
    String titleEng;
    String kcal;
    boolean soldout;
    @SerializedName("very_low_cal")
    boolean veryLowCal;
    @SerializedName("low_cal")
    boolean lowCal;
    @SerializedName("high_cal")
    boolean highCal;
    String price;
    String payments;
    @SerializedName("img_src")
    String imgSrc;
    String corner;
    String floor;

    public DelacourtMenu(String id, String titleKor, String titleEng, String kcal, boolean soldout, boolean lowCal, boolean highCal, String price, String payments, String imgSrc, String corner, String floor) {
        this.id = id;
        this.titleKor = titleKor;
        this.titleEng = titleEng;
        this.kcal = kcal;
        this.soldout = soldout;
        this.lowCal = lowCal;
        this.highCal = highCal;
        this.price = price;
        this.payments = payments;
        this.imgSrc = imgSrc;
        this.corner = corner;
        this.floor = floor;
    }

    protected DelacourtMenu(Parcel in) {
        id = in.readString();
        titleKor = in.readString();
        titleEng = in.readString();
        kcal = in.readString();
        soldout = in.readByte() != 0;
        veryLowCal = in.readByte() != 0;
        lowCal = in.readByte() != 0;
        highCal = in.readByte() != 0;
        price = in.readString();
        payments = in.readString();
        imgSrc = in.readString();
        corner = in.readString();
        floor = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(titleKor);
        dest.writeString(titleEng);
        dest.writeString(kcal);
        dest.writeByte((byte) (soldout ? 1 : 0));
        dest.writeByte((byte) (veryLowCal ? 1 : 0));
        dest.writeByte((byte) (lowCal ? 1 : 0));
        dest.writeByte((byte) (highCal ? 1 : 0));
        dest.writeString(price);
        dest.writeString(payments);
        dest.writeString(imgSrc);
        dest.writeString(corner);
        dest.writeString(floor);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<DelacourtMenu> CREATOR = new Creator<DelacourtMenu>() {
        @Override
        public DelacourtMenu createFromParcel(Parcel in) {
            return new DelacourtMenu(in);
        }

        @Override
        public DelacourtMenu[] newArray(int size) {
            return new DelacourtMenu[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitleKor() {
        return titleKor;
    }

    public void setTitleKor(String titleKor) {
        this.titleKor = titleKor;
    }

    public String getTitle_eng() {
        return titleEng;
    }

    public void setTitle_eng(String title_eng) {
        this.titleEng = title_eng;
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

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
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

    public boolean isLowCal() {
        return lowCal;
    }

    public void setLowCal(boolean lowCal) {
        this.lowCal = lowCal;
    }

    public boolean isHighCal() {
        return highCal;
    }

    public void setHighCal(boolean highCal) {
        this.highCal = highCal;
    }

    public boolean isVeryLowCal() {
        return veryLowCal;
    }

    public void setVeryLowCal(boolean veryLowCal) {
        this.veryLowCal = veryLowCal;
    }
}
