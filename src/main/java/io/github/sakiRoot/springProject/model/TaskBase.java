package io.github.sakiRoot.springProject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
abstract class TaskBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    @NotBlank(message = "Task's description must not be empty")
    protected String description;
    protected boolean done;

    //@Embedded
    //@AttributeOverrides({
    //        @AttributeOverride(column = @Column(name = "updatedOn"), name = "updatedOn")
    //})
    //W ten sposob mozna zmienic nazwe kolumny na nazwe jaka chcemy jej nadac
    @Embedded
    private Audit audit = new Audit();

    TaskBase(){
    }

    public int getId() {
        return id;
    }

    void setId(final int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }
}
