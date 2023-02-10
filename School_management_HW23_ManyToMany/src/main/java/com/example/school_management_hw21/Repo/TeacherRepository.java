package com.example.school_management_hw21.Repo;

import com.example.school_management_hw21.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    public Teacher findByIdEquals(Integer id);
}
