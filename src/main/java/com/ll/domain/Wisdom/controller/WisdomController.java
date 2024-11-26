package com.ll.domain.Wisdom.controller;

import com.ll.domain.Wisdom.entity.Wise;
import com.ll.domain.Wisdom.service.WisdomService;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class WisdomController {
    private final WisdomService wisdomService;
    private final Scanner scanner;

    public WisdomController(Scanner scanner) {
        this.scanner = scanner;
        this.wisdomService = new WisdomService();
    }

    public void makeSampleData() {
        wisdomService.add("첫 번째 ", "작가");
        wisdomService.add("두 번째 명언", "1 작가");
    }

    public void showing() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        ArrayList<Wise> wises = wisdomService.findAll();

        for(int i = wises.size()-1; i>-1; i--) {
            System.out.println(wises.get(i));
        }
    }

    public void deleting(String order) {
        int target = Integer.parseInt(order.split("=")[1]);
        boolean removed = wisdomService.removeById(target);
        if (removed) {
            System.out.println(target+"번의 명언이 삭제되었습니다.");
        }
        else{
            System.out.println(target+"번의 명언은 존재하지 않습니다.");
        }
    }

    public void editing(String order) {
        int target = Integer.parseInt(order.split("=")[1]);
        Wise targetwise = null;

        Optional<Wise> opWisdom = wisdomService.findById(target);

        if(opWisdom.isEmpty()) {
            System.out.println(target+"번 명언은 존재하지 않습니다.");
            return;
        }
        targetwise = opWisdom.get();
        System.out.println("명언(기존) : "+targetwise.getWise());
        System.out.print("명언) ");
        String newWise = scanner.nextLine();


        System.out.println("작가(기존) : "+targetwise.getAuthor());
        System.out.print("작가) ");
        String newAuthor = scanner.nextLine();


        wisdomService.modify(targetwise,newWise,newAuthor);

    }

    public void registing() {
        System.out.print("명언 : ");
        String wisname = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        Wise wise =wisdomService.add(wisname, author);
        System.out.println(wise.getWisnum() +"번 명언이 등록되었습니다.");
    }


}
