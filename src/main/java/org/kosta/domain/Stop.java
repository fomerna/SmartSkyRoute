package org.kosta.domain;

import java.util.ArrayList;
import java.util.List;

public class Stop {
    private String s1;
    private String s2;
    private String s3;
    private String s4;
    private String s5;
    private String s6;
    private String s7;
    private String s8;
    private String s9;
    private String s10;

    public String getS1() {
        return s1;
    }

    public void setS1(String s1) {
        this.s1 = s1;
    }

    public String getS2() {
        return s2;
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public String getS3() {
        return s3;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public String getS4() {
        return s4;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }

    public String getS5() {
        return s5;
    }

    public void setS5(String s5) {
        this.s5 = s5;
    }

    public String getS6() {
        return s6;
    }

    public void setS6(String s6) {
        this.s6 = s6;
    }

    public String getS7() {
        return s7;
    }

    public void setS7(String s7) {
        this.s7 = s7;
    }

    public String getS8() {
        return s8;
    }

    public void setS8(String s8) {
        this.s8 = s8;
    }

    public String getS9() {
        return s9;
    }

    public void setS9(String s9) {
        this.s9 = s9;
    }

    public String getS10() {
        return s10;
    }

    public void setS10(String s10) {
        this.s10 = s10;
    }

    public Stop(){}
    public Stop(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.s5 = s5;
        this.s6 = s6;
        this.s7 = s7;
        this.s8 = s8;
        this.s9 = s9;
        this.s10 = s10;
    }

    public List<String> StopList(Stop stop){
        List<String> stopList = new ArrayList<>();
        if(stop.s1 != null){
            stopList.add(stop.getS1());
        }
        if(stop.s2 != null){
            stopList.add(stop.getS2());
        }
        if(stop.s3 != null){
            stopList.add(stop.getS3());
        }
        if(stop.s4 != null){
            stopList.add(stop.getS4());
        }
        if(stop.s5 != null){
            stopList.add(stop.getS5());
        }
        if(stop.s6 != null){
            stopList.add(stop.getS6());
        }
        if(stop.s7 != null){
            stopList.add(stop.getS7());
        }
        if(stop.s8 != null){
            stopList.add(stop.getS8());
        }
        if(stop.s9 != null){
            stopList.add(stop.getS9());
        }
        if(stop.s10 != null){
            stopList.add(stop.getS10());
        }

        return stopList;
    }
}
