package com.example.blogsystem_hw27.service;

import com.example.blogsystem_hw27.apiException.ApiException;
import com.example.blogsystem_hw27.model.MyUser;
import com.example.blogsystem_hw27.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {
    private final MyUserRepository myUserRepository;

    public List<MyUser> getAll(){
        return myUserRepository.findAll();
    }

    public MyUser getOne(Integer id){
        MyUser myUser = myUserRepository.findMyUserById(id);
        if(myUser == null){
            throw new ApiException("user not found");
        }
        return myUser;
    }

    public void add(MyUser myUser){
        String hashPassword = new BCryptPasswordEncoder().encode(myUser.getPassword());
        myUser.setRole("USER");
        myUser.setPassword(hashPassword);
        myUserRepository.save(myUser);
    }

    public void update(Integer id,MyUser myUser){
        MyUser myUser1= myUserRepository.findMyUserById(id);
        if(myUser == null){
            throw new ApiException("user not found");
        }
        myUser1.setUsername(myUser.getUsername());
        myUser1.setPassword(new BCryptPasswordEncoder().encode(myUser.getPassword()));
        myUserRepository.save(myUser);
    }

    public void delete(Integer id) {
        MyUser myUser = myUserRepository.findMyUserById(id);
        if(myUser == null){
            throw new ApiException("user not found");
        }
        myUserRepository.delete(myUser);
    }





}
