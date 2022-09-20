package com.example.sprintrestapi.services;

import com.example.sprintrestapi.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseServices {

    public List<Course> getCourses();
    public  Course getCourse(long courseId);
    public  Course addCourse(Course course );
    public  Course updateCourse(Course course);

}
