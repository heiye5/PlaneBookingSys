package com.dao.impl;

import com.bean.FlightInfo;
import com.dao.IFlightDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;

public class FlightDaoImpl implements IFlightDao {
    @Override
    public void insertFlight(FlightInfo flightInfo) throws SQLException {
        String url = "jdbc:oracle:thin:dbip:1521:orcl";
        String userName = "opts";
        String password = "opts1234";
        String sql = "insert into flight values (?,?,?,?,?,?,?)";

        Connection connection = DriverManager.getConnection(url,userName,password);
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1,flightInfo.getId());
        ps.setString(2,flightInfo.getFlightId());
        ps.setString(3,flightInfo.getPlaneType());
        ps.setInt(4,flightInfo.getCurrentSeatsNum());
        ps.setString(5,flightInfo.getDepartureCity());
        ps.setString(6,flightInfo.getArriveCity());
        ps.setString(7,flightInfo.getDepartureDate());

        ps.executeUpdate();
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
