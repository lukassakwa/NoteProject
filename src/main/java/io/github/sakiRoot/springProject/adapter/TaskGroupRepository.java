package io.github.sakiRoot.springProject.adapter;

import io.github.sakiRoot.springProject.model.TaskGroup;

import java.util.List;
import java.util.Optional;

public interface TaskGroupRepository {
    List<TaskGroup> findAll();
    Optional<TaskGroup> findById(Integer id);
    TaskGroup save(TaskGroup entity);
    boolean existsByDoneIsFalseAndId(Integer id);
}
