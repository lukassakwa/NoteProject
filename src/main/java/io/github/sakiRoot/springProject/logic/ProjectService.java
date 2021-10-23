package io.github.sakiRoot.springProject.logic;

import io.github.sakiRoot.springProject.adapter.ProjectsRepository;
import io.github.sakiRoot.springProject.adapter.TaskGroupRepository;
import io.github.sakiRoot.springProject.configuration.properties.TaskConfigurationProperties;
import io.github.sakiRoot.springProject.model.Projects;
import io.github.sakiRoot.springProject.model.Task;
import io.github.sakiRoot.springProject.model.TaskGroup;
import io.github.sakiRoot.springProject.model.projection.GroupReadModel;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    private ProjectsRepository repository;
    private TaskGroupRepository taskGroupRepository;
    private TaskConfigurationProperties taskConfigurationProperties;

    public ProjectService(final ProjectsRepository repository, final TaskGroupRepository taskGroupRepository, final TaskConfigurationProperties taskConfigurationProperties) {
        this.repository = repository;
        this.taskGroupRepository = taskGroupRepository;
        this.taskConfigurationProperties = taskConfigurationProperties;
    }

    public List<Projects> readAll(){
        return repository.findAll();
    }

    public GroupReadModel createGroup(int projectId, LocalDateTime deadline){
        if(!taskConfigurationProperties.getTemplateConfigurationProperties().isAllowMultipleTasks() && taskGroupRepository.existsByDoneIsFalseAndId(projectId)){
            throw new IllegalStateException("Only one undone group for project are allow");
        }
        TaskGroup group = repository.findById(projectId)
                .map(projects -> {
                    var result = new TaskGroup();
                    result.setDescription(projects.getDescription());
                    result.setTasks(projects.getProjectsSteps().stream()
                            .map(projectsSteps ->
                                new Task(projectsSteps.getDescription(), deadline.plusDays(projectsSteps.getDaysToDeadline()))
                            )
                            .collect(Collectors.toSet())
                    );
                   return result;
                })
                .orElseThrow(() -> new IllegalArgumentException("Project with given id not found"));
        return new GroupReadModel(group);
    }

}
