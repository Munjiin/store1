package com.company.domain;

import java.util.Date;

public class StoreVO {

    private int sno;
    private double lat,lng;
    private String sname,gubun,img;
    private Date regdate;

    @Override
    public String toString() {
        return "StoreVO{" +
                "sno=" + sno +
                ", lat=" + lat +
                ", lng=" + lng +
                ", sname='" + sname + '\'' +
                ", gubun='" + gubun + '\'' +
                ", img='" + img + '\'' +
                ", regdate=" + regdate +
                '}';
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGubun() {
        return gubun;
    }

    public void setGubun(String gubun) {
        this.gubun = gubun;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
}
