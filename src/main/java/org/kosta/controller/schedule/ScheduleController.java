package org.kosta.controller.schedule;

import org.kosta.controller.airport.AirportController;
import org.kosta.service.airport.AirportService;
import org.kosta.service.schedule.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/schedule/")
public class ScheduleController {


    private static final Logger logger = LoggerFactory.getLogger(AirportController.class);

    private final AirportService airportService;

    private final ScheduleService scheduleService;


    @Autowired
    public ScheduleController(AirportService airportService, ScheduleService scheduleService) {
        this.airportService = airportService;
        this.scheduleService = scheduleService;
    }

    @RequestMapping(value = "read", method = RequestMethod.GET)
    public void read(@RequestParam("airport") ArrayList<String> airport, Model model) throws Exception {



    }

}
