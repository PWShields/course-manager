package com.puffinpowered.coursemanager.controller.rest;

import com.puffinpowered.coursemanager.domain.Course;
import com.puffinpowered.coursemanager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pshields on 7/04/2017.
 */
@RestController
@RequestMapping("/json/course")
public class CourseRestController {

    @Autowired
    CourseService courseService;

    @RequestMapping(method= RequestMethod.GET, value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course findOne(@PathVariable(value = "id") Long id) {
                return courseService.findOne(id);
    }

}
