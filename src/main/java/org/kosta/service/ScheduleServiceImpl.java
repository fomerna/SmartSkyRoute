
package org.kosta.service;

import org.kosta.domain.AirportVO;
import org.kosta.domain.ScheduleVO;
import org.kosta.etc.TransDate;
import org.kosta.persistence.AirportDAO;
import org.kosta.persistence.ScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public ScheduleVO routeSnoService(int sno) throws Exception {
        return scheduleDAO.routeSno(sno);
    }


    private static final TransDate transDate = new TransDate();

    private final ScheduleDAO scheduleDAO;

    private final AirportDAO airportDAO;

    @Autowired
    public ScheduleServiceImpl(ScheduleDAO scheduleDAO, AirportDAO airportDAO) {
        this.scheduleDAO = scheduleDAO;
        this.airportDAO = airportDAO;
    }

    @Override
    public List<List<ScheduleVO>> randomSch(List<String> result, String DepDay, String ArvDay) throws Exception {
        List<List<ScheduleVO>> randomsch = new ArrayList<>();
        List<String> listDay = transDate.gapDate(DepDay, ArvDay);
        ScheduleVO vo = new ScheduleVO();
        for (int i = 0; i < result.size() - 1; i++) {
            vo.setDep(result.get(i));
            vo.setArv(result.get(i + 1));
            if (i == 0) {
                vo.setDepDay(listDay.get(0));
            } else if (i == result.size() - 2) {
                vo.setArvDay(listDay.get(listDay.size() - 1));
                randomsch.add(scheduleDAO.selectArvday(vo));
                break;
            } else {
                vo.setDepDay(listDay.get(i * ((listDay.size() / (result.size() - 2)))));
            }
            randomsch.add(scheduleDAO.selectDepday(vo));
        }
        return randomsch;
    }

    @Override
    public List<List<ScheduleVO>> round(List<String> result, String DepDay, String ArvDay) throws Exception {

        List<List<ScheduleVO>> round = new ArrayList<>();
        ScheduleVO vo = new ScheduleVO();


        vo.setDep(result.get(0));
        vo.setArv(result.get(1));

        vo.setDepDay(DepDay);


        round.add(scheduleDAO.selectDepday(vo));


        vo.setDep(result.get(1));
        vo.setArv(result.get(0));

        vo.setDepDay(ArvDay);


        round.add(scheduleDAO.selectDepday(vo));

        return round;
    }


    @Override

    public List<ScheduleVO> selectReRouteService(HashMap<String, Object> param) throws Exception {
        return scheduleDAO.selectReRoute(param);
    }

    @Override
    public List<ScheduleVO> selectReRouteMoreService(HashMap<String, Object> param) throws Exception {
        return scheduleDAO.selectReRouteMore(param);
    }

    @Override
    public List<List<AirportVO>> selectCity(List<List<ScheduleVO>> randomSch) throws Exception {
        List<List<AirportVO>> listAirport = new ArrayList<>();

        for (int i = 0; i < randomSch.size(); i++) {
            List<AirportVO> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(airportDAO.readAll(randomSch.get(i).get(0).getDep()));
                temp.add(airportDAO.readAll(randomSch.get(i).get(0).getArv()));
            } else {
                temp.add(airportDAO.readAll(randomSch.get(i).get(0).getDep()));
                temp.add(airportDAO.readAll(randomSch.get(i).get(0).getArv()));
            }
            listAirport.add(temp);
        }
        return listAirport;
    }
}

