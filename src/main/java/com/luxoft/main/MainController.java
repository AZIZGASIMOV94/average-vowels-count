package com.luxoft.main;


import com.luxoft.service.impl.RequestHandlerServiceImpl;
import com.luxoft.service.inter.RequestHandlerServiceInter;

import java.io.IOException;

public class MainController {

    private static RequestHandlerServiceInter requestHandlerServiceInter;

    public static void main(String[] args) throws IOException {
        requestHandlerServiceInter = new RequestHandlerServiceImpl();
        requestHandlerServiceInter.findAvgNumOfVowels();
    }
}
