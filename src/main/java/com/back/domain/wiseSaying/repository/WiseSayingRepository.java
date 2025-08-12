package com.back.domain.wiseSaying.repository;

import com.back.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {

    private List<WiseSaying> wiseSayings = new ArrayList<>();
    private int lastId = 0;

    public WiseSaying save(WiseSaying wiseSaying) {
        if (wiseSaying.isNew()) {
            wiseSaying.setId(++lastId);
            wiseSayings.add(wiseSaying);
        }

        return wiseSaying;
    }

    public boolean delete(int id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }

    public WiseSaying findByIdOrNull(int id) {

        return wiseSayings.stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<WiseSaying> findByContentContainingDesc(String kw,int pageSize,int pageNo) {
        return wiseSayings.reversed().stream()
                .filter(w -> w.getSaying().contains(kw))
                .skip((pageNo - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }

    public List<WiseSaying> findByAuthorContainingDesc(String kw,int pageSize,int pageNo) {

        return wiseSayings.reversed().stream()
                .filter(w -> w.getAuthor().contains(kw))
                .skip((pageNo - 1) * pageSize)
                .limit(pageSize)
                .toList();
    }

    public PageDto findByContentContainingOrAuthorContainingDesc(String kw,int pageSize,int pageNo) {

        List<WiseSaying> filteredContent =  wiseSayings.reversed().stream()
                .filter(w -> w.getAuthor().contains(kw) || w.getSaying().contains(kw))
                .toList();

        List<WiseSaying> content = filteredContent.stream()
                .skip((pageNo - 1) * pageSize)
                .limit(pageSize)
                .toList();

        int totalItems = filteredContent.size();

        return new PageDto(pageNo,pageSize,totalItems,content);
    }
}