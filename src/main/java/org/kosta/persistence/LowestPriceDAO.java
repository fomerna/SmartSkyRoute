package org.kosta.persistence;

import org.kosta.domain.ScheduleVO;

public interface LowestPriceDAO {
    Integer selectLowestPrice(ScheduleVO scheduleVO)throws Exception;

    ScheduleVO selectLowestSche(ScheduleVO scheduleVO)throws Exception;

}
