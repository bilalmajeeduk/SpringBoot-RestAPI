package com.example.sprintrestapi.services;

import com.example.sprintrestapi.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class CourseImpl implements  CourseServices {

    List<Course> list;

    public CourseImpl() {
        list = new ArrayList<>();
        list.add(new Course(12, "NewCourse", "this is the Math course"));
        list.add(new Course(11, "ComputerScience", "this is the CS course"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {
        Course course = null;
        for(Course c: list){
            if (c.getId() == courseId){
                course = c;
                break;
            }
        }
        return course;
    }

    // Adding a new new Course

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        list.forEach(e -> {
            if (e.getId() == course.getId()){
                e.setTitle(course.getTitle());
                e.setDescription(course.getDescription());
            }
        });
        return course;
    }

    @Override
    public void deleteCourse(long parseLong) {
        list=this.list.stream().filter(e-> e.getId()!=parseLong).collect(Collectors.toList());
    }


}
