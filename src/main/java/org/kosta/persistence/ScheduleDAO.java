package org.kosta.persistence;

import org.kosta.domain.ScheduleVO;

import java.util.HashMap;
import java.util.List;

public interface ScheduleDAO {

   List<ScheduleVO> readAll(ScheduleVO vo) throws Exception;

   List<ScheduleVO> selectDepday(ScheduleVO scheduleVO)throws Exception;

   List<ScheduleVO> selectArvday(ScheduleVO scheduleVO)throws Exception;

   ScheduleVO selectPriceDepday(ScheduleVO scheduleVO)throws  Exception;

   ScheduleVO selectPriceArvday(ScheduleVO scheduleVO)throws  Exception;

   List<ScheduleVO> selectReRoute(HashMap<String,Object> param)throws  Exception;

   List<ScheduleVO> selectReRouteMore(HashMap<String,Object> param)throws  Exception;

   ScheduleVO routeSno(int sno)throws  Exception;


}
