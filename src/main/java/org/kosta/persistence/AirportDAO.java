package org.kosta.persistence;

import org.kosta.domain.AirportVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AirportDAO {

    AirportVO readAll(String airportCode) throws Exception;

    double readLat(String airportCode) throws Exception;

    double readLon(String airportCode) throws Exception;

    List<AirportVO> selectAirport2(Map<String,Object> param)throws  Exception;

}
