package com.puffinpowered.coursemanager.service;

import com.puffinpowered.coursemanager.domain.Course;

/**
 * Created by pshields on 12/04/2017.
 */
public interface CourseService {
    Course findOne(Long id);
}
