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
                   deleting();
               }
               else if(order.startsWith("수정")){
                   editing();;
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


    private void deleting() {
        int target = Integer.parseInt(order.split("=")[1]);
        boolean removed = wises.removeIf(item -> item.getWisnum() == target);
        if (removed) {
            System.out.println(target+"번의 명언이 삭제되었습니다.");
        }
        else{
            System.out.println(target+"번의 명언은 존재하지 않습니다.");
        }
    }
    private void editing() {
        int taget = Integer.parseInt(order.split("=")[1]);
        Wise targetwise = null;

        for(Wise item: wises){
            if(item.getWisnum() == taget){
                targetwise = item;
                break;
            }
        }

        if(targetwise != null){
            System.out.println("명언(기존) : "+targetwise.getWise());
            System.out.print("명언) ");
            String newWise = scanner.nextLine();
            targetwise.setWise(newWise);

            System.out.println("작가(기존) : "+targetwise.getAuthor());
            System.out.print("작가) ");
            String newAuthor = scanner.nextLine();
            targetwise.setAuthor(newAuthor);
        }

        else{
            System.out.println(taget+"번 명언은 존재하지 않습니다.");
        }
    }
}
