package com.ll;
import com.ll.domain.Wisdom.controller.WisdomController;
import com.ll.domain.Wisdom.entity.Wise;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private Scanner scanner;
    private final ArrayList<Wise> wises;

    private String order;
    private final WisdomController wisdomController;

    public App(){
        scanner = new Scanner(System.in);
        wises = new ArrayList<>();
        order = "null";
        wisdomController = new WisdomController();
    }
    void run(){
        System.out.println("== 명언 앱 ==");
        while (true) {
               System.out.print("명령) ");
               order = scanner.nextLine();
               if (order.equals("등록")) {
                   wisdomController.registing(scanner,wises);
               }
               else if(order.equals("목록")){
                   wisdomController.showing(wises);
               }
               else if(order.startsWith("삭제")){
                   wisdomController.deleting(wises,order);
               }
               else if(order.startsWith("수정")){
                   wisdomController.editing(order,wises,scanner);
               }
               else if(order.equals("종료")){
                   break;
               }
        }
        scanner.close();
    }
}
