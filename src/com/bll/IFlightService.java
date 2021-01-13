package com.bll;

import com.bean.FlightInfo;

import java.sql.SQLException;
import java.util.Set;

public interface IFlightService {
    void insertFlight(FlightInfo flightInfo) throws SQLException;
    Set<FlightInfo> getAllFlight();
    FlightInfo getFlightByDepartureCity(String departureCity);
    FlightInfo getFlightByArriveCity(String arriveCity);
    FlightInfo getFlightByDepartureDate(String departureDate);
    void updateFlight(FlightInfo flightInfo);
}
