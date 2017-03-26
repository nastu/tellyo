package com.company.task4;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Matts on 23.03.2017.
 */
public class AJavaTest {

    public static void main(String[] args) {
        ElasticFileSystemDAO dao = new ElasticFileSystemDAO();
        ElasticFileSystem efs = new ElasticFileSystem("efs1");
        dao.save(efs);

        CompletableFuture[] futures = new CompletableFuture[1024];
        for (int i = 0; i < 1024; i++) {
            futures[i] = CompletableFuture.runAsync(() -> {
                dao.addRecording("efs1", 0.1);
            });
        }
        CompletableFuture.allOf(futures).join();

        ElasticFileSystem updatedEfs = dao.load(ElasticFileSystem.class, "efs1");
        System.out.println(updatedEfs.mounts);
        System.out.println(updatedEfs.recordedHours);
    }
}

