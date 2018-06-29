package org.kosta.persistence;


import org.apache.ibatis.session.SqlSession;
import org.kosta.domain.AirportVO;
import org.kosta.domain.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class dealDAOImpl implements dealDAO{


    private final SqlSession sqlSession;

    @Autowired
    public dealDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    private static final String namespace = "com.kosta.mappers.DealMapper";


    @Override
    public List<ScheduleVO> deal(ScheduleVO vo) throws Exception {
        return sqlSession.selectList(namespace + ".deal",vo);
    }

    @Override
    public AirportVO selectAirportCode(String airportCode) throws Exception {
        return sqlSession.selectOne(namespace+".selectAirportCode",airportCode);
    }
}
