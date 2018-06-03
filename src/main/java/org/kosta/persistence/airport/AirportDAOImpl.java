package org.kosta.persistence.airport;

import org.kosta.domain.airport.AirportVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository
public class AirportDAOImpl implements AirportDAO {

    private final SqlSession sqlSession;

    @Autowired
    public AirportDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    private static final String namespace = "com.kosta.mappers.AirportMapper";

    @Override
    public AirportVO readAll(String airportCode) throws Exception {
        return sqlSession.selectOne(namespace + ".selectAirport", airportCode);
    }

    @Override
    public List<AirportVO> selectAirport2(HashMap<String, Object> param) throws Exception {
        return sqlSession.selectList(namespace + ".selectAirport2", param);
    }

    @Override
    public double readLat(String airportCode) throws Exception {
        return sqlSession.selectOne(namespace + ".readLat", airportCode);
    }

    @Override
    public double readLon(String airportCode) throws Exception {
        return sqlSession.selectOne(namespace + ".readLon", airportCode);
    }


}
