package house.rental.com.rentalyourhouse;

import android.graphics.Bitmap;

/**
 * Created by BSILIND\parthiban.m on 6/1/16.
 */
public class SearchResultModel {
    Bitmap houseimage;
    String pricel;
    String houseaddress;
    String housedetail;
    String housestatus;
    String phoneno;

    public Bitmap getHouseimage() {
        return houseimage;
    }

    public void setHouseimage(Bitmap houseimage) {
        this.houseimage = houseimage;
    }

    public String getPricel() {
        return pricel;
    }

    public void setPricel(String pricel) {
        this.pricel = pricel;
    }

    public String getHouseaddress() {
        return houseaddress;
    }

    public void setHouseaddress(String houseaddress) {
        this.houseaddress = houseaddress;
    }

    public String getHousedetail() {
        return housedetail;
    }

    public void setHousedetail(String housedetail) {
        this.housedetail = housedetail;
    }

    public String getHousestatus() {
        return housestatus;
    }

    public void setHousestatus(String housestatus) {
        this.housestatus = housestatus;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
