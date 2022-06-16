package pe.edu.upc.usermanagementmicroservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_employer")
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor

public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty( message = "El nombre no puede estar vacio!")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty( message = "El apellido no puede estar vacio!")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty( message = "El dni no puede estar vacio!")
    @Column(name = "dni")
    private String dni;

    @NotEmpty( message = "El correo no puede estar vacio!")
    @Column(name = "email")
    @Email
    private String email;

    @NotEmpty( message = "El numero de celular no puede estar vacio!")
    @Column(name = "number_phone")
    private String numberPhone;

    @NotEmpty( message = "La contraseña no puede estar vacio!")
    @Column(name = "password")
    private String password;
}
