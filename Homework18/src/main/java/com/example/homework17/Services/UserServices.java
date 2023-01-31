package com.example.homework17.Services;

import com.example.homework17.Model.UserModel;
import com.example.homework17.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor

public class UserServices {

    private final UserRepository userRepository;

    public List<UserModel> getUsers(){
        return userRepository.findAll();
    }

    public void addUser(UserModel userModel){
        userRepository.save(userModel);
    }


    public boolean updateUser(UserModel userModel, Integer id){
        UserModel userModel2 = userRepository.getById(id);

        if (userModel2 == null) {
            return false;
        }
       // userModel.setId(id);
        userModel2.setName(userModel.getName());
        userModel2.setEmail(userModel.getEmail());
        userModel2.setAge(userModel.getAge());
        userModel2.setPassword(userModel.getPassword());
        userModel2.setRole(userModel.getRole());
        userModel2.setUsername(userModel.getUsername());
        userRepository.save(userModel2);
        return true;
    }


    public  boolean deleteUser(Integer id){
        UserModel userModel = userRepository.getById(id);
        userRepository.delete(userModel);
        return true;
    }

    //////////////////////////////////////////////////////////////////

    public UserModel getUsernameAndPassword(String username, String password){
        UserModel user = userRepository.findUserModelByUsernameAndPassword(username,password);
        return user;
    }

    public UserModel getByEmail(String Email){
        UserModel user = userRepository.findUserModelByEmail(Email);
        return user;
    }

    public List<UserModel> getRole(String role){

        return userRepository.getRole(role);
    }

    public List<UserModel> getAge(int age){

        return userRepository.getAge(age);
    }



}
