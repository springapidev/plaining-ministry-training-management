package bd.gov.plandiv.pdts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    private int noOfTrainee;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Set<FundingSourceOrg> fundingSourceOrgs;

    private boolean status;


}
