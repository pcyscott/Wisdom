package com.ll.domain.repository;

import com.ll.domain.Wisdom.entity.Wise;

import java.util.ArrayList;
import java.util.Optional;

public class WisdomRepository {
    private final ArrayList<Wise> wises;
    private int index;
    public WisdomRepository() {
        this.wises = new ArrayList<>();
        this.index = 0;
    }

    public void add(Wise wise) {
        wises.add(wise);
        wise.setWisnum(++index);
    }

    public ArrayList<Wise> findAll() {
        return wises;
    }

    public boolean removeById(int target) {
        return wises.removeIf(wis -> wis.getWisnum() == target);
    }

    public Optional<Wise> findById(int target) {
        return wises.stream().filter(wis -> wis.getWisnum() == target).findFirst();
    }
}
