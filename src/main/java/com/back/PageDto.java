package com.back;

import com.back.domain.wiseSaying.entity.WiseSaying;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageDto {

    private int page;
    private int pageSize;
    private int totalItems; // 전체 명언의 수
    private List<WiseSaying> content;

    public int getTotalPageCnt() {
        if(totalItems == 0){
            return 0;
        }
        return (int) Math.ceil((double) totalItems / pageSize);
    }
}
