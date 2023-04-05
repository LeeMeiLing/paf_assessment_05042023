package ibf2022.paf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ibf2022.paf.assessment.server.exceptions.TodoNotCreatedException;
import ibf2022.paf.assessment.server.models.Task;
import ibf2022.paf.assessment.server.models.User;
import ibf2022.paf.assessment.server.repositories.TaskRepository;
import ibf2022.paf.assessment.server.repositories.UserRepository;

// TODO: Task 7
@Service
public class TodoService {

    @Autowired
    UserRepository userRepo;

    @Autowired
    TaskRepository taskRepo;

    @Transactional
    public void upsertTask(String username, List<Task> tasks){

        String userId = null;

        // check if user exist & get the userId
        Optional<User> user = userRepo.findUserByUsername(username);
        if(user.isPresent()){
            userId = user.get().getUserId();
        }
        
        // create user if not exist & get the userId
        // throw exception if fail to create user
        if(user.isEmpty()){
            User newUser = new User();
            newUser.setUsername(username);
            userId = userRepo.insertUser(newUser);

            if (userId == null){
                throw new TodoNotCreatedException("Fail to insert new user " + username);
            }

        }

        // assign the userId to each task in task list
        // insert task
        // throw exception if fail to insert any task
        for(Task t : tasks){
            t.setUserId(userId);
            Integer taskInserted = taskRepo.insertTask(t);
            if( taskInserted == 0){
                throw new TodoNotCreatedException("Fail to insert task");
            }
        }

        // testing, to remove
        System.out.println(" TODO CREATED ");

    }
}
