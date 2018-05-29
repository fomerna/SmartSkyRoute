package org.kosta.service.schedule;

import org.kosta.domain.schedule.ScheduleVO;
import org.kosta.persistence.schedule.ScheduleDAO;
import org.kosta.service.airport.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleDAO scheduleDAO;

    private final AirportService airportService;

    @Autowired
    public ScheduleServiceImpl(ScheduleDAO scheduleDAO, AirportService airportService) {
        this.scheduleDAO = scheduleDAO;
        this.airportService = airportService;
    }


    @Override
    public List<ScheduleVO> set0(ScheduleVO vo, String dep, String arv) throws Exception {

        List<ScheduleVO> result = new ArrayList<>();

        airportService.route0(dep, arv);

        vo.setDep(airportService.route0(dep, arv).get(0));
        vo.setArv(airportService.route0(dep, arv).get(1));

        result.add(vo);

        return result;
    }

    @Override
    public List<ScheduleVO> set1(ScheduleVO vo, String dep, String s1, String arv) throws Exception {

        List<ScheduleVO> result = new ArrayList<>();

        airportService.route1(dep, arv, s1);

        vo.setDep(airportService.route1(dep, arv, s1).get(0));
        vo.setArv(airportService.route1(dep, arv, s1).get(1));

        result.add(vo);

        vo.setDep(airportService.route1(dep, arv, s1).get(1));
        vo.setArv(airportService.route1(dep, arv, s1).get(2));

        result.add(vo);

        return result;
    }

    @Override
    public List<ScheduleVO> set2(ScheduleVO vo, String dep, String s1, String s2, String arv) throws Exception {

        List<ScheduleVO> result = new ArrayList<>();

        airportService.route2(dep, arv, s1, s2);

        vo.setDep(airportService.route2(dep, arv, s1, s2).get(0));
        vo.setDep(airportService.route2(dep, arv, s1, s2).get(1));

        result.add(vo);

        vo.setDep(airportService.route2(dep, arv, s1, s2).get(1));
        vo.setDep(airportService.route2(dep, arv, s1, s2).get(2));

        result.add(vo);

        vo.setDep(airportService.route2(dep, arv, s1, s2).get(2));
        vo.setDep(airportService.route2(dep, arv, s1, s2).get(3));

        result.add(vo);

        return result;
    }

    @Override
    public List<ScheduleVO> set3(ScheduleVO vo, String dep, String s1, String s2, String s3, String arv) throws Exception {

        List<ScheduleVO> result = new ArrayList<>();

        airportService.route3(dep, arv, s1, s2, s3);

        vo.setDep(airportService.route3(dep, arv, s1, s2, s3).get(0));
        vo.setDep(airportService.route3(dep, arv, s1, s2, s3).get(1));

        result.add(vo);

        vo.setDep(airportService.route3(dep, arv, s1, s2, s3).get(1));
        vo.setDep(airportService.route3(dep, arv, s1, s2, s3).get(2));

        result.add(vo);

        vo.setDep(airportService.route3(dep, arv, s1, s2, s3).get(2));
        vo.setDep(airportService.route3(dep, arv, s1, s2, s3).get(3));

        result.add(vo);

        vo.setDep(airportService.route3(dep, arv, s1, s2, s3).get(3));
        vo.setDep(airportService.route3(dep, arv, s1, s2, s3).get(4));

        result.add(vo);

        return result;
    }

    @Override
    public List<ScheduleVO> set4(ScheduleVO vo, String dep, String s1, String s2, String s3, String s4, String arv) throws Exception {

        List<ScheduleVO> result = new ArrayList<>();

        airportService.route4(dep, arv, s1, s2, s3, s4);

        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(0));
        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(1));

        result.add(vo);
        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(1));
        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(2));

        result.add(vo);

        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(2));
        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(3));

        result.add(vo);

        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(3));
        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(4));

        result.add(vo);

        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(4));
        vo.setDep(airportService.route4(dep, arv, s1, s2, s3, s4).get(5));

        result.add(vo);
        return result;
    }

    @Override
    public List<ScheduleVO> set5(ScheduleVO vo, String dep, String s1, String s2, String s3, String s4, String s5, String arv) throws Exception {

        List<ScheduleVO> result = new ArrayList<>();

        airportService.route5(dep, arv, s1, s2, s3,s4,s5);

        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(0));
        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(1));

        result.add(vo);

        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(1));
        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(2));

        result.add(vo);

        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(2));
        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(3));

        result.add(vo);

        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(3));
        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(4));

        result.add(vo);

        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(4));
        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(5));

        result.add(vo);

        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(5));
        vo.setDep(airportService.route5(dep, arv, s1, s2, s3,s4,s5).get(6));

        result.add(vo);

        return result;
    }

    @Override
    public List<ScheduleVO> route0(ScheduleVO vo) throws Exception {
        return scheduleDAO.readAll(vo);
    }

    @Override
    public List<ScheduleVO> route1(ScheduleVO vo) throws Exception {
        return scheduleDAO.readAll(vo);
    }

    @Override
    public List<ScheduleVO> route2(ScheduleVO vo) throws Exception {
        return scheduleDAO.readAll(vo);
    }

    @Override
    public List<ScheduleVO> route3(ScheduleVO vo) throws Exception {
        return scheduleDAO.readAll(vo);
    }

    @Override
    public List<ScheduleVO> route4(ScheduleVO vo) throws Exception {
        return scheduleDAO.readAll(vo);
    }

    @Override
    public List<ScheduleVO> route5(ScheduleVO vo) throws Exception {
        return null;
    }
}
