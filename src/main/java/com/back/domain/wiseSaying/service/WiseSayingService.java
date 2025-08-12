package com.back.domain.wiseSaying.service;

import com.back.AppContext;
import com.back.domain.wiseSaying.WiseSayingRepository.WiseSayingRepository;
import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.List;

public class WiseSayingService {

    private  WiseSayingRepository wiseSayingRepository;

    public WiseSayingService(){
        this.wiseSayingRepository = AppContext.wiseSayingRepository;
    }
    public WiseSaying write(String saying, String author) {

        WiseSaying wiseSaying = new WiseSaying(saying,author);
        wiseSayingRepository.save(wiseSaying);

        return wiseSaying;
    }

    public List<WiseSaying> findListDesc() {
        return wiseSayingRepository.findListDesc();
    }

    public boolean delete(int id) {
        return wiseSayingRepository.delete(id);
    }

    public WiseSaying findByIdOrNull(int id) {
        return wiseSayingRepository.findByIdOrNUll(id);
    }

    public void modify(WiseSaying wiseSaying, String newSaying, String newAuthor) {
        wiseSaying.setSaying(newSaying);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.save(wiseSaying);
    }
}
