package com.company.task4;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

/**
 * Created by Matts on 25.03.2017.
 */
public class ElasticFileSystemDAO {

    private AmazonDynamoDBClient client = new AmazonDynamoDBClient(new ProfileCredentialsProvider());
    private DynamoDBMapper mapper = new DynamoDBMapper(client);

    public void save(ElasticFileSystem efs) {
        mapper.save(efs);
    }

    public ElasticFileSystem load(Class<ElasticFileSystem> efsClass, String id) {
        return mapper.load(efsClass, id);
    }

    public void addRecording(String fsId, Double recordedHours) {
        ElasticFileSystem efs = load(ElasticFileSystem.class, fsId);
        efs.incrementMounts();
        efs.setRecordedHours(efs.getRecordedHours() + recordedHours);
        save(efs);
    }
}
