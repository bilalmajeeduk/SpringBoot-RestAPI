package com.example.sprintrestapi.controller;


import com.example.sprintrestapi.entities.Course;
import com.example.sprintrestapi.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class ApiRequest {

    @Autowired
    private CourseServices courseServices;

//    @RequestMapping("/api/home")
    @GetMapping("api/home")
    public  String getHelloWorld(){
        return "Hello this is the home page of the Courses section, try using /courses to get the list of Courses";
    }

    @GetMapping("/api/courses")
    public List<Course> getCourses(){
        return this.courseServices.getCourses();
    };

    @GetMapping("/api/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return  this.courseServices.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/api/course")
    public  Course addCourse(@RequestBody Course course) {
        return  this.courseServices.addCourse(course);
    }
    // Updating the post request
    @PutMapping("/api/course")
    public Course updateCourse(@RequestBody Course course) {
        return  this.courseServices.updateCourse(course);
    }

    //delete the course
    @DeleteMapping("/api/course/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.courseServices.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
        return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
