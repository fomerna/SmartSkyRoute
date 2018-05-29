package org.kosta.domain.airport;

import lombok.Data;

@Data
public class AirportVO {

    public AirportVO() {
    }

    public AirportVO(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public AirportVO(String airportCode, String airportName, String city, String country, double lat, double lon) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
    }

    private String airportCode;
    private String airportName;
    private String city;
    private String country;
    private double lat;
    private double lon;

}
