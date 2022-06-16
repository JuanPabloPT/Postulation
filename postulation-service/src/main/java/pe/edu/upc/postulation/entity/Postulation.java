package pe.edu.upc.postulation.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.postulation.model.Postulant;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_postulations")
public class Postulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_postulation")
    private String numberPostulation;

    @Column(name = "joboffer_id")
    private Long jobOfferId;

    //@Transient
    //private JobOffer jobOffer;

    @Column(name = "postulant_id")
    private Long postulantId;

    @Transient
    private Postulant postulant;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;



}
