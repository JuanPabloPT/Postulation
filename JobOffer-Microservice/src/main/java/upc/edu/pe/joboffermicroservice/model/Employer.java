package upc.edu.pe.joboffermicroservice.model;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder

public class Employer {

    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private String numberPhone;
    private String password;
}