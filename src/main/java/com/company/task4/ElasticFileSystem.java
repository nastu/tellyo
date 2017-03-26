package com.company.task4;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import javax.persistence.*;

/**
 * Created by Matts on 25.03.2017.
 */
@DynamoDBTable(tableName = "ElasticFileSystem")
public class ElasticFileSystem {

    public String id;
    public Double recordedHours;
    public Integer mounts;
    public Enum fsState;

    public ElasticFileSystem(String id) {
        this.id = id;
        this.recordedHours = 0.0;
        this.mounts = 0;
        this.fsState = FsState.INIT;
    }

    @DynamoDBHashKey(attributeName = "Id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName = "RecordedHours")
    public Double getRecordedHours() {
        return recordedHours;
    }

    public void setRecordedHours(Double recordedHours) {
        this.recordedHours = recordedHours;
    }

    @DynamoDBAttribute(attributeName = "Mounts")
    public Integer getMounts() {
        return mounts;
    }

    public void setMounts(Integer mounts) {
        this.mounts = mounts;
    }

    public void incrementMounts() {
        this.mounts += 1;
    }

    @DynamoDBAttribute(attributeName = "FsState")
    public Enum getFsState() {
        return fsState;
    }

    public void setFsState(Enum fsState) {
        this.fsState = fsState;
    }
}