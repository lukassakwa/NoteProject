package io.github.sakiRoot.springProject.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

//Przykladowa klasa odzwierciedlajaca tabele bazo danowa
//Zawiera pola, ktore przedstawiaja kolumny
@Entity
@Table(name = "tasks")
public class Task extends TaskBase{
    //@Transient
    //Ta adnotacje uzywamy jesli nie chcemy zeby te dane zostaly zapisane na bazie danych
    //np .Pesel -> chcemy zeby uzytkownik podal ale nie chcemy zeby zostal on przeslany w json i
    //dodany do bazy danych
    //private int Pesel;
    private LocalDateTime deadline;
    //rozdzial 6 76 lekcja
    //Relacja pomiedzy task entity a group entity
    @ManyToOne
    @JoinColumn(name = "task_group_id")
    private TaskGroup group;

    Task(){
    }

    public Task(String description, LocalDateTime deadline){
        this.description = description;
        this.deadline = deadline;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    TaskGroup getTaskGroup() {
        return group;
    }

    void setTaskGroup(TaskGroup group) {
        this.group = group;
    }

    public void updateFrom(final Task source){
        deadline = source.deadline;
        group = source.group;
        //createdOn i updateOn beda tu ustawiane bezposrednio z hibernate (metody prePersist() i preMigrate())
    }
}
