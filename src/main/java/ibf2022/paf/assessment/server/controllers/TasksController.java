package ibf2022.paf.assessment.server.controllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 4, Task 8
@Controller
public class TasksController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    TaskRepository taskRepo;

    // POST /task
    // Content-Type: application/x-www-form-urlencoded
    @PostMapping("/task")
    public String handleSave(@RequestBody MultiValueMap<String,String> payload){
        /*
         *  username: fred
            description-0: do%20laundry
            priority-0: 1
            dueDate-0: 2023-04-13
            description-1: buy%20apple
            priority-1: 2
            dueDate-1: 2023-04-07
         */
        String username = payload.getFirst("username");
        Integer totalTask = (payload.size() - 1) / 3; // minus one for username
        System.out.println(">>> total task = " + totalTask); //debug

        List<Task> tasks = new ArrayList<>();
        
        for (int i = 0; i < totalTask; i++){
            Task task = new Task();
            task.setUsername(username);
            task.setDescription(payload.getFirst("description-" + i));
            task.setPriority(Integer.parseInt(payload.getFirst("priority-" + i)));
            task.setDueDate(Date.valueOf(payload.getFirst("dueDate-" + i)));
            tasks.add(task);
        }

        System.out.println(tasks); // debug

        // // debug, to remove
        // for(Task t : tasks){
        //     t.setUserId("1b80114c");
        //     taskRepo.insertTask(t);
        // }

        return null;

    }
    
}
