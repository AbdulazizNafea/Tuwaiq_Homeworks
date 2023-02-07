package com.example.school_management_hw21.Controller;

import com.example.school_management_hw21.Model.Course;
import com.example.school_management_hw21.Services.CourseServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/c")
public class CourseController {

    private final CourseServices courseServices;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        List<Course> courses = courseServices.getall();
        return ResponseEntity.status(200).body(courses);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody Course courses) {
        courseServices.add(courses);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@RequestBody Course course, @PathVariable Integer id) {
        courseServices.update(course,id);
        return ResponseEntity.status(200).body("User Added");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        if(courseServices.delete(id)){
            courseServices.delete(id);
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("User not found");
    }
}
