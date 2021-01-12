package com.bll.impl;

import com.bean.FlightInfo;
import com.bll.IFlightService;

import java.util.Set;

public class FlightServiceImpl implements IFlightService {

    @Override
    public void insertFlight(FlightInfo flightInfo) {
        System.out.println(flightInfo);
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

