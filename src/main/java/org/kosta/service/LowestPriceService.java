package org.kosta.service;

import org.kosta.domain.ScheduleVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface LowestPriceService {
        HashMap<String,Integer> dayHashmap(List<String> stringList, List<Integer> integerList)throws Exception;

        List<List<String>> permutationList(List<String> stopList, ScheduleVO scheduleVO)throws Exception;

        List<Integer> LowestListIdx(List<List<String>> listPermutation, Map<String, Integer> hashMapDay, ScheduleVO scheduleVO)throws  Exception;

        List<List<ScheduleVO>> result(List<List<String>> listPermutation, Map<String, Integer> hashMapDay, ScheduleVO scheduleVO, List<Integer> listIdx)throws Exception;
}
