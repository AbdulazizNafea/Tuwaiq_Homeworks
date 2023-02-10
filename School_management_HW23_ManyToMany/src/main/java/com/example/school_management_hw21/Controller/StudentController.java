package com.example.school_management_hw21.Controller;

import com.example.school_management_hw21.Model.Course;
import com.example.school_management_hw21.Model.Student;
import com.example.school_management_hw21.Repo.StudentRepoistory;
import com.example.school_management_hw21.Services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/s")
public class StudentController {

    private  final StudentServices studentServices;

    @GetMapping("/get")
    public ResponseEntity get(){
        List<Student> student = studentServices.getall();
        return ResponseEntity.status(200).body(student);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Student student) {
        studentServices.add(student);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@RequestBody Student student, @PathVariable Integer id) {
        studentServices.update(student,id);
        return ResponseEntity.status(200).body("User Added");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        if(studentServices.delete(id)){
            studentServices.delete(id);
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("User not found");
    }

    ///////////////////////////////////////////////////////
    //assign student to course
    @PutMapping("{s_id}/c/{c_id}")
    public ResponseEntity assignStudentToCourse(@PathVariable Integer s_id, @PathVariable Integer c_id){
        studentServices.assignStudentToCourse(s_id,c_id);
        return ResponseEntity.status(200).body("good");
    }

    @GetMapping("/gets/{id}")
    public ResponseEntity getStatusByCourseId(@PathVariable Integer id){
        if(studentServices.studentList(id) != null){
            List<Student> list = studentServices.studentList(id);
            return ResponseEntity.status(200).body(list);
        }
        return ResponseEntity.status(400).body("Users not found");

    }

    //change major
    @PutMapping("/g/{id}/{major}")
    public ResponseEntity f (@PathVariable Integer id, @PathVariable String  major){
        studentServices.changeStudentMajor(id,major);
        return ResponseEntity.status(200).body("student course added");

    }

}
