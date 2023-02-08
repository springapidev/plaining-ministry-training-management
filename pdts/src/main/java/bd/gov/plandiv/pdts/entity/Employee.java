package bd.gov.plandiv.pdts.entity;

import bd.gov.plandiv.pdts.enums.Gender;
import bd.gov.plandiv.pdts.enums.Religion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable=false)
    private String email;

    @Column(nullable = false)
    private String password;

    private boolean status;

    @Column(nullable=false)
    private String firstName;

    private String LastName;
    private String photo;
    @Lob
    private String biography;

   @ManyToMany
   private Set<Role> roles;

   private LocalDate dob;
   private Gender gender;
   private Religion religion;
   @ManyToOne
   private Designation designation;
   @ManyToOne
   private Department department;

   private LocalDate joiningDate;
   private LocalDate retirementDate;
   private LocalDate restDate;
   private String lastDegree;



}


