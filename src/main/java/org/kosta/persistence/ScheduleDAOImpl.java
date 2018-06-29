package org.kosta.persistence;


import org.apache.ibatis.session.SqlSession;
import org.kosta.domain.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {


    private final SqlSession sqlSession;

    @Autowired
    public ScheduleDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    private static final String namespace = "com.kosta.mappers.schedule.scheduleMapper";

    @Override
    public List<ScheduleVO> readAll(ScheduleVO vo) throws Exception {
        return sqlSession.selectList(namespace + ".selectSchedule", vo);
    }

    @Override
    public List<ScheduleVO> selectDepday(ScheduleVO scheduleVO) throws Exception {
        return sqlSession.selectList(namespace+".selectDepday",scheduleVO);
    }

    @Override
    public List<ScheduleVO> selectArvday(ScheduleVO scheduleVO) throws Exception {
        return sqlSession.selectList(namespace+".selectArvday",scheduleVO);
    }

    @Override
    public ScheduleVO selectPriceDepday(ScheduleVO scheduleVO) throws Exception {
        return sqlSession.selectOne(namespace+".selectPriceDepday",scheduleVO);
    }

    @Override
    public ScheduleVO selectPriceArvday(ScheduleVO scheduleVO) throws Exception {
        return sqlSession.selectOne(namespace+".selectPriceArvday",scheduleVO);
    }

    @Override
    public List<ScheduleVO> selectReRoute(HashMap<String,Object> param) throws Exception {
        return sqlSession.selectList(namespace+".selectReRoute",param);
    }

    @Override
    public ScheduleVO routeSno(int sno) throws Exception {
        return sqlSession.selectOne(namespace+".routeSno",sno);
    }


    @Override
    public List<ScheduleVO> selectReRouteMore(HashMap<String, Object> param) throws Exception {
        return sqlSession.selectList(namespace+".selectReRouteMore",param);
    }
}
