package bd.gov.plandiv.pdts.service;

import bd.gov.plandiv.pdts.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    boolean save(Role role);
    boolean update(Role role);
    boolean isExistById(Long id);
    boolean isExistByName(String name);
    Optional<Role> findById(Long id);
    Optional<Role> findByName(String name);
    boolean delete(Long id);
    List<Role> findAll();
    List<Role> search(String name);

}
