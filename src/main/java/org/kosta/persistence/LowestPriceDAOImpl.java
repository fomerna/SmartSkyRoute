package org.kosta.persistence;

import org.apache.ibatis.session.SqlSession;
import org.kosta.domain.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.xml.stream.events.Namespace;

@Repository
public class LowestPriceDAOImpl implements LowestPriceDAO {
    private static final String namespace = "com.kosta.mappers.lowestMapper";

    private final SqlSession sqlSession;

    @Autowired
    public LowestPriceDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }


    @Override
    public Integer selectLowestPrice(ScheduleVO scheduleVO) throws Exception {
        return sqlSession.selectOne(namespace+".selectLowestPrice",scheduleVO);
    }

    @Override
    public ScheduleVO selectLowestSche(ScheduleVO scheduleVO) throws Exception {
        return sqlSession.selectOne(namespace+".selectLowestSche",scheduleVO);
    }
}
