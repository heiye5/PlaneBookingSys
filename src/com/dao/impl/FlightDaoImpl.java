package com.dao.impl;

import com.bean.FlightInfo;
import com.dao.IFlightDao;
import java.util.Set;

public class FlightDaoImpl implements IFlightDao {
    @Override
    public void insertFlight(FlightInfo flightInfo) {
        System.out.println("DAO层 = " + flightInfo);
    }

    @Override
    public Set<FlightInfo> getAllFlight() {
        return null;
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
