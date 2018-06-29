package org.kosta.service;

import org.kosta.domain.AirportVO;

import java.util.List;

public interface AirportService {


    int calKm(AirportVO a, AirportVO b) throws Exception;

    List<String> route(List<String> list)throws Exception;

    AirportVO readAllService(String airportCode)throws Exception;

}
