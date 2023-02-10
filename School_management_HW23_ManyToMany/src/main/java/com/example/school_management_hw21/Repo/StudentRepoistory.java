package com.example.school_management_hw21.Repo;

import com.example.school_management_hw21.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepoistory extends JpaRepository<Student,Integer> {

    public Student findStudentById(Integer id);
}
