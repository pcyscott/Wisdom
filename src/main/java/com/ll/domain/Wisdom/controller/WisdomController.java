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
}
