
package org.kosta.service.schedule;

import org.kosta.domain.schedule.ScheduleVO;
import org.kosta.etc.TransDate;
import org.kosta.persistence.schedule.ScheduleDAO;
import org.kosta.service.airport.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private static final TransDate transDate = new TransDate();

    private final ScheduleDAO scheduleDAO;

    private final AirportService airportService;

    @Autowired
    public ScheduleServiceImpl(ScheduleDAO scheduleDAO, AirportService airportService) {
        this.scheduleDAO = scheduleDAO;
        this.airportService = airportService;
    }

    @Override
    public List<List<ScheduleVO>> randomSch(List<String> result, String DepDay, String ArvDay) throws Exception {
         List<List<ScheduleVO>> randomsch = new ArrayList<>();
        List<String> listDay = transDate.gapDate(DepDay,ArvDay);
        ScheduleVO vo = new ScheduleVO();
        for (int i = 0; i <result.size()-1; i++) {
            vo.setDep(result.get(i));
            vo.setArv(result.get(i+1));
            if(i==0){
                vo.setDepDay(listDay.get(0));
            }else if(i==result.size()-2){
                vo.setArvDay(listDay.get(listDay.size()-1));
                randomsch.add(scheduleDAO.selectArvday(vo));
                break;
            }else{
                vo.setDepDay(listDay.get(i*((listDay.size()/(result.size()-2)))));
            }
            randomsch.add(scheduleDAO.selectDepday(vo));
        }
        return randomsch;
    }

    @Override
    public List<ScheduleVO> selectReRouteService(HashMap<String,Object> param) throws Exception {
        return scheduleDAO.selectReRoute(param);
    }

    @Override
    public List<ScheduleVO> selectReRouteMoreService(HashMap<String, Object> param) throws Exception {
        return scheduleDAO.selectReRouteMore(param);
    }
}

