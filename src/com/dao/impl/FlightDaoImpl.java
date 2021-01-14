package com.dao.impl;

import com.bean.FlightInfo;
import com.dao.IFlightDao;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class FlightDaoImpl implements IFlightDao {
    //录入航班信息
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

    //显示所有航班信息
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

    /**
     *查询航班信息
     */
    //出发城市
    @Override
    public FlightInfo getFlightByDepartureCity(String departureCity) throws SQLException {
        String url = "jdbc:oracle:thin:dbip:1521:orcl";
        String userName = "opts";
        String password = "opts1234";
        String sql = "select FLIGHT_ID,PLANE_TYPE,TOTAL_SEATS_NUM,DEPARTURE_AIRPORT,DESTINATION_AIRPORT,DEPARTURE_TIME from flight " +
                "where DEPARTURE_AIRPORT = ?";

        Connection connection = DriverManager.getConnection(url,userName,password);
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,departureCity);
        ResultSet rs = ps.executeQuery();

        FlightInfo flightInfo = null;

        while(rs.next()){
            String flightId = rs.getString("FLIGHT_ID");
            int currentSeatsNum = rs.getInt("TOTAL_SEATS_NUM");
            String planeType = rs.getString("PLANE_TYPE");
            String departureCitys = rs.getString("DEPARTURE_AIRPORT");
            String arriveCity = rs.getString("DESTINATION_AIRPORT");
            String departureDates = rs.getString("DEPARTURE_TIME");

            flightInfo = new FlightInfo(flightId,currentSeatsNum,planeType,departureCitys,arriveCity,departureDates);
        }

        return flightInfo;

    }

    //目的城市
    @Override
    public FlightInfo getFlightByArriveCity(String arriveCity) throws SQLException {
        String url = "jdbc:oracle:thin:dbip:1521:orcl";
        String userName = "opts";
        String password = "opts1234";
        String sql = "select FLIGHT_ID,PLANE_TYPE,TOTAL_SEATS_NUM,DEPARTURE_AIRPORT,DESTINATION_AIRPORT,DEPARTURE_TIME from flight " +
                "where DESTINATION_AIRPORT = ?";

        Connection connection = DriverManager.getConnection(url,userName,password);
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,arriveCity);
        ResultSet rs = ps.executeQuery();

        FlightInfo flightInfo = null;

        while(rs.next()){
            String flightId = rs.getString("FLIGHT_ID");
            int currentSeatsNum = rs.getInt("TOTAL_SEATS_NUM");
            String planeType = rs.getString("PLANE_TYPE");
            String departureCity = rs.getString("DEPARTURE_AIRPORT");
            String arriveCitys = rs.getString("DESTINATION_AIRPORT");
            String departureDates = rs.getString("DEPARTURE_TIME");

            flightInfo = new FlightInfo(flightId,currentSeatsNum,planeType,departureCity,arriveCitys,departureDates);
        }

        return flightInfo;
    }

    //起飞时间
    @Override
    public FlightInfo getFlightByDepartureDate(String departureDate) throws SQLException {
        String url = "jdbc:oracle:thin:dbip:1521:orcl";
        String userName = "opts";
        String password = "opts1234";
        String sql = "select FLIGHT_ID,PLANE_TYPE,TOTAL_SEATS_NUM,DEPARTURE_AIRPORT,DESTINATION_AIRPORT,DEPARTURE_TIME from flight " +
                "where DEPARTURE_TIME = ?";

        Connection connection = DriverManager.getConnection(url,userName,password);
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,departureDate);
        ResultSet rs = ps.executeQuery();

        FlightInfo flightInfo = null;

        while(rs.next()){
            String flightId = rs.getString("FLIGHT_ID");
            int currentSeatsNum = rs.getInt("TOTAL_SEATS_NUM");
            String planeType = rs.getString("PLANE_TYPE");
            String departureCity = rs.getString("DEPARTURE_AIRPORT");
            String arriveCity = rs.getString("DESTINATION_AIRPORT");
            String departureDates = rs.getString("DEPARTURE_TIME");

            flightInfo = new FlightInfo(flightId,currentSeatsNum,planeType,departureCity,arriveCity,departureDates);
        }

        return flightInfo;
    }

    @Override
    public void updateFlight(FlightInfo flightInfo) {

    }
}
