package org.kosta.service;

import org.kosta.domain.ScheduleVO;
import org.kosta.etc.MapSort;
import org.kosta.etc.Permutation;
import org.kosta.etc.TransDate;
import org.kosta.persistence.LowestPriceDAO;
import org.kosta.persistence.ScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LowestPriceServiceImpl implements LowestPriceService {
    private TransDate transDate = TransDate.getInstance();
    private MapSort mapSort = new MapSort();


    @Autowired
    private LowestPriceDAO lowestPriceDAO;

    @Override
    public HashMap<String, Integer> dayHashmap(List<String> stringList, List<Integer> integerList) throws Exception {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < stringList.size(); i++) {
            hashMap.put(stringList.get(i), integerList.get(i));
        }
        return hashMap;
    }

    @Override
    public List<List<String>> permutationList(List<String> stopList, ScheduleVO scheduleVO) throws Exception {

        String[] arr = new String[stopList.size()];
        for (int i = 0; i < stopList.size(); i++) {
            arr[i] = stopList.get(i);
        }

        Permutation permutation = new Permutation(arr.length, arr.length);
        List<List<String>> list = new ArrayList<>();
        permutation.perm(arr, 0, list);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).add(0, scheduleVO.getDep());
            list.get(i).add(scheduleVO.getArv());
        }
        return list;
    }
    @Override
    public List<Integer> LowestListIdx(List<List<String>> listPermutation, Map<String, Integer> hashMapDay, ScheduleVO scheduleVO) throws Exception {
        int count = 0;
        String first_day = scheduleVO.getDepDay();
        Map<Integer, Integer> sumList = new HashMap<>();
        for (int i = 0; i < listPermutation.size(); i++) {
            int sum = 0;
            for (int j = 0; j < listPermutation.get(i).size() - 1; j++) {
                scheduleVO.setDep(listPermutation.get(i).get(j));
                scheduleVO.setArv(listPermutation.get(i).get(j + 1));
                if (j != 0) {
                    scheduleVO.setDepDay(transDate.PlusDate(scheduleVO.getDepDay(), hashMapDay.get(listPermutation.get(i).get(j))));
                }
                if (lowestPriceDAO.selectLowestPrice(scheduleVO) == null) {
                    break;
                } else {
                    sum += lowestPriceDAO.selectLowestPrice(scheduleVO);
                }
                count++;
            }
            scheduleVO.setDepDay(first_day);
            if (sum != 0 && count==listPermutation.get(i).size()-1) {
                sumList.put(i, sum);
            }
            count = 0;
        }
        List<Integer> listTemp = mapSort.ListIdx(sumList);
        return listTemp;
    }

    @Override
    public List<List<ScheduleVO>> result(List<List<String>> listPermutation, Map<String, Integer> hashMapDay, ScheduleVO scheduleVO, List<Integer> listIdx) throws Exception {
        List<List<ScheduleVO>> result = new ArrayList<>();
        String first_day = scheduleVO.getDepDay();
        if (listIdx.size() >= 3) {
            for (int i = 0; i < 3; i++) {
                List<ScheduleVO> temp = new ArrayList<>();
                for (int j = 0; j < listPermutation.get(0).size() - 1; j++) {
                    scheduleVO.setDep(listPermutation.get(listIdx.get(i)).get(j));
                    scheduleVO.setArv(listPermutation.get(listIdx.get(i)).get(j + 1));
                    if (j != 0) {
                        scheduleVO.setDepDay(transDate.PlusDate(scheduleVO.getDepDay(), hashMapDay.get(listPermutation.get(listIdx.get(i)).get(j))));
                    }
                    temp.add(lowestPriceDAO.selectLowestSche(scheduleVO));
                }
                scheduleVO.setDepDay(first_day);
                result.add(temp);
            }
        }
        return result;
    }
}
