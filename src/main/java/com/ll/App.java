package com.ll;

import com.ll.domain.Wisdom.controller.WisdomController;
import com.ll.domain.repository.WisdomRepository;
import com.ll.domain.system.controller.SystemController;

import java.util.Scanner;

public class App {
    private Scanner scanner;
    private String order;
    private final WisdomController wisdomController;
    private final SystemController systemController;
    private final WisdomRepository wisdomRepository;

    public App(){
        scanner = new Scanner(System.in);
        order = "null";
        wisdomController = new WisdomController(scanner);
        wisdomRepository = new WisdomRepository();
        systemController = new SystemController();
    }
    void run(){
        System.out.println("== 명언 앱 ==");
        wisdomController.makeSampleData();

        while (true) {
               System.out.print("명령) ");
               order = scanner.nextLine();
               if (order.equals("등록")) {
                   wisdomController.registing();
               }
               else if(order.equals("목록")){
                   wisdomController.showing();
               }
               else if(order.startsWith("삭제")){
                   wisdomController.deleting(order);
               }
               else if(order.startsWith("수정")){
                   wisdomController.editing(order);
               }
               else if(order.equals("종료")){
                   systemController.progclosing();
                   break;
               }
        }
        scanner.close();
    }
}
