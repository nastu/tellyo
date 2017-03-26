package com.company.task2andtask3;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Matts on 23.03.2017.
 */
public class AJavaTest {

    static final String JSON_PATH = "C:\\Users\\Matts\\Documents\\InteliJProjects\\src\\main\\java\\com\\company\\task2andtask3\\video.json";

    public static void main(String[] args) {
        Video video = new Video(1, "FailArmy", new Date(1970, 0, 1, 0, 0), new HashSet<DailyStatistics>(), true);
        DailyStatistics dSDayOne = new DailyStatistics(1, new Date(1970, 0, 1, 0, 0), 1, 1, video);
        DailyStatistics dSDayTwo = new DailyStatistics(2, new Date(1970, 0, 2, 0, 0), 7, 4, video);
        video.getDailyStatistics().add(dSDayOne);
        video.getDailyStatistics().add(dSDayTwo);

        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(JSON_PATH), video);
            System.out.println("Wrapped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

