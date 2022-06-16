package pe.edu.upc.usermanagementmicroservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_company")
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @NotNull( message = "El nombre no puede estar vacio!")
    @Column(nullable = false)
    private String name;

    @NotNull( message = "La descripcion no puede estar vacia!")
    @Column(nullable = false)
    private String description;

    @NotNull( message = "El ruc no puede estar vacio!")
    @Column(nullable = false)
    private String ruc;

    @NotNull( message = "El url del logo no puede estar vacio!")
    @Column(nullable = false)
    private String logo;

    @NotNull( message = "El pais no puede estar vacio!")
    @Column(nullable = false)
    private String country;

    @NotNull( message = "La ciudad no puede estar vacia!")
    @Column(nullable = false)
    private String city;

    @NotNull( message = "El distrito no puede estar vacio!")
    @Column(nullable = false)
    private String district;

    @NotNull( message = "La direccion no puede estar vacia!")
    @Column(nullable = false)
    private String direction;


    @ManyToOne
    @JoinColumn(name = "employer_id")
    @NotNull( message = "El empleador no puede estar vacio!")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Employer employer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sector_id")
    @NotNull( message = "El sector no puede estar vacio!")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Sector sector;
}
