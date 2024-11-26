package com.ll.domain.Wisdom.service;

import com.ll.domain.Wisdom.entity.Wise;
import com.ll.domain.repository.WisdomRepository;

import java.util.ArrayList;
import java.util.Optional;

public class WisdomService {
    private final WisdomRepository wisdomRepository;

    public WisdomService() {
        this.wisdomRepository = new WisdomRepository();
    }
    public Wise add(String wisname, String author) {

        Wise wise = new Wise(wisname, author, 0);
        wisdomRepository.add(wise);
        return wise;
    }

    public ArrayList<Wise> findAll() {
        return wisdomRepository.findAll();
    }

    public boolean removeById(int target) {
        return wisdomRepository.removeById(target);
    }

    public Optional<Wise> findById(int target) {
        return wisdomRepository.findById(target);
    }

    public void modify(Wise wise, String newWise, String newAuthor) {
        wise.setWise(newWise);
        wise.setAuthor(newAuthor);

    }
}
