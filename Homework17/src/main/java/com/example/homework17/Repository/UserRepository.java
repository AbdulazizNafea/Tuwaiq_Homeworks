package com.example.homework17.Repository;

import com.example.homework17.Model.UserModel;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepositoryImplementation<UserModel,Integer> {
}
