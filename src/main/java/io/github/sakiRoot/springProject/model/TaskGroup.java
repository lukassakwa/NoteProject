package io.github.sakiRoot.springProject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "task_groups")
public class TaskGroup extends TaskBase{
    //Relacja pomiedzy task entity a group entity
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
    private Set<Task> tasks;

    public TaskGroup(){
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
