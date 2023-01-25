package com.springboot.homework13rest_crud.Controller;

import com.springboot.homework13rest_crud.Pojo.Task;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTask(){
        return tasks;
    }

    @PostMapping("/add")
    public String addTask (@RequestBody Task task){
        tasks.add(task);
        return "added";
    }

    @PutMapping("/update/{index}")
    public String updateTask(@PathVariable int index, @RequestBody Task task){
      tasks.set(index,task);
        return "updated";
    }

    @DeleteMapping("/delete/{index}")
    public String deleteTask(@PathVariable int index){
        tasks.remove(index);
        return "deleted";
    }

    @PutMapping("/change/{index}")
    public String changeStatus(@PathVariable int index){

        for(Task i: tasks){
            if(i.getStatus().equals("Done")){
                i.setStatus("not done");
                return "changed to not done";
            }else {
                i.setStatus("done");
                return "changed to done";
            }
        }
       return null;
    }

    @GetMapping("/search/{title}")
    public String searchTask(@PathVariable String title){
        for (Task t:tasks) {
            if(t.getTitle().equals(title)){
                return t.getTitle();
            }
        }
        return "Title not found";




    }
}
