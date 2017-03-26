package com.company.task2andtask3;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by Matts on 23.03.2017.
 */
@Entity
@Table(name = "video")
public class Video implements java.io.Serializable {
    private long id;
    private String name;
    private Date createdOn;
    private Set<DailyStatistics> dailyStatistics;
    private Boolean userHasAccess;

    public Video(long id, String name, Date createdOn, Set<DailyStatistics> dailyStatistics, Boolean userHasAccess) {
        this.id = id;
        this.name = name;
        this.createdOn = createdOn;
        this.dailyStatistics = dailyStatistics;
        this.userHasAccess = userHasAccess;
    }

    // Getters
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    @Column(name = "created_on", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedOn() {
        return createdOn;
    }

    @Transient
    public Boolean isUserHasAccess() {
        return userHasAccess;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "dailyStatistics", orphanRemoval = true)
    @JsonManagedReference
    public Set<DailyStatistics> getDailyStatistics() {
        return dailyStatistics;
    }

}


