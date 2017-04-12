package com.puffinpowered.coursemanager.service;

import com.puffinpowered.coursemanager.domain.Course;
import com.puffinpowered.coursemanager.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pshields on 10/04/2017.
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course findOne(Long id){
        return courseRepository.findOne(id);
    }
}
