package org.kosta.controller;


import org.kosta.domain.AirportVO;
import org.kosta.domain.ScheduleVO;
import org.kosta.service.dealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DealController {

    private dealService service;

    @Autowired
    public DealController(dealService service) {
        this.service = service;
    }

    @RequestMapping(value = "/deal", method = RequestMethod.GET)
    public String deal() throws Exception {

        return "deal";

    }

    @RequestMapping(value = "/deal", method = RequestMethod.POST)
    public String deal1(ScheduleVO vo, Model model) throws Exception {

        List<ScheduleVO> list = service.deal(vo);

        model.addAttribute("list", list);
        return "index";

    }

    @RequestMapping(value = "/input/{dep}/{depDay}", method = RequestMethod.GET)
    public ResponseEntity<List<ScheduleVO>> lowest(@PathVariable String dep, @PathVariable String depDay) throws Exception {

        ScheduleVO vo = new ScheduleVO();
        vo.setDep(dep);
        vo.setDepDay(depDay);
        ResponseEntity<List<ScheduleVO>> entity = null;
        try {
            entity = new ResponseEntity<>(service.deal(vo), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }

    @RequestMapping(value = "/LowestAirport/{dep}/{depDay}", method = RequestMethod.GET)
    public ResponseEntity<List<AirportVO>> LowestAirport(@PathVariable String dep, @PathVariable String depDay) throws Exception {

        ScheduleVO vo = new ScheduleVO();
        vo.setDep(dep);
        vo.setDepDay(depDay);
        ResponseEntity<List<AirportVO>> entity = null;

        try {
            List<AirportVO> listAirport = new ArrayList<>();
            List<ScheduleVO> temp =service.deal(vo);
            listAirport.add(service.selectAirportCodeService(temp.get(0).getArv()));
            listAirport.add(service.selectAirportCodeService(temp.get(1).getArv()));
            listAirport.add(service.selectAirportCodeService(temp.get(2).getArv()));
            entity = new ResponseEntity<>(listAirport, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}
