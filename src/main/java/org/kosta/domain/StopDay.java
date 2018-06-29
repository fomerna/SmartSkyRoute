package org.kosta.domain;

import java.util.ArrayList;
import java.util.List;

public class StopDay {
    private String day1;
    private String day2;
    private String day3;
    private String day4;
    private String day5;
    private String day6;
    private String day7;
    private String day8;
    private String day9;
    private String day10;
    public StopDay() {
    }

    public StopDay(String day1, String day2, String day3, String day4, String day5, String day6, String day7, String day8, String day9, String day10) {
        this.day1 = day1;
        this.day2 = day2;
        this.day3 = day3;
        this.day4 = day4;
        this.day5 = day5;
        this.day6 = day6;
        this.day7 = day7;
        this.day8 = day8;
        this.day9 = day9;
        this.day10 = day10;
    }

    public String getDay1() {
        return day1;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public String getDay2() {
        return day2;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public String getDay3() {
        return day3;
    }

    public void setDay3(String day3) {
        this.day3 = day3;
    }

    public String getDay4() {
        return day4;
    }

    public void setDay4(String day4) {
        this.day4 = day4;
    }

    public String getDay5() {
        return day5;
    }

    public void setDay5(String day5) {
        this.day5 = day5;
    }

    public String getDay6() {
        return day6;
    }

    public void setDay6(String day6) {
        this.day6 = day6;
    }

    public String getDay7() {
        return day7;
    }

    public void setDay7(String day7) {
        this.day7 = day7;
    }

    public String getDay8() {
        return day8;
    }

    public void setDay8(String day8) {
        this.day8 = day8;
    }

    public String getDay9() {
        return day9;
    }

    public void setDay9(String day9) {
        this.day9 = day9;
    }

    public String getDay10() {
        return day10;
    }

    public void setDay10(String day10) {
        this.day10 = day10;
    }

    public List<Integer> StopDayList(StopDay stopDay){
        List<Integer> stopDayList = new ArrayList<>();
        if(stopDay.getDay1() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay1()));
        }
        if(stopDay.getDay2() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay2()));
        }
        if(stopDay.getDay3() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay3()));
        }
        if(stopDay.getDay4() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay4()));
        }
        if(stopDay.getDay5() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay5()));
        }
        if(stopDay.getDay6() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay6()));
        }
        if(stopDay.getDay7() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay7()));
        }
        if(stopDay.getDay8() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay8()));
        }
        if(stopDay.getDay9() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay9()));
        }
        if(stopDay.getDay10() != null){
            stopDayList.add(Integer.parseInt(stopDay.getDay10()));
        }
        return stopDayList;
    }
}
