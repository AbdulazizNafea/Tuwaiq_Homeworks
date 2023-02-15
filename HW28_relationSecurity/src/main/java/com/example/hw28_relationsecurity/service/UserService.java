package com.example.hw28_relationsecurity.service;

import com.example.hw28_relationsecurity.apiException.ApiException;
import com.example.hw28_relationsecurity.model.User;
import com.example.hw28_relationsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //get all user - Admin
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    //get user by id
    public User getUserById(Integer userId){
        User user = userRepository.findUserById(userId);
        if (user.getId() == null) {
            throw new ApiException("user not found");
        }else if (user.getId() != userId) {
            throw new ApiException(" not allow to get user");
        }
        return user;
    }

    //register user
    public void addUser(User user){
        user.setRole("USER");
        if(user.getPassword().isBlank() || user.getPassword().isEmpty()){
            throw new ApiException("Password should be not empty and more than 3");
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user);
    }
    //update by user
    public void updateByUser(Integer authUser,User user){
        User user1 = userRepository.findUserById(authUser);
        if (user1 == null) {
            throw new ApiException("user not found");
        }else if(user1.getId() != authUser){
            throw new ApiException("not allow to update this user");
        }
        if(user.getPassword().isBlank() || user.getPassword().isEmpty()){
            throw new ApiException("Password should be not empty");
        }
        user1.setId(authUser);
        user1.setRole("USER");
        user1.setUsername(user.getUsername());

        user1.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user1);

    }
    //delete by user
    public void deleteByUser(Integer id,Integer authUser){
        User user1 = userRepository.findUserById(id);
        if (user1 == null) {
            throw new ApiException("user not found");
        }else if(user1.getId() != authUser){
            throw new ApiException("not allow to delete this user");
        }
        userRepository.delete(user1);

    }
    //update any user by admin
    public void update (Integer id,User user){
        User user1=userRepository.findUserById(id);
        if (user1 == null)
        {
            throw new ApiException("user not found");
        }
        //user1.setId(authUser);
        //user1.setRole("USER");
        user1.setUsername(user.getUsername());
        //user1.setLocked(user.isLocked());
        user1.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepository.save(user1);
    }
    //delete any user by admin
}
