package pe.edu.upc.paymentservice.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Subscription {
    private Long id;
    private String name;
    private String description;
    private String limitPostulations;
    private String duration;
}
