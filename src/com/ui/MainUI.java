package com.ui;

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
            System.out.println("------------------------------------");
            System.out.println("|   1.录入航班信息（输入数字1）       |");
            System.out.println("|   2.显示所有航班信息（输入数字2）   |");
            System.out.println("|   3.查询航班信息（输入数字3）       |");
            System.out.println("|   4.机票预订（输入数字4）           |");
            System.out.println("|   5.机票退订（输入数字5）           |");
            System.out.println("|   6.退出系统（输入数字6）           |");
            System.out.println("-------------------------------------");

            System.out.print("请输入相应的数字选择：");
            String result = scanner.next();
            if(result.equals("1")){
                String id = UUID.randomUUID().toString();
//                System.out.println(id.replace("-",""));
                String newId = id.replace("-","");

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
                System.out.print("起飞时间:");
                String departureDate = scanner.next();

                FlightInfo flightInfo = new FlightInfo(newId,flightId,currentSeatsNum,planeType,departureCity,arriveCity,departureDate);
                IFlightService iFlightService = new FlightServiceImpl();

                iFlightService.insertFlight(flightInfo);

                System.out.println("\n");

            }else if(result.equals("2")){
                System.out.println("你选择了2");
            }else if(result.equals("3")){
                System.out.println("你选择了3");
            }else if(result.equals("4")){
                System.out.println("你选择了4");
            }else if(result.equals("5")){
                System.out.println("你选择了5");
            }else if(result.equals("6")){
                System.out.println("正在退出...");
                return;
            }else{
                System.out.print("\n");
                System.out.println("***********************************************");
                System.out.println("*   非法字符，请输入纯数字（1，2,3,4,5，6）！！!  *");
                System.out.println("***********************************************");
                System.out.print("\n");
            }
        }
    }
}
