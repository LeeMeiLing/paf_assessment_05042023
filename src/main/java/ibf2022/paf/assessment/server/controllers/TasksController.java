package ibf2022.paf.assessment.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 4, Task 8
@Controller
public class TasksController {

    @Autowired
    UserRepository userRepo;

    // @PostMapping("/task")
    // public String handleSave(Task task){
    //     /*
    //      *  username: fred
    //         description-0: do%20laundry
    //         priority-0: 1
    //         dueDate-0: 2023-04-13
    //         description-1: buy%20apple
    //         priority-1: 2
    //         dueDate-1: 2023-04-07
    //      */
    // }
    
}
