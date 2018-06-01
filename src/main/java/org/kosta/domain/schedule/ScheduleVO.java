package org.kosta.domain.schedule;

import lombok.Data;


public class ScheduleVO {

    private int sno;

    private String dep;
    private String depDay;
    private String depTime;

    private String arv;
    private String arvDay;
    private String arvTime;

    private String airlineCode;
    private int fno;

    private int price;

    public ScheduleVO() {
    }

    public ScheduleVO(String dep, String depDay, String arv) {
        this.dep = dep;
        this.depDay = depDay;
        this.arv = arv;
    }

    public ScheduleVO(int sno, String dep, String depDay, String depTime, String arv, String arvDay, String arvTime, String airlineCode, int fno, int price) {
        this.sno = sno;
        this.dep = dep;
        this.depDay = depDay;
        this.depTime = depTime;
        this.arv = arv;
        this.arvDay = arvDay;
        this.arvTime = arvTime;
        this.airlineCode = airlineCode;
        this.fno = fno;
        this.price = price;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getDepDay() {
        return depDay;
    }

    public void setDepDay(String depDay) {
        this.depDay = depDay;
    }

    public String getDepTime() {
        return depTime;
    }

    public void setDepTime(String depTime) {
        this.depTime = depTime;
    }

    public String getArv() {
        return arv;
    }

    public void setArv(String arv) {
        this.arv = arv;
    }

    public String getArvDay() {
        return arvDay;
    }

    public void setArvDay(String arvDay) {
        this.arvDay = arvDay;
    }

    public String getArvTime() {
        return arvTime;
    }

    public void setArvTime(String arvTime) {
        this.arvTime = arvTime;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
