package bd.gov.plandiv.pdts.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String name;
    @Lob
    private String descriptions;
    private int duration;
    private String hostCountry;
    private LocalDate startDate;
    private LocalDate endDate;
    @ManyToOne
    private Project project;

    private boolean status;


}
