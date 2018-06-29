package org.kosta.domain;

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

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
