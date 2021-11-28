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
public class HoaDon {
    private int stt,price,soLuong,sum;
    private String name,size,ma;

    public HoaDon(int stt,String name, String size,int price, int soLuong) {
        this.stt = stt;
        this.price = price;
        this.soLuong = soLuong;
        this.name = name;
        this.size = size;
        this.sum = soLuong*price;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.sum=price*this.soLuong;
        this.price = price;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.sum=soLuong*this.price;
        this.soLuong = soLuong;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
    @Override
    public String toString(){
        return stt+" "+name+" "+size+" "+price+" "+soLuong+" "+sum;
    }
}
