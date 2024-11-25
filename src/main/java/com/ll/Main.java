package com.ll;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        app.run();
        int num = 0;
        System.out.println("== 명언 앱 ==");
        Scanner scanner = new Scanner(System.in);
        ArrayList<Wise> wises = new ArrayList<>();
        while(true) {

            String order = scanner.nextLine();
            if(order.equals("종료")) {
                break;
            }

            switch(order){
                case "등록":
                    num += 1;
                    System.out.print("명언 : ");
                    String wisName = scanner.nextLine();
                    System.out.print("작가 : ");
                    String authName = scanner.nextLine();
                    Wise wise = new Wise(wisName, authName, num);
                    wises.add(wise);
                    System.out.println(num +"번 명언이 등록되었습니다.");
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    for(int i = wises.size()-1; i>-1; i--) {
                        System.out.println(wises.get(i));
                    }
                    break;
            }
            if(order.startsWith("삭제")){
                int target = Integer.parseInt(order.split("=")[1]);
                boolean removed = wises.removeIf(item -> item.getWisnum() == target);

                if(removed) {
                    System.out.println(target+"번의 명언이 삭제되었습니다.");
                }
                else {
                    System.out.println(target+"번의 명언은 존재하지 않습니다.");
                }
            }
            if(order.startsWith("수정")){

                int target2 = Integer.parseInt(order.split("=")[1]);
                Wise targetWise = null;

                for(Wise item:wises) {
                    if(item.getWisnum() == target2) {
                        targetWise = item;
                        break;
                    }
                }
                if(targetWise != null) {
                    System.out.println("명언(기존) : "+targetWise.getWise());
                    System.out.print("명언) ");
                    String newWise = scanner.nextLine();
                    targetWise.setWise(newWise);

                    System.out.println("작가(기존) : "+targetWise.getAuthor());
                    System.out.print("작가) ");
                    String newAuthor = scanner.nextLine();
                    targetWise.setAuthor(newAuthor);
                }
                else{
                    System.out.println(target2+"번 명언은 존재하지 않습니다.");
                }
            }
        }
        scanner.close();
    }
}