package com.back.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilFileTest {

    @Test
    @DisplayName("파일 생성")
    void t1(){

        //무언가를 세팅한다.
        String filePath = "test.txt";

        // 수행하면
        Util.file.touch(filePath);

        //결과가 나온다 -> 실제 파일이 존재하는가?
        boolean rst = Util.file.exists(filePath);

        assertThat(rst).isTrue();

        // 테스트 끝나면 파일 삭제

    }

    @Test
    @DisplayName("파일 삭제")
    void t2(){

        //given
        String filePath = "test.txt";
        Util.file.touch(filePath);

        //when
        Util.file.delete(filePath);

        //then
        boolean rst = Util.file.exists(filePath);
        assertThat(rst).isFalse();
    }

    @Test
    @DisplayName("파일 읽기/쓰기")
    void t3(){

        //given
        String filePath = "test.txt";
        Util.file.set(filePath,"hello world");

        //when
        String content = Util.file.get(filePath,"");

        //then
        assertThat(content).isEqualTo("hello world");

        Util.file.exists(filePath);
    }
}
