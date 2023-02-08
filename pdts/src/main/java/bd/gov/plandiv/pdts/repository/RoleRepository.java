package bd.gov.plandiv.pdts.repository;

import bd.gov.plandiv.pdts.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role , Long>  {
    boolean existsByName(String name);
    Optional<Role> findByName(String name);

    List<Role> findAllByNameContainingIgnoreCase(String name);
}
