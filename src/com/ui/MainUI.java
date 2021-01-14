package com.ui;

import com.bean.FlightInfo;
import com.bll.IFlightService;
import com.bll.impl.FlightServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainUI {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//        String test = scanner.next();
//        System.out.println(test);
        while(true){
            System.out.println("------------------------------------");
            System.out.println("|   1.录入航班信息（输入数字1）       |");
            System.out.println("|   2.显示所有航班信息（输入数字2）   |");
            System.out.println("|   3.查询航班信息（输入数字3）       |");
            System.out.println("|   4.机票预订（输入数字4）          |");
            System.out.println("|   5.机票退订（输入数字5）          |");
            System.out.println("|   6.退出系统（输入数字6）          |");
            System.out.println("------------------------------------");

            System.out.print("请输入相应的数字选择：");
            String result = scanner.next();
            if(result.equals("1")){
                String id = UUID.randomUUID().toString();
//                System.out.println(id.replace("-",""));
                String newId = id.replace("-","");                  //删去"-"

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

                FlightInfo flightInfo = new FlightInfo(newId,flightId,currentSeatsNum, planeType,departureCity,arriveCity,departureDate);
                IFlightService iFlightService = new FlightServiceImpl();

                System.out.println("正在录入数据...");

                try {
                    iFlightService.insertFlight(flightInfo);
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    String messageStr = e.getMessage();
                    String newMessage = messageStr.substring(0,9);
                    if(newMessage.equals("ORA-12899")){
                         //按指定模式在字符串查找
//                        String pattern = "(\\w+-\\d{5}):(\\s\\w+)+\\s(\"\\w+\")\\.(\"\\w+\")\\.(\"\\w+\")";
                        String pattern = "(\\w+-\\d{5}):(\\s[\\u4E00-\\u9FA5]+)";
                        // 创建 Pattern 对象
                        Pattern r = Pattern.compile(pattern);
                        // 现在创建 matcher 对象
                        Matcher m = r.matcher(messageStr);
                        if (m.find()) {
                            System.out.println(m.group(0));
                            System.out.println(m.group(1));
//                            String tableName = m.group(4);
//                            String columnName = m.group(5);
//                            System.out.println(tableName + "表的" + columnName + "这一列的值过大，请仔细检查");
                        } else {
                            System.out.println("NO MATCH");
                        }
                    }

                }


                System.out.println("\n");

            }else if(result.equals("2")){
                IFlightService iFlightService = new FlightServiceImpl();

                try {
                    Set<FlightInfo> sets= iFlightService.getAllFlight();
                    for(FlightInfo set : sets){
                        System.out.println(set+"\n");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else if(result.equals("3")){
                System.out.println("|   1.起飞时间（输入数字1）   |");
                System.out.println("|   2.出发城市（输入数字2）   |");
                System.out.println("|   3.目的城市（输入数字3）   |");
                System.out.println("|   输入其他任意字符退出系统   |");
                System.out.print("请选择查找方式：");
                String search = scanner.next();

                IFlightService iFlightService = new FlightServiceImpl();
                if(search.equals("1")){
                    System.out.print("起飞时间：");
                    String time = scanner.next();
                    try {
                        FlightInfo flightInfo = iFlightService.getFlightByDepartureDate(time);
                        System.out.println(flightInfo);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(search.equals("2")){
                    System.out.print("出发机场：");
                    String time = scanner.next();
                    try {
                        FlightInfo flightInfo = iFlightService.getFlightByDepartureCity(time);
                        System.out.println(flightInfo);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else if(search.equals("3")){
                    System.out.print("到达机场：");
                    String time = scanner.next();
                    try {
                        FlightInfo flightInfo = iFlightService.getFlightByArriveCity(time);
                        System.out.println(flightInfo);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("正在退出");
                    return;
                }

            }else if(result.equals("4")){
                System.out.println("你选择了4");
            }else if(result.equals("5")){
                System.out.println("你选择了5");
            }else if(result.equals("6")){
                System.out.println("正在退出...");
                return;
            }else{
                System.out.print("\n");
                System.out.println("************************************************************");
                System.out.println("*   ！！！非法字符，请输入纯数字（1，2,3,4,5，6）中的一个！！!  *");
                System.out.println("************************************************************");
                System.out.print("\n");
            }
        }
    }
}
