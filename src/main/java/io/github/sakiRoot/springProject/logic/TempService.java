package io.github.sakiRoot.springProject.logic;

import io.github.sakiRoot.springProject.adapter.TaskGroupRepository;
import io.github.sakiRoot.springProject.model.Task;
import io.github.sakiRoot.springProject.model.TaskGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TempService {
    @Autowired
    List<String> temp(TaskGroupRepository taskGroupRepository){
        return taskGroupRepository.findAll().stream()
                .flatMap(taskGroup -> taskGroup.getTasks().stream())
                .map(Task::getDescription)
                .collect(Collectors.toList());
    }
}
