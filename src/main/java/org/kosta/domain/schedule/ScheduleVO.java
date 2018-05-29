package org.kosta.domain.schedule;

import lombok.Data;

@Data
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


}
