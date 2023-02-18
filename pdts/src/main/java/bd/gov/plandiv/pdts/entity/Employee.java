package bd.gov.plandiv.pdts.entity;

import bd.gov.plandiv.pdts.enums.Gender;
import bd.gov.plandiv.pdts.enums.Religion;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email can not null")
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password can not null")
    private String password;

    private boolean status;
    @NotBlank(message = "Firstname can not null")
    @Column(nullable = false)
    private String firstName;

    private String lastName;
    private String photo;
    @NotBlank(message = "Biography can not null")
    @Lob
    private String biography;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Role> roles;
    @NotNull(message = "Date of Birth can not null")
    private LocalDate dob;
    private Gender gender;
    private Religion religion;
    @ManyToOne
    private Designation designation;
    @ManyToOne
    private Department department;
    @NotNull(message = "Joining Date can not null")
    private LocalDate joiningDate;
    @NotNull(message = "Retirement Date can not null")
    private LocalDate retirementDate;

    private LocalDate restDate;
    @NotBlank(message = "Last Degree can not null")
    private String lastDegree;

    public Employee() {
    }

    public Employee(Employee employee) {
        this.email = employee.email;
        this.password = employee.password;
        this.status = employee.status;
        this.roles = employee.roles;
    }

}


