package bd.gov.plandiv.pdts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
    @ManyToOne
    private FundingSourceOrg fundingSourceOrg;

    private boolean status;


}
