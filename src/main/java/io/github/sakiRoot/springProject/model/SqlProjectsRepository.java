package io.github.sakiRoot.springProject.model;

import io.github.sakiRoot.springProject.adapter.ProjectsRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectsRepository extends ProjectsRepository, JpaRepository<Projects, Integer> {
    @Override
    @Query("from Projects p join fetch p.projectsSteps")
    List<Projects> findAll();
}
