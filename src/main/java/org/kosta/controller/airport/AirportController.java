package org.kosta.controller.airport;

import org.kosta.service.airport.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/airport/")
public class AirportController {

    private static final Logger logger = LoggerFactory.getLogger(AirportController.class);

    private final AirportService service;

    @Autowired
    public AirportController(AirportService service) {
        this.service = service;
    }


    @RequestMapping(value = "read", method = RequestMethod.GET)
    public void read(@RequestParam("airportCode") String airportCode, Model model) throws Exception {

        logger.info("read......");
        model.addAttribute("airport", service.readAll(airportCode));

    }

    @RequestMapping(value = "calkm", method = RequestMethod.GET)
    public String calkm(@RequestParam("dep") String dep, @RequestParam("arv") String arv, Model model) throws Exception {

        logger.info((
                Integer.toString(
                        service.calKm(dep, arv)
                )) + "Km");
        logger.info("==============================");

        model.addAttribute("airport", service.calKm(dep, arv));

        return "airport/calkm";
    }

@RequestMapping(value = "route", method = RequestMethod.GET)
public String route() throws Exception{
        return "airport/route";
}

    @RequestMapping(value = "calc", method = RequestMethod.GET)
    public String calc() throws Exception{
        return "airport/calc";
    }

    @RequestMapping(value = "route0", method = RequestMethod.GET)
    public String route0(@RequestParam("dep") String dep, @RequestParam("arv") String arv, Model model) throws Exception {


        model.addAttribute("route0", service.route0(dep, arv));

        return "airport/route0";
    }

    @RequestMapping(value = "route1", method = RequestMethod.GET)
    public String route1(@RequestParam("dep") String dep, @RequestParam("s1") String s1, @RequestParam("arv") String arv, Model model) throws Exception {


        model.addAttribute("route1", service.route1(dep, arv, s1));

        return "airport/route1";
    }

    @RequestMapping(value = "route2", method = RequestMethod.GET)
    public String route2(@RequestParam("dep") String dep, @RequestParam("arv") String arv, @RequestParam("s1") String s1, @RequestParam("s2") String s2, Model model) throws Exception {


        model.addAttribute("route2", service.route2(dep, arv, s1, s2));

        return "airport/route2";
    }

    @RequestMapping(value = "route3", method = {RequestMethod.GET,RequestMethod.POST})
    public String route3(@RequestParam("dep") String dep, @RequestParam("arv") String arv, @RequestParam("s1") String s1, @RequestParam("s2") String s2, @RequestParam("s3") String s3, Model model) throws Exception {


        model.addAttribute("route3", service.route3(dep, arv, s1, s2, s3));

        return "airport/route3";
    }

    @RequestMapping(value = "route4", method = RequestMethod.GET)
    public String route4(@RequestParam("dep") String dep, @RequestParam("arv") String arv, @RequestParam("s1") String s1, @RequestParam("s2") String s2, @RequestParam("s3") String s3, @RequestParam("s4") String s4, Model model) throws Exception {


        model.addAttribute("route4", service.route4(dep, arv, s1, s2, s3, s4));

        return "airport/route4";
    }

    @RequestMapping(value = "route5", method = RequestMethod.GET)
    public String route5(@RequestParam("dep") String dep, @RequestParam("arv") String arv, @RequestParam("s1") String s1, @RequestParam("s2") String s2, @RequestParam("s3") String s3, @RequestParam("s4") String s4, @RequestParam("s5") String s5, Model model) throws Exception {


        model.addAttribute("route5", service.route5(dep, arv, s1, s2, s3, s4, s5));

        return "airport/route5";
    }

}
