package org.kosta.service;

import org.kosta.domain.AirportVO;
import org.kosta.domain.ScheduleVO;

import java.util.List;

public interface dealService {

    List<ScheduleVO> deal(ScheduleVO vo) throws Exception;

    AirportVO selectAirportCodeService(String airportCode)throws Exception;

}
