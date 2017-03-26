package com.company.task5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Matts on 23.03.2017.
 */
public class AJavaTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(32);

        long startThreads = System.currentTimeMillis();
        executor.execute(() -> {
            for (int i = 0; i < 1024; i++) {
                () -> copyOrCryptTs();
            }
        });
        executor.execute(()->{
            for (int i = 0; i < 1024; i++) {
                dstTs -> createThumb();
            }
        });
        executor.shutdown();
        try{
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }


}

