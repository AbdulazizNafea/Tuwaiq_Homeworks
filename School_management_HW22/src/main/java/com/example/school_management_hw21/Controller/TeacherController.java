package com.example.school_management_hw21.Controller;


import com.example.school_management_hw21.Model.Teacher;
import com.example.school_management_hw21.Services.TeacherServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/t")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherServices teacherServices;

    @GetMapping("/get")
    public ResponseEntity getTeacher(){
        List<Teacher> customers = teacherServices.getTeachers();
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody Teacher teacher) {
        teacherServices.addTeacher(teacher);
        return ResponseEntity.status(200).body("User Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@RequestBody Teacher teacher, @PathVariable Integer id) {
        teacherServices.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body("User Added");

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        if(teacherServices.deleteTeacher(id)){
            teacherServices.deleteTeacher(id);
            return ResponseEntity.status(200).body("deleted");
        }
        return ResponseEntity.status(400).body("User not found");
    }
////////////////////////////////////////////////////////////////////////////


    @PutMapping("c_t/{courseId}/{teacherId}")
    public ResponseEntity addCourseToTeacher(@PathVariable Integer courseId, @PathVariable Integer teacherId) {

        if(teacherServices.addCourseToTeacher(courseId,teacherId)){
            teacherServices.addCourseToTeacher(courseId,teacherId);
            return ResponseEntity.status(200).body("added");
        }
        return ResponseEntity.status(400).body(" not found");

    }


//
//
//
//    @GetMapping("/getAll")
//    public List<Address> getAll(){
//        return teacherServices.getAll();
//    }
//    @PostMapping("/addAddress")
//    public ResponseEntity addAddress(@RequestBody AddressDTO addressDTO){
//        teacherServices.addAddress2(addressDTO);
//        return   ResponseEntity.status(200).body("Add Address Done");
//    }
//
//    @PutMapping("/updateA")
//    public ResponseEntity updateCustomer(@RequestBody  AddressDTO ad){
//        if (teacherServices.updateAddress(ad)) {
//            teacherServices.updateAddress(ad);
//            return ResponseEntity.status(200).body("User address updated");
//        }
//        return ResponseEntity.status(400).body("User not found");
//
//    }
//    @DeleteMapping("/deleteA/{id}")
//    public ResponseEntity deleteCustomer(@PathVariable Integer id){
//        if (teacherServices.deleteAddress(id)) {
//            teacherServices.deleteAddress(id);
//            return ResponseEntity.status(200).body("user address delete");
//        }
//        return ResponseEntity.status(400).body("User not found");
//
//    }
//
//
//

}
