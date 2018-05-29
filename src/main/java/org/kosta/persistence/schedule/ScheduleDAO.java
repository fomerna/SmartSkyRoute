package org.kosta.persistence.schedule;

import org.kosta.domain.schedule.ScheduleVO;

import java.util.List;

public interface ScheduleDAO {

   List<ScheduleVO> readAll(ScheduleVO vo) throws Exception;
}
