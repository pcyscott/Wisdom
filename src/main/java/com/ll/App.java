package com.ll;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private Scanner scanner;
    private ArrayList<Wise> wises;
    private int index;
    private String order;

    public App(){
        scanner = new Scanner(System.in);
        wises = new ArrayList<>();
        index = 0;
        order = "null";
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
                   showing();
               }
               else if(order.equals("삭제")){
                   deleting();
               }
               else if(order.equals("수정")){
                   editing();;
               }
               else if(order.equals("종료")){
                   break;
               }
        }
    }

    private void registing() {
    }

    private void showing() {

    }
    private void deleting() {

    }
    private void editing() {}
}
