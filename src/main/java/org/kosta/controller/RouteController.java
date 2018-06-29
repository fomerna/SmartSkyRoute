package org.kosta.controller;

import org.kosta.domain.AirportVO;
import org.kosta.domain.Stop;
import org.kosta.domain.ScheduleVO;
import org.kosta.service.AirportService;
import org.kosta.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class RouteController {

    private AirportService airportService;

    private ScheduleService scheduleService;

    @Autowired
    public RouteController(AirportService airportService, ScheduleService scheduleService) {
        this.airportService = airportService;
        this.scheduleService = scheduleService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String route() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String route(ScheduleVO scheduleVO, Stop stop, Model model) throws Exception {
        List<String> code_list = new ArrayList<>();

        code_list.add(scheduleVO.getDep());
        code_list.add(scheduleVO.getArv());
        code_list.addAll(1, stop.StopList(stop));
        List<String> result = new ArrayList<>();
        result = airportService.route(code_list);


        List<List<ScheduleVO>> randomSch = scheduleService.randomSch(result, scheduleVO.getDepDay(), scheduleVO.getArvDay());
        List<List<AirportVO>> city = scheduleService.selectCity(randomSch);
        model.addAttribute("list", randomSch);
        model.addAttribute("city", city);


        return "/airport/result";
    }

    @RequestMapping(value = "/round", method = RequestMethod.POST)
    public String round(ScheduleVO scheduleVO, Model model) throws Exception {


        List<String> codeList = new ArrayList<>();

        codeList.add(scheduleVO.getDep());
        codeList.add(scheduleVO.getArv());
        List<AirportVO> listAirport = new ArrayList<>();
        listAirport.add(airportService.readAllService(scheduleVO.getDep()));
        listAirport.add(airportService.readAllService(scheduleVO.getArv()));
        List<List<ScheduleVO>> round = scheduleService.round(codeList, scheduleVO.getDepDay(), scheduleVO.getArvDay());
        model.addAttribute("city",listAirport);
        model.addAttribute("list", round);

        return "/airport/roundResult";
    }

    @RequestMapping(value = "Airport/{dep}/{arv}",method=RequestMethod.GET)
    public ResponseEntity<List<AirportVO>> airportJson(@PathVariable String dep,@PathVariable String arv){
        ResponseEntity<List<AirportVO>> entity = null;
        List<AirportVO> temp = new ArrayList<>();
        try{
            temp.add(airportService.readAllService(dep));
            temp.add(airportService.readAllService(arv));
            entity = new ResponseEntity<>(temp,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }


    @RequestMapping(value = "/reRoute/{dep}/{depDay}/{arv}/{col}/{order}", method = RequestMethod.GET)
    public ResponseEntity<List<ScheduleVO>> reRoute(@PathVariable String dep, @PathVariable String depDay, @PathVariable String arv, @PathVariable String col, @PathVariable String order) throws Exception {
        ScheduleVO scheduleVO = new ScheduleVO(dep, depDay, arv);
        HashMap<String, Object> param = new HashMap<>();
        param.put("dep", dep);
        param.put("arv", arv);
        param.put("depDay", depDay);
        param.put("col", col);
        param.put("order", order);
        ResponseEntity<List<ScheduleVO>> entity = null;
        try {
            entity = new ResponseEntity<>(scheduleService.selectReRouteService(param), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "/routeMore/{dep}/{depDay}/{arv}/{col}/{order}/{str_input}", method = RequestMethod.GET)
    public ResponseEntity<List<ScheduleVO>> routeMore(@PathVariable String dep, @PathVariable String depDay, @PathVariable String arv, @PathVariable String col, @PathVariable String order, @PathVariable int str_input) throws Exception {
        ScheduleVO scheduleVO = new ScheduleVO(dep, depDay, arv);
        HashMap<String, Object> param = new HashMap<>();
        param.put("dep", dep);
        param.put("arv", arv);
        param.put("depDay", depDay);
        param.put("col", col);
        param.put("order", order);
        param.put("str_input", str_input * 5);
        ResponseEntity<List<ScheduleVO>> entity = null;
        try {
            entity = new ResponseEntity<>(scheduleService.selectReRouteMoreService(param), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "routeSno/{sno}", method = RequestMethod.GET)
    public ResponseEntity<ScheduleVO> routeSno(@PathVariable int sno) {
        ResponseEntity<ScheduleVO> entity = null;
        try {
            entity = new ResponseEntity<>(scheduleService.routeSnoService(sno), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

}

