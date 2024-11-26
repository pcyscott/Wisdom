package com.ll.domain.Wisdom.controller;

import com.ll.domain.Wisdom.entity.Wise;

import java.util.ArrayList;

public class WisdomController {
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
}
