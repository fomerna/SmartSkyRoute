package org.kosta.service;


import org.kosta.domain.AirportVO;
import org.kosta.domain.ScheduleVO;
import org.kosta.persistence.dealDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class dealServiceImpl implements dealService{


    private final dealDAO dao;

    @Autowired
    public dealServiceImpl(dealDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<ScheduleVO> deal(ScheduleVO vo) throws Exception {
        return dao.deal(vo);
    }

    @Override
    public AirportVO selectAirportCodeService(String airportCode) throws Exception {
        return dao.selectAirportCode(airportCode);
    }


}
