package bd.gov.plandiv.pdts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class ForeignTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean status;
    @ManyToOne
    private ForeignTourPurpose purpose;
    @ManyToOne
    private FundingSourceOrg fundingSourceOrg;
    private String arrangeBy;
    @Lob
    private String comment;
    @ManyToOne
    private Employee employee;
}
