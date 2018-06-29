package org.kosta.domain;

import lombok.Data;

@Data
public class AirlineVO {

    public AirlineVO() {
    }
    private String airlineCode;
    private String airlineName;


    public AirlineVO(String airlineCode, String airlineName) {
        this.airlineCode = airlineCode;
        this.airlineName = airlineName;
    }

}
