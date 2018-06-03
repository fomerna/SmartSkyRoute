package org.kosta.domain.airline;

import lombok.Data;

@Data
public class AirlineVO {

    private String airlineCode;
    private String airlineName;

    public AirlineVO() {
    }

    public AirlineVO(String airlineCode, String airlineName) {
        this.airlineCode = airlineCode;
        this.airlineName = airlineName;
    }
}
