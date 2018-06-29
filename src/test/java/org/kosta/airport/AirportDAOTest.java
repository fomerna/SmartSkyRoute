/*

package org.kosta.airport;

import org.kosta.domain.AirportVO;
import org.kosta.persistence.AirportDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kosta.service.AirportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/applicationContext.xml"})
public class AirportDAOTest {

    private static final Logger logger = LoggerFactory.getLogger(AirportDAOTest.class);

    @Autowired
    private AirportDAO airportDAO;

    @Autowired
    private AirportService service;

    @Test
    public void lat() throws Exception {
        System.out.println(airportDAO.readLat("LHR"));
    }

    @Test
    public void testIn() throws Exception{

        List<String> code_list = new ArrayList<>();

        code_list.add("NRT");
        code_list.add("ICN");
        code_list.add("FCO");
        code_list.add("CDG");
        code_list.add("PVG");
        code_list.add("PEK");

        HashMap<String,Object> param= new HashMap<>();

        param.put("code_list", code_list);

        List<AirportVO> airportVOList;
        airportVOList=airportDAO.selectAirport2(param);

        logger.info(airportVOList.get(0).getAirportCode());



    }

    @Test
    public void testReadAll() throws Exception {

        logger.info(airportDAO.readAll("BCN").toString());
    }

    @Test
    public void testCalKm() throws Exception {

        logger.info((
                Integer.toString(
                        service.calKm("ICN", "BCN")
                )) + "Km"
        );
        logger.info("=======================================");
    }

    @Test
    public void testRoute() throws Exception {


        ArrayList<String> airport0 = new ArrayList<>();
        ArrayList<String> airport1 = new ArrayList<>();

        List<String> airport = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("출발지: ");
        String dep = sc.nextLine();
        System.out.print("도착지: ");
        String arr = sc.nextLine();
        String stops;

        airport0.add(dep);
        airport0.add(arr);

        System.out.print("경유지 개수: ");
        int a = sc.nextInt();


        for (int i = 0; i < a; i++) {
            System.out.print(i + "번: ");
            stops = sc.nextLine();
            airport1.add(stops);
        }

        sc.close();

        if (a == 0) {

            service.calKm(airport0.get(0), airport0.get(1));

            airport.addAll(airport0);

            logger.info(String.valueOf(service.calKm(airport0.get(0), airport0.get(1))));
            logger.info(airport.toString());

        } else if (a == 1) {


            // 1차

            ArrayList<Integer> dist1 = new ArrayList<>();
            HashMap<Integer, String> map1 = new HashMap<>();

            for (int i = 0; i < airport1.size(); i++) {

                dist1.add(service.calKm(airport0.get(0), airport1.get(i)));
                map1.put(dist1.get(i), airport1.get(i));
            }

            logger.info(airport1.toString());
            logger.info(dist1.toString());
            logger.info(map1.toString());

            logger.info(map1.get(Collections.min(dist1)));

            airport.add(airport0.get(0));
            airport.add(map1.get(Collections.min(dist1)));

            // 도착

            airport.add(airport0.get(1));
            logger.info(String.valueOf(service.calKm(map1.get(Collections.min(dist1)), airport0.get(1))));

            logger.info(airport.toString());


        } else if (a == 2) {


            // 1차

            ArrayList<Integer> dist1 = new ArrayList<>();
            HashMap<Integer, String> map1 = new HashMap<>();

            for (int i = 0; i < airport1.size(); i++) {

                dist1.add(service.calKm(airport0.get(0), airport1.get(i)));
                map1.put(dist1.get(i), airport1.get(i));
            }

            logger.info(airport1.toString());
            logger.info(dist1.toString());
            logger.info(map1.toString());

            logger.info(map1.get(Collections.min(dist1)));

            airport.add(airport0.get(0));
            airport.add(map1.get(Collections.min(dist1)));

            // 2차

            ArrayList<String> airport2 = new ArrayList<>(airport1);
            ArrayList<Integer> dist2 = new ArrayList<>();
            HashMap<Integer, String> map2 = new HashMap<>();

            airport2.remove(map1.get(Collections.min(dist1)));

            for (int i = 0; i < airport2.size(); i++) {
                dist2.add(service.calKm(map1.get(Collections.min(dist1)), airport2.get(i)));
                map2.put(dist2.get(i), airport2.get(i));

            }

            // 도착

            airport.add(airport0.get(1));
            logger.info(String.valueOf(service.calKm(map2.get(Collections.min(dist2)), airport0.get(1))));

            logger.info(airport.toString());


        } else if (a == 3) {


            // 1차

            ArrayList<Integer> dist1 = new ArrayList<>();
            HashMap<Integer, String> map1 = new HashMap<>();

            for (int i = 0; i < airport1.size(); i++) {

                dist1.add(service.calKm(airport0.get(0), airport1.get(i)));
                map1.put(dist1.get(i), airport1.get(i));
            }

            logger.info(airport1.toString());
            logger.info(dist1.toString());
            logger.info(map1.toString());

            logger.info(map1.get(Collections.min(dist1)));

            airport.add(airport0.get(0));
            airport.add(map1.get(Collections.min(dist1)));

            // 2차

            ArrayList<String> airport2 = new ArrayList<>(airport1);
            ArrayList<Integer> dist2 = new ArrayList<>();
            HashMap<Integer, String> map2 = new HashMap<>();

            airport2.remove(map1.get(Collections.min(dist1)));

            for (int i = 0; i < airport2.size(); i++) {
                dist2.add(service.calKm(map1.get(Collections.min(dist1)), airport2.get(i)));
                map2.put(dist2.get(i), airport2.get(i));

            }

            airport.add(map2.get(Collections.min(dist2)));

            // 3차

            ArrayList<String> airport3 = new ArrayList<>(airport2);
            ArrayList<Integer> dist3 = new ArrayList<>();
            HashMap<Integer, String> map3 = new HashMap<>();

            airport3.remove(map2.get(Collections.min(dist2)));

            for (int i = 0; i < airport3.size(); i++) {
                dist3.add(service.calKm(map2.get(Collections.min(dist2)), airport3.get(i)));
                map3.put(dist3.get(i), airport3.get(i));
            }

            airport.add(map3.get(Collections.min(dist3)));


            // 도착

            airport.add(airport0.get(1));
            logger.info(String.valueOf(service.calKm(map3.get(Collections.min(dist3)), airport0.get(1))));

            logger.info(airport.toString());


        } else if (a == 4) {


            // 1차

            ArrayList<Integer> dist1 = new ArrayList<>();
            HashMap<Integer, String> map1 = new HashMap<>();

            for (int i = 0; i < airport1.size(); i++) {

                dist1.add(service.calKm(airport0.get(0), airport1.get(i)));
                map1.put(dist1.get(i), airport1.get(i));
            }

            logger.info(airport1.toString());
            logger.info(dist1.toString());
            logger.info(map1.toString());

            logger.info(map1.get(Collections.min(dist1)));

            airport.add(airport0.get(0));
            airport.add(map1.get(Collections.min(dist1)));

            // 2차

            ArrayList<String> airport2 = new ArrayList<>(airport1);
            ArrayList<Integer> dist2 = new ArrayList<>();
            HashMap<Integer, String> map2 = new HashMap<>();

            airport2.remove(map1.get(Collections.min(dist1)));

            for (int i = 0; i < airport2.size(); i++) {
                dist2.add(service.calKm(map1.get(Collections.min(dist1)), airport2.get(i)));
                map2.put(dist2.get(i), airport2.get(i));

            }

            airport.add(map2.get(Collections.min(dist2)));

            // 3차

            ArrayList<String> airport3 = new ArrayList<>(airport2);
            ArrayList<Integer> dist3 = new ArrayList<>();
            HashMap<Integer, String> map3 = new HashMap<>();

            airport3.remove(map2.get(Collections.min(dist2)));

            for (int i = 0; i < airport3.size(); i++) {
                dist3.add(service.calKm(map2.get(Collections.min(dist2)), airport3.get(i)));
                map3.put(dist3.get(i), airport3.get(i));
            }

            airport.add(map3.get(Collections.min(dist3)));

            // 4차

            ArrayList<String> airport4 = new ArrayList<>(airport3);
            HashMap<Integer, String> map4 = new HashMap<>();
            ArrayList<Integer> dist4 = new ArrayList<>();

            airport4.remove(map3.get(Collections.min(dist3)));

            for (int i = 0; i < airport4.size(); i++) {
                dist4.add(service.calKm(map3.get(Collections.min(dist3)), airport4.get(i)));
                map4.put(dist4.get(i), airport4.get(i));
            }

            airport.add(map4.get(Collections.min(dist4)));

            // 도착

            airport.add(airport0.get(1));
            logger.info(String.valueOf(service.calKm(map4.get(Collections.min(dist4)), airport0.get(1))));

            logger.info(airport.toString());

        } else if (a == 5) {


            // 1차

            ArrayList<Integer> dist1 = new ArrayList<>();
            HashMap<Integer, String> map1 = new HashMap<>();

            for (int i = 0; i < airport1.size(); i++) {

                dist1.add(service.calKm(airport0.get(0), airport1.get(i)));
                map1.put(dist1.get(i), airport1.get(i));
            }

            logger.info(airport1.toString());
            logger.info(dist1.toString());
            logger.info(map1.toString());

            logger.info(map1.get(Collections.min(dist1)));

            airport.add(airport0.get(0));
            airport.add(map1.get(Collections.min(dist1)));

            // 2차

            ArrayList<String> airport2 = new ArrayList<>(airport1);
            ArrayList<Integer> dist2 = new ArrayList<>();
            HashMap<Integer, String> map2 = new HashMap<>();

            airport2.remove(map1.get(Collections.min(dist1)));

            for (int i = 0; i < airport2.size(); i++) {
                dist2.add(service.calKm(map1.get(Collections.min(dist1)), airport2.get(i)));
                map2.put(dist2.get(i), airport2.get(i));

            }

            airport.add(map2.get(Collections.min(dist2)));

            // 3차

            ArrayList<String> airport3 = new ArrayList<>(airport2);
            ArrayList<Integer> dist3 = new ArrayList<>();
            HashMap<Integer, String> map3 = new HashMap<>();

            airport3.remove(map2.get(Collections.min(dist2)));

            for (int i = 0; i < airport3.size(); i++) {
                dist3.add(service.calKm(map2.get(Collections.min(dist2)), airport3.get(i)));
                map3.put(dist3.get(i), airport3.get(i));
            }

            airport.add(map3.get(Collections.min(dist3)));

            // 4차

            ArrayList<String> airport4 = new ArrayList<>(airport3);
            HashMap<Integer, String> map4 = new HashMap<>();
            ArrayList<Integer> dist4 = new ArrayList<>();

            airport4.remove(map3.get(Collections.min(dist3)));

            for (int i = 0; i < airport4.size(); i++) {
                dist4.add(service.calKm(map3.get(Collections.min(dist3)), airport4.get(i)));
                map4.put(dist4.get(i), airport4.get(i));
            }

            airport.add(map4.get(Collections.min(dist4)));

            // 5차

            ArrayList<String> airport5 = new ArrayList<>(airport4);
            ArrayList<Integer> dist5 = new ArrayList<>();
            HashMap<Integer, String> map5 = new HashMap<>();

            airport5.remove(map4.get(Collections.min(dist4)));

            for (int i = 0; i < airport5.size(); i++) {
                dist5.add(service.calKm(map4.get(Collections.min(dist4)), airport5.get(i)));
                map5.put(dist5.get(i), airport5.get(i));
            }
            airport.add(map5.get(Collections.min(dist5)));

            // 도착

            airport.add(airport0.get(1));
            logger.info(String.valueOf(service.calKm(map5.get(Collections.min(dist5)), airport0.get(1))));

            logger.info(airport.toString());

        }


    }


}
*/
