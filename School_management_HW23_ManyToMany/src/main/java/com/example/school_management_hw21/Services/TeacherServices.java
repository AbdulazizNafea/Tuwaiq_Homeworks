package com.example.school_management_hw21.Services;


import com.example.school_management_hw21.ApiException.ApiException;
import com.example.school_management_hw21.DTO.AddressDTO;
import com.example.school_management_hw21.Model.Address;
import com.example.school_management_hw21.Model.Course;
import com.example.school_management_hw21.Model.Teacher;
import com.example.school_management_hw21.Repo.AddressRepository;
import com.example.school_management_hw21.Repo.CourseRepository;
import com.example.school_management_hw21.Repo.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServices {

    private final TeacherRepository teacherRepo;
    private final CourseRepository courseRepository;
    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepo.save(teacher);
    }

    public boolean updateTeacher(Teacher teacher , Integer id){
        Teacher teacher2 = teacherRepo.findByIdEquals(id);
        if (teacher2 == null) {
            return false;
        }
        teacher2.setName(teacher.getName());
        teacher2.setAge(teacher.getAge());
        teacher2.setEmail(teacher.getEmail());
        teacher2.setSalary(teacher.getSalary());
        teacherRepo.save(teacher2);
        return true;
    }


    public boolean deleteTeacher(Integer id){
        Teacher teacher2 = teacherRepo.findByIdEquals(id);
        if (teacher2 == null) {
            return false;
        }
        teacherRepo.delete(teacher2);
        return true;
    }

    //////////////////////////////////////////////////////////////////

    public boolean addCourseToTeacher(Integer courseId, Integer teacherId){
        Teacher teacher2 = teacherRepo.findByIdEquals(teacherId);
        Course course = courseRepository.findCourseById(courseId);

        if (course == null || teacher2 == null) {
            return false;
        }
        course.setTeacher(teacher2);
        courseRepository.save(course);
        return true;
    }
    ///////////////////////////////////////////////////////////
    public Teacher teacherDetails(Integer id){
        Teacher teacher= teacherRepo.findByIdEquals(id);
        //Teacher teacher = teacherRepo.findByIdEquals(id);
        //teacher.getAddress();
        //teacher.getAddress();
        //List<Teacher> list= new ArrayList<>();
       // list.add(teacher);
        return teacher;
    }

}
