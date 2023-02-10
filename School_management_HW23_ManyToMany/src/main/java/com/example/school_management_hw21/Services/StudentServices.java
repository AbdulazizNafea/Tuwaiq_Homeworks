package com.example.school_management_hw21.Services;

import com.example.school_management_hw21.ApiException.ApiException;
import com.example.school_management_hw21.Model.Course;
import com.example.school_management_hw21.Model.Student;
import com.example.school_management_hw21.Repo.CourseRepository;
import com.example.school_management_hw21.Repo.StudentRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServices {

    private final StudentRepoistory studentRepoistory;
    private final CourseRepository courseRepository;

    private final CourseServices courseServices;

    public List<Student> getall() {
        return studentRepoistory.findAll();
    }

    public void add(Student student) {
        studentRepoistory.save(student);
    }

    public boolean update(Student student, Integer id) {
        Student student1 = studentRepoistory.findStudentById(id);
        if (student1 == null) {
            return false;
        }

        student1.setName(student.getName());
        student1.setAge(student.getAge());
        student1.setMajor(student.getMajor());
        studentRepoistory.save(student1);
        return true;
    }


    public boolean delete(Integer id) {
        Student student = studentRepoistory.findStudentById(id);
        if (student == null) {
            return false;
        }
        studentRepoistory.delete(student);
        return true;
    }


    //////////////////////////////////////////
    //connect to table many to many

    public void assignStudentToCourse(Integer s_id, Integer c_id) {
        Student student = studentRepoistory.findStudentById(s_id);
        Course course = courseRepository.findCourseById(c_id);

        if (course == null || course == null) {
          throw new ApiException("id not found");
        }
        student.getCourse().add(course);
        course.getStudent().add(student);
        studentRepoistory.save(student);
        courseRepository.save(course);

    }

    ///////////////////////////////////////////////////////
    //Create endpoint that takes course id and return the student list

    public List<Student> studentList(Integer id) {
        Course course = courseRepository.findCourseById(id);
        if (course == null) {
            return null;
        }
        List<Student> list = course.getStudent();
        return list;

    }

    /////////////////////////////////////////
    /*
    Create endpoint that takes student id and major and change the
    student major ( changing the major will drop all the courses that the student attended to )
     */

    public void changeStudentMajor(Integer s_id, String major){
        Student student2 = studentRepoistory.findStudentById(s_id);
        if (student2 == null) {
           throw new ApiException("id not found");
        }
        if (student2.getMajor().equalsIgnoreCase(major)) {
            throw new ApiException("same major");
        }

        student2.setMajor(major);

        for (Course course: student2.getCourse()) {
            studentList(course.getId()).remove(student2);
            courseRepository.save(course);
        }
        student2.getCourse().clear();
        studentRepoistory.save(student2);

    }
}


