package io.github.sakiRoot.springProject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Task's description must not be empty")
    private String description;
    @OneToMany(mappedBy = "project")
    private Set<TaskGroup> taskGroups;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectsSteps> projectsSteps;

    public Projects() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
