package ibf2022.paf.assessment.server.models;

import java.sql.Date;

// TODO: Task 4

public class Task {

    /*
     *  username: fred
        description-0: do%20laundry
        priority-0: 1
        dueDate-0: 2023-04-13
     */
    private String username;
    private String userId;
    private Integer task_id;
    private String description;
    private Integer priority;
    private Date dueDate;
    
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Integer getTask_id() {
        return task_id;
    }
    public void setTask_id(Integer task_id) {
        this.task_id = task_id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getPriority() {
        return priority;
    }
    public void setPriority(Integer priority) {
        this.priority = priority;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    @Override
    public String toString() {
        return "Task [username=" + username + ", userId=" + userId + ", task_id=" + task_id + ", description="
                + description + ", priority=" + priority + ", dueDate=" + dueDate + "]";
    }

    

}
