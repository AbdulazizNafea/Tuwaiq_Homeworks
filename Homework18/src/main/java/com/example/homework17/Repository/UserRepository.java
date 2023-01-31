package com.example.homework17.Repository;

import com.example.homework17.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel,Integer> {


    public UserModel findUserModelByUsernameAndPassword(String username, String password);

    public UserModel findUserModelByEmail(String email);

    public UserModel findUserModelByRole(String role);
    @Query("select user from UserModel user where user.role like ?1")
    //@Query(nativeQuery = true ,value = "select * from UserModel where role ='admin'")
    public List<UserModel> getRole(String role);

    @Query("select user from  UserModel user where user.age = ?1 or user.age > ?1")
    public List <UserModel> getAge(int role);

}
