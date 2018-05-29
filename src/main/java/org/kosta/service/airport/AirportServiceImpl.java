package org.kosta.service.airport;

import org.kosta.domain.airport.AirportVO;
import org.kosta.persistence.airport.AirportDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;


@Service
public class AirportServiceImpl implements AirportService {

    private final AirportDAO airportDAO;

    @Autowired
    public AirportServiceImpl(AirportDAO airportDAO) {
        this.airportDAO = airportDAO;
    }

    // 1개 공항의 모든 정보 Read
    @Override
    public AirportVO readAll(String airportCode) throws Exception {
        return airportDAO.readAll(airportCode);
    }

    // lat Read
    @Override
    public double readLat(String airportCode) throws Exception {
        return airportDAO.readLat(airportCode);
    }

    // lon Read
    @Override
    public double readLon(String airportCode) throws Exception {
        return airportDAO.readLon(airportCode);
    }


    // a--b 위도 & 경도 => km 계산 (double -> int)
    @Override
    public int calKm(String a, String b) throws Exception {

        double theta = airportDAO.readLon(a) - airportDAO.readLon(b);


        double dist = Math.sin(deg2rad(airportDAO.readLat(a))) * Math.sin(deg2rad(airportDAO.readLat(b))) + Math.cos(deg2rad(airportDAO.readLat(a)))
                * Math.cos(deg2rad(airportDAO.readLat(b))) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;

        DecimalFormat decimalFormat = new DecimalFormat("#");

        return Integer.parseInt(decimalFormat.format(dist));
    }

    // converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }


    @Override
    public List<String> route0(String dep, String arv) throws Exception {

        ArrayList<String> airport0 = new ArrayList<>();


        airport0.add(dep);
        airport0.add(arv);

        calKm(airport0.get(0), airport0.get(1));

        List<String> airport = new ArrayList<>(airport0);

        System.out.print(String.valueOf(calKm(airport0.get(0), airport0.get(1))));
        System.out.print(airport.toString());

        return airport;
    }

    @Override
    public List<String> route1(String dep, String arv, String s1) throws Exception {
        ArrayList<String> airport0 = new ArrayList<>();
        List<String> airport = new ArrayList<>();


        airport0.add(dep);
        airport0.add(arv);

        // 1차
        ArrayList<String> airport1 = new ArrayList<>();

        airport1.add(s1);

        ArrayList<Integer> dist1 = new ArrayList<>();
        HashMap<Integer, String> map1 = new HashMap<>();


        for (int i = 0; i < airport1.size(); i++) {

            dist1.add(calKm(airport0.get(0), airport1.get(i)));
            map1.put(dist1.get(i), airport1.get(i));
        }

        System.out.print(airport1.toString());
        System.out.print(dist1.toString());
        System.out.print(map1.toString());

        System.out.print(map1.get(Collections.min(dist1)));

        airport.add(airport0.get(0));
        airport.add(map1.get(Collections.min(dist1)));

        // 도착

        airport.add(airport0.get(1));
        System.out.print(String.valueOf(calKm(map1.get(Collections.min(dist1)), airport0.get(1))));

        System.out.print(airport.toString());

        return airport;
    }

    @Override
    public List<String> route2(String dep, String arv, String s1, String s2) throws Exception {

        ArrayList<String> airport0 = new ArrayList<>();
        List<String> airport = new ArrayList<>();


        airport0.add(dep);
        airport0.add(arv);

        // 1차
        ArrayList<String> airport1 = new ArrayList<>();

        airport1.add(s1);
        airport1.add(s2);

        ArrayList<Integer> dist1 = new ArrayList<>();
        HashMap<Integer, String> map1 = new HashMap<>();


        for (int i = 0; i < airport1.size(); i++) {

            dist1.add(calKm(airport0.get(0), airport1.get(i)));
            map1.put(dist1.get(i), airport1.get(i));
        }

        System.out.print(airport1.toString());
        System.out.print(dist1.toString());
        System.out.print(map1.toString());

        System.out.print(map1.get(Collections.min(dist1)));

        airport.add(airport0.get(0));
        airport.add(map1.get(Collections.min(dist1)));

        // 2차

        ArrayList<String> airport2 = new ArrayList<>(airport1);
        ArrayList<Integer> dist2 = new ArrayList<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        airport2.remove(map1.get(Collections.min(dist1)));

        for (int i = 0; i < airport2.size(); i++) {
            dist2.add(calKm(map1.get(Collections.min(dist1)), airport2.get(i)));
            map2.put(dist2.get(i), airport2.get(i));

        }

        airport.add(map2.get(Collections.min(dist2)));

        // 도착

        airport.add(airport0.get(1));
        System.out.print(String.valueOf(calKm(map2.get(Collections.min(dist2)), airport0.get(1))));

        System.out.print(airport.toString());

        return airport;

    }

    @Override
    public List<String> route3(String dep, String arv, String s1, String s2, String s3) throws Exception {


        ArrayList<String> airport0 = new ArrayList<>();
        List<String> airport = new ArrayList<>();


        airport0.add(dep);
        airport0.add(arv);

        // 1차
        ArrayList<String> airport1 = new ArrayList<>();

        airport1.add(s1);
        airport1.add(s2);
        airport1.add(s3);

        ArrayList<Integer> dist1 = new ArrayList<>();
        HashMap<Integer, String> map1 = new HashMap<>();


        for (int i = 0; i < airport1.size(); i++) {

            dist1.add(calKm(airport0.get(0), airport1.get(i)));
            map1.put(dist1.get(i), airport1.get(i));
        }

        System.out.print(airport1.toString());
        System.out.print(dist1.toString());
        System.out.print(map1.toString());

        System.out.print(map1.get(Collections.min(dist1)));

        airport.add(airport0.get(0));
        airport.add(map1.get(Collections.min(dist1)));

        // 2차

        ArrayList<String> airport2 = new ArrayList<>(airport1);
        ArrayList<Integer> dist2 = new ArrayList<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        airport2.remove(map1.get(Collections.min(dist1)));

        for (int i = 0; i < airport2.size(); i++) {
            dist2.add(calKm(map1.get(Collections.min(dist1)), airport2.get(i)));
            map2.put(dist2.get(i), airport2.get(i));

        }

        airport.add(map2.get(Collections.min(dist2)));

        // 3차

        ArrayList<String> airport3 = new ArrayList<>(airport2);
        ArrayList<Integer> dist3 = new ArrayList<>();
        HashMap<Integer, String> map3 = new HashMap<>();

        airport3.remove(map2.get(Collections.min(dist2)));

        for (int i = 0; i < airport3.size(); i++) {
            dist3.add(calKm(map2.get(Collections.min(dist2)), airport3.get(i)));
            map3.put(dist3.get(i), airport3.get(i));
        }

        airport.add(map3.get(Collections.min(dist3)));


        // 도착

        airport.add(airport0.get(1));
        System.out.print(String.valueOf(calKm(map3.get(Collections.min(dist3)), airport0.get(1))));

        System.out.print(airport.toString());

        return airport;
    }

    @Override
    public List<String> route4(String dep, String arv, String s1, String s2, String s3, String s4) throws Exception {

        ArrayList<String> airport0 = new ArrayList<>();
        List<String> airport = new ArrayList<>();


        airport0.add(dep);
        airport0.add(arv);

        // 1차
        ArrayList<String> airport1 = new ArrayList<>();

        airport1.add(s1);
        airport1.add(s2);
        airport1.add(s3);
        airport1.add(s4);

        ArrayList<Integer> dist1 = new ArrayList<>();
        HashMap<Integer, String> map1 = new HashMap<>();


        for (int i = 0; i < airport1.size(); i++) {

            dist1.add(calKm(airport0.get(0), airport1.get(i)));
            map1.put(dist1.get(i), airport1.get(i));
        }

        System.out.print(airport1.toString());
        System.out.print(dist1.toString());
        System.out.print(map1.toString());

        System.out.print(map1.get(Collections.min(dist1)));

        airport.add(airport0.get(0));
        airport.add(map1.get(Collections.min(dist1)));

        // 2차

        ArrayList<String> airport2 = new ArrayList<>(airport1);
        ArrayList<Integer> dist2 = new ArrayList<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        airport2.remove(map1.get(Collections.min(dist1)));

        for (int i = 0; i < airport2.size(); i++) {
            dist2.add(calKm(map1.get(Collections.min(dist1)), airport2.get(i)));
            map2.put(dist2.get(i), airport2.get(i));

        }

        airport.add(map2.get(Collections.min(dist2)));

        // 3차

        ArrayList<String> airport3 = new ArrayList<>(airport2);
        ArrayList<Integer> dist3 = new ArrayList<>();
        HashMap<Integer, String> map3 = new HashMap<>();

        airport3.remove(map2.get(Collections.min(dist2)));

        for (int i = 0; i < airport3.size(); i++) {
            dist3.add(calKm(map2.get(Collections.min(dist2)), airport3.get(i)));
            map3.put(dist3.get(i), airport3.get(i));
        }

        airport.add(map3.get(Collections.min(dist3)));

        // 4차

        ArrayList<String> airport4 = new ArrayList<>(airport3);
        HashMap<Integer, String> map4 = new HashMap<>();
        ArrayList<Integer> dist4 = new ArrayList<>();

        airport4.remove(map3.get(Collections.min(dist3)));

        for (int i = 0; i < airport4.size(); i++) {
            dist4.add(calKm(map3.get(Collections.min(dist3)), airport4.get(i)));
            map4.put(dist4.get(i), airport4.get(i));
        }

        airport.add(map4.get(Collections.min(dist4)));

        // 도착

        airport.add(airport0.get(1));
        System.out.print(String.valueOf(calKm(map4.get(Collections.min(dist4)), airport0.get(1))));

        System.out.print(airport.toString());

        return airport;

    }

    @Override
    public List<String> route5(String dep, String arv, String s1, String s2, String s3, String s4, String s5) throws Exception {

        ArrayList<String> airport0 = new ArrayList<>();
        List<String> airport = new ArrayList<>();


        airport0.add(dep);
        airport0.add(arv);

        // 1차
        ArrayList<String> airport1 = new ArrayList<>();

        airport1.add(s1);
        airport1.add(s2);
        airport1.add(s3);
        airport1.add(s4);
        airport1.add(s5);

        ArrayList<Integer> dist1 = new ArrayList<>();
        HashMap<Integer, String> map1 = new HashMap<>();


        for (int i = 0; i < airport1.size(); i++) {

            dist1.add(calKm(airport0.get(0), airport1.get(i)));
            map1.put(dist1.get(i), airport1.get(i));
        }

        System.out.print(airport1.toString());
        System.out.print(dist1.toString());
        System.out.print(map1.toString());

        System.out.print(map1.get(Collections.min(dist1)));

        airport.add(airport0.get(0));
        airport.add(map1.get(Collections.min(dist1)));

        // 2차

        ArrayList<String> airport2 = new ArrayList<>(airport1);
        ArrayList<Integer> dist2 = new ArrayList<>();
        HashMap<Integer, String> map2 = new HashMap<>();

        airport2.remove(map1.get(Collections.min(dist1)));

        for (int i = 0; i < airport2.size(); i++) {
            dist2.add(calKm(map1.get(Collections.min(dist1)), airport2.get(i)));
            map2.put(dist2.get(i), airport2.get(i));

        }

        airport.add(map2.get(Collections.min(dist2)));

        // 3차

        ArrayList<String> airport3 = new ArrayList<>(airport2);
        ArrayList<Integer> dist3 = new ArrayList<>();
        HashMap<Integer, String> map3 = new HashMap<>();

        airport3.remove(map2.get(Collections.min(dist2)));

        for (int i = 0; i < airport3.size(); i++) {
            dist3.add(calKm(map2.get(Collections.min(dist2)), airport3.get(i)));
            map3.put(dist3.get(i), airport3.get(i));
        }

        airport.add(map3.get(Collections.min(dist3)));

        // 4차

        ArrayList<String> airport4 = new ArrayList<>(airport3);
        HashMap<Integer, String> map4 = new HashMap<>();
        ArrayList<Integer> dist4 = new ArrayList<>();

        airport4.remove(map3.get(Collections.min(dist3)));

        for (int i = 0; i < airport4.size(); i++) {
            dist4.add(calKm(map3.get(Collections.min(dist3)), airport4.get(i)));
            map4.put(dist4.get(i), airport4.get(i));
        }

        airport.add(map4.get(Collections.min(dist4)));

        // 5차

        ArrayList<String> airport5 = new ArrayList<>(airport4);
        ArrayList<Integer> dist5 = new ArrayList<>();
        HashMap<Integer, String> map5 = new HashMap<>();

        airport5.remove(map4.get(Collections.min(dist4)));

        for (int i = 0; i < airport5.size(); i++) {
            dist5.add(calKm(map4.get(Collections.min(dist4)), airport5.get(i)));
            map5.put(dist5.get(i), airport5.get(i));
        }
        airport.add(map5.get(Collections.min(dist5)));

        // 도착

        airport.add(airport0.get(1));
        System.out.print(String.valueOf(calKm(map5.get(Collections.min(dist5)), airport0.get(1))));

        System.out.print(airport.toString());

        return airport;

    }
}