/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author mac
 */
public class SanPham {
    private int ID,lPrice,mPrice,sPrice;
    private String name,code;

    public SanPham(int ID, String code,String name, int sPrice, int mPrice, int lPrice) {
        this.ID = ID;
        this.lPrice = lPrice;
        this.mPrice = mPrice;
        this.sPrice = sPrice;
        this.name = name;
        this.code = code;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getlPrice() {
        return lPrice;
    }

    public void setlPrice(int lPrice) {
        this.lPrice = lPrice;
    }

    public int getmPrice() {
        return mPrice;
    }

    public void setmPrice(int mPrice) {
        this.mPrice = mPrice;
    }

    public int getsPrice() {
        return sPrice;
    }

    public void setsPrice(int sPrice) {
        this.sPrice = sPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Override
    public String toString(){
        return ID+" "+code+" "+name+" "+sPrice+" "+mPrice+" "+lPrice;
    }
}
