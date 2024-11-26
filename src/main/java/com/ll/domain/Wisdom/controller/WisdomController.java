package com.ll.domain.Wisdom.controller;

import com.ll.domain.Wisdom.entity.Wise;

import java.util.ArrayList;
import java.util.Scanner;

public class WisdomController {
    private int index;

    private void makeSampleData(ArrayList<Wise> wises) {

    }

    public void showing(ArrayList<Wise> wises) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        for(int i = wises.size()-1; i>-1; i--) {
            System.out.println(wises.get(i));
        }
    }

    public void deleting(ArrayList<Wise> wises, String order) {
        int target = Integer.parseInt(order.split("=")[1]);
        boolean removed = wises.removeIf(item -> item.getWisnum() == target);
        if (removed) {
            System.out.println(target+"번의 명언이 삭제되었습니다.");
        }
        else{
            System.out.println(target+"번의 명언은 존재하지 않습니다.");
        }
    }

    public void editing(String order, ArrayList<Wise> wises, Scanner scanner) {
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

    public void registing(Scanner scanner, ArrayList<Wise> wises) {
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
