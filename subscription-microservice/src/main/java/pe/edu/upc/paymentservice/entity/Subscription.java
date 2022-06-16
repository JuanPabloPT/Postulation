package pe.edu.upc.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_subscription")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacio!")
    private String name;

    @NotEmpty(message = "no puede estar vacio!")
    private String description;

    @NotEmpty(message = "no puede estar vacio!")
    @Column(name = "limit_postulations")
    private String limitPostulations;

    @Range(message = "no puede estar vacio!")
    private String duration;

}
    /*
    {
        "id": 0,
            "description": "string",
            "limitPostulations": 0,
            "preDesignTemplates": true,
            "duration": 0,
            "createdAt": "2021-10-30T07:59:59.958Z",
            "status": "string"
    }
     */
