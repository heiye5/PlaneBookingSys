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

    @Override
    public void insertFlight(FlightInfo flightInfo) throws SQLException {
        iFlightDao.insertFlight(flightInfo);
    }

    @Override
    public Set<FlightInfo> getAllFlight() throws SQLException {
//        System.out.println("service");
        Set<FlightInfo> sets = iFlightDao.getAllFlight();
        return sets;
    }

    @Override
    public FlightInfo getFlightByDepartureCity(String departureCity) {
        return null;
    }

    @Override
    public FlightInfo getFlightByArriveCity(String arriveCity) {
        return null;
    }

    @Override
    public FlightInfo getFlightByDepartureDate(String departureDate) {
        return null;
    }

    @Override
    public void updateFlight(FlightInfo flightInfo) {

    }
}

