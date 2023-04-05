package ibf2022.paf.assessment.server.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.Task;

// TODO: Task 6
@Repository
public class TaskRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String INSERT_TASK_SQL = "insert into task (description, priority, due_date, user_id) values(?,?,?,?)";

    // return 1 if successful, 0 if fail to insert
    public Integer insertTask(Task task){

        try{
            Integer affectedRows = jdbcTemplate.update(INSERT_TASK_SQL, task.getDescription(), task.getPriority(), task.getDueDate(), task.getUserId());
            
            if(affectedRows > 0){
                return 1;
            }else{
                return 0; 
            }
        }catch(Exception ex){
            return 0;
        }

    }

}
