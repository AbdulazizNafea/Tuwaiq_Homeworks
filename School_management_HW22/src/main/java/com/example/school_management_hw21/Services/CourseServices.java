package com.example.school_management_hw21.Services;

import com.example.school_management_hw21.Model.Course;
import com.example.school_management_hw21.Repo.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServices {

    private final CourseRepository courseRepository;

    public List<Course> getall() {
        return courseRepository.findAll();
    }

    public void add(Course course){
        courseRepository.save(course);
    }

    public boolean update(Course course , Integer id){
        Course course1 = courseRepository.findCourseById(id);
        if (course1 == null) {
            return false;
        }

        course1.setName(course.getName());
        courseRepository.save(course1);
        return true;
    }


    public boolean delete(Integer id){
        Course course2 = courseRepository.findCourseById(id);
        if (course2 == null) {
            return false;
        }
        courseRepository.delete(course2);
        return true;
    }
}
