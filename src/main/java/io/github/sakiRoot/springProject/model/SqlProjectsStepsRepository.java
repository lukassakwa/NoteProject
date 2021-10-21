package io.github.sakiRoot.springProject.model;

import io.github.sakiRoot.springProject.adapter.ProjectsStepsRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlProjectsStepsRepository extends ProjectsStepsRepository, JpaRepository<ProjectsSteps, Integer> {
}
