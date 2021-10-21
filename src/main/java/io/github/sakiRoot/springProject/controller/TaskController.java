package io.github.sakiRoot.springProject.controller;

import io.github.sakiRoot.springProject.model.Task;
import io.github.sakiRoot.springProject.adapter.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
//@RestController => @Controller and @ResponseBody
@Controller
@ResponseBody
class TaskController{
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository taskRepository;

    @Autowired
    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks", params = {"!sort", "!page", "!size"})
    ResponseEntity<List<Task>> readAllTasks(){
        logger.warn("Exposing all the tasks!");
        return ResponseEntity.ok(taskRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks")
    ResponseEntity<List<Task>> readAllTasks(Pageable pageable){
        logger.warn("Custom exposing!");
        return ResponseEntity.ok(taskRepository.findAll(pageable).getContent());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tasks/{id}")
    ResponseEntity<Task> readSingleTask(@PathVariable int id){
        return taskRepository.findById(id)
                .map(task -> ResponseEntity.ok(task))
                .orElse(ResponseEntity.notFound().build());
    }

    @Transactional
    @RequestMapping(method = RequestMethod.PUT, path = "/tasks/{id}")
    public ResponseEntity<?> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate){
        logger.warn("Index update!");
        if(!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.findById(id)
                .ifPresent(task -> {
                    task.updateFrom(toUpdate);
                    //taskRepository.save(task); <- drugi sposob jesli nie chcemy uzyc Transactional
                });
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/tasks")
    ResponseEntity<Task> addTask(@RequestBody @Valid Task toAdd){
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/")
                .buildAndExpand(toAdd.getId())
                .toUri();
        taskRepository.save(toAdd);
        return ResponseEntity.created(location).build();
    }

    //programowanie aspektowe
    //Transactional dziala tylko wtedy gdy metoda jest publiczna
    //Ten task jest zarzadzany przez orm co znaczy ze zmiana w metodzie zajdzie takze w bazie danych
    @Transactional
    @RequestMapping(method = RequestMethod.PATCH, path = "/tasks/{id}")
    public ResponseEntity<?> updateTask(@PathVariable int id){
        if(!taskRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        taskRepository.findById(id)
                .ifPresent(task -> task.setDone(!task.isDone()));
        //throw new RuntimeException();
        return ResponseEntity.noContent().build();
    }

}
