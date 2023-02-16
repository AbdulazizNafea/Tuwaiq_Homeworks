package com.example.todoproject;

import com.example.todoproject.model.MyUser;
import com.example.todoproject.model.Todo;
import com.example.todoproject.repository.MyUserRepository;
import com.example.todoproject.repository.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MyUserRepositoryTest {

    @Autowired
    MyUserRepository myUserRepository;

    @Autowired
    TodoRepository todoRepository;

    MyUser myUser,myUser2;
    Todo todo1,todo2,todo3;

    List<Todo> todos;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"ali" , "12345" , "ADMIN" , null);
        todo1 = new Todo(null , "todo1", "body1" , myUser );
        todo2 = new Todo(null , "todo2", "body2" , myUser );
        todo3 = new Todo(null , "todo3", "body3" , myUser );
        myUser2=new MyUser(null,"Maha" , "12345" , "ADMIN" , null);

    }


    @Test
    public void findMyUserByIdTest(){
        myUserRepository.save(myUser);
        MyUser myUser1 = myUserRepository.findMyUserById(myUser.getId());
        Assertions.assertThat(myUser1).isEqualTo(myUser);
    }

    @Test
    public void findMyUserByUsernameTest(){
        myUserRepository.save(myUser);
        MyUser myUser1 = myUserRepository.findMyUserByUsername(myUser.getUsername());
        Assertions.assertThat(myUser1).isEqualTo(myUser);
    }

}
