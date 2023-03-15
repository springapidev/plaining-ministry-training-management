package bd.gov.plandiv.pdts.repository;


import bd.gov.plandiv.pdts.entity.Department;
import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.entity.Role;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {
    Optional<Employee> findByEmail(String name);
    Optional<Employee> findByEmailAndStatus(String name,boolean status);
    boolean existsByEmail(String email);
    List<Employee> findAllByDepartment(Department department);
    Employee findByEmailOrMobileOrIdNoContaining(String email, String mobile, String idNo);

    @Transactional
    @Modifying
    @Query("update Employee u set u.roles = ?1 where u.id = ?2")
    int updateRolesWhenPay(Set<Role> roles, Long id);

    @Transactional
    @Modifying
    @Query("update Employee u set u.photo = ?1 where u.email = ?2")
    int changePhoto(String photo, String email);

    @Transactional
    @Modifying
    @Query("update Employee u set u.firstName = ?1,u.lastName = ?2,u.dob = ?3,u.mobile = ?4 where u.email = ?5")
    int updateUserInfo(String firstName, String lastName, LocalDate dob, String mobile, String email);


    @Transactional
    @Modifying
    @Query("update Employee u set u.roles = ?1 where u.id = ?2")
    int updateRoles(Set<Role> roles, String id);



//    @Modifying
//    @Transactional
//    @Query("update Employee u set u.passResetKey = ?1 where u.email = ?2")
//    int updateResetKey(String passResetKey, String email);

    @Modifying
    @Transactional
    @Query("update Employee u set u.password = ?1 where u.email = ?2")
    int updatePassword(String password, String email);
}
