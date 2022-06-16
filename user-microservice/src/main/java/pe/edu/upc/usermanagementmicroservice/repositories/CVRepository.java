package pe.edu.upc.usermanagementmicroservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.usermanagementmicroservice.entity.CV;
import pe.edu.upc.usermanagementmicroservice.entity.Postulant;

import java.util.List;

public interface CVRepository extends JpaRepository<CV, Long> {
    public List<CV> findByPostulant(Postulant postulant);
}
