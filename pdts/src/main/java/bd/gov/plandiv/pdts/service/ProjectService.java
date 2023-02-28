package bd.gov.plandiv.pdts.service;

import bd.gov.plandiv.pdts.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    boolean save(Project project);
    boolean update(Project project);
    boolean isExistById(Long id);
    boolean isExistByName(String name);
    Optional<Project> findById(Long id);
    Optional<Project> findByName(String name);
    boolean delete(Long id);
    List<Project> findAll();


}
