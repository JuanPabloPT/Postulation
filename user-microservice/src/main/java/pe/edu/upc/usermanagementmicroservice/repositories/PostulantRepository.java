package pe.edu.upc.usermanagementmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.usermanagementmicroservice.entity.Postulant;

import java.util.List;

public interface PostulantRepository extends JpaRepository<Postulant, Long> {
    public List<Postulant> findByFirstName(String firstName);
    public List<Postulant> findByLastName( String lastName);
}
