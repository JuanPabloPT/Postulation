package pe.edu.upc.paymentservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.paymentservice.model.Postulant;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_postulant_subscription")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Postulant_Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Postulant postulant;

    private Long postulantId;
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Subscription subscription;

    @Temporal(TemporalType.DATE)
    private Date date;
}

