package io.github.sakiRoot.springProject.adapter;

import io.github.sakiRoot.springProject.model.Projects;
import io.github.sakiRoot.springProject.model.TaskGroup;

import java.util.List;
import java.util.Optional;

public interface ProjectsRepository {
    List<Projects> findAll();
    Optional<Projects> findById(Integer id);
    Projects save(Projects entity);
}
