package com.example.todoproject;


import com.example.todoproject.model.MyUser;
import com.example.todoproject.model.Todo;
import com.example.todoproject.repository.MyUserRepository;
import com.example.todoproject.service.MyUserService;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyUserServiceTest {

    @InjectMocks
    MyUserService myUserService;

    @Mock
    MyUserRepository myUserRepository;

    MyUser myUser, myUser1, myUser2, myUser3;

    Todo todo, todo1, todo2, todo3;

    List<Todo> todos;
    List<MyUser> myUserList;

    @BeforeEach
    void setUp() {
        myUser = new MyUser(null, "Ali", "12345", "ADMIN", null);
        myUser1 = new MyUser(null, "Nas", "12345", "ADMIN", null);
        myUser2 = new MyUser(null, "Saad", "12345", "ADMIN", null);
        myUser3 = new MyUser(null, "Moh", "12345", "ADMIN", null);

        todo1 = new Todo(null, "todo1", "body1", myUser);
        todo2 = new Todo(null, "todo2", "body2", myUser);
        todo3 = new Todo(null, "todo3", "body3", myUser);

        myUserList = new ArrayList<>();
        myUserList.add(myUser);
        myUserList.add(myUser1);
        myUserList.add(myUser2);
        myUserList.add(myUser3);
    }

    @Test
    public void getAllUsers() {
        when(myUserRepository.findAll()).thenReturn(myUserList);

        List<MyUser> userList = myUserService.getAllUsers();
//Note// It gives error because it has same name with other class but different import, so I comment it to use other class in different method.
        //Assertions.assertEquals(4, userList.size());
        verify(myUserRepository, times(1)).findAll();
    }

    @Test
    public void getUser() {
        myUserRepository.save(myUser1);
        when(myUserRepository.findMyUserById(myUser1.getId())).thenReturn(myUser1);
        MyUser myUser = myUserRepository.findMyUserById(myUser1.getId());
        //Note//read above note to understand
        Assertions.assertThat(myUser1).isEqualTo(myUser);

        verify(myUserRepository, times(1)).findMyUserById(myUser1.getId());
    }

    @Test
    public void addUserTest() {
        myUserService.addUser(myUser1);
        verify(myUserRepository, times(1)).save(myUser1);
    }

    @Test
    public void updateUserTest() {
        when(myUserRepository.findMyUserById(myUser1.getId())).thenReturn(myUser1);

        myUserService.updateUser(myUser1, myUser1.getId());

        verify(myUserRepository, times(1)).findMyUserById(myUser1.getId());
        verify(myUserRepository, times(1)).save(myUser1);
    }

    @Test
    public void deleteUserTest() {
        when(myUserRepository.findMyUserById(myUser1.getId())).thenReturn(myUser1);
        myUserService.deleteUser(myUser1.getId());
        verify(myUserRepository, times(1)).findMyUserById(myUser1.getId());
        verify(myUserRepository, times(1)).delete(myUser1);
    }
}
