package org.kosta.service;

import org.kosta.domain.AirportVO;
import org.kosta.domain.ScheduleVO;

import java.util.HashMap;
import java.util.List;

public interface ScheduleService {

    List<List<ScheduleVO>> randomSch(List<String> result,String DepDay,String ArvDay)throws Exception;

    List<ScheduleVO> selectReRouteService(HashMap<String,Object> param)throws  Exception;

    List<ScheduleVO> selectReRouteMoreService(HashMap<String,Object> param)throws  Exception;

    ScheduleVO routeSnoService(int sno)throws  Exception;

    List<List<ScheduleVO>> round(List<String> result,String DepDay,String ArvDay)throws Exception;

    List<List<AirportVO>> selectCity(List<List<ScheduleVO>> randomSch)throws Exception;


}
