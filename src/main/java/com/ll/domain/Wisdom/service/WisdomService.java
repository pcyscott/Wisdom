package com.ll.domain.Wisdom.service;

import com.ll.domain.Wisdom.entity.Wise;

import java.util.ArrayList;
import java.util.Optional;

public class WisdomService {
    private final ArrayList<Wise> wises;
    private int index;
    public WisdomService() {
        this.wises = new ArrayList<>();
        this.index = 0;
    }
    public Wise add(String wisname, String author) {
        int id = ++index;
        Wise wise = new Wise(wisname, author, id);
        wises.add(wise);
        return wise;
    }

    public ArrayList<Wise> findAll() {
        return wises;
    }

    public boolean removeById(int target) {
        return wises.removeIf(wises -> wises.getWisnum()==target);
    }

    public Optional<Wise> findById(int target) {
        return wises.stream().filter(wis -> wis.getWisnum()==target).findFirst();
    }

    public void modify(Wise targetwise, String newWise, String newAuthor) {
        targetwise.setWise(newWise);
        targetwise.setAuthor(newAuthor);

    }
}
