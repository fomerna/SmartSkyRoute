package org.kosta.persistence.airport;

import org.kosta.domain.airport.AirportVO;

import java.util.HashMap;
import java.util.List;

public interface AirportDAO {

    AirportVO readAll(String airportCode) throws Exception;

    double readLat(String airportCode) throws Exception;

    double readLon(String airportCode) throws Exception;

    List<AirportVO> selectAirport2(HashMap<String,Object> param)throws Exception;

}
