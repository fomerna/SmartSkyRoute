/*
package org.kosta.schedule;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.domain.schedule.ScheduleVO;
import org.kosta.persistence.schedule.ScheduleDAO;
import org.kosta.service.airport.AirportService;
import org.kosta.service.schedule.ScheduleService;
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
    public void testReadAll() throws Exception {

        ScheduleVO vo = new ScheduleVO();
        List<List<ScheduleVO>> result = new ArrayList<>();
        airportService.route2("PVG", "MAD", "PEK", "ICN");


        vo.setDep(airportService.route2("PVG", "MAD", "PEK", "ICN").get(0));
        vo.setArv(airportService.route2("PVG", "MAD", "PEK", "ICN").get(1));
        logger.info(scheduleService.route2(vo).toString());

        result.add(scheduleService.route2(vo));

        vo.setDep(airportService.route2("PVG", "MAD", "PEK", "ICN").get(1));
        vo.setArv(airportService.route2("PVG", "MAD", "PEK", "ICN").get(2));

        result.add(scheduleService.route2(vo));

        vo.setDep(airportService.route2("PVG", "MAD", "PEK", "ICN").get(2));
        vo.setArv(airportService.route2("PVG", "MAD", "PEK", "ICN").get(3));

        result.add(scheduleService.route2(vo));
        logger.info(result.toString());


    }
}
*/
