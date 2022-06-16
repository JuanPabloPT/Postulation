package pe.edu.upc.paymentservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upc.paymentservice.model.Postulant;
import pe.edu.upc.paymentservice.model.Subscription;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_subscription")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postulantId;
    private Long subscriptionId;

    @Transient
    private Postulant postulant;
    @Transient
    private Subscription subscription;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Payment payment;

    @Temporal(TemporalType.DATE)
    private Date dateOfBuy;
}