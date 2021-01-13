package com.dao.impl;

import com.bean.FlightInfo;
import com.dao.IFlightDao;

import java.sql.*;
import java.util.HashSet;
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
    public Set<FlightInfo> getAllFlight() throws SQLException {
        Set<FlightInfo> sets = new HashSet<FlightInfo>();
        String url = "jdbc:oracle:thin:dbip:1521:orcl";
        String userName = "opts";
        String password = "opts1234";
        String sql = "select * from flight";

        Connection connection = DriverManager.getConnection(url,userName,password);
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            String id = rs.getString("ID");
            String flightId = rs.getString("FLIGHT_ID");
            int currentSeatsNum = rs.getInt("TOTAL_SEATS_NUM");
            String planeType = rs.getString("PLANE_TYPE");
            String departureCity = rs.getString("DEPARTURE_AIRPORT");
            String arriveCity = rs.getString("DESTINATION_AIRPORT");
            String departureDate = rs.getString("DEPARTURE_TIME");

            FlightInfo flightInfo = new FlightInfo(id,flightId,currentSeatsNum,planeType,departureCity,arriveCity,departureDate);
            sets.add(flightInfo);
        }

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
