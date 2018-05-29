package org.kosta.persistence.airport;

import org.kosta.domain.airport.AirportVO;

public interface AirportDAO {

    AirportVO readAll(String airportCode) throws Exception;

    double readLat(String airportCode) throws Exception;

    double readLon(String airportCode) throws Exception;

}
