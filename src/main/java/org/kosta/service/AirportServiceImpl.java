package org.kosta.service;

import org.kosta.domain.AirportVO;
import org.kosta.persistence.AirportDAO;
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

    // converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    // a--b 위도 & 경도 => km 계산 (double -> int)
    @Override
    public int calKm(AirportVO a, AirportVO b) throws Exception {
        double theta = a.getLon() - b.getLon();


        double dist = Math.sin(deg2rad(a.getLat())) * Math.sin(deg2rad(b.getLat())) + Math.cos(deg2rad(a.getLat()))
                * Math.cos(deg2rad(b.getLat())) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515 * 1.609344;

        DecimalFormat decimalFormat = new DecimalFormat("#");

        return Integer.parseInt(decimalFormat.format(dist));
    }

    @Override
    public List<String> route(List<String> list) throws Exception {
        Map<String,Object> map= new HashMap<>();
        map.put("code_list",list);
        List<AirportVO> airportList = airportDAO.selectAirport2(map);
        List<String> result=new ArrayList<>();

        if(airportList.size()>3) {
            AirportVO endAirport = airportList.get(airportList.size() - 1);
            airportList.remove(airportList.size() - 1);
            int idx,min,temp;

            do {
                min=0;
                temp=0;
                idx=0;
                for (int i = 1; i <airportList.size() ; i++) {
                    if (i == 1) {
                        min= calKm(airportList.get(0),airportList.get(1));
                        idx=1;
                        continue;
                    }
                    temp=calKm(airportList.get(0),airportList.get(i));
                    if (temp<min) {
                        min=temp;
                        idx=i;
                    }
                }

                if(airportList.size()>1) {
                    result.add(airportList.get(0).getAirportCode());
                    airportList.set(0, airportList.get(idx));
                    airportList.remove(idx);
                }else{
                    result.add(airportList.get(idx).getAirportCode());
                    airportList.remove(idx);
                }
            } while (airportList.size()>0);

            result.add(endAirport.getAirportCode());


        }else{
            for(int i =0;i<airportList.size();i++) {
                result.add(airportList.get(i).getAirportCode());
            }

        }


        return result;
    }
    @Override
    public AirportVO readAllService(String airportCode) throws Exception {
        return airportDAO.readAll(airportCode);
    }
}