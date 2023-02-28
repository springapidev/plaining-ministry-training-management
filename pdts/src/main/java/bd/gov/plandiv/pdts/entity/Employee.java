package bd.gov.plandiv.pdts.entity;

import bd.gov.plandiv.pdts.enums.Gender;
import bd.gov.plandiv.pdts.enums.Religion;
import jakarta.persistence.*;
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

    @Column(unique = true, nullable=false)
    private String email;
    @Column(unique = true, nullable=false)
    private String mobile;

    @Column(nullable = false)
    private String password;

    private boolean status;

    @Column(nullable=false)
    private String firstName;

    private String lastName;
    @Column(nullable=false)
    private String idNo;
    private String grade;
    @Column(nullable=false)
    private String workingPlace;
    private String photo;
    @Lob
    private String biography;

   @ManyToMany
   private Set<Role> roles;
    @Column(nullable=false)
   private LocalDate dob;
   private Gender gender;
   private Religion religion;
   @ManyToOne
   private Designation designation;
   @ManyToOne
   private Department department;
    @Column(nullable=false)
   private LocalDate joiningDate;
   private LocalDate joiningDateInCurrentRank;
   private LocalDate retirementDate;
   private LocalDate restDate;
   private String lastDegree;



}


