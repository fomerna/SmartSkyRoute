package org.kosta.deal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.domain.ScheduleVO;
import org.kosta.service.dealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})

public class dealDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(dealDAOTest.class);

    @Autowired
    private dealService service;


    @Test
    public void dealRead() throws Exception {

        ScheduleVO vo = new ScheduleVO();

        vo.setDep("ICN");
        vo.setDepDay("2018-07-02");


        logger.info(service.deal(vo).toString());

    }
}


