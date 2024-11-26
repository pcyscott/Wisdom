package com.ll;
import com.ll.domain.Wisdom.controller.WisdomController;
import com.ll.domain.Wisdom.entity.Wise;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private Scanner scanner;
    private final ArrayList<Wise> wises;
    private int index;
    private String order;
    private final WisdomController wisdomController;

    public App(){
        scanner = new Scanner(System.in);
        wises = new ArrayList<>();
        index = 0;
        order = "null";
        wisdomController = new WisdomController();
    }
    void run(){
        System.out.println("== 명언 앱 ==");
        while (true) {
               System.out.print("명령) ");
               order = scanner.nextLine();
               if (order.equals("등록")) {
                   registing();
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

    private void registing() {
        index++;
        System.out.print("명언 : ");
        String wisname = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        Wise wise = new Wise(wisname, author, index);
        wises.add(wise);
        System.out.println(index +"번 명언이 등록되었습니다.");
    }
}
