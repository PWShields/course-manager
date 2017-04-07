package com.puffinpowered.coursemanager.repository;

import com.puffinpowered.coursemanager.domain.Course;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pshields on 7/04/2017.
 */
public interface CourseRepository extends CrudRepository<Course, Long>{
}
