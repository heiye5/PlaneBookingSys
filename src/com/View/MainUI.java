package com.View;

import com.bean.FlightInfo;
import com.bll.IFlightService;
import com.bll.impl.FlightServiceImpl;

import java.util.Scanner;
import java.util.UUID;

public class MainUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String test = scanner.next();
//        System.out.println(test);
        while(true){
            System.out.println("请输入相应的数字选择：");

            System.out.println("1.录入航班信息");

            int result = scanner.nextInt();

            if(result == 1){
                System.out.println("请输入航班信息");

                String id = UUID.randomUUID().toString();
                System.out.println(id.replace("-",""));

                System.out.print("请输入航班编号：");
                String flightId = scanner.next();
                System.out.print("机型：");
                String planeType = scanner.next();
                System.out.print("座位数：");
                int currentSeatsNum = scanner.nextInt();
                System.out.print("起飞机场：");
                String departureCity = scanner.next();
                System.out.print("目的机场：");
                String arriveCity = scanner.next();
                System.out.println("起飞时间:");
                String departureDate = scanner.next();

                FlightInfo flightInfo = new FlightInfo(id,flightId,currentSeatsNum,planeType,departureCity,arriveCity,departureDate);
                IFlightService iFlightService = new FlightServiceImpl();

                iFlightService.insertFlight(flightInfo);

            }

        }
    }
}
