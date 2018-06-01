
package org.kosta.airport;

import org.kosta.domain.Stop;
import org.kosta.domain.airport.AirportVO;
import org.kosta.domain.schedule.ScheduleVO;
import org.kosta.etc.Permutation;
import org.kosta.etc.TransDate;
import org.kosta.persistence.airport.AirportDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.persistence.schedule.ScheduleDAO;
import org.kosta.service.airport.AirportService;
import org.kosta.service.schedule.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class AirportDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(AirportDAOTest.class);
    private static final TransDate transDate = new TransDate();
    private Permutation permutation;

    @Autowired
    private AirportDAO airportDAO;

    @Autowired
    private AirportService airportService;

    @Autowired
    private ScheduleDAO scheduleDAO;

    @Autowired
    private ScheduleService scheduleService;

    @Test
    public void lat() throws Exception {
        System.out.println(airportDAO.readLat("LHR"));
    }

    @Test
    public void testSelect()throws  Exception{

        List<String> code_list = new ArrayList<>();
        code_list.add("ICN");
        code_list.add("LHR");
        Stop stop = new Stop();
        stop.setS1("NRT");
        code_list.addAll(1,stop.StopList(stop));
        logger.info(code_list.toString());

       /* code_list.add("MXP");
        code_list.add("PEK");*/

  /*      //AirportDAO-TEST
        HashMap<String,Object> param = new HashMap<>();
        param.put("code_list",code_list);
        List<AirportVO> listAirport;
        listAirport=airportDAO.selectAirport2(param);


        //airportService -최단거리 경로
        List<String> result = airportService.route(listAirport);

        //scheduleService-스케줄 소환
        List<List<ScheduleVO>> totalSch = scheduleService.randomSch(result,"2018-07-1","2018-7-20");*/


        //최저값 찾기s
        //permutation = new Permutation(code_list.size()-2,code_list.size()-2);
      // String[] arr = new String[code_list.size()-2];

    }




}
