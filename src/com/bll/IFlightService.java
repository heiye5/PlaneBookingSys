package com.bll;

import com.bean.FlightInfo;

import java.sql.SQLException;
import java.util.Set;

public interface IFlightService {
    void insertFlight(FlightInfo flightInfo) throws SQLException;
    Set<FlightInfo> getAllFlight() throws SQLException;
    FlightInfo getFlightByDepartureCity(String departureCity) throws SQLException;
    FlightInfo getFlightByArriveCity(String arriveCity) throws SQLException;
    FlightInfo getFlightByDepartureDate(String departureDate) throws SQLException;
    void updateFlight(FlightInfo flightInfo);
}
