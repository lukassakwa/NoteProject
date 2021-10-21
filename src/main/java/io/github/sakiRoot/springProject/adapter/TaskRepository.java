package io.github.sakiRoot.springProject.adapter;

import io.github.sakiRoot.springProject.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.net.ContentHandler;
import java.util.List;
import java.util.Optional;

public interface TaskRepository{
    List<Task> findAll();
    Page<Task> findAll(Pageable pageable);
    Optional<Task> findById(Integer id);
    boolean existsById(Integer id);
    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);
    Task save(Task entity);
    List<Task> findByDone(boolean done);
}
