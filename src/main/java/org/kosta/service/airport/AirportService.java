package org.kosta.service.airport;

import org.kosta.domain.airport.AirportVO;

import java.util.ArrayList;
import java.util.List;

public interface AirportService {

    AirportVO readAll(String airportCode) throws Exception;

    double readLat(String airportCode) throws Exception;

    double readLon(String airportCode) throws Exception;

    int calKm(String a, String b) throws Exception;

    List<String> route0(String dep, String arv) throws Exception;

    List<String> route1(String dep, String arv, String s1) throws Exception;

    List<String> route2(String dep, String arv, String s1, String s2) throws Exception;

    List<String> route3(String dep, String arv, String s1, String s2, String s3) throws Exception;

    List<String> route4(String dep, String arv, String s1, String s2, String s3, String s4) throws Exception;

    List<String> route5(String dep, String arv, String s1, String s2, String s3, String s4, String s5) throws Exception;


}
