package io.github.sakiRoot.springProject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "projects_steps")
public class ProjectsSteps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Task's description must not be empty")
    private String description;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Projects project;
    @Column(name = "days_to_deadline")
    private Long daysToDeadline;

    public ProjectsSteps() {
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

    public Projects getProject() {
        return project;
    }

    public void setProject(Projects project) {
        this.project = project;
    }

    public Long getDaysToDeadline() {
        return daysToDeadline;
    }

    public void setDaysToDeadline(Long daysToDeadline) {
        this.daysToDeadline = daysToDeadline;
    }
}
