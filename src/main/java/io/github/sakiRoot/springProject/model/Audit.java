package io.github.sakiRoot.springProject.model;

import javax.persistence.Embeddable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

//Baza ktora nie jest encja
//Jest to klasa z polami ktore chcemy uzywac w wiecej niz tylko jednej tabeli w bazie danych
//Jest ona wykorzystywana do dziedziczenia
//Rozdzial 6 odc 72
//@MappedSuperclass
@Embeddable // -> poprawny sposob deklarowania encji w javie
class Audit {
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    void prePersist(){
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    void preMerge(){
        updatedOn = LocalDateTime.now();
    }
}
