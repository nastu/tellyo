package com.company.task2andtask3;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Matts on 23.03.2017.
 */
@Entity
@Table(name = "dailyStatistics")
public class DailyStatistics implements java.io.Serializable {
    private long id;
    private Date snapshotTime;
    private long views;
    private long comments;
    private Video relatedVideo;

    public DailyStatistics(long id, Date snapshotTime, long views, long comments, Video relatedVideo){
        this.id = id;
        this.snapshotTime = snapshotTime;
        this.views = views;
        this.comments = comments;
        this.relatedVideo = relatedVideo;
    }

    // Getters
    @Id
    @Column(name = "stats_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = "snapshot_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getSnapshotTime() {
        return snapshotTime;
    }

    @Column(name = "views", nullable = false)
    public long getViews() {
        return views;
    }

    @Column(name = "comments", nullable = false)
    public long getComments() {
        return comments;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    public Video getRelatedVideo() {
        return relatedVideo;
    }

}
