package com.back;

import com.back.domain.wiseSaying.WiseSayingRepository.WiseSayingRepository;
import com.back.domain.wiseSaying.controller.WiseSayingController;
import com.back.domain.wiseSaying.service.WiseSayingService;
import com.back.system.SystemController;

import java.util.Scanner;

public class AppContext {

    public static Scanner sc;
    public static WiseSayingController wiseSayingController;
    public static WiseSayingService wiseSayingService ;
    public static WiseSayingRepository wiseSayingRepository ;
    public static SystemController systemController;

    public static void init(Scanner sc){
        AppContext.sc = sc;
        AppContext.wiseSayingRepository = new WiseSayingRepository();
        AppContext.wiseSayingService = new WiseSayingService(); // ← 주입
        AppContext.systemController = new SystemController();
        AppContext.wiseSayingController = new WiseSayingController(sc); // ← 주입
    }

    public static void init(){
        init(new Scanner(System.in));
    }
}
