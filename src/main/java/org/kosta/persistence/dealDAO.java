package org.kosta.persistence;


import org.kosta.domain.AirportVO;
import org.kosta.domain.ScheduleVO;

import java.util.List;

public interface dealDAO {

    List<ScheduleVO> deal(ScheduleVO vo) throws Exception;

    AirportVO selectAirportCode(String airportCode)throws Exception;
}
