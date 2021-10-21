package io.github.sakiRoot.springProject.model;

import io.github.sakiRoot.springProject.adapter.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Interfejs z metodami dodawania, usuwania itp. rekordow z bazy danych
//@RepositoryRestResource -> Metody sa tlumaczone na zapytania
@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task, Integer> {
    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from tasks where id=:id")
    boolean existsById(@Param("id") Integer id);

    @Override
    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);
}
