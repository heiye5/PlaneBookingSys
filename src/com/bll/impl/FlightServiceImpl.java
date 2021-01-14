package com.bll.impl;

import com.bean.FlightInfo;
import com.bll.IFlightService;
import com.dao.IFlightDao;
import com.dao.impl.FlightDaoImpl;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class FlightServiceImpl implements IFlightService {
    IFlightDao iFlightDao;

    public FlightServiceImpl() {
        iFlightDao = new FlightDaoImpl();
    }

    //录入航班信息
    @Override
    public void insertFlight(FlightInfo flightInfo) throws SQLException {
        iFlightDao.insertFlight(flightInfo);
    }

    //显示所有航班信息
    @Override
    public Set<FlightInfo> getAllFlight() throws SQLException {
//        System.out.println("service");
        Set<FlightInfo> sets = iFlightDao.getAllFlight();
        return sets;
    }


    /**
     * 查询航班信息
     */
    //出发城市
    @Override
    public FlightInfo getFlightByDepartureCity(String departureCity) throws SQLException {
        return iFlightDao.getFlightByDepartureCity(departureCity);
    }
    //目的城市
    @Override
    public FlightInfo getFlightByArriveCity(String arriveCity) throws SQLException {
        return iFlightDao.getFlightByArriveCity(arriveCity);
    }
    //起飞时间
    @Override
    public FlightInfo getFlightByDepartureDate(String departureDate) throws SQLException {
        return iFlightDao.getFlightByDepartureDate(departureDate);
    }


    @Override
    public void updateFlight(FlightInfo flightInfo) {

    }
}

