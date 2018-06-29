package org.kosta.controller;

import com.fasterxml.jackson.annotation.JacksonInject;
import org.kosta.domain.ScheduleVO;
import org.kosta.domain.Stop;
import org.kosta.domain.StopDay;
import org.kosta.etc.Permutation;
import org.kosta.etc.TransDate;
import org.kosta.service.LowestPriceService;
import org.kosta.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.plaf.metal.MetalIconFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class LowestPriceController {
    @Autowired
    private LowestPriceService lowestPriceService;

    private TransDate transDate = TransDate.getInstance();

    @RequestMapping(value = "LowestPrice", method = RequestMethod.POST)
    public String LowestPrice(ScheduleVO scheduleVO, Stop stop, StopDay stopDay, Model model) throws Exception {
        List<List<ScheduleVO>> result = new ArrayList<>();
        List<String> stopList = stop.StopList(stop);
        List<Integer> stopDayList = stopDay.StopDayList(stopDay);

        //거주지역 - 거주일
        HashMap<String, Integer> hashMapDay = lowestPriceService.dayHashmap(stopList, stopDayList);

        //순열 결과 List<List<String>>
        List<List<String>> listPermutation = lowestPriceService.permutationList(stopList, scheduleVO);

        List<Integer> listIdx = lowestPriceService.LowestListIdx(listPermutation, hashMapDay, scheduleVO);

        result = lowestPriceService.result(listPermutation, hashMapDay, scheduleVO, listIdx);

        model.addAttribute("result", result);


        return "/airport/LowestRoute";
    }


}
