package com.puffinpowered.coursemanager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by pshields on 7/04/2017.
 *
 */
@Data
@Entity
public class Course {
    private @Id
    @GeneratedValue
    Long id;

    private String courseName;

    @ManyToOne
    private Provider provider;


    public Course(String courseName, Provider provider) {
        this.courseName = courseName;
        this.provider = provider;
    }

    public Course() {
    }
}
