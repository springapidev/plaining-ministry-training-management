package bd.gov.plandiv.pdts.config;

import bd.gov.plandiv.pdts.entity.Employee;
import bd.gov.plandiv.pdts.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    EmployeeRepository repository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let Visitor login with either username or email
        Optional<Employee> optionalUsers = repository.findByEmailAndStatus(usernameOrEmail, true);
        if (optionalUsers.isEmpty()) {
            optionalUsers
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        }
        return optionalUsers
                .map(CustomUserDetails::new).get();
    }

}