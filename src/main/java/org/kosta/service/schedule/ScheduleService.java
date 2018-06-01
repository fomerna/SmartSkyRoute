package org.kosta.service.schedule;

import org.kosta.domain.schedule.ScheduleVO;

import java.util.HashMap;
import java.util.List;

public interface ScheduleService {

    List<List<ScheduleVO>> randomSch(List<String> result,String DepDay,String ArvDay)throws Exception;

    List<ScheduleVO> selectReRouteService(HashMap<String,Object> param)throws  Exception;

    List<ScheduleVO> selectReRouteMoreService(HashMap<String,Object> param)throws  Exception;
  /*  List<ScheduleVO> route0(ScheduleVO vo) throws Exception;

    List<ScheduleVO> route1(ScheduleVO vo) throws Exception;

    List<ScheduleVO> route2(ScheduleVO vo) throws Exception;

    List<ScheduleVO> route3(ScheduleVO vo) throws Exception;

    List<ScheduleVO> route4(ScheduleVO vo) throws Exception;

    List<ScheduleVO> route5(ScheduleVO vo) throws Exception;

    List<ScheduleVO> set0(ScheduleVO vo, String dep, String arv) throws Exception;

    List<ScheduleVO> set1(ScheduleVO vo, String dep, String s1, String arv) throws Exception;

    List<ScheduleVO> set2(ScheduleVO vo, String dep, String s1, String s2, String arv) throws Exception;

    List<ScheduleVO> set3(ScheduleVO vo, String dep, String s1, String s2, String s3, String arv) throws Exception;

    List<ScheduleVO> set4(ScheduleVO vo, String dep, String s1, String s2, String s3, String s4, String arv) throws Exception;

    List<ScheduleVO> set5(ScheduleVO vo, String dep, String s1, String s2, String s3, String s4, String s5, String arv) throws Exception;*/


}
