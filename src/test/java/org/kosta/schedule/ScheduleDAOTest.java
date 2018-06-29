package org.kosta.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.domain.AirportVO;
import org.kosta.domain.ScheduleVO;
import org.kosta.etc.TransDate;
import org.kosta.persistence.ScheduleDAO;
import org.kosta.service.AirportService;
import org.kosta.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class ScheduleDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleDAOTest.class);


    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private AirportService airportService;


    @Test
    public void test() throws Exception {

        List<AirportVO> airportList = new ArrayList<>();

        TransDate transDate = new TransDate();
        List<List<ScheduleVO>> round = new ArrayList<>();
        ScheduleVO scheduleVO = new ScheduleVO();

        AirportVO airportVO = new AirportVO();
        AirportVO airportVO2 = new AirportVO();

        airportVO.setAirportCode("ICN");
        airportList.add(airportVO);
        airportVO2.setAirportCode("NRT");
        airportList.add(airportVO2);

        String depDay="2018-07-01";
        String arvDay="2018-07-05";





        logger.info(scheduleService.round(airportService.route(airportList),depDay,arvDay).toString());
    }
}
