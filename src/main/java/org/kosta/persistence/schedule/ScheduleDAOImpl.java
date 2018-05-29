package org.kosta.persistence.schedule;


import org.apache.ibatis.session.SqlSession;
import org.kosta.domain.schedule.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
