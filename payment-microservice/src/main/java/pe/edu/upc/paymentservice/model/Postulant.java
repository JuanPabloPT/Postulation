package pe.edu.upc.paymentservice.model;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class Postulant {
    private Long id;
    private String firstName;
    private String lastName;
    private String number;
    private String password;
    private String email;
    private String document;
    private Date birthday;
    private String civilStatus;
}
